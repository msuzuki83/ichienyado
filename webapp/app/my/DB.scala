package my

/**
 * my.DB.scala
 */
case class DB(sql: String, res: Option[String] = Option("")) {
    def execute : DB = {
        val db = DB.apply(sql)
        db
    }

    def json : String = {
        val json = "{'sql':'" + sql + "'}"
        json
    }
}
