import edu.holycross.shot.ohco2._
import edu.holycross.shot.cite._
import scala.io.Source
import edu.holycross.shot.greek._
import edu.holycross.shot.mid.validator._


case class GreekLex(urn: CtsUrn, greek: LiteraryGreekString)

val cex = "editions/lysias1-twocols.cex"

def loadCorpus(srcFile: String = cex) : Corpus = {
  println("Loading corpus...")
  val cex = Source.fromFile(srcFile).getLines.mkString("\n")
  val c = Corpus(cex)
  println("Done.")
  c
}






def tokens(corpus: Corpus = loadCorpus()) : Vector[MidToken] = {
  LiteraryGreekString.tokenizeCorpus(corpus)
}

def lexical(tokens: Vector[MidToken]  ): Vector[MidToken] = {
  tokens.filter(_.tokenCategory.toString == "Some(LexicalToken)")
}

def greekLex(tokens: Vector[MidToken]) : Vector[GreekLex] = {
  tokens.map(tkn => GreekLex(tkn.urn, LiteraryGreekString(tkn.string)))
}

def histogram(tokens: Vector[MidToken] ) : Vector[(String, Int)]= {
  val grouped = tokens.groupBy(_.string)
  val counted =  grouped.map{ case (k,v) => (k,v.size) }
  counted.toSeq.sortBy(_._2).reverse.toVector
}



def defaultHist : Vector[(String, Int)] = {
  val tkns = tokens()
  val lex = lexical(tkns)
  histogram(lex)
}


def thresholdN(histo: Vector[(String, Int)], n: Int = 3) = {
  histo.filter(_._2 >= n)
}

def topN(histo: Vector[(String, Int)], n: Int = 100) = {
  histo.take(100)
}

/*
def zipf(histo:  Vector[(String,Int)]) : Vector[(Int, Int)] = {
  val cnts = histo.groupBy(_._2)
  val freqs = cnts.toSeq.map{ case (count, v) => (count, v.size) }
}
*/
