package services

import models.entities.News
import models.repositories.NewsRepositoryComponent
import models.tables.Schemas

import scala.concurrent.Future

trait NewsServiceComponent extends NewsRepositoryComponent with Schemas with DBConnection {
  val newsService: NewsService = new NewsService

  val newsRepository: NewsRepository = new NewsRepository

  class NewsService {
    def getById(id: Long): Future[Option[News]] = newsRepository.getById(id)

    def getAll(): Future[Iterable[News]] = newsRepository.getAll()

    def getByZoneName(zoneName: String): Future[Iterable[News]] = newsRepository.getByZoneName(zoneName)
  }

}