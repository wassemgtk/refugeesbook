package controllers


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
}

