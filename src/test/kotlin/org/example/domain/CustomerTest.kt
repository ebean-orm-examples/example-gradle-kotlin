package org.example.domain

import org.example.domain.query.QCustomer
import org.example.domain.query.QOrder
import org.example.domain.scalartype.ValidEmail
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertNotNull
import kotlin.test.fail
import org.example.domain.query.QCustomer.Companion._alias as c

class CustomerTest {

  @Test
  fun query() {

    assertNotNull(
      QCustomer()
        .select(c.name)
        .name.equalToOrNull("Rob")
        .raw("name is null or name =?", "Rob")
        .findOne(),
      "No Rob by name"
    )
  }

  @Test
  fun `query by email`() {
    assertNotNull(
      Customer.findByEmail(ValidEmail("foo@example.com")),
      "No Rob by email"
    )
  }

  @Test
  fun save() {
    val rob = Customer.findByName("Rob") ?: fail("no rob")

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

  @After
  fun tearDown() {
    val customer = Customer.findByName("Rob")
    customer?.orders?.forEach {
      it.delete()
    }
    customer?.delete()
  }

  @Before
  fun setup() {

    Product("DK1", "Desk").save()
    Product("DK2", "Desk 2").save()
    Product("CH3", "Chair 3").save()

    val customer = Customer(ValidEmail("foo@example.com"), "Rob")
    customer.creditLimit = BigDecimal("1000")
    customer.save()
  }
}
