package com.javarush.test.level21.lesson08.task03;

import com.sun.org.apache.xpath.internal.SourceTree;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Object clone()throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone()throws CloneNotSupportedException {
            throw new CloneNotSupportedException();

        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone() throws CloneNotSupportedException{
            return new C(this.getI(),this.getJ(),this.getName());
        }
    }

    public static void main(String[] args){
        A a =new A(1,3);
        B b=new B(1,3,"sss");
        C c=new C(1,3,"s");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
