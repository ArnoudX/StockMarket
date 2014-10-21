package models

import reactivemongo.bson._
import models.persistance._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent._
import scala.util.Success
import scala.util.Failure
import scala.concurrent.duration._
import scala.language.postfixOps

case class Chart(
  id: BSONObjectID = BSONObjectID.generate,
  errors: String,
  source_name: String,
  source_code: String,
  code: String,
  name: String
  /*urlize_name: String,
  display_url: String,
  description: String,
  updated_at: Option[DateTime],
  frequency: String,
  from_date: Option[DateTime],
  to_date: Option[DateTime],
  column_names: Array[String],
  privacy: String,
  type_value: String,
  premium: String,
  data: Array[DateTime]*/
)

object Chart{
  object ChartReader extends BSONDocumentReader[Chart] {
    def read(doc: BSONDocument): Chart = Chart(
        doc.getAs[BSONObjectID]("_id").get,
        doc.getAs[String]("errors").get,
        doc.getAs[String]("source_name").get,
        doc.getAs[String]("source_code").get,
        doc.getAs[String]("code").get,
         doc.getAs[String]("name").get
    )
  }
}