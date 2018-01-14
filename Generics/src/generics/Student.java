/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author Daniel
 */
public class Student implements Comparable<Student>{
    
    private String name;
    private long cpf;
    
    public Student() {
    }
    public Student(String name, long cpf){
        this();
        this.name=name;
        this.cpf=cpf;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cpf==o.cpf){
            return 0;
        } else if (this.cpf<o.cpf){
            return -1;
        } else{
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return cpf+" "+name;
    }
    
}
