package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.OrderLine

abstract class OrderLineFinder : Finder<Long, OrderLine>(OrderLine::class.java)

