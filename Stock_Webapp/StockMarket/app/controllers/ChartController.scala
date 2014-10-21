package controllers

import play.api._
import play.api.mvc._
import reactivemongo.bson._
import reactivemongo.api._
import scala.concurrent.ExecutionContext.Implicits.global

object Chart extends Controller {
  
  def index = Action {
    Ok(views.html.index())
  }

  // gets an instance of the driver
  // (creates an actor system)
  val driver = new MongoDriver
  val connection = driver.connection(List("localhost"))


 // Gets a reference to the database "plugin"
  val db = connection("data/db")

  // Gets a reference to the collection "acoll"
  // By default, you get a BSONCollection.
  val collection = db("stock_db")
        
  def listDocs() = {
    // Select only the documents which field 'firstName' equals 'Jack'
    val query = BSONDocument("code" -> "AAPL")
    // select only the field 'lastName'
    val filter = BSONDocument(
      "_id" -> 1,
      "code" -> 1
    )
    
    collection.find(query, filter).cursor[BSONDocument].enumerate().apply(Iteratee.foreach { doc =>
      println("Query successful: " + BSONDocument.pretty(doc))
    })
  }
}