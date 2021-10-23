/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 1
 * <p>
 * TODO: Complete implementation of Tuple.Java
 *
 * @author Shivam Bairoloya, Caroline Lee
 * @username sbairoli, lee3629
 * @sources -,https://stackoverflow.com/questions/3661413/how-to-cast-an-object-to-an-int
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
        //TODO: Implement compareTo
        String mystr, compstr;
        int smallestLen, myLen, compLen;
        int i;
        char mvar, cvar;


        /**get item arrays**/
        Item[] myArray = this.getItems();
        Item[] compArray = toCompare.getItems();

        /**compare arrays**/
        //dont traverse nulls
        if (myArray == null && compArray == null)
            return 0; // both empty
        else if (compArray == null)
            return -1;
        else if (myArray == null)
            return 1;

        //convert to strings
        mystr = myArray.toString();
        compstr = compArray.toString();
        myLen = mystr.length();
        compLen = compstr.length();

        smallestLen = Math.min(myLen, compLen);
        //for loop comp
        mvar = 0;
        cvar = 0;
        for (i = 0; i < smallestLen; i++)
        {
            //look at elements
            mvar = mystr.charAt(i);
            cvar = compstr.charAt(i);

            //compare elements
            if (mvar != cvar)
            {
                if (cvar > mvar)
                    return -1;
                return 1;
            }
        }

        if (mvar == cvar)
            return 0; //same array
        else if (myLen > compLen)
            return 1; //mylen longer than complen

        return -1; //complen longer than mylen
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
