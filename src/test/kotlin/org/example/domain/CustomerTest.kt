package org.example.domain

import org.example.domain.query.QCustomer
import org.example.domain.query.QOrder
import org.junit.Test
import java.math.BigDecimal
import org.example.domain.query.QCustomer.Companion._alias as c

class CustomerTest {

  @Test
  fun qeru() {

    val customer = QCustomer()
      .select(c.name)
      .name.equalToOrNull("Rob")
      .raw("name is null or name =?", "Rob")
      .findOne()
  }

  @Test
  fun save() {

    setup()

    val customer = QCustomer()
      .select(c.name)
      .name.isNull
      .raw("name is null or name =?", "Rob")
      .findOne()

    val rob = Customer.findByName("Rob") ?: throw IllegalStateException("no rob")

    val products = Product.findMapBySku()

    val order = Order(rob)

    order.lines.add(OrderLine(products["DK1"]!!, 7))
    order.lines.add(OrderLine(products["DK2"]!!, 20))
    order.lines.add(OrderLine(products["CH3"]!!, 1))

    order.save()

    QOrder()
      .customer.name.startsWith("Ro")
      .findOne()
  }

  private fun setup() {

    Product("DK1", "Desk").save()
    Product("DK2", "Desk 2").save()
    Product("CH3", "Chair 3").save()

    val customer = Customer("Rob")
    customer.creditLimit = BigDecimal("1000")
    customer.save()
  }
}
