package bar01

import sys.process._
import java.io.File

/**
 * Hello world!
 *
 */
object movies_images extends App {
	override def  main(args: Array[String]): Unit = {
    val input_folders = "/home/z/input_movies"
	val command_lines:String = s"ls  $input_folders"
	println(command_lines)
	val names_allinfolder = command_lines.!!
//	println(names_allinfolder)
	val extensions_movies= List(".3gp",".mp4")
//	val  movie_names =	names_allinfolder.filter( name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$")  ) )
	val  movie_names =	names_allinfolder.split("\n").filter(name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$") ))
    movie_names.foreach(println)

//	val process_lines = Process(command_lines)
//	val processIO_lines = new ProcessIO(_=>(),sdtout => scala.io.Source.fromInputStream(sdtout).getLines.foreach(println ), _ => () )
//	val bar = process_lines.run(processIO_lines)
//	println("*******************************************")
//	println(processIO_lines)


//	println("here")
////	val exs = "\\.mp4$\\|\\.3gp$"
//	val exs = "\\.mp4$"
//	println(exs)
//	val file_names_wanted=s"ls " #| s"grep   $exs"!!
//	println(file_names_wanted)


//	  #2 catch fps
	val f   ="/home/z/input_movies"
	val x   ="movie06.mp4"
//	val fps = new ProcessLogger
	val fps= s"ffprobe -v error -select_streams v -of default=noprint_wrappers=1:nokey=1 -show_entries stream=r_frame_rate $f/$x" !!
//	val fps  = fps_command

	println(fps)




	} // end main
} // end object