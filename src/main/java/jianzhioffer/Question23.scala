package jianzhioffer

/**
 *
 * date 17/7/31
 * @author wenle
 */
object Question23 {

  def printTreeUpDown(root: TreeNode) = {

    traverse(List(root))

  }

  def traverse(l: List[TreeNode]) : Unit = {

    if (l.isEmpty) return
    l.foreach(node => if(node != null) print(node.key))
    println()
    traverse(l.flatMap(node => {
      (node.left :: node.right :: Nil).filter(node => node != null)
    }))
  }

  def main(args : Array[String]) = {

    val root : TreeNode = new TreeNode
    root.key = 0

    val node1 : TreeNode = new TreeNode
    node1.key = 1
    root.left = node1

    val node2 : TreeNode = new TreeNode
    node2.key = 2
    root.right = node2

    val node3 : TreeNode = new TreeNode
    node3.key = 3
    node1.left = node3

    val node4 : TreeNode = new TreeNode
    node4.key = 4
    node1.right = node4

    val node5 : TreeNode = new TreeNode
    node5.key = 5
    node2.right = node5

    val node6 : TreeNode = new TreeNode
    node6.key = 6
    node5.right = node6

    printTreeUpDown(root)

  }

}
