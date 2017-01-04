package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
      private String name;
        private String sourName;
        private int age;
        private boolean education;
        private double weidth;
        private byte iQ;

        Human (String name,String sourName, int agr){
            this.name=name;
            this.sourName=sourName;
            age=agr;
        }//напишите тут ваши переменные и конструкторы
        Human (String name, String sourName, int age, byte iQ){
            this.name=name;
            this.sourName=sourName;
            this.age=age;
            this.iQ=iQ;
        }
        Human (String name, double weidth){
            this.name=name;
            this.weidth=weidth;
        }
        Human (boolean education){
            this.education=education;
        }
        Human (String name, String sourName, int age, boolean education, double weidth, byte iQ) {
            this.name=name;
            this.sourName=sourName;
            this.age=age;
            this.education=education;
            this.weidth=weidth;
            this.iQ=iQ;
        }
        Human (Boolean education, byte iQ) {
            this.education=education;
            this.iQ=iQ;
        }
        Human (int age, byte iQ) {
            this.age=age;
            this.iQ=iQ;
        }
        Human (String name, double weidth, byte iQ) {
            this.name=name;
            this.weidth=weidth;
            this.iQ=iQ;
        }
        Human (String sourName, double weidth, int age) {
            this.sourName=sourName;
            this.weidth=weidth;
            this.age=age;
        }
        Human (byte iQ, int age) {
            this.iQ=iQ;
            this.age=age;
        }
    }
}
