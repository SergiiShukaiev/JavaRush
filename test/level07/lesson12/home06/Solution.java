package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human dedPapa=new Human("Vasa",true,65, null, null);
        dedPapa.toString();
        Human babaPapa=new Human("Natasha", false, 63, null, null);
        babaPapa.toString();

        Human dedMama=new Human("Kolja", true, 70, null, null);
        dedMama.toString();
        Human babaMama=new Human("Tamara", false, 66, null, null);
        babaMama.toString();

        Human papa=new Human("Vitalja", true, 39, dedPapa, babaPapa);
        papa.toString();
        Human mama=new Human("Sveta", false, 36, dedMama, babaMama);
        mama.toString();

        Human child1=new Human("Olja", false, 14, papa, mama);
        child1.toString();
        Human child2=new Human("Igor", true, 11, papa, mama);
        child2.toString();
        Human child3=new Human("Ira", false, 7, papa, mama);
        child3.toString();
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;


            System.out.println(text);

            return text;
        }
    }

}
