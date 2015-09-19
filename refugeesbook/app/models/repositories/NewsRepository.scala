package models.repositories

import models.entities.News
import models.tables.NewsTable
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait NewsRepositoryComponent {
  this: Profile with DBConnection with NewsTable =>

  import profile.api._

  class NewsRepository {

    def getById(id: Long): Future[Option[News]] = {
      db.run(news.filter(_.id === id).result.headOption)
    }

    def getAll(): Future[Iterable[News]] = {
      db.run(news.result)
    }
  }

}