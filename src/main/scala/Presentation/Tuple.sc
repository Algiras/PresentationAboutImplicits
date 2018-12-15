
sealed trait Ordering[A] {
  def compare(left: A, right: A): Int
}

object Compare {
  def apply[A](implicit ev: Ordering[A]): Ordering[A] = ev
}

implicit val compareInt: Ordering[Int] = new Ordering[Int] {
  override def compare(left: Int, right: Int): Int = left - right
}

implicit val compareString: Ordering[String] = new Ordering[String] {
  override def compare(left: String, right: String): Int = left.length - right.length
}

Compare[Int].compare(1, 1)
Compare[String].compare("a", "a")

type User = (String, Int)

implicit val compareUser: Ordering[User] = new Ordering[(String, Int)] {
  override def compare(left: (String, Int), right: (String, Int)): Int = {
    val nameCompare = Compare[String].compare(left._1, right._1)
    val ageCompare = Compare[Int]compare(left._2, right._2)

    if(nameCompare != 0) nameCompare else ageCompare
  }
}

type HNil = Unit

implicit val baseCompare: Ordering[HNil] = new Ordering[HNil] {
  override def compare(left: HNil, right: HNil): Int = 0
}

implicit def inductionStep[Head, Tail](implicit
               headCompare: Ordering[Head],
               tailCompare: Ordering[Tail]) = new Ordering[(Head, Tail)] {
  override def compare(left: (Head, Tail), right: (Head, Tail)) = {
    val headResult = headCompare.compare(left._1, right._1)
    val tailResult = tailCompare.compare(left._2, right._2)

    if(headResult != 0) headResult else tailResult
  }
}

Compare[(String, (String, Int))].compare(("a", ("b", 1)), ("a", ("b", 1)))

