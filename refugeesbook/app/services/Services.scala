package services


trait Services
  extends DBConnection
  with CountryServiceComponent
  with NewsServiceComponent
  with UserServiceComponent
  with ContactServiceComponent
  with FacebookGroupServiceComponent
  with ZoneServiceComponent {

}