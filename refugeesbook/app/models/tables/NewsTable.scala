package models.tables

import models.entities.News
import services.Profile

trait NewsTable {
  this: Profile =>

  import profile.api._

  class NewsT(tag: Tag) extends Table[News](tag, "zone") {
    def countryId = column[Long]("country_id")

    def zoneId = column[Long]("zone_id")

    def title = column[String]("title")

    def description = column[String]("description")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (countryId, zoneId, title,description, id.?) <>(News.tupled, News.unapply)
  }

  val news = TableQuery[NewsT]
}
