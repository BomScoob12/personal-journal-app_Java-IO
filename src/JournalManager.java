import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JournalManager {
    public void writeEntry(JournalEntry entry){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("journalEntry.txt", true));
            bufferedWriter.write(entry.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String> readEntry(){
        try {
            String allEntry;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("journalEntry.txt"));
            LinkedList<String> listOfEntry = new LinkedList<>();
            while ((allEntry = bufferedReader.readLine()) != null){
                    listOfEntry.add(allEntry);
                // get all entry in LIST
            }
            return listOfEntry;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //not done yet
    public void deleteEntries(LocalDateTime timestamp){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("journalEntry.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("journalEntry.txt"));
            LinkedList<String> remainEntries = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true){
                if(i<= 10) {
                    sb.append(reader.read());
                    i++;
                } else{
                    return;
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        }

    }

    public boolean clearFile(){
        File file = new File("journalEntry.txt");
        return file.delete();
    }

}
