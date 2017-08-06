package jianzhioffer

/**
 *
 * date 17/8/6
 * @author wenle
 */
object Question29 {


  def findNumMoreThanHalfCount(list: List[Int]): Int = {

    def accumulate(result: (Int, Int), num: Int): (Int, Int) = {

      if (result._2 == 0) {
        (num, 1)
      } else if (result._1 == num) {
        (num, result._2 + 1)
      } else {
        (num, result._2 - 1)
      }
    }

    val result: (Int, Int) = list.foldLeft((0, 0))(accumulate);
    result._1
  }

  def main(args : Array[String]) : Unit = {

    val numbers  = List(1, 2, 3, 1, 1, 1);

    println(findNumMoreThanHalfCount(numbers));


    val numbers2  = List(0, 0, 1);

    println(findNumMoreThanHalfCount(numbers2));


  }

}
