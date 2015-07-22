import com.typesafe.sbt.SbtStartScript

// Change to actual project name
name := "ProjectName"

seq(SbtStartScript.startScriptForClassesSettings: _*)

version := "0.1"

scalaVersion := "2.11.4"

wartremoverErrors ++= Seq(
  Wart.Any,
  Wart.Any2StringAdd,
  Wart.EitherProjectionPartial,
  Wart.OptionPartial,
  Wart.Product,
  Wart.Serializable,
  Wart.ListOps,
  Wart.Nothing
)

scalacOptions ++= Seq(
  "-deprecation",           
  "-encoding", "UTF-8",       // yes, this is 2 args
  "-feature",                
  "-unchecked",
  "-language:postfixOps",
  "-Xfatal-warnings",       
  "-Xlint",
  "-Yno-adapted-args",       
  "-Ywarn-dead-code",        // N.B. doesn't work well with the ??? hole
  "-Ywarn-numeric-widen",   
  "-Ywarn-value-discard",
  "-Xfuture"
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// Standard for most KTP Apps cases. Others will be needed. Consult other projects for reference
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.6",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "hirondelle.date4j" % "date4j" % "1.0" from "http://www.date4j.net/date4j.jar",
  "io.spray" %% "spray-routing-shapeless2" % "1.3.2",
  "io.spray" %% "spray-can" % "1.3.2",
  "io.spray" %% "spray-client" % "1.3.2",
  "io.spray" %% "spray-json" % "1.3.1",
  "net.virtual-void" %%  "json-lenses" % "0.6.0"
)

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Maven Central" at "http://repo1.maven.org/maven2"
)

retrieveManaged := true

// reduce the maximum number of errors shown by the Scala compiler
maxErrors := 20

// increase the time between polling for file changes when using continuous execution
pollInterval := 1000

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

incOptions := incOptions.value.withNameHashing(true)

// set the prompt (for this build) to include the project id.
shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

// set the prompt (for the current project) to include the username
shellPrompt := { state => System.getProperty("user.name") + "> " }

// only show 20 lines of stack traces
traceLevel := 20

logLevel := Level.Info

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}