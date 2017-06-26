package org.example.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Customer {

  @Id
  var id: Long = 0

  var name: String = ""

  var version: Long = 0
}