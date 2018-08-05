
// Counts frequencies of strings in a list
// read from a file.
//

object TokenHistogram {

  val usg = "Usage: scala TokenHistogram FILENAME[...]"

  def main (args: Array[String]) {
    if (args.length < 1) {
      println (usg)

    } else {
      val histo = scala.collection.mutable.Map[String, Int]()
      var totalTokens = 0
      for (arg <- args) {
        val tokenList = scala.io.Source.fromFile(arg, "UTF-8").getLines()
        for (oneToken <- tokenList) {
          totalTokens = totalTokens + 1
          if (histo.contains(oneToken)) {
            val newCount = histo(oneToken) + 1
            histo(oneToken) = newCount
          } else {
            histo(oneToken) = 1
          }
        }
      }


      val countSort = histo.toList sortBy {_._2}
      var runningTotal = 0.0
      println ("token\tcount\trunning total\trunning pct.")
      for ((k,v) <- countSort.reverse) {
        runningTotal = runningTotal + v
        val twoPlaces = (math floor (100*runningTotal / totalTokens) * 100) / 100
        println (k + "\t" + v + "\t" + runningTotal + "\t" + twoPlaces)
      }
    }
  }
}
