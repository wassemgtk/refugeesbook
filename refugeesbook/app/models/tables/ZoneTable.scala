package models.tables

import models.entities.Zone
import services.Profile

trait ZoneTable {
  this: Profile =>

  import profile.api._

  class Zones(tag: Tag) extends Table[Zone](tag, "zone") {
    def countryId = column[Long]("country_id")

    def name = column[String]("name")

    def code = column[String]("code")

    def status = column[Boolean]("status")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (countryId, name, code, status, id.?) <>(Zone.tupled, Zone.unapply)
  }

  val zones = TableQuery[Zones]
}
