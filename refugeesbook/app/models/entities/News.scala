package models.entities

case class News(
                 countryId: Long,
                 zoneId: Long,
                 title: String,
                 description: String,
                 id: Option[Long] = None
                 )