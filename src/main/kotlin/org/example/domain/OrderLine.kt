package org.example.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class OrderLine(

  @ManyToOne
  var product: Product,

  var quantity : Int

) : BaseModel() {

  @ManyToOne(optional = false)
  var order: Order? = null

  var description: String? = null

}
