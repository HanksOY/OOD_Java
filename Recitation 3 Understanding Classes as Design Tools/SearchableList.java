import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchableList {
    public static void main(String[] args) {
        // Set up list with items
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Available items: " + items);
        System.out.println("Enter item to search (or 'quit' to exit):");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Search and interact based on result
            int index = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equalsIgnoreCase(input)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("Found '" + items.get(index) + "' at position " + index);
                System.out.println("  -> Action: Remove it? (yes/no)");
                String response = scanner.nextLine().trim();
                if (response.equalsIgnoreCase("yes")) {
                    items.remove(index);
                    System.out.println("  -> Removed! Current list: " + items);
                }
            } else {
                System.out.println("'" + input + "' not found.");
                System.out.println("  -> Action: Add it? (yes/no)");
                String response = scanner.nextLine().trim();
                if (response.equalsIgnoreCase("yes")) {
                    items.add(input);
                    System.out.println("  -> Added! Current list: " + items);
                }
            }

            System.out.println("\nEnter item to search (or 'quit' to exit):");
        }

        scanner.close();
    }
}

