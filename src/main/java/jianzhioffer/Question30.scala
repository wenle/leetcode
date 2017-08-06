package jianzhioffer

import scala.collection.immutable.TreeSet

/**
 *
 * date 17/8/6
 * @author wenle
 */
object Question30 {

  def keepMinK(set: TreeSet[Int], k: Int, num: Int): TreeSet[Int] = {
    if (set.size < k) {
      set.insert(num)
    } else if (num >= set.last) {
      set
    } else {
      set.dropRight(1).insert(num)
    }
  }

  def getMinK(numbers: List[Int], k: Int): Set[Int] = {
    numbers.foldLeft(new TreeSet[Int]())(
      (set, num) => {
        keepMinK(set, k, num)
      }
    )
  }

  def main(args: Array[String]): Unit = {

    System.out.println(getMinK(List(5, 6, 7, 8, 9, 0, 1, 2, 3, 4), 3))
  }
}




