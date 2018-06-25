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
                case "home" => new Query(mode, "select * ")
                case "list" => new Query(mode, "select * ")
                case "info" => new Query(mode, "select * ")
                case _      => new Query(mode, "select * ")
            }
            query
        }

        def From : Query = {
            val query: Query = mode match {
                case "home" => new Query(mode, sql + "from home ")
                case "list" => new Query(mode, sql + "from list ")
                case "info" => new Query(mode, sql + "from info ")
                case _      => new Query(mode, sql + "from home ")
            }
            query
        }

        def Where : Query = {
            val query: Query = mode match {
                case "home" => new Query(mode, sql + " ")
                case "list" => new Query(mode, sql + "where area=`tokyo` ")
                case "info" => new Query(mode, sql + "where id=`0001` ")
                case _      => new Query(mode, sql + " ")
            }
            query
        }

        def OrderBy : Query = {
            val query: Query = mode match {
                case "home" => new Query(mode, sql + "order by id ")
                case "list" => new Query(mode, sql + "order by id ")
                case "info" => new Query(mode, sql + " ")
                case _      => new Query(mode, sql + "order by id ")
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
