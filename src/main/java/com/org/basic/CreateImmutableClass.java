package com.org.basic;


import java.util.HashMap;
import java.util.Map;

/**
 * If I'm using any mutable class object in my class than I have to deep copy of that class
 * inside the constructor and getMethod().
 * primitive data type and String class are already Immutable that's why I'm not deep copy it.
 * but Map is a mutable that's why I have to deep copy it.
 * */


final class Student{
    final private String name;
    final private int age;
    final private Map<String, String> metadata;
    public Student(String name, int age,Map<String, String> metadata){
        this.name = name;
        this.age = age;
        this.metadata = new HashMap<>(metadata);
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public Map<String, String> getMetadata(){
//        return this.metadata;
        // Deep copy
        return new HashMap<>(metadata);
    }
    @Override
    public String toString(){
        return "Name : "+name + " age : "+age + " Metadata : "+ metadata;
    }
}
/**
 * This Student Class is Not an Immutable class because metadata map and address
 * Anyone can add elements into the metadata Map and change the properties of address
 *
 *         Map<String, String> metadata = new HashMap<>();
 *         metadata.put("Hobby","Coding.");
 *
 *         Student student = new Student("Ramanuj", 28,metadata);
 *         student.getMetadata().put("Programming Language ","Java");
 *         student.getMetadata().put("Role","Student");
 *
 *         System.out.println(student.toString());
 *
 * */

/**
 * That's why Deep copy of an object should be performed in the getter methods to
 * return a copy rather than returning the actual object reference.
 *
 * And Parameterized constructor should initialize all the fields performing
 * a deep copy so that data members can't be modified with an object reference.
 * */

// Output
    // Before Deep copy
    // Name : Ramanuj age : 28 Metadata : {Role=Student, Hobby=Coding., Programming Language =Java}

// After Deep copy
    // Name : Ramanuj age : 28 Metadata : {Hobby=Coding.}




public class CreateImmutableClass {
    public static void main(String []args){

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Hobby","Coding.");

        Student student = new Student("Ramanuj", 28,metadata);
        student.getMetadata().put("Programming Language ","Java");
        student.getMetadata().put("Role","Student");

        System.out.println(student.toString());
    }
}
