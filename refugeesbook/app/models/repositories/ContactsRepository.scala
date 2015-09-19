package models.repositories

import models.entities.Contact
import models.tables.{ZoneTable, CountryTable, ContactTable}
import play.api.Logger
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait ContactRepositoryComponent {
  this: Profile with DBConnection with ContactTable with CountryTable with ZoneTable =>

  import profile.api._

  class ContactRepository {

    def getById(id: Long): Future[Option[Contact]] = {
      db.run(contacts.filter(_.id === id).result.headOption)
    }

    def getAll(): Future[Iterable[Contact]] = {
      db.run(contacts.result)
    }

    def getByCountry(countryId: Long): Future[Iterable[Contact]] = {
      db.run(contacts.filter(_.countryId === countryId).result)
    }

    def getByCountryName(countryName: String): Future[Iterable[Contact]] = {
      db.run {
        (contacts join countries on (_.countryId === _.id))
          .filter(_._2.name like s"%${countryName}%")
          .map(_._1)
          .result
      }
    }

    def getByZoneName(zoneName: String): Future[Iterable[Contact]] = {
      db.run {
        (contacts join zones on (_.zoneId === _.id))
          .filter(_._2.name like s"%${zoneName}%")
          .map(_._1)
          .result
      }
    }
  }

}