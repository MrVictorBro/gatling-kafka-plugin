package ru.tinkoff.gatling.kafka.request.builder

import com.sksamuel.avro4s.{FromRecord, RecordFormat, SchemaFor}
import io.gatling.core.session.Expression

case class Avro4sAttributes[K, V](requestName: Expression[String],
                                  key: Option[Expression[K]],
                                  payload: Expression[V],
                                  headers: Map[String, String],
                                  schema: SchemaFor[V],
                                  format: RecordFormat[V],
                                  fromRecord: FromRecord[V])
