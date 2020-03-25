package ru.tinkoff.gatling.kafka.request.builder

import io.gatling.core.session.Expression
import scala.collection.immutable.HashMap

case class KafkaRequestBuilderBase(requestName: Expression[String]) {

  def send[K, V](key: Expression[K], payload: Expression[V])(implicit sender: Sender[K, V]): RequestBuilder[K, V] =
    sender.send(requestName, Some(key), payload, HashMap())

  def send[V](payload: Expression[V])(implicit sender: Sender[Nothing, V]): RequestBuilder[_, V] =
    sender.send(requestName, None, payload, HashMap())

  def send[K, V](key: Expression[K], payload: Expression[V], headers: Map[String, String])(implicit sender: Sender[K, V]): RequestBuilder[K, V] =
    sender.send(requestName, Some(key), payload, headers)
}

