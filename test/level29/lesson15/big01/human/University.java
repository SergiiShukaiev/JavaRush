package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students=new ArrayList<Student>();

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Student getStudentWithAverageGrade( double averageGrade) {
        //TODO:
        for (Student student : students){
            if (student.getAverageGrade()==averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int iMaxGrade=0;
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getAverageGrade()>students.get(iMaxGrade).getAverageGrade())
                iMaxGrade=i;
        }
        return students.size()==0 ? null : students.get(iMaxGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        int iMinGrade=0;
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getAverageGrade()<=students.get(iMinGrade).getAverageGrade())
                iMinGrade=i;
        }
         return students.size()==0 ? null : students.get(iMinGrade);
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }
}
