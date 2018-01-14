/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e1 = new Employee("Employee1", 123456);
        Employee e2 = new Employee("Employee2", 234567);
        Employee e3 = new Employee("Employee3", 345678);
        
        Employee[] employeeArray = {e3,e2,e1};
        System.out.println("Before sorting:");
        System.out.print("[ ");
        Arrays.stream(employeeArray).forEach(x->System.out.print(x+" "));
        System.out.println("]");
        
        Student s1 = new Student("Student1", 123456);
        Student s2 = new Student("Student2", 234567);
        Student s3 = new Student("Student3", 345678);
        
        Student[] studentArray = {s3,s2,s1};
        System.out.println("Before sorting:");
        System.out.print("[ ");
        Arrays.stream(studentArray).forEach(x->System.out.print(x+" "));
        System.out.println("]");
        
/*      
        Using sort generic method to receive different actual type argument arrays, if and only these type argument classes 
        are compatible with the upper bound declared at the generic method for the type variable (parameter). The return
        downcasting is automatic according to the actual type argument passed as the type parameter.
*/
        Employee[] employeeArraySorted = GenericMethods.sort(employeeArray);
        Student[] studentArraySorted = GenericMethods.sort(studentArray);
        
        System.out.println("After sorting:");
        System.out.print("[ ");
        Arrays.stream(employeeArraySorted).forEach(x->System.out.print(x+" "));
        System.out.println("]");
        
        System.out.println("After sorting:");
        System.out.print("[ ");
        Arrays.stream(studentArraySorted).forEach(x->System.out.print(x+" "));
        System.out.println("]\n");
        
        //Generic class for different type arguments ("Employee" and "Student")
        Employee[] employeeArray2 = {e3,e2,e1};
        Student[] studentArray2 = {s3,s2,s1};
        GenericList<Employee> genericEmployee = new GenericList<>(employeeArray2);
        List<Employee> listEmployee = genericEmployee.getList();
        GenericList<Student> genericStudent = new GenericList<>();
        List<Student> listStudent=genericStudent.createGenericList(studentArray2);
        System.out.println("Before sorting:");
        System.out.println(listEmployee);
        System.out.println(listStudent);
        
        GenericMethods.sort(listEmployee);
        GenericMethods.sort(listStudent);
        System.out.println("After sorting:");
        System.out.println(listEmployee);
        System.out.println(listStudent);
    }
}
