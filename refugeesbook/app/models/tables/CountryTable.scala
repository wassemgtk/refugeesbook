package models.tables

import models.entities.Country
import services.Profile

trait CountryTable {
  this: Profile =>

  import profile.api._

  class Countries(tag: Tag) extends Table[Country](tag, "country") {
    def name = column[String]("name")

    def isoCode2 = column[String]("iso_code_2")

    def isoCode3 = column[String]("iso_code_3")

    def addressFormat = column[String]("address_format")

    def postcodeRequired = column[Boolean]("postcode_required")

    def status = column[Boolean]("status")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (name, isoCode2, isoCode3, addressFormat, postcodeRequired, status, id.?) <>(Country.tupled, Country.unapply)
  }

  val countries = TableQuery[Countries]
}
