package org.example.domain.scalartype

sealed class Email(
  val fullEmail: String
)

class ValidEmail(fullEmail: String) : Email(fullEmail) {
  init {
    check(fullEmail.matches(EMAIL_VALIDATOR)) { "$fullEmail is an invalid email" }
  }
}

class UncheckedEmail(fullEmail: String) : Email(fullEmail)

internal val EMAIL_VALIDATOR =
  Regex("([%a-zåäö0-9!#$&'*+-/=?^_`{|}~]+)@([-a-zåäö0-9.]+\\.[a-zåäö]{2,})", RegexOption.IGNORE_CASE)
