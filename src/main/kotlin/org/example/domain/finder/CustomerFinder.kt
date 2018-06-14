package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Customer

open class CustomerFinder : Finder<Long,Customer>(Customer::class.java) {

  fun findByName(name: String): Customer? {

    return query().where().eq("name", name).findOne()
  }
}
