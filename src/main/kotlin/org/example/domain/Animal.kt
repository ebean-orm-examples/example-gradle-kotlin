package org.example.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Animal(

  var name: String,

  @ManyToOne
  var owner: Owner

) : BaseModel() {

  var age : Int = 0

  var type : String? = null

  var notes: String? = null
}
