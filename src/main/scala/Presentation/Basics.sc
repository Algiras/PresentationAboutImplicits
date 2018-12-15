// domino

trait Domino

case object DominoNil extends Domino
case class DominoVal(value: Int, tail: Domino) extends Domino

def makeDominoFall(value: Domino): Int = value match {
  // Knock over first domino
  case DominoNil => 0
  // If domino falls, the next domino fails
  case DominoVal(dominoValue, tail) => dominoValue + makeDominoFall(tail)
}

def length[A](list: List[A]): Int = list match {
  case Nil => 0
  case _ :: tail => 1 + length(tail)
}

def map[A, B](list: List[A], fn: A => B): List[B] = list match {
  case Nil => Nil
  case head :: tail => fn(head) :: map(tail, fn)
}