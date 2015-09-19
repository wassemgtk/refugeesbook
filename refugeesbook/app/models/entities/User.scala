package models.entities

import java.sql.Timestamp

import org.joda.time.DateTime

case class User(
                 userGroupId: Long,
                 username: String,
                 password: String,
                 salt: String,
                 firstName: String,
                 lastName: String,
                 email: String,
                 code: String,
                 ip: String,
                 status: Boolean,
                 dateAdded: Timestamp,
                 id: Option[Long] = None
                 )