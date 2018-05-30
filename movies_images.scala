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
	val extensions_movies= List(".3gp",".mp4")
//	val  movie_names =	names_allinfolder.filter( name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$")  ) )
	val  movie_names_string_list =	names_allinfolder.split("\n").filter(name_one => extensions_movies.exists( extension_one => name_one.matches(s".*$extension_one$$") ))
//	movie_names_string_list.toString.split("\n")
	println(movie_names_string_list(5))
//	println(movie_names_string_list.indexOf("movie06.mp4"))
//	  #2 catch fps
	val f   ="/home/z/input_movies"
	val x   ="movie06.mp4"
//	val fps = new ProcessLogger
	def get_fps(folder_path:String,movie_name:String) :Double={
			println(folder_path,movie_name)
			val fps= s"ffprobe -v error -select_streams v -of default=noprint_wrappers=1:nokey=1 -show_entries stream=r_frame_rate $folder_path/$movie_name" !!
		 	val fps_array = fps.toString.split("\\/")
		   	fps_array(0).toDouble / fps_array(1).toDouble
		}
    println(	get_fps(f,movie_names_string_list(5)) )
//	val fps=s"ffprobe -v error -select_streams v -of default=noprint_wrappers=1:nokey=1 -show_entries stream=r_frame_rate $f/$x" !!
////	val fps  = fps_command
//
// 	val fps_array = fps.toString.split("\\/")
//	fps_array(0).toDouble / fps_array(1).toDouble\


//	def getListOfFiles(dir: File):List[File] = dir.listFiles.filter(_.isFile).toList
	def getListOfFiles(dir: File, extensions: List[String]): List[File] = {
		    dir.listFiles.filter(_.isFile).toList.filter { file =>
			extensions.exists(file.getName.endsWith(_))
    }
}

	val  all_jpgs_path = getListOfFiles(new File("/data/bar"),List(".jpg"))
//    println(all_jpgs_path.count(_.isFile))

    println(all_jpgs_path.last)
// 	val moviename_frame_location = all_jpgs_path(3528).toString.split("/").last.split("split__split__split__split")
//	val moviename_index = moviename_frame_location(0).toDouble
//	println(moviename_index )
//	println (movie_names_string_list(moviename_index.toInt))
//	val frame_location    = moviename_frame_location(1).toString.split("\\.")(0).toDouble
//    println(frame_location)

	val all_jpgs_list = "ls /data/bar".!!. split("\n")
	val movieindex_frame_location  = all_jpgs_list(6)
    val moiveindex_framelocation =	movieindex_frame_location.split("/").last.toString.split("split__split__split__split")
	val movie_index = moiveindex_framelocation(0).toInt
		println(movie_index)

	val frame_location = moiveindex_framelocation(1).split("\\.")(0).toDouble
		println(frame_location)
//	val movieindex = movieindex_frame_location.split("/")(0).split("split__split__split__split")
//		println(movieindex)
//	val frame_location= movieindex_frame_location.split("/")(0).split("split__split__split__split")
//		print(frame_location)

	} // end main
} // end object