package models.tables

import services.Profile

trait Schemas extends CountryTable with ZoneTable{
  this: Profile =>
  import profile.api._
  val schemas: Vector[TableQuery[_ <: Table[_]]] = Vector(countries,zones)
}