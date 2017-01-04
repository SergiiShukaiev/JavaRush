package com.javarush.test.level29.lesson15.big01.user;

public class User {
    private String name;
    private String surname;
    private int age;

    private Address address;


    private Work work;

    private boolean man = true;

    public boolean isMan()
    {
        return man;
    }

    public void setMan(boolean man)
    {
        this.man = man;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void printInfo(){
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
        printAdditionalInfo();

    }

    public void printAdditionalInfo() {
        if (getAge()<16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getBoss(){
        return getWork().getBoss();

    }
}
