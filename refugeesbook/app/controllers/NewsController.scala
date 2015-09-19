package controllers

import models.entities.{News, Zone, Country}
import play.api.Logger
import play.api.mvc._
import services.Services
import scala.concurrent.ExecutionContext.Implicits.global

class NewsController extends Controller with Services {
  def index(countryName: String, zoneName: String) = Action async {
    for {
      country <- countryService.getByName(countryName)
      zone <- zoneService.getByName(zoneName)
      news <- newsService.getByZoneName(zoneName)
    } yield (country, zone, news) match {
      case (Some(country: Country), Some(zone: Zone), news: Iterable[News]) =>
        Ok(views.html.services.news(country, zone, news))
      case other =>
        Logger.info(other.toString)
        Redirect(routes.HomeController.index).flashing(
          "error" -> "Please select correct Country and Zone"
        )
    }
  }
}
