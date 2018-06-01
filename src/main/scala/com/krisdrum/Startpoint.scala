package com.krisdrum

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import simpliestWebservice.{ClientRoutes, SimpliestWebservice}

object Startpoint extends App with ClientRoutes {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  Http().bindAndHandle(test, "localhost", 5000)
}
