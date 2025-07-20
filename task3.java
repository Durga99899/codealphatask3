import java.util.Scanner;
import java.util.HashMap;

public class ChatBot {

    private static HashMap<String, String> faq = new HashMap<>();

    // Initialize basic rule-based responses
    static {
        faq.put("hello", "Hi there! How can I assist you?");
        faq.put("hi", "Hello! How can I help?");
        faq.put("what is your name", "I'm a Java Chatbot created for Cognifyz Internship.");
        faq.put("how are you", "I'm just a bot, but I'm functioning as expected!");
        faq.put("bye", "Goodbye! Have a great day!");
    }

    public static String getResponse(String input) {
        input = input.toLowerCase().trim();

        // Exact match
        if (faq.containsKey(input)) {
            return faq.get(input);
        }

        // Partial match logic
        for (String key : faq.keySet()) {
            if (input.contains(key)) {
                return faq.get(key);
            }
        }

        return "I'm still learning. Please rephrase or ask something else!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 Java Chatbot: Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: " + faq.get("bye"));
                break;
            }

            String reply = getResponse(userInput);
            System.out.println("Chatbot: " + reply);
        }

        scanner.close();
    }
}
