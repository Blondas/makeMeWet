package com.krisdrum.reactiveStream

import akka.actor.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, ThrottleMode}
import akka.stream.scaladsl.{Flow, Source}
import akka.util.ByteString
import scala.compat.Platform.EOL
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

trait ReactiveStream {
  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer
  implicit val executionContext: ExecutionContext


  val source = Source.repeat(s"Lorem ipsum$EOL")
    .via (Flow[String].map(ByteString(_)))
    .throttle(
      elements = 2,
      per = 1 second,
      maximumBurst = 1,
      mode = ThrottleMode.Shaping
    )

  val reactiveStream = path("reactive") {
        get {
          complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, source))
      }
    }
}
