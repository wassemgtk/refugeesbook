package services

import models.entities.Zone
import models.repositories.ZoneRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait ZoneServiceComponent extends ZoneRepositoryComponent with Schemas with DBConnection {
  val zoneService: ZoneService = new ZoneService

  val zoneRepository: ZoneRepository = new ZoneRepository

  class ZoneService {
    def getById(id: Long): Future[Option[Zone]] = zoneRepository.getById(id)

    def getAll(): Future[Iterable[Zone]] = zoneRepository.getAll()

    def getByCountry(countryId: Long): Future[Iterable[Zone]] = zoneRepository.getByCountry(countryId)

    def getByCountryName(countryName: String): Future[Iterable[Zone]] = zoneRepository.getByCountryName(countryName)
  }

}