#!/usr/bin/env amm

// cite lib only available from UH right now,
// so need to add this to list of resolvers.
import ammonite._, Resolvers._
val beta = Resolver.Http(
  "uh-beta",
   "http://beta.hpcc.uh.edu/nexus/content/groups/public",
   MavenPattern,
   false
 )
interp.resolvers() = interp.resolvers() :+ beta


// Note double colon for ivy pattern of scala libs.
import $ivy.`io.github.cite_architecture::cite:1.1.3`
import io.github.cite_architecture.cite._

val u = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:")
println(u)
