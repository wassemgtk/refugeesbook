package models.repositories

import models.entities.User
import models.tables.UserTable
import play.api.Logger
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait UserRepositoryComponent {
  this: Profile with DBConnection with UserTable =>

  import profile.api._

  class UserRepository {

    def getById(id: Long): Future[Option[User]] = {
      db.run(users.filter(_.id === id).result.headOption)
    }

    def getByUsername(username: String): Future[Option[User]] = {
      db.run(users.filter(_.username like s"%$username%").result.headOption)
    }

    def getAll(): Future[Iterable[User]] = {
      db.run(users.result)
    }
  }

}