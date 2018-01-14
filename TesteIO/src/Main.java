public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("Daniel", "Dom Manuel de Medeiros, xxxx", 33, 30464623);
        WriteFile.record(c1);
        Client c2 = (Client)ReadFile.read();
        System.out.println(c2);
        if (c1.toString().compareTo(c2.toString())==0){
            System.out.println("Sucessfull read/write work!");
        }
    }
}
