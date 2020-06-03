package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Customer
import org.example.domain.query.QCustomer
import org.example.domain.scalartype.Email
import org.example.domain.scalartype.ValidEmail

abstract class CustomerFinder : Finder<Long,Customer>(Customer::class.java) {

  fun findByName(name: String): Customer? {

    val c = QCustomer._alias

    return QCustomer()
      .select(c.id, c.name)
      .name.istartsWith(name)
      .findOne()
  }

  fun findByEmail(email: ValidEmail): Customer? {
    TODO("Search by email")
    QCustomer()
    // .email.eq(email)
      .findOne()
  }
}
