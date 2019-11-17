package org.example.domain

import io.ebean.annotation.DbEnumValue

enum class Sex(@get:DbEnumValue val code: String) {
  MALE("1"),
  FEMALE("2"),
  DEFAULT("0");
  override fun toString(): String {
    return code
  }
}
