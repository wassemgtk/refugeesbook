package models.entities

case class Zone(
                 countryId: Long,
                 name: String,
                 code: String,
                 status: Boolean,
                 id: Option[Long] = None
                 )