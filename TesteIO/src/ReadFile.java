import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
    public static Object read(){
        try {
            Path path = Paths.get("fileR.txt");
            Path pathData = Paths.get("file.dat");
            Formatter f = new Formatter(path.toFile()); // Ou PrintWriter
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss a");
            f.format("---------------%nDate: %s%n%s", sdf.format(date), "Reading Object file.dat...");
            Object r = readData(pathData);
            if (r!=null){
                f.format("%n%s", "Successfully Readed!");
                f.format("%n---------------");
                f.close();
                return r;  
            } else {
                f.format("%n%s", "NOT Successfully Readed!");
                f.format("%n---------------");
                f.close();
                return null;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Object readData(Path path){
        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()));
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path)); // Ou Scanner (File file)
            Object o = ois.readObject();
            ois.close();
            return o;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
