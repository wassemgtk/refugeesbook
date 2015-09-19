package models.tables

import models.entities.FacebookGroup
import services.Profile

trait FacebookGroupTable {
  this: Profile =>

  import profile.api._

  class FacebookGroups(tag: Tag) extends Table[FacebookGroup](tag, "fb_group") {
    def countryId = column[Long]("country_id")

    def zoneId = column[Long]("zone_id")

    def groupName = column[String]("group_name")

    def groupUrl = column[String]("group_url")

    def groupID = column[String]("group_Id")


    def description = column[String]("description")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (countryId, zoneId, groupName, groupUrl, groupID, description, id.?) <>(FacebookGroup.tupled, FacebookGroup.unapply)
  }

  val fbGroups = TableQuery[FacebookGroups]
}
