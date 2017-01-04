package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeObject(this.mother);
            out.writeObject(this.father);
            out.writeInt(this.age);
            out.writeObject(this.children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName =(String)in.readObject();
            lastName =(String) in.readObject();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }
    public static void main(String[] args) throws IOException
    {
        Person person=new Person("qqq", "www", 25);
        Person mama=new Person("www", "qqq", 5);
        Person papa=new Person("rrr", "eee", 2);
        Person child1=new Person("eee", "rrr", 28);
        Person child2=new Person("EEE", "RRR", 8);
        person.setMother(mama);
        person.setFather(papa);
        List<Person> child=new ArrayList<Person>();
        child.add(child1);
        child.add(child2);
        person.setChildren(child);

        System.out.println(person.firstName+" "+person.lastName+" "+person.age+" "+person.mother+" "+person.father+" "+person.children);

        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Алина\\Desktop\\qwe.txt"));
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\Алина\\Desktop\\qwe.txt"));

        out.writeObject(person);
        out.close();

        try{
            Person newPerson=(Person) in.readObject();
            in.close();
        } catch(ClassNotFoundException ex){}

    }
}
