/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Person implements Comparable<Person>{
    private String name;
    public Person(String name) {
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public Integer getNameLength(){
        return name.length();
    }
    public Character getFirstLetter() {
        return getName().charAt(0);
    }
    public Boolean isFirstLetterUpperCase() {
        String s1 = String.valueOf(getName().charAt(0));
        String s1UpperCase = String.valueOf(getName().charAt(0)).toUpperCase();
        return s1.equals(s1UpperCase);
    }
    @Override
    public String toString() {
        return getName();
    }
    @Override
    public int compareTo(Person o) {
        if(this.getName().toUpperCase().equals(o.getName().toUpperCase()))
            return 0;
        if(this.getName().toUpperCase().compareTo(o.getName().toUpperCase())>0)
            return 1;
        return -1;
    }
}