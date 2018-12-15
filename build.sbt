name := "learningInduction"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

version := "0.1"

scalaVersion := "2.12.8"


libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3"
)