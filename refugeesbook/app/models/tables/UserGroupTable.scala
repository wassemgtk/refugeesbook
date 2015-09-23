package models.tables

import models.entities.UserGroup
import services.Profile

trait UserGroupTable {
  this: Profile =>

  import profile.api._

  class UserGroups(tag: Tag) extends Table[UserGroup](tag, "user_group") {
    def name = column[String]("name")

    def permission = column[String]("permission")

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (name, permission, id.?) <>(UserGroup.tupled, UserGroup.unapply)
  }

  val userGroups = TableQuery[UserGroups]
}
