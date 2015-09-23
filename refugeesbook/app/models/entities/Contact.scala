package models.entities

case class Contact(
                    countryId: Long,
                    zoneId: Long,
                    contactName: String,
                    contactNumber: String,
                    contactType: String,
                    contactChannel: String,
                    description: String,
                    id: Option[Long] = None
                    )