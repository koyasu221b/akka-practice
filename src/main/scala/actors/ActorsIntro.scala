package actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {

  // actor system
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  // create actors

  // word count actor
  class WordCountActor extends Actor {
    // internal data
    var totalWords = 0

    // behavior
    def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        println(s"[word counter] I have received: $message")
        totalWords += message.split(" ").length;

      case msg => println(s"[word counter] I cannot understand ${msg.toString}");
    }
  }

  // instantiate our actor
  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordCounter")
  val anotherWordCounter = actorSystem.actorOf(Props[WordCountActor], "anotherWordCounter")


  // communicate!

  wordCounter.!("I am learning Akka and it's pretty damn cool!")
  anotherWordCounter.!("A different message")


  object Person {
    def props(name: String) = Props(new Person(name))
  }

  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case "hi" => println(s"Hi, my name is $name")
      case _ =>
    }
  }

  val person = actorSystem.actorOf(Person.props("Bob"))
  person ! "hi"
}
