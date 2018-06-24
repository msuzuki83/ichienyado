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

		println ("model "+model)

		model
	}

	protected def query2json(query: String) : String = {
		val json = "{'hoge':'hoge'}"

		json
	}
}
