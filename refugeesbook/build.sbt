name := """refugeesbook"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  evolutions,
  filters,
  "mysql" % "mysql-connector-java" % "5.1.22",
  "com.typesafe.slick" %% "slick" % "3.0.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "io.strongtyped" %% "active-slick" % "0.3.1",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
