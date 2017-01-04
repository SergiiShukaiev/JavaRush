package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int num1=Integer.parseInt(reader.readLine());
        int num2=Integer.parseInt(reader.readLine());


        System.out.println(gcd(num1, num2));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }

 /*       while(num2!=0){
            if (num1>num2){
                int tmp=num1%num2;
                num1=tmp;
            }
            if (num1<num2){
                int tmp=num2%num1;
                num2=tmp;
            }
        }
        System.out.println(num1);

    } */
}
