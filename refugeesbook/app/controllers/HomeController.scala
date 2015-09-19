package controllers


import models.entities.{Zone, Country}
import play.api.Logger
import play.api.mvc._
import services.Services
import scala.concurrent.ExecutionContext.Implicits.global


class HomeController extends Controller with Services {

  def index = Action async { implicit request =>
    countryService.getAll.map { countries =>
      Ok(views.html.home(countries))
      //Logger.info(countries.toString)
    }
  }

  def zones(countryName: String) = Action async { implicit request =>
    for {
      country <- countryService.getByName(countryName)
      zones <- zoneService.getByCountryName(countryName)
    } yield {
      country match {
        case Some(country: Country) =>
          Ok(views.html.zones(country, zones))
        case other =>
          Redirect(routes.HomeController.index)
            .flashing(
              "error" -> "Please select correct country"
            )
      }
    }
  }

  def services(countryName: String, zoneName: String) = Action async { implicit request =>
    for {
      country <- countryService.getByName(countryName)
      zone <- zoneService.getByName(zoneName)
    } yield (country, zone) match {
      case (Some(country: Country), Some(zone: Zone)) =>
        Ok(views.html.zoneServices(country, zone))
      case other =>
        Redirect(routes.HomeController.index)
          .flashing(
            "error" -> "Please select correct country and zone"
          )
    }
  }

}

