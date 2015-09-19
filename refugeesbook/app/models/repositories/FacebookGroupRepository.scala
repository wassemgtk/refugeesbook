package models.repositories

import models.entities.FacebookGroup
import models.tables.{ZoneTable, CountryTable, FacebookGroupTable}
import play.api.Logger
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait FacebookGroupRepositoryComponent {
  this: Profile with DBConnection with FacebookGroupTable with CountryTable with ZoneTable =>

  import profile.api._

  class FacebookGroupRepository {

    def getById(id: Long): Future[Option[FacebookGroup]] = {
      db.run(fbGroups.filter(_.id === id).result.headOption)
    }

    def getAll(): Future[Iterable[FacebookGroup]] = {
      db.run(fbGroups.result)
    }

    def getByCountry(countryId: Long): Future[Iterable[FacebookGroup]] = {
      db.run(fbGroups.filter(_.countryId === countryId).result)
    }

    def getByCountryName(countryName: String): Future[Iterable[FacebookGroup]] = {
      db.run {
        (fbGroups join countries on (_.countryId === _.id))
          .filter(_._2.name like s"%${countryName}%")
          .map(_._1)
          .result
      }
    }

    def getByZoneName(zoneName: String): Future[Iterable[FacebookGroup]] = {
      db.run {
        (fbGroups join zones on (_.zoneId === _.id))
          .filter(_._2.name like s"%${zoneName}%")
          .map(_._1)
          .result
      }
    }
  }

}