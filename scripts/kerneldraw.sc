// This is too cool, but I don't really understand kernel density estimates.

import com.cibo.evilplot.colors.Color
import com.cibo.evilplot.numeric.Bounds
import com.cibo.evilplot.plot._
import com.cibo.evilplot.plot.aesthetics.DefaultTheme._
import com.cibo.evilplot.plot.renderers.PathRenderer


// This has "displayPlot" function
import com.cibo.evilplot._

import com.cibo.evilplot.plot.aesthetics.DefaultTheme._
//import com.cibo.evilplot.numeric.Point

val data = hist.map(_._2.toDouble)

def gaussianKernel(u: Double): Double = {
  1 / math.sqrt(2 * math.Pi) * math.exp(-0.5d * u * u)
}


def densityEstimate(data: Seq[Double], bandwidth: Double)(
  x: Double
): Double = {
  val totalProbDensity = data.map { x_i =>
    gaussianKernel((x - x_i) / bandwidth)
  }.sum
  totalProbDensity / (data.length * bandwidth)
}
val colors = Color.getGradientSeq(3)
val bandwidths = Seq(5d, 2d, 0.5d)

val ov = Overlay(
  colors.zip(bandwidths).map { case (c, b) =>
    FunctionPlot(
      densityEstimate(data, b),
      Some(Bounds(0, 30)),
      Some(500),
      Some(PathRenderer.default(color = Some(c)))
    )
  }:_*
)
  .standard()
  .xbounds(0, 30)
  .render()
