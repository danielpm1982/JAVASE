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
public class Employee implements Comparable<Employee>{
    
    private String name;
    private long cpf;
    
    public Employee() {
    }
    public Employee(String name, long cpf){
        this();
        this.name=name;
        this.cpf=cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public int compareTo(Employee o) {
        if(this.cpf==o.cpf){
            return 0;
        } else if(this.cpf<o.cpf){
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
