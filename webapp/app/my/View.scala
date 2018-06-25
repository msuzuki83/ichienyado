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

        views.html.index(html)
    }

    protected def json2html(json: String) : String = {
      val l = Json(json).parse.list

        var html = ""
        html += (s"<h2>DEBUG: $json</h2>")
        html += "<table border=1>"
        l.foreach { i =>
          html += "<tr>"
          i.foreach { j =>
            html += (s"<td>$j</td>")
          }
          html += "</tr>"
        }
        html += "</table>"

        html
    }
}
