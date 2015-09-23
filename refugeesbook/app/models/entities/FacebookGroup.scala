package models.entities

case class FacebookGroup(
                    countryId: Long,
                    zoneId: Long,
                    groupName: String,
                    groupUrl: String,
                    groupId: String,
                    description: String,
                    id: Option[Long] = None
                    )