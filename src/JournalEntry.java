import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalEntry {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String timeFormat;
    String note;

    public JournalEntry(String note){
        LocalDateTime currentTime = LocalDateTime.now();
        this.timeFormat = formatter.format(currentTime);
        this.note = note;
    }

    public String getTimeFormat(){
        return this.timeFormat;
    }

    @Override
    public String toString(){
        return timeFormat + " - " + note;
    }

}
