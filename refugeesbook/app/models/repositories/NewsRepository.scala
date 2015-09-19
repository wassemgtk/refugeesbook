package models.repositories

import models.entities.News
import models.tables.{ZoneTable, NewsTable}
import services.{DBConnection, Profile}
import scala.concurrent.Future


trait NewsRepositoryComponent {
  this: Profile with DBConnection with NewsTable with ZoneTable =>

  import profile.api._

  class NewsRepository {

    def getById(id: Long): Future[Option[News]] = {
      db.run(news.filter(_.id === id).result.headOption)
    }

    def getAll(): Future[Iterable[News]] = {
      db.run(news.result)
    }

    def getByZoneName(zoneName: String): Future[Iterable[News]] = {
      db.run {
        (news join zones on (_.zoneId === _.id))
          .filter(_._2.name like s"%$zoneName%")
          .map(_._1)
          .result
      }
    }
  }

}