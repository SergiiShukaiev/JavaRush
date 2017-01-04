package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args)
    {
        String str = "JavaRush - лучший сервис обучения Java.";
        System.out.println();
        try
        {
            System.out.println(getPartOfString(str));
        }
        catch (TooShortStringException e)
        {
            System.out.println("Something wrong!");
        }
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        int firstSpace = string.indexOf(" ") + 1;
        char[] chars = string.toCharArray();
        int spacesCounter = 0;
        int indexOfLastSpace = 0;
        for (int i = 0; i < string.length(); i++) {
            if (chars[i] == ' ') {
                spacesCounter++;
                if (spacesCounter == 4) {
                    indexOfLastSpace = string.length();
                }
                else if (spacesCounter == 5) {
                    indexOfLastSpace = i;
                    break;
                }
            }
        }
        if (spacesCounter < 4) {
            throw new TooShortStringException();
        }
        return string.substring(firstSpace, indexOfLastSpace);
    }

    public static class TooShortStringException extends Exception
    {
    }
}