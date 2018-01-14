/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

/**
 *
 * @author Daniel
 */
public class Client implements Comparable<Client>{
    private String name;
    private Long cpf;
    public Client(String name, String cpf) {
        this.name=name;
        this.cpf=Long.valueOf(cpf);
    }

    @Override
    public int compareTo(Client clientOther) {
        if(name.compareTo(clientOther.name)!=0){
            if(name.compareTo(clientOther.name)==0){
                return 0;
            } else if(name.compareTo(clientOther.name)<0){
                return -1;
            } else {
                return 1;
            }
        } else{
            if(cpf.compareTo(clientOther.cpf)==0){
                return 0;
            } else if(cpf.compareTo(clientOther.cpf)<0){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Name: "+this.name+" CPF: "+this.cpf;
    }
}
