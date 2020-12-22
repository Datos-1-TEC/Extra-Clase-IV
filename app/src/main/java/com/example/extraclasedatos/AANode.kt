class AANode {
    lateinit var left: AANode
    lateinit var right: AANode
    var element: Int
    var level: Int

    /** Constructor  */
    constructor() {
        element = 0
        left = this
        right = this
        level = 0
    }
    /** Constructor  */
    /** Constructor  */
    @JvmOverloads
    constructor(ele: Int, left: AANode? = null, right: AANode? = null) {
        element = ele
        if (left != null) {
            this.left = left
        }
        if (right != null) {
            this.right = right
        }
        level = 1
    }
}