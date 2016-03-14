
// ParaParser.scala
//
// Reads in one or more TEI XML files with citable nodes
// identified by @n attribute on <p> elements in the body
// (e.g., orations of Lysias), writes to standard output,
// in document order, two tab-delimited columns:
// 1. citation value on @n attribute
// 2. token string
//
import scala.xml.XML

object ParaParser {
  val usg = "Usage: scala ParaParser FILENAME[...]"

  def main (args: Array[String]) {
    if (args.length < 1) {
      println (usg)

    } else {
      for (arg <- args) {
        val root = XML.loadFile(arg)
        // Grab all <p> elements anywhere in the body of the text:
        val paras = root \\ "body" \\ "p"
        for (para <- paras) {
          // citation value:
          val n = para \ "@n"
          // split paragraph text on occurrences of 1 or more
          // white space or punctuation characters:
          val allTokens = para.text.split("""[\s,\.\:\(\);]+""")
          for (oneToken <- allTokens) {
            println (n + "\t" + oneToken)
          }
        }
      }
    }
  }
}
