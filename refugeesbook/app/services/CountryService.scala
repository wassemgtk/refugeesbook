package services

import models.entities.Country
import models.repositories.CountryRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait CountryServiceComponent extends CountryRepositoryComponent with Schemas with DBConnection {
  val countryService: CountryService = new CountryService

  val countryRepository: CountryRepository = new CountryRepository

  class CountryService {
    def getById(id: Long): Future[Option[Country]] = countryRepository.getById(id)

    def getAll(): Future[Iterable[Country]] = countryRepository.getAll()
  }

}