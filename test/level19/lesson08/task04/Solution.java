package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream=System.out;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PrintStream stream=new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String result=isCalculate(outputStream.toString());
        System.out.println(result);
    }

    public static String isCalculate(String s){
        String[] str=s.split(" ");
        String result="";
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[2]);
        int c;
        if(str[1].equals("+")){
            c=a+b;
            result=a+" + "+b+" = "+c;
        }
        else if(str[1].equals("-")){
            c=a-b;
            result=a+" - "+b+" = "+c;
        }
        else if(str[1].equals("*")){
            c=a*b;
            result=a+" * "+b+" = "+c;
        }
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

