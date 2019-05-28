
def fact(num: Int): Option[Int] = num match  {
  case nr if nr < 0 => None
  case 0 => Some(1) // base case
  case nr => fact(nr - 1).map(_ * nr) // inductive step
}

def length[A](list: List[A]): Int = list match {
  case Nil => 0
  case _ :: xs => 1 + length(xs)
}

def map[A, B](list: List[A], fn: A => B): List[B] = list match {
  case Nil => Nil
  case x :: xs => fn(x) :: map(xs, fn)
}

fact(3)
//
length(List(1,2,3))
map(List(1,2,3), (_: Int) + 1)

trait Squash[T] {
  def squash(a: T, b: T): T
}

object Squash {
  def apply[T](implicit ev: Squash[T]): Squash[T] = ev
}

implicit class Squashy[T](value: T)(implicit ev: Squash[T]) {
  def squash(another: T): T = ev.squash(value, another)
}

implicit val squashInt = new Squash[Int] {
  override def squash(a: Int, b: Int) = a + b
}

implicit def squashOption[U](implicit ev: Squash[U]) = new Squash[Option[U]] {
  override def squash(a: Option[U], b: Option[U]) = for {
    v1 <- a
    v2 <- b
  } yield ev.squash(v1, v2)
}


implicitly[Squash[Option[Int]]].squash(Some(1), Some(3))
Squash[Option[Int]].squash(Some(1), Some(3))


Option(1) squash Option(2)
