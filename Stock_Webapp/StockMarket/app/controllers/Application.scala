package controllers

import play.api._
import play.api.mvc._

import reactivemongo.api._
import reactivemongo.bson._
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {
    def index = 
    Action {	 
	  	Ok(views.html.chart())
  	}
}
