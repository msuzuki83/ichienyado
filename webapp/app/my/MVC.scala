package my

/**
 * my.MVC.scala
 */
class MVC {
}

/**
 * Option
 */
sealed abstract class MVCOption[+A] extends MVC {
}
final case class MVCSome[+A](x: A) extends MVCOption[A] {
}
case object MVCNone extends MVCOption[Nothing] {
}

/**
 * Option MVC
 */
class OptionParse extends MVCOption[String] {
}
class OptionModel extends MVCOption[String] {
}
class OptionView extends MVCOption[String] {
}
