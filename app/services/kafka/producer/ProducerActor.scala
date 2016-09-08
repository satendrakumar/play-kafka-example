package services.kafka.producer

import akka.actor.Actor
import play.api.Logger

class ProducerActor(producer: KafkaProducer) extends Actor {

  val topic = "demo-topic"

  def receive: Receive = {
    case Start =>
      Logger.info("Got message........................")
      startProducer()

  }

  def startProducer() = {
    Logger.info("Sending........................")
    val batchSize = 10
    (1 to 10000).map(no => "Message " + no).grouped(batchSize).foreach { message =>

      Logger.info("Sending message batch size " + message.length)

      producer.send(topic, message)
      Thread.sleep(1000)

    }

  }


}


case object Start