package org.example.domain

import javax.persistence.Entity

@Entity
class Owner(

  val name: String

) : BaseModel() {

  var phone:String? = null
}
