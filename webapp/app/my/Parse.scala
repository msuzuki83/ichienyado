package my

import play.api._
import play.api.mvc._

/**
 * my.Parse.scala
 */
object Parse extends OptionParse {

    def apply(implicit request: Request[AnyContent]): MVCOption[String] = {
        val params: Map[String,String] = request.queryString.map { case (k,v) => k -> v.mkString }
        val home = Query.apply("home")

        val parse: MVCOption[String] = params.get("mode") match {
            case Some( mode ) => MVCSome[String]( mode.Select.From.Where.OrderBy.build )
            case None         => MVCSome[String]( home.Select.From.Where.OrderBy.build )
        }

        parse
    }

    sealed protected case class Query(mode: String, sql: String = "") {
        def Select : Query = {
            val query: Query = mode match {
                case "home" => Query.apply(mode, "select * ")
                case "list" => Query.apply(mode, "select * ")
                case "info" => Query.apply(mode, "select * ")
                case _      => Query.apply(mode, "select * ")
            }
            query
        }

        def From : Query = {
            val query: Query = mode match {
                case "home" => Query.apply(mode, sql + "from home ")
                case "list" => Query.apply(mode, sql + "from list ")
                case "info" => Query.apply(mode, sql + "from info ")
                case _      => Query.apply(mode, sql + "from home ")
            }
            query
        }

        def Where : Query = {
            val query: Query = mode match {
                case "home" => Query.apply(mode, sql + " ")
                case "list" => Query.apply(mode, sql + "where area=`tokyo` ")
                case "info" => Query.apply(mode, sql + "where id=`0001` ")
                case _      => Query.apply(mode, sql + " ")
            }
            query
        }

        def OrderBy : Query = {
            val query: Query = mode match {
                case "home" => Query.apply(mode, sql + "order by id ")
                case "list" => Query.apply(mode, sql + "order by id ")
                case "info" => Query.apply(mode, sql + " ")
                case _      => Query.apply(mode, sql + "order by id ")
            }
            query
        }

        def build : String = {
            sql
        }
    }

    protected implicit def string2query (str : String) : Query = {
        val query = Query.apply(str)
        query
    }

}
