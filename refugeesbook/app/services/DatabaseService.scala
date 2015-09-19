package services

import play.api.Play
import slick.driver.{MySQLDriver, JdbcProfile}

trait Profile {
  val profile: JdbcProfile
}

trait DBConnection extends Profile {
  override val profile = MySQLDriver

  import profile.api._
  val db: Database = Database.forURL(driver = Play.current.configuration.getString("db.default.driver").get,
    user = Play.current.configuration.getString("db.default.username").get,
    password = Play.current.configuration.getString("db.default.password").get,
    url = Play.current.configuration.getString("db.default.url").get)
}