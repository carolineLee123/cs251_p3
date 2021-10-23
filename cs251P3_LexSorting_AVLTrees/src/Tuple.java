/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 1
 * <p>
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
        String mystr, compstr;
        int smallestLen, myLen, compLen;
        int i;
        /**get item arrays**/
        Item[] myArray = this.getItems();
        Item[] compArray = toCompare.getItems();




        smallestLen = Math.min(myArray.length, compArray.length);
        //for loop comp

        for (i = 0; i < smallestLen; i++)
        {
            //look at elements
            //convert to strings
            mystr = myArray[i].toString();
            compstr = compArray[i].toString();

            int comp = mystr.compareTo(compstr);
/**
            System.out.println("COMPARETO");
            System.out.println("str1: " + mystr);
            System.out.println("str2: " + compstr);

            System.out.println("compare: " + comp+"\n\n");
*/
            //compare elements
            if (comp != 0)
            {
                if (comp > 0)
                    return 1;
                return -1;
            }
        }

        if (myArray.length == compArray.length)
            return 0; //same array
        else if (myArray.length > compArray.length)
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
