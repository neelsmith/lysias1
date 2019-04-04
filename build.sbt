resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")
//resolvers += Resolver.bintrayRepo("cibotech", "public")
scalaVersion := "2.12.4"
libraryDependencies ++= Seq(
  "edu.holycross.shot.cite" %% "xcite" % "3.7.0",
  "edu.holycross.shot" %% "ohco2" % "10.11.1",
  "edu.holycross.shot" %% "greek" % "2.2.0",
  "edu.holycross.shot" %% "kanones" % "1.0.0",

  "edu.holycross.shot" %% "midvalidator" % "5.2.1" //,

   //"com.cibo" %% "evilplot-repl" % "0.6.3"
)
