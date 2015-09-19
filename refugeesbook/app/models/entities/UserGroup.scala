package models.entities

case class UserGroup(
                      name: String,
                      permission: String,
                      id: Option[Long] = None
                      )