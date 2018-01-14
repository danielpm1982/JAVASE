package javaapplication56;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication56 {
    public static void main(String[] args) throws InterruptedException{
        Scanner s = new Scanner(System.in);
        System.out.println("type something below:");
        String input = s.nextLine();
        System.out.println("Validating...");
        Thread.sleep(1000);
        while(validate2(input)==false){
            System.out.println("type something below:");
            input = s.nextLine();
            System.out.println("Validating...");
            Thread.sleep(1000);
        }
    }
    public static boolean validate(String input){
        boolean b=false;
        try {
            //b=input.matches("[a-zA-Z]+\\d*[@][a-zA-Z]+\\.com\\.*[a-zA-Z]*");
            //b=input.matches("[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+");
            //b=input.matches("[a-zA-Z]+\\s*[a-zA-Z]*");
            //b=input.matches("[a-zA-Z]+(\\d|(_\\d))*(_[a-zA-Z])*(@[a-zA-Z]+\\.([a-zA-Z][a-zA-Z]|[a-zA-Z][a-zA-Z][a-zA-Z])(\\.[a-zA-Z][a-zA-Z])*)*");
            b=input.matches("[A-Z]?[aeiou]{3,}\\d{3,5}");
            if(b==false){
                throw new IllegalArgumentException("INVALID Input!");
            }
            System.out.println("VALID Input!");
            System.out.println("["+input.split("@")[0]+"\n@\n"+input.split("@")[1].split("\\.")[0]+"\n.\n"+input.split("@")[1].split("\\.")[1]+"]");
            //System.out.println("["+input.split("@")[0]+"\n@\n"+input.split("@")[1].split("\\.")[0]+"\n.\n"+input.split("@")[1].split("\\.")[1]+"\n.\n"+input.split("@+")[1].split("\\.+")[2]+"]");
            System.out.println(input.replaceAll("[@|\\.|m]+","_"));
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static boolean validate2(String input){
        boolean b=false;
        try {
            //b=input.matches("[a-zA-Z]+\\d*[@][a-zA-Z]+\\.com\\.*[a-zA-Z]*");
            //b=input.matches("[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+");
            //b=input.matches("[a-zA-Z]+\\s*[a-zA-Z]*");
            //b=input.matches("[a-zA-Z]+(\\d|(_\\d))*(_[a-zA-Z])*(@[a-zA-Z]+\\.([a-zA-Z][a-zA-Z][a-zA-Z]|[a-zA-Z][a-zA-Z])(\\.[a-zA-Z][a-zA-Z])*)*");
            //b=input.matches("[A-Z]?[aeiou]{3,}\\d{3,5}");
            
            //using pattern only once (Pattern static matches method)
            //b=Pattern.matches("[a-zA-Z]+(\\d|(_\\d))*(_[a-zA-Z])*(@[a-zA-Z]+\\.([a-zA-Z][a-zA-Z][a-zA-Z]|[a-zA-Z][a-zA-Z]))", input);
            
            //using pattern more than once and encapsulating in a Matcher object
            Pattern pattern = Pattern.compile("[a-zA-Z]+(\\d|(_\\d))*(_[a-zA-Z])*(@[a-zA-Z]+\\.([a-zA-Z][a-zA-Z][a-zA-Z]|[a-zA-Z][a-zA-Z]))");
            Matcher matcher = pattern.matcher(input);
            b=matcher.matches();
            
            if(b==false){
                throw new IllegalArgumentException("INVALID Input!");
            }
            System.out.println("VALID Input!");
            
//            matcher = pattern.matcher(input);
//            while(matcher.find()){
//                System.out.println(matcher.group());
//            }
            
            pattern = Pattern.compile("\\.|\\@|[a-zA-Z]");
            matcher = pattern.matcher(input);
            while(matcher.find()){
                System.out.println(matcher.group());
            }
            
            //lookingAt() enters in a looping because it always reads from the first match, differently from find(), that reads from the last match returned (by group(), e.g.).
//            pattern = Pattern.compile("\\.|\\@|[a-zA-Z]");
//            matcher = pattern.matcher(input);
//            while(matcher.lookingAt()){
//                System.out.println(matcher.group());
//            }
            
            //System.out.println("["+input.split("@")[0]+"\n@\n"+input.split("@")[1].split("\\.")[0]+"\n.\n"+input.split("@")[1].split("\\.")[1]+"]");
            //System.out.println("["+input.split("@")[0]+"\n@\n"+input.split("@")[1].split("\\.")[0]+"\n.\n"+input.split("@")[1].split("\\.")[1]+"\n.\n"+input.split("@+")[1].split("\\.+")[2]+"]");
            //System.out.println(input.replaceAll("[@|\\.|m]+","_"));
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
