package models.repositories

import models.entities.Country
import models.tables.CountryTable
import play.api.Logger
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait CountryRepositoryComponent {
  this: Profile with DBConnection with CountryTable =>

  import profile.api._

  class CountryRepository {

    def getById(id: Long): Future[Option[Country]] = {
      db.run(countries.filter(_.id === id).result.headOption)
    }

    def getByName(name: String): Future[Option[Country]] = {
      db.run(countries.filter(_.name like s"%$name%").result.headOption)
    }

    def getAll(): Future[Iterable[Country]] = {
      db.run(countries.result)
    }
  }

}