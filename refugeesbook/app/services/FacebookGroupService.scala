package services

import models.entities.FacebookGroup
import models.repositories.FacebookGroupRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait FacebookGroupServiceComponent extends FacebookGroupRepositoryComponent with Schemas with DBConnection {
  val fbGroupService: FacebookGroupService = new FacebookGroupService

  val fbGroupRepository: FacebookGroupRepository = new FacebookGroupRepository

  class FacebookGroupService {
    def getById(id: Long): Future[Option[FacebookGroup]] = fbGroupRepository.getById(id)

    def getAll(): Future[Iterable[FacebookGroup]] = fbGroupRepository.getAll()

    def getByCountry(countryId: Long): Future[Iterable[FacebookGroup]] = fbGroupRepository.getByCountry(countryId)

    def getByCountryName(countryName: String): Future[Iterable[FacebookGroup]] = fbGroupRepository.getByCountryName(countryName)

    def getByZoneName(contactName: String): Future[Iterable[FacebookGroup]] = fbGroupRepository.getByZoneName(contactName)

  }

}