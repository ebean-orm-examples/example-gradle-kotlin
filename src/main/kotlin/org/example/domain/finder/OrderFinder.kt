package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Order

abstract class OrderFinder : Finder<Long, Order>(Order::class.java)
