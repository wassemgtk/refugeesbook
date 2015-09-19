package models.repositories

import models.tables.Schemas
import services.DBConnection

trait Repositories
  extends DBConnection
  with CountryRepositoryComponent
  with ZoneRepositoryComponent
  with Schemas {

}