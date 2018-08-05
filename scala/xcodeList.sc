#!/usr/bin/env amm

import ammonite.ops._

import ammonite._, Resolvers._
val beta = Resolver.Http(
  "uh-beta",
   "http://beta.hpcc.uh.edu/nexus/content/groups/public",
   MavenPattern,
   false
 )
interp.resolvers() = interp.resolvers() :+ beta


import $ivy.`edu.unc.epidoc:transcoder:1.2-SNAPSHOT`
import edu.unc.epidoc.transcoder.TransCoder

val xcoder = new TransCoder()
xcoder.setParser("Unicode")
xcoder.setConverter("BetaCode")





val src = cwd/"words.txt"
val wordlines = read.lines!(src)

val betawds = wordlines.map(w => xcoder.getString(w).toLowerCase)

for (w <- betawds) { println(w)}
