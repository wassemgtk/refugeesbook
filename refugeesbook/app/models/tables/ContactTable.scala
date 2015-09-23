package models.tables

import models.entities.Contact
import services.Profile

trait ContactTable {
  this: Profile =>

  import profile.api._

  class Contacts(tag: Tag) extends Table[Contact](tag, "contacts") {
    def countryId = column[Long]("country_id")

    def zoneId = column[Long]("zone_id")

    def contactName = column[String]("contact_name")

    def contactNumber = column[String]("contact_number")

    def contactType = column[String]("contact_type")

    def contactChannel = column[String]("contact_channel")

    def description = column[String]("description")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (countryId, zoneId, contactName, contactNumber, contactType, contactChannel, description, id.?) <>(Contact.tupled, Contact.unapply)
  }

  val contacts = TableQuery[Contacts]
}
