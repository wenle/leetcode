package jianzhioffer

/**
 *
 * date 17/8/2
 * @author wenle
 */
object Question24 {

  // scala不熟,写得真丑
  def isAfterSeqOfBST(values: Array[Int]): Boolean = {

    if (values.isEmpty) {
      return false;
    }
    if (values.length == 1) {
      return true;
    }

    val rootVal = values.last;
    val rightStart = values.indexWhere(_ > rootVal, 0)
    if (rightStart < 0) {
      return true;
    }

    val rightSubSeq: Array[Int] = values.slice(rightStart, values.length - 1)
    if (rightSubSeq.exists(_ <= rootVal)) {
      return false;
    }

    val isLeftSubSeqBST: Boolean = if (rightStart > 0) isAfterSeqOfBST(values.slice(0, rightStart)) else true

    return isAfterSeqOfBST(rightSubSeq) && isLeftSubSeqBST


  }

  def main(args: Array[String]) = {

    println(isAfterSeqOfBST(Array(5, 7, 6, 9, 11, 10, 8)))
    println(isAfterSeqOfBST(Array(7, 4, 6, 5)))

  }

}
