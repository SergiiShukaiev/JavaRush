package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {

      Man man1=new Man("Sereban", 28, "Niko");
      Man man2=new Man("Voloda", 29, "Kherson");

        Woman woman1=new Woman("Alina", 24, "Centre");
        Woman woman2=new Woman("Shurka", 26, "Okrugnaja");

        //создай по два объекта каждого класса тут

       System.out.println(man1); //выведи их на экран тут
       System.out.println(man2); //выведи их на экран тут

        System.out.println(woman1); //выведи их на экран тут
        System.out.println(woman2); //выведи их на экран тут
    }

   public static class Man
   {
      private String name;
       private int age;
       private String address;

       public Man(String name, int age, String address)
       {
           this.name = name;
           this.age = age;
           this.address = address;
       }
       public String toString() {return name + " " + age + " " + address;}

   }

public static class Woman
{
    private String name;
    private int age;
    private String address;
    public String toString() {return name + " " + age + " " + address;}

   public Woman(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}


// добавьте тут ваши классы
}
