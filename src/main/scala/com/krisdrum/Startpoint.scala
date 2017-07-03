package com.krisdrum

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import reactiveStream.ReactiveStream
import simpliestWebservice.SimpliestWebservice

object Startpoint extends App with ReactiveStream with SimpliestWebservice {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  Http().bindAndHandle(route ~ reactiveStream, "localhost", 5000)
}
