package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable
    {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
         Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
     /*   private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.defaultWriteObject();
        } */
     /*   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            in.defaultReadObject();
            outputStream=System.out;
            logger=Logger.getLogger(String.valueOf(Person.class));
        } */

   /*     @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(firstName);
            out.writeObject(lastName);
          //  out.writeObject(fullName);
            out.writeObject(greetingString);
            out.writeObject(country);
            out.writeObject(sex);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            firstName=(String)in.readObject();
            lastName=(String)in.readObject();
            fullName=String.format("%s, %s", lastName, firstName);
            country=(String)in.readObject();
            sex=(Sex)in.readObject();


        } */
    }

    enum Sex {
        MALE,
        FEMALE
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person=new Person("Sergii", "Shukaiev", "Ukraine", Sex.MALE);
        Person person1=new Person("Alina", "Shukaieva", "Ukraine", Sex.FEMALE);
        System.out.println(person1.firstName + " : " + person1.lastName + " : " + person1.sex);
        System.out.println(person1.greetingString + person1.fullName + " : " + person1.country);
        System.out.println(person1.outputStream);
        System.out.println(person1.logger);
        System.out.println();

        OutputStream output=new FileOutputStream("C:\\Users\\Алина\\Desktop\\qwe.txt");
        ObjectOutputStream out=new ObjectOutputStream(output);
        out.writeObject(person);
        out.writeObject(person1);

        output.close();
        out.close();

        InputStream inout=new FileInputStream("C:\\Users\\Алина\\Desktop\\qwe.txt");
        ObjectInputStream in=new ObjectInputStream(inout);
        Person loadPerson=(Person)in.readObject();
        Person loadPerson1=(Person) in.readObject();

        inout.close();
        in.close();

        System.out.println(loadPerson1.firstName + " : " + loadPerson1.lastName + " : " + loadPerson1.sex);
        System.out.println(loadPerson1.greetingString + loadPerson1.fullName + " : " + loadPerson1.country);
        System.out.println(loadPerson1.outputStream);
        System.out.println(loadPerson1.logger);
    }
}
