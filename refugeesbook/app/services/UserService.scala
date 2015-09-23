package services

import models.entities.User
import models.repositories.UserRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait UserServiceComponent extends UserRepositoryComponent with Schemas with DBConnection {
  val userService: UserService = new UserService

  val userRepository: UserRepository = new UserRepository

  class UserService {
    def getById(id: Long): Future[Option[User]] = userRepository.getById(id)

    def getByUsername(username: String): Future[Option[User]] = userRepository.getByUsername(username)

    def getAll(): Future[Iterable[User]] = userRepository.getAll()
  }

}