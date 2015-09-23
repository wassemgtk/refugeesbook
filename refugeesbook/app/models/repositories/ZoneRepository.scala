package models.repositories

import models.entities.Zone
import models.tables.{CountryTable, ZoneTable}
import play.api.Logger
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait ZoneRepositoryComponent {
  this: Profile with DBConnection with ZoneTable with CountryTable =>

  import profile.api._

  class ZoneRepository {

    def getById(id: Long): Future[Option[Zone]] = {
      db.run(zones.filter(_.id === id).result.headOption)
    }

    def getAll(): Future[Iterable[Zone]] = {
      db.run(zones.result)
    }

    def getByCountry(countryId: Long): Future[Iterable[Zone]] = {
      db.run(zones.filter(_.countryId === countryId).result)
    }

    def getByCountryName(countryName: String): Future[Iterable[Zone]] = {
      db.run {
        (zones join countries on (_.countryId === _.id))
          .filter(_._2.name like s"%${countryName}%")
          .map(_._1)
          .result
      }
    }

    def getByName(name: String): Future[Option[Zone]] = {
      db.run(zones.filter(_.name like s"%$name%").result.headOption)
    }
  }

}