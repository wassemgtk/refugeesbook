package models.tables

import java.sql.Timestamp

import models.entities.User
import org.joda.time.DateTime
import services.Profile

trait UserTable {
  this: Profile =>

  import profile.api._

  class Users(tag: Tag) extends Table[User](tag, "user") {

    def userGroupId = column[Long]("user_group_id")

    def username = column[String]("username")

    def password = column[String]("password")

    def salt = column[String]("salt")

    def firstName = column[String]("firstname")

    def lastName = column[String]("lastname")

    def email = column[String]("email")

    def code = column[String]("code")

    def ip = column[String]("ip")

    def status = column[Boolean]("status")

    def dateAdded = column[Timestamp]("date_added")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (userGroupId, username, password, salt, firstName, lastName, email, code, ip, status, dateAdded, id.?) <>(User.tupled, User.unapply)
  }

  val users = TableQuery[Users]
}
