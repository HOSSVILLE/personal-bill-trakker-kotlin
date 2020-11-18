package org.hoss.repositories

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import org.hoss.models.Payee
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PayeeRepository : CrudRepository<Payee, Long> {
    override fun findAll(): List<Payee>
    override fun findById(id: Long): Optional<Payee>
}