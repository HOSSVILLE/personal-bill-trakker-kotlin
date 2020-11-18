package org.hoss.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class PayDates (
        @Column(name="paydate") var payDate: Date,
        @Id @Column(name="week_of_year") var weekOfYear: Int)
