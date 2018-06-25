package my

/**
 * my.Model.scala
 */
object Model extends OptionModel {
    def apply(parse: MVCOption[String]): MVCOption[String] = {

        val model: MVCOption[String] = parse match {
            case MVCSome( obj ) => MVCSome[String](query2json(obj.toString))
            case MVCNone        => MVCNone
        }

        model
    }

    protected def query2json(sql: String) : String = {
        val json = DB(sql).execute.json
        json
    }
}
