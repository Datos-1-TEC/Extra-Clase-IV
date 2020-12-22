class AATree {
    private var root: AANode
    var preorderString = ""
    var inorderString = ""
    var postorderString = ""

    /** Function to check if tree is empty  */
    val isEmpty: Boolean
        get() = root === nil

    /** Make the tree empty  */
    fun clear() {
        root = nil
    }
    fun insert(X: Int) {
        root = insert(X, root)
    }

    private fun insert(X: Int, node: AANode): AANode {
        var node = node
        if (node === nil) node = AANode(X, nil, nil) else if (X < node.element) node.left =
            insert(X, node.left) else if (X > node.element) node.right = insert(X, node.right) else return node
        node = skew(node)
        node = split(node)
        return node
    }

    private fun skew(node: AANode): AANode {
        return if (node === nil) nil else if (node.left === nil) node else if (node.left.level == node.level) {
            val L = node.left
            node.left = L.right
            L.right = node
            L
        } else node
    }

    private fun split(node: AANode): AANode {
        return if (node === nil) nil else if (node.right === nil || node.right.right === nil) node else if (node.level == node.right.right.level) {
            val R = node.right
            node.right = R.left
            R.left = node
            R.level = R.level + 1
            R
        } else node
    }

    private fun search(r: AANode, `val`: Int): Boolean {
        var r = r
        var found = false
        while (r !== nil && !found) {
            val rval = r.element
            if (`val` < rval) r = r.left else if (`val` > rval) r = r.right else {
                found = true
                break
            }
            found = search(r, `val`)
        }
        return found
    }

    fun inorder() {
        inorder(root)
    }

    private fun inorder(node: AANode) {
        if (node !== nil) {
            inorder(node.left)
            inorderString += node.element.toString() + "->"
            print(node.element.toString() + " ")
            inorder(node.right)
        }
    }

    fun preorder() {
        preorder(root)
    }

    private fun preorder(r: AANode) {
        if (r !== nil) {
            preorderString += r.element.toString() + "->"
            preorder(r.left)
            preorder(r.right)
        }
    }

    fun postorder() {
        postorder(root)
    }

    private fun postorder(r: AANode) {
        if (r !== nil) {
            postorder(r.left)
            postorder(r.right)
            postorderString += r.element.toString() + "->"

        }
    }
    fun getCurrentInorder(): String {
        var inorder = this.inorderString
        this.inorderString = ""
        return inorder
    }
    fun getCurrentPreorder(): String{
        var preorder = this.preorderString
        this.preorderString = ""
        return  preorder
    }
    fun getCurrentPostOrder(): String{
        var postorder = this.postorderString
        this.postorderString = ""
        return postorder
    }

    companion object {
        private val nil = AANode()
    }

    /** Constructor  */
    init {
        root = nil
    }
}