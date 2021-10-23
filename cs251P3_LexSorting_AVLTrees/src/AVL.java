import java.util.ArrayList;
import java.util.List;

/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 2
 * <p>
 *
 * @author Shivam Bairoloya, Caroline Lee
 * @username sbairoli, lee3629
 * @sources - https://www.youtube.com/watch?v=CdGVkgMuq_4
 */
public class AVL {

    /**
     * Insert a tuple in the tree
     *
     * @param node The root of the tree
     * @param tuple The data to be inserted
     * @return root of the tree
     */
    public Node insert(Node node, Tuple tuple)
    {
        int comp;
        int balance;

        /**left or right of node**/
        //check if node exists
        if (node == null)
            return (new Node(tuple));

        //recursively insert
        comp = node.data.compareTo(tuple);
        if (comp > 0)
            node.left = insert(node.left, tuple); //less than
        else if (comp < 0)
            node.right = insert(node.right, tuple); //greater than
        else if (comp == 0)// delete duplicates? equal to
            return node;

        /**check balance of tree**/
        updateHeight(node); //check height
        balance = balanceFactor(node); //get balance
        //left rotate
        if (balance > 1 && node.left.data.compareTo(tuple) > 0)
            return leftRotate(node);

        // right rotate
        if (balance < -1 && node.right.data.compareTo(tuple) < 0)
            return rightRotate(node);

        // left-right
        if (balance < -1 && node.right.data.compareTo(tuple) > 0)
        {
            node.right = leftRotate(node.right);
            return rightRotate(node);
        }

        // right-left
        if (balance > 1 &&node.left.data.compareTo(tuple) < 0)
        {
            node.left = rightRotate(node.left);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * rotate with parent node x's left side with further down the branch
     * @param x node moved
     * @return y node swapped
     */
    Node leftRotate(Node x)
    {
        //swap nodes
        Node y = x.left;
        Node temp = y.right;
        y.right = x;
        x.left = temp;

        //update heights
        updateHeight(x);
        updateHeight(y);

        return y;
    }


    /**
     * rotate with parent node x's right side with further down the branch
     * @param x node moved
     * @return y node swapped
     */
    Node rightRotate(Node x)
    {
        //swap nodes
        Node y = x.right;
        Node temp = y.left;
        y.left = x;
        x.right = temp;

        //update heights
        updateHeight(x);
        updateHeight(y);

        return y;
    }

    /**
     * update variable node height to keep tree balanced
     * @param node the Node
     */
    private void updateHeight(Node node)
    {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * Returns the height of a particular node
     * Returns -1 if the node is null
     *
     * @param node the node
     * @return the height
     */
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    /**
     * Returns the balance factor of a particular node
     *
     * @param node
     * @return the balance factor
     */
    public int balanceFactor(Node node) {
        //assume node is not null
        return (height(node.left) - height(node.right));
    }

    /**
     * Returns the preorder traversal
     *
     * @param node
     * @return
     */
    public List<Node> preorder(Node node) {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(node);
        if (node.left != null) {
            nodes.addAll(preorder(node.left));
        }
        if (node.right != null) {
            nodes.addAll(preorder(node.right));
        }
        return nodes;
    }


    /**
     * Returns the inorder traversal
     *
     * @param node
     * @return
     */
    public List<Node> inorder(Node node) {
        List<Node> nodes = new ArrayList<Node>();
        if (node.left != null) {
            nodes.addAll(inorder(node.left));
        }
        nodes.add(node);
        if (node.right != null) {
            nodes.addAll(inorder(node.right));
        }
        return nodes;
    }

    /**
     * Returns the level order traversal
     *
     * @param node
     * @return
     */
    public String levelOrder(Node node) {
        int height = height(node);
        List<List<Node>> levels = new ArrayList<>();
        for (int i = 1; i <= height + 1; i++) {
            levels.add(levelOrderHelper(node, i));
        }
        StringBuilder out = new StringBuilder();
        int i = 0;
        for (List<Node> level : levels) {
            out.append("Level ").append(i).append(": ");
            for (Node x : level) {
                out.append("|").append(x).append("|");
            }
            out.append("\n");
            i++;
        }
        return out.toString();
    }

    /**
     * Recursive function to aid level order traversal
     *
     * @param curr
     * @param level
     * @return
     */
    private List<Node> levelOrderHelper(Node curr, int level) {
        List<Node> currLevel = new ArrayList<>();
        if (curr == null) {
            currLevel.add(null);
            return currLevel;
        }
        if (level == 1) {
            currLevel.add(curr);
            return currLevel;
        }

        currLevel.addAll(levelOrderHelper(curr.left, level - 1));
        currLevel.addAll(levelOrderHelper(curr.right, level - 1));
        return currLevel;
    }

    /**
     * For manual testing
     * @param args
     */
    public static void main(String[] args) {

    }
}