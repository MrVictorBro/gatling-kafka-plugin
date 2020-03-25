package ru.tinkoff.gatling.kafka.utils

import java.util
import java.util.stream.Collectors

import org.apache.kafka.common.header.Header
import org.apache.kafka.common.header.internals.RecordHeader

import scala.collection.JavaConverters.mapAsJavaMap

object HeadersConverter {
  def mapToHeaders(headers: Map[String, String]): util.List[Header] =
    mapToHeaders(mapAsJavaMap(headers))

  def mapToHeaders(headers: util.Map[String, String]): util.List[Header] =
    headers.entrySet.stream
      .map[RecordHeader]{e: util.Map.Entry[String, String] => new RecordHeader(e.getKey, e.getValue.getBytes)}
      .collect{Collectors.toList[Header]}
}
