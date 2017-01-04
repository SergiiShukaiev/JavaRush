package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static void main(String[] args){
        new Solution().go();
    }

    public void go(){
        method1();
    }
    public void method1(){
        method2();
    }
    public void method2(){
        method3();
    }
    public void method3(){
        method4();
    }
    public void method4(){
        getStackTraceDeep();
    }
    public static int getStackTraceDeep()
    {
        int stackCount=0;
       StackTraceElement[] elements=Thread.currentThread().getStackTrace();

        for (StackTraceElement element:elements){
            stackCount++;//напишите тут ваш код
            System.out.println(element.getMethodName());
        }
        System.out.println(stackCount);
        return stackCount;

    }
}
