package my

/**
 * my.View.scala
 */
object View extends OptionView {
	def apply(model: MVCOption[String]): play.twirl.api.Html = {

		val html: String = model match {
			case MVCSome( obj ) => json2html(obj.toString)
			case MVCNone        => ""
		}

		println ("html "+html)

		views.html.index(html)
	}

	protected def json2html(model: String) : String = {
		val html = "<h1>" + model + "<h1>"

		html
	}
}
