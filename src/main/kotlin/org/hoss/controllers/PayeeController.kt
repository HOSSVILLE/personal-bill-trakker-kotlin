package org.hoss.controllers

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.reactivex.Single
import org.hoss.models.Payee
import org.hoss.repositories.PayeeRepository
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/payee")
open class PayeeController (private val payeeRepository: PayeeRepository) {

    @Get("/all")
    fun all(): List<Payee> {
        var theList = payeeRepository.findAll()
        LOG.info("Number of Payees found ${theList.size}")
        return  theList
    }

    @Get( "/{id}")
    fun findById(id: String): Optional<Payee> {
       LOG.info("Find Payee by ID {}",id)

        return payeeRepository.findById(id.toLong())
    }

    @Post("/add")
    fun addPayee(@Body payee: Payee):Payee {
        println("received $payee")

        return payeeRepository.save(payee)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(PayeeController::class.java)
    }
}