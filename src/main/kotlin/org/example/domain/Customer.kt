package org.example.domain

import io.ebean.annotation.Length
import org.example.domain.finder.CustomerFinder
import org.example.domain.scalartype.ValidEmail
import java.math.BigDecimal
import javax.persistence.*

@Entity
class Customer(

  @Column(length = 50, unique = true)
  val email: ValidEmail,

  @Column(length = 150, unique = true)
  var name: String

) : BaseModel() {

  var sex: Sex = Sex.DEFAULT

  var other: String? = null

  var creditLimit: BigDecimal? = null

  @Length(500)
  var notes: String? = null

  @OneToMany
  var orders: List<Order> = mutableListOf()

  companion object Find : CustomerFinder()
}
