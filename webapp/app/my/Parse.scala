package my

import play.api._
import play.api.mvc._

/**
 * my.Parse.scala
 */
object Parse extends OptionParse {
	def apply(implicit request: Request[AnyContent]): MVCOption[String] = {
		var params: Map[String,String] = request.queryString.map { case (k,v) => k -> v.mkString }

		println ("Parse#apply getOrElse=" + params.get("mode").getOrElse(""))

		val parse: MVCOption[String] = params.get("mode") match {
			case Some( "info" ) => MVCSome[String]("select * from jalan where id = ? order by id")
			case Some( "list" ) => MVCSome[String]("select * from jalan where area = ? order by id")
			case None           => MVCSome[String]("select * from jalan order by id")
			case _              => MVCSome[String]("select * from jalan order by id")
		}

		println ("parse "+parse)

		parse
	}
}
