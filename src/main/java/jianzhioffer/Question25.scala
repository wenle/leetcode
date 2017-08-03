package jianzhioffer

/**
 *
 * date 17/8/3
 * @author wenle
 */
object Question25 {

  def printVerticalPaths(root: TreeNode, sum: Int): Unit = {

    if (root == null) {
      return
    }
    sumVertical(root, 0, sum, Array())

  }

  def sumVertical(node: TreeNode, lastSum: Int, targetSum: Int, path: Array[Int]): Unit = {

    val currentSum: Int = lastSum + node.key
    val currentPath = path :+ node.key;
    if (currentSum == targetSum) {
      if (node.left == null && node.right == null) {
        currentPath.foreach(value => {
          print(value)
          print(" ")
        })
        println
      }
    }
    if (currentSum < targetSum) {
      if (node.left != null)
        sumVertical(node.left, currentSum, targetSum, currentPath)
      if (node.right != null)
        sumVertical(node.right, currentSum, targetSum, currentPath)
    }
  }


  def main(args: Array[String]) = {

    val root: TreeNode = new TreeNode
    root.key = 0

    val node1: TreeNode = new TreeNode
    node1.key = 1
    root.left = node1

    val node2: TreeNode = new TreeNode
    node2.key = 2
    root.right = node2

    val node3: TreeNode = new TreeNode
    node3.key = 3
    node1.left = node3

    val node4: TreeNode = new TreeNode
    node4.key = 4
    node1.right = node4

    val node5: TreeNode = new TreeNode
    node5.key = 5
    node2.right = node5

    val node6: TreeNode = new TreeNode
    node6.key = 6
    node5.right = node6

    val node7: TreeNode = new TreeNode
    node7.key =2
    node2.left = node7

    printVerticalPaths(root, 4)
    println("===")
    printVerticalPaths(root, 13)
    println("===")
    printVerticalPaths(root, 100)
    println("===")
    printVerticalPaths(root, 7)
    println("===")
    printVerticalPaths(root, 5)


  }

}
