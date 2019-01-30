import com.cibo.evilplot._
import com.cibo.evilplot.numeric._
import com.cibo.evilplot.plot._
import com.cibo.evilplot.plot.renderers.PointRenderer
import scala.util.Random
// This has "displayPlot" function
import com.cibo.evilplot._

//import com.cibo.evilplot.numeric.Point


// LOAD sandbox.sc and get a histogram named "hist"

val data = hist.map(_._2.toDouble)
val zipf = data.zipWithIndex.map{ case (y,x) => Point(y,x.toDouble) }


val scat = ScatterPlot(zipf).render()
