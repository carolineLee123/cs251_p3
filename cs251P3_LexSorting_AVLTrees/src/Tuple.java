/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 1
 * <p>
 * TODO: Complete implementation of Tuple.Java
 *
 * @author Shivam Bairoloya, TODO: add your name here
 * @username sbairoli, TODO: add your username here
 * @sources -, TODO: add your sources here
 */

public class Tuple<Item extends Comparable<Item>> {

    private Item[] items;

    /**
     * Initialize items
     *
     * @param items the initial value
     */
    public Tuple(Item[] items) {
        this.items = items;
    }

    /**
     * Getter
     *
     * @return items
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Setter
     *
     * @param items to set
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * Returns a String representation of the items
     *
     * @return toString representation
     */
    @Override
    public String toString() {
        StringBuilder x = new StringBuilder("");
        for (int i = 0; i < items.length; i++) {
            x.append(items[i]);
        }
        return x.toString();
    }

    /**
     * Lexicographically compares the items
     *
     * @param toCompare items to compare with
     * @return -1 if less 0 if it is the same and 1 if it is greater
     */

    public int compareTo(Tuple<Item> toCompare) {
        //TODO: Implement compareTo
    }

    /**
     * For manual testing
     * @param args
     */


    public static void main(String[] args) {
        //Main can be used for manual testing
        //Look at TestTuple to generate your own cases
    }
}
