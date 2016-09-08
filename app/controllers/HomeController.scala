package controllers


import javax.inject.Inject

import akka.actor.{ActorSystem, Props}
import play.api.Logger
import play.api.mvc._
import services.kafka.consumer.KafkaConsumer
import services.kafka.producer.{KafkaProducer, ProducerActor, Start}


class HomeController @Inject()(system: ActorSystem) extends Controller {

  val topic = "demo-topic"
  val groupId = "demo-topic-consumer"

  val consumer: KafkaConsumer = new KafkaConsumer(topic, groupId, "localhost:2181")

  val producer: KafkaProducer = new KafkaProducer("localhost:9092")


  def index = Action {

    Ok("Your new application is ready.")
  }


  def start = Action {
    Logger.info("Staring..........................")
    val producerActor = system.actorOf(Props(classOf[ProducerActor], producer))
    producerActor ! Start
   // val cosumerActor = system.actorOf(Props(classOf[ProducerActor], producer))
    //cosumerActor ! Start

    Ok("Producer & consumer have started")
  }


}




