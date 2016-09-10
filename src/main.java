import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Pagh on 10-Sep-16.
 */
public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DynamicTable<Integer> table = new DynamicTable<>();

        String line;

        while ((line = input.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            String cmd = tokens.nextToken();

            if (cmd.equals("I")) {
                table.add(Integer.parseInt(tokens.nextToken()));
            } else if (cmd.equals("D")) {
                table.deleteLast();
            } else if (cmd.equals("P")) {
                table.printElements();
            } else if (cmd.equals("S")) {
                table.printSizes();
            }
        }
    }
}
