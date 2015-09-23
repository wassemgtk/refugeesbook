package controllers

import models.entities.{News, Zone, Country}
import play.api.mvc._
import services.Services
import scala.concurrent.ExecutionContext.Implicits.global

class MapController extends Controller with Services{
  def index(countryName: String, zoneName: String) = Action async  {
    for {
      country <- countryService.getByName(countryName)
      zone <- zoneService.getByName(zoneName)
      news <- newsService.getByZoneName(zoneName)
    } yield (country, zone, news) match {
      case (country: Country, zone: Zone, news: Iterable[News]) =>
        Ok(views.html.services.news(country, zone, news))
      case _ =>
        Redirect(routes.HomeController.index).flashing(
          "error" -> "Please select correct Country and Zone"
        )
    }
  }
}
