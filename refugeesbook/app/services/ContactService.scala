package services

import models.entities.Contact
import models.repositories.ContactRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait ContactServiceComponent extends ContactRepositoryComponent with Schemas with DBConnection {
  val contactService: ContactService = new ContactService

  val contactRepository: ContactRepository = new ContactRepository

  class ContactService {
    def getById(id: Long): Future[Option[Contact]] = contactRepository.getById(id)

    def getAll(): Future[Iterable[Contact]] = contactRepository.getAll()

    def getByCountry(countryId: Long): Future[Iterable[Contact]] = contactRepository.getByCountry(countryId)

    def getByCountryName(countryName: String): Future[Iterable[Contact]] = contactRepository.getByCountryName(countryName)

    def getByZoneName(contactName: String): Future[Iterable[Contact]] = contactRepository.getByZoneName(contactName)

  }

}