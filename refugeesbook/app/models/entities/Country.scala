package models.entities

case class Country(
                          name: String,
                          isoCode2: String,
                          isoCode3: String,
                          addressFormat: String,
                          postcodeRequired: Boolean,
                          statue: Boolean,
                          id: Option[Long] = None
                          )