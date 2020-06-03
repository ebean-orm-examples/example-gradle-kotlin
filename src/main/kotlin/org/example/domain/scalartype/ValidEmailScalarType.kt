package org.example.domain.scalartype

import io.ebean.config.ScalarTypeConverter

@Suppress("unused")
class ValidEmailScalarType : ScalarTypeConverter<ValidEmail, String> {
  override fun getNullValue() = null

  override fun wrapValue(email: String) = ValidEmail(email)

  override fun unwrapValue(email: ValidEmail) = email.fullEmail
}
