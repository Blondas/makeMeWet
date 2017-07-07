package com.krisdrum.simpliestWebservice

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.http.scaladsl.server.Route

trait SimpliestWebservice {

  val route: Route = path("hello") {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to Holiday Check</h1>"))
    }
  }

}
