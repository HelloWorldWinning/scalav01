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
	val names_allinfolder = command_lines.!!
//	println(names_allinfolder)
	val extensions_movies= List(".3gp",".mp4")
//	val  movie_names =	names_allinfolder.filter( name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$")  ) )
	val  movie_names_string_list =	names_allinfolder.split("\n").filter(name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$") ))
	movie_names_string_list.toString.split("\n")
	println(movie_names_string_list(1))
	println(movie_names_string_list.indexOf("movie06.mp4"))
//	  #2 catch fps
	val f   ="/home/z/input_movies"
	val x   ="movie06.mp4"
//	val fps = new ProcessLogger
	def fps_get(folder_path:String,movie_name:String) :Double={
			println(folder_path,movie_name)
			val fps= s"ffprobe -v error -select_streams v -of default=noprint_wrappers=1:nokey=1 -show_entries stream=r_frame_rate $folder_path/$movie_name" !!
		 	val fps_array = fps.toString.split("\\/")
		   	fps_array(0).toDouble / fps_array(1).toDouble

		}
    println(	fps_get(f,movie_names_string_list(5)) )
	val fps=s"ffprobe -v error -select_streams v -of default=noprint_wrappers=1:nokey=1 -show_entries stream=r_frame_rate $f/$x" !!
//	val fps  = fps_command

 	val fps_array = fps.toString.split("\\/")
	fps_array(0).toDouble / fps_array(1).toDouble




	} // end main
} // end object