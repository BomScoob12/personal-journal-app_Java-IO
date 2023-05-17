import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int option = 0;
            Scanner scan = new Scanner(System.in);
            var manager = new JournalManager();
            while (option != 5) {
                System.out.println("Welcome to Personal Journal");
                System.out.println("1. Write new entry");
                System.out.println("2. List all entry");
                System.out.println("3. Delete Entries");
                System.out.println("4. Clear File");
                System.out.println("5. Exit");
                System.out.print("Enter menu option : ");
                option = scan.nextInt();
                scan.nextLine();
                switch (option) {
                    case 1 -> {
                        System.out.print("Write entry: ");
                        String entries = scan.nextLine();
                        manager.writeEntry(new JournalEntry(entries));
                    }
                    case 2 -> {
                        System.out.println("List all entries");
                        List<String> allEntries =  manager.readEntry();
                        for (String allEntry : allEntries) {
                            System.out.println(allEntry);
                        }
                    }
                    case 3 -> {
                        System.out.println("Delete entries");
                        LocalDateTime time = LocalDateTime.parse(scan.nextLine());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        String timestamp = time.format(formatter);
                        manager.deleteEntries(time);
                        System.out.println("Entries deleted");
                    }
                    case 4 -> {
                        System.out.println("You need to delete all entry?");
                        System.out.println("yes or no.");
                        System.out.print("Enter your answer : ");
                        String ans = scan.nextLine();
                        if(ans.equals("yes")) System.out.println(manager.clearFile() ? "File deleted" : "Error");
                    }

                }
                System.out.println();
            }
        } catch (InputMismatchException e) {
            e.getStackTrace();
        }
    }
}