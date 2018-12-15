import shapeless.{::, Generic, HList, HNil}

trait Ordering[A] {
  def compare(left: A, right: A): Int
}

object Compare {
  def apply[A](implicit ev: Ordering[A]): Ordering[A] = ev
}

implicit val compareInt: Ordering[Int] = (left: Int, right: Int) => left - right

implicit val compareString: Ordering[String] = (left: String, right: String) => left.length - right.length

implicit val compareHNil: Ordering[HNil] = (_: HNil, _: HNil) => 0

implicit def compareHList[Head, Tail <: HList](implicit
                                               headCompare: Ordering[Head],
                                               tailCompare: Ordering[Tail]) = new Ordering[Head :: Tail] {
  override def compare(left: Head :: Tail, right: Head :: Tail) = {
    val headResult = headCompare.compare(left.head, right.head)
    val tailResult = tailCompare.compare(left.tail, right.tail)

    if(headResult != 0) headResult else tailResult
  }
}

implicit def compareCaseClasses[CC, HL <: HList](implicit gen: Generic.Aux[CC, HL],
                                           hListC: Ordering[HL]): Ordering[CC] = new Ordering[CC] {
  override def compare(left: CC, right: CC): Int = {
    val lHL = gen.to(left)
    val rHL = gen.to(right)

    hListC.compare(lHL, rHL)
  }
}

case class User(name: String, age: Int)

val transformer = Generic[User]

transformer.from(HList("name", 42))
transformer.to(User("name", 42))

Compare[Int].compare(1, 1)
Compare[String].compare("a", "a")
Compare[User].compare(User("name", 42), User("name", 42))