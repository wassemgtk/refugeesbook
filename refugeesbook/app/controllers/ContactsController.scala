package controllers

import models.entities.{Contact, Zone, Country}
import play.api.mvc.{Action, Controller}
import services.Services
import scala.concurrent.ExecutionContext.Implicits.global

class ContactsController extends Controller with Services {
  def index(countryName: String, zoneName: String) = Action async {
    for {
      country <- countryService.getByName(countryName)
      zone <- zoneService.getByName(zoneName)
      contacts <- contactService.getByZoneName(zoneName)
    } yield (country, zone, contacts) match {
      case (Some(country: Country), Some(zone: Zone), contacts: Iterable[Contact]) =>
        Ok(views.html.services.contacts(country, zone, contacts))
      case _ =>
        Redirect(routes.HomeController.index).flashing(
          "error" -> "Please select correct Country and Zone"
        )
    }
  }
}