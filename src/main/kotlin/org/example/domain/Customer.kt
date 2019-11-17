package org.example.domain

import io.ebean.annotation.Length
import org.example.domain.finder.CustomerFinder
import java.math.BigDecimal
import javax.persistence.*

@Entity
open class Customer(name: String) : BaseModel() {

  @Column(length = 150, unique = true)
  var name: String = name

  @Enumerated(EnumType.STRING)
  var sex: Sex = Sex.DEFAULT

  var other: String? = null

  var creditLimit: BigDecimal? = null

  @Length(500)
  var notes: String? = null

  @OneToMany(mappedBy = "customer")
  var orders: List<Order> = mutableListOf()

  companion object Find : CustomerFinder()
}
