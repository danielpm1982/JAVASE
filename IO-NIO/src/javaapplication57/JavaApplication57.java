package javaapplication57;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class JavaApplication57 {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Path path = createPath();
        //Path path = selectPath();
        //if using Objects byte-based files, do not read empty files or non structured Object files cause EOFExceptions will be thrown. First write, than read!
        if(!isEmpty(path)){
            showPathInfo(path);
        } else{
            System.out.println("File is empty!");
        }
        //select HOW to write (byte-based or text-based files!!!!):
        writeAtPath8(path,Arrays.asList("Daniel","Juliana","Tina","Bosco"));
        showPathInfo(path);
        //if using Object-based files, ommit the next two lines, and activate the second showAtGUI (below) instead.
        List<String> textLines = Files.lines(path).collect(Collectors.toList());
        showAtGUI(textLines);
        //different showAtGUI to be used with Objects byte-based file reading/writing:
        //showAtGUI(Arrays.asList((String[])(new ObjectInputStream(Files.newInputStream(path))).readObject()));
        //optional deletion:
        //deletePath(path);
        showDir(Paths.get("myDirectory1"));
    }
    
    public static Path createPath(){
        Scanner s = new Scanner(System.in);
        System.out.println("Type a file/directory name:");
        return Paths.get(s.nextLine());
    }
    
    private static int openFileTrials=1;
    public static Path selectPath(){
        Path path = null;
        //the current relative directory name is simply "."
        JFileChooser fchooser = new JFileChooser(".");
        while (path==null){
            System.out.println("Select your file/directory at the GUI FileChooser! - "+openFileTrials+" st/nd/rd try...");
            if(fchooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                openFileTrials=1;
                return fchooser.getSelectedFile().toPath();
            } else{
                openFileTrials++;
                if(openFileTrials>3){
                    System.exit(0);
                }
            }
        }
        return null;
    }
    
    public static boolean isEmpty(Path path) throws IOException, ClassNotFoundException{
        return (Files.size(path)==0);
    }
    
    public static void showPathInfo(Path path) throws IOException, ClassNotFoundException{
        System.out.println(path.toAbsolutePath());
        if(!Files.exists(path)){
            Files.createFile(path);
            System.out.println("File created!");
        } else{
            System.out.println("File already exists!");
        }
        System.out.println("Is directory: "+Files.isDirectory(path));
        System.out.println("Last Modified: "+Files.getLastModifiedTime(path));
        System.out.println("Is executable: "+Files.isExecutable(path));
        System.out.println("Lines: ");
        //select WHAT to read (byte-based or text-based files!!!!):
        readAtPath5(path);
        System.out.println("Size: "+Files.size(path));
    }
    
    public static void readAtPath(Path path) throws IOException{
        System.out.println("Reading: ...");
        Files.lines(path).forEach(System.out::println);
    }
    
    public static void readAtPath2(Path path) throws IOException{
        System.out.println("Reading: ...");
        Scanner t = new Scanner (path);
        while(t.hasNext()){
            System.out.println(t.next());
        }
        t.close();
    }
    
    public static void readAtPath3(Path path) throws IOException{
        System.out.println("Reading: ...");
        try(BufferedReader br = Files.newBufferedReader(path)){
            br.lines().forEach(System.out::println);
        }
    }
    
    public static void readAtPath4(Path path) throws IOException{
        System.out.println("Reading: ...");
        try(BufferedReader br = Files.newBufferedReader(path)){
            String s;
            while((s = br.readLine())!=null){
                System.out.println(s);
            }
        }
    }
    
    public static void readAtPath5(Path path) throws IOException{
        System.out.println("Reading: ...");
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))){
            String s;
            while((s = br.readLine())!=null){
                System.out.println(s);
            }
        }
    }
    
    public static void readAtPath6(Path path) throws IOException, ClassNotFoundException{
        System.out.println("Reading: ...");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            String[] stringArray = (String[])ois.readObject();
            for(String s:stringArray){
                System.out.println(s);
            }
        }
    }
    
    public static void readAtPath7(Path path) throws IOException, ClassNotFoundException{
        System.out.println("Reading: ...");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))){
            String[] stringArray = (String[])ois.readObject();
            for(String s:stringArray){
                System.out.println(s);
            }
        }
    }
    
    public static void writeAtPath(Path path, List<String> list) throws IOException{
        System.out.println("Writing: ...");
        Files.write(path, list);
    }
    
    public static void writeAtPath2(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(Formatter formatter = new Formatter(path.toFile())){
                for(String line:list){
                    formatter.format("%s%n", line);
                }
            }
            //must use try with resources or close the formatter, otherwise
            //the file is not written.
    }
    
    public static void writeAtPath3(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(PrintWriter pw = new PrintWriter(path.toFile())){
                for(String line:list){
                    pw.println(line);
                }
            }
    }
    
    public static void writeAtPath4(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(BufferedWriter bw = Files.newBufferedWriter(path)){
                for(String line:list){
                    bw.write(line);
                    bw.newLine();
                }
            }
    }
    
    public static void writeAtPath5(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()))){
                for(String line:list){
                    bw.write(line);
                    bw.newLine();
                }
            }
    }
    
    public static void writeAtPath6(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(path))){
                os.writeObject(list.toArray(new String[list.size()]));
            }
    }
    
    public static void writeAtPath7(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
                os.writeObject(list.toArray(new String[list.size()]));
                os.close();
            }
    }
    
    public static void writeAtPath8(Path path, List<String> list) throws IOException{
            System.out.println("Writing: ...");
            try(PrintStream ps = new PrintStream(new FileOutputStream(path.toFile()))){
                for(String line:list){
                    ps.println(line);
                }
            }
    }
    
    public static void deletePath(Path path) throws InterruptedException, IOException{
        System.out.println("Deleting in 15s...");
        Thread.sleep(15000);
        Files.delete(path);
        if(!Files.exists(path)){
            System.out.println("File deleted!");
        } else{
            System.out.println("File NOT deleted!");
        }
    }
    
    public static void showDir(Path path2) throws IOException{
        if(Files.isDirectory(path2)){
            System.out.println("Directory:");
            DirectoryStream<Path> ds = Files.newDirectoryStream(path2);
            for(Path p:ds){
                System.out.println(p);
            }
        }
    }
    
    public static void showAtGUI(List<String> textLines){
        String text="";
        for(int i=0; i<textLines.size();i++){
            text+=textLines.get(i);
            if(i<textLines.size()-1){
                text+="\n";
            }
        }
        JFrame frame = new JFrame("TextLines");
        frame.setIconImage(new ImageIcon("icon.jpg").getImage());
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(Color.BLACK);
        JTextArea textArea = new JTextArea(text);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        textArea.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(textArea);
        JLabel label = new JLabel("Wait main thread ends to close GUI!");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        panel.add(label);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

//Before being deleted, the file can be opened outside the program. After deletion, although
//its name keeps appearing at the directory until program ends, it becomes inaccessible!

/*
IO classes:
Byte-based:
PipedInputStream/PipedOutputStream (subclasses of InputStream/OutputStream);
ByteArrayInputStream/ByteArrayOutputStream (subclasses of InputStream/OutputStream);
SequenceInputStream (subclass of InputStream);
FilterInputStream/FilterOutputStream (subclasses of InputStream/OutputStream);
PrintStream (subclass of FilterOutputStream);
DataInputStream/DataOutputStream (subclasses of FilterInputStream/FilterOutputStream);
BufferedInputStream/BufferedOutputStream (subclasses of FilterInputStream/FilterOutputStream);

Character-based:
BufferedReader/BufferedWriter (subclasses of Reader/Writer);
LineNumberReader (subclass of BufferedReader);
CharArrayReader/CharArrayWriter (subclasses of Reader/Writer);
InputStreamReader/InputStreamWriter
FileReader/FileWriter
PipedReader/PipedWriter
StringReader/StringWriter
PrintWriter
ObjectInputStream/ObjectOutputStream
*/