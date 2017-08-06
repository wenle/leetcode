package jianzhioffer

/**
 *
 * date 17/8/6
 * @author wenle
 */
object Question31 {

  def maxSubListSum(list: List[Int]) : Int = {

    if(list == null || list.isEmpty) {
      return 0
    }
    val result:(Int, Int) = list.foldLeft((list(0), list(0)))(func);
    result._2
  }

  def func(result: (Int, Int), num : Int) : (Int, Int) = {

    val currentSum = result._1 + num
    val maxSum = result._2


    if(currentSum <= 0) {
      (0, maxSum)
    } else if(currentSum > maxSum) {
      (currentSum, currentSum)
    } else {
      (currentSum, maxSum)
    }
  }

  def main(args : Array[String]) : Unit = {

    println(maxSubListSum(List(1, -2, 3, 10, -4, 7, 2, -5)))
    println(maxSubListSum(List()))
    println(maxSubListSum(List(-1)))
  }


}
