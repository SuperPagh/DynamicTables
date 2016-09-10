import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by SuperPagh on 10-Sep-16.
 */
public class IntegerExample {
    public static void main(String[] args) throws IOException {
        //Read from console
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //Initialize Dynamic Table
        DynamicTable<Integer> table = new DynamicTable<>();

        String line;

        //Continue for as long as there is commands to follow
        while ((line = input.readLine()) != null) {
            //Read one line at a time
            StringTokenizer tokens = new StringTokenizer(line);
            String cmd = tokens.nextToken();

            switch(cmd) {
                case "I": //Insert the following integer into the dynamic table
                    table.add((Integer.parseInt(tokens.nextToken())));
                    break;
                case "D": //Delete the last element
                    table.deleteLast();
                    break;
                case "P": //Print the elements in the table
                    table.printElements();
                    break;
                case "S":   //Print the current number of elements
                            //And the size of the allocated table
                    table.printSizes();
                    break;
                case "G": //Get the element on the i'th place. i is the following integer.
                    System.out.println(table.get((Integer.parseInt(tokens.nextToken()))));
                    break;
            }
        }
    }
}