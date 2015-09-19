package controllers

import models.entities.{FacebookGroup, News, Zone, Country}
import play.api.mvc.{Action, Controller}
import services.Services
import scala.concurrent.ExecutionContext.Implicits.global

class FacebookPagesController extends Controller with Services{
  def index(countryName: String, zoneName: String) = Action async  {
    for {
      country <- countryService.getByName(countryName)
      zone <- zoneService.getByName(zoneName)
      groups <- fbGroupRepository.getByZoneName(zoneName)
    } yield (country, zone, news) match {
      case (Some(country: Country), Some(zone: Zone), groups: Iterable[FacebookGroup]) =>
        Ok(views.html.services.facebookPages(country, zone, groups))
      case _ =>
        Redirect(routes.HomeController.index).flashing(
          "error" -> "Please select correct Country and Zone"
        )
    }
  }
}