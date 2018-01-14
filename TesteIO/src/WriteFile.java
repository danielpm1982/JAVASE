import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteFile {
    public static void record(Object o){
        try {
            Path path = Paths.get("fileW.txt");
            Path pathData = Paths.get("file.dat");
            Formatter f = new Formatter(path.toFile()); // Ou PrintWriter
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss a");
            f.format("---------------%nDate: %s%n%s", sdf.format(date), "Recording Object file.dat...");
            if (recordData(pathData, o)){
                f.format("%n%s", "Successfully Recorded!");
            } else {
                f.format("%n%s", "NOT Successfully Recorded!");
            }
            f.format("%n---------------");
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean recordData(Path path, Object o){
        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()));
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path)); // Ou Scanner(File file)
            oos.writeObject(o);
            oos.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
