package services


trait Services
  extends DBConnection
  with CountryServiceComponent
  with ZoneServiceComponent {

}