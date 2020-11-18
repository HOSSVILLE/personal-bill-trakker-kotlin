package org.hoss.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.hoss.models.PayDates
import org.hoss.models.Payee
import org.hoss.repositories.PayDatesRepository
import java.util.*
import org.slf4j.LoggerFactory

@Controller("/general")
open class GeneralController(private val payDatesRepository: PayDatesRepository) {

    @Get("/weekOfYear")
    fun all(): Int {
        var cal = Calendar.getInstance(Locale.US);
        var date = Date()
        LOG.info("Date {}",date)
        cal.set(2021,Calendar.JANUARY,1)
        LOG.info("year : {} month: {} day: {}",cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH))
        LOG.info("November id is {}",Calendar.NOVEMBER)
        return cal.get(Calendar.WEEK_OF_YEAR)

    }
    @Get("/payDates/all")
    fun allPayDates(): List<PayDates> {
        return payDatesRepository.findAll();
    }

    @Get("/paydate/next")
    fun nextPayDate(): Optional<PayDates> {
        var cal = Calendar.getInstance()
        var paydate = payDatesRepository.findById(cal.get(Calendar.WEEK_OF_YEAR))
        if (paydate.isEmpty){
            paydate = payDatesRepository.findById(cal.get(Calendar.WEEK_OF_YEAR)+1)
        }
        return paydate
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(GeneralController::class.java)
    }
}