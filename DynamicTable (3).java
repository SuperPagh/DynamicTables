import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicTable {
	// Add necessary fields

	public void insert(int number) {
		// Implement this
	}
	
	public void delete() {
		// Implement this
	}
		
	public void printTable() {
		// Implement this
	}
	
	public void reportSize() {
		// Implement this
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		DynamicTable table = new DynamicTable();
	
		String line;
		
		while ((line = input.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			String cmd = tokens.nextToken();
			
			if (cmd.equals("I")) {
				table.insert(Integer.parseInt(tokens.nextToken()));
			} else if (cmd.equals("D")) {
				table.delete();
			} else if (cmd.equals("P")) {
				table.printTable();
			} else if (cmd.equals("S")) {
				table.reportSize();
			}
		}
	}
}
