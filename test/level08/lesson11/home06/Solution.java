package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
     /*   ArrayList<Human> childrenc=new ArrayList<Human>();
        ArrayList<Human> children=new ArrayList<Human>();
       Human child1=new Human ("Vova", true, 3, childrenc);
        Human child2=new Human ("Vika", false, 8, childrenc);
        Human child3=new Human("Max", true, 12, childrenc);
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human papa=new Human("Andrej", true, 41, children);
        Human mama=new Human("Tanja", false, 37, children);
        ArrayList<Human> childpapa=new ArrayList<Human>();
        childpapa.add(papa);
        ArrayList<Human> childmama=new ArrayList<Human>();
        childmama.add(mama);

        Human dedPapa=new Human("Vitala", true, 85, childpapa);
        Human babaPapa=new Human("Nina", false, 82, childpapa);

        Human dedMama=new Human("Borja", true, 81, childmama);
        Human babaMama=new Human("Katja", false, 80, childmama); */

        ArrayList<Human> children=new ArrayList<Human>();
        Human child1=new Human ("Vova", true, 3, children);
        Human child2=new Human ("Vika", false, 8, children);
        Human child3=new Human("Max", true, 12, children);
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human papa=new Human("Andrej", true, 41, children);
        Human mama=new Human("Tanja", false, 37, children);
        System.out.println(papa.toString());
        System.out.println(mama.toString());

        children.clear();
        children.add(papa);
        Human dedPapa=new Human("Vitala", true, 85, children);
        Human babaPapa=new Human("Nina", false, 82, children);
        System.out.println(dedPapa.toString());
        System.out.println(babaPapa.toString());

        children.set(0, mama);
        Human dedMama=new Human("Borja", true, 81, children);
        Human babaMama=new Human("Katja", false, 80, children);
        System.out.println(dedMama.toString());
        System.out.println(babaMama.toString());


      /*  System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

        System.out.println(papa.toString());
        System.out.println(mama.toString());

        System.out.println(dedPapa.toString());
        System.out.println(babaPapa.toString());

        System.out.println(dedMama.toString());
        System.out.println(babaMama.toString()); */
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;


        }//напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
