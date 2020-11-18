package org.hoss.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Payee(
    @Id
    @GeneratedValue
    var id: Long,
    val name: String)