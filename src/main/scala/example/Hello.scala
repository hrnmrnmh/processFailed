package example

import java.io.File
import java.net.URL

import scala.language.postfixOps
import scala.sys.process.urlToProcess
import scala.util.Try

object Hello {
  def main(args: Array[String]): Unit = {
    val saveFile = "saved.txt"
    val f = new File(saveFile)
    if (!f.exists()) {
      f.createNewFile()
    }

    val ssss = Try{
      // そして帰らぬ人となる～
      new URL("https://hrnmrnmh.github.io/404") #> f !!

      f
    }

    ssss.failed.map(_.getMessage).foreach(println(_))
    ssss.map(_.length()).map(_ + "bytes get").foreach(println(_))
  }
}

