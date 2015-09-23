package models.tables

import services.Profile

trait Schemas extends CountryTable
with ZoneTable
with UserGroupTable
with UserTable
with NewsTable
with FacebookGroupTable
with ContactTable {
  this: Profile =>

  import profile.api._

  val schemas: Vector[TableQuery[_ <: Table[_]]] = Vector(countries, zones, contacts, news, users)
}