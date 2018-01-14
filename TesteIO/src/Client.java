
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Client implements Serializable{
    private String name;
    private String address;
    private int age;
    private int tel;
    public Client(){};
    public Client(String name, String address, int age, int tel) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client: "+this.getName()+" Address: "+this.getAddress()+" Age: "+this.getAge()+" Tel: "+this.getTel()+".";
    }
}
