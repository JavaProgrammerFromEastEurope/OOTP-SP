package com.company;

import java.util.Arrays;

import static java.text.MessageFormat.format;

class Student implements Comparable<Student> {

    enum Education {Specialist, Bachelor, SecondEducation}

    private Person person;
    private Education education;
    private int groupNumber;
    private Exam[] exams = new Exam[]{new Exam()};

    Student() {  //конструктор без параметров
        person = new Person();
        education = Education.SecondEducation;
        groupNumber = 681063;
    }
    Student(Person person, Education personEducation, int groupNumber) {  //конструктор с параметрами
        if (person == null || personEducation == null)
            throw new NullPointerException();
        this.person      = person;
        this.education   = personEducation;
        this.groupNumber = groupNumber;
    }

    public Person getPerson()      { return person;}   //вывод полей
    public Education getEducation(){ return education;}
    public int getGroupNumber()    { return groupNumber;}
    public Exam[] getExam()        { return exams;}

    void setPerson(Person person)         { this.person = person;} //приваивание данных к полям
    void setEducation(Education education){ this.education = education;}
    void setGroupNumber(int groupNumber)  { this.groupNumber = groupNumber;}

    private static double getPersonAverageScore(Exam[] exams) { //вывод среднего балла
        double aScore = 0.0,
                count = 0.0;
        for (Exam aExam : exams){
             aScore += aExam.getScore();
             count++;
        }
        return aScore / count;
    }

    boolean getPersonEducationIndex(Education education) {  //сравлнение образования
        System.out.printf("%s - ", education);
        return this.education.equals(education) ;
    }

    void AddExams(Exam[] params) {
        this.exams =  params;
        } //добавление экзамена

    private static void  getExams(Exam[] exams) { //вывод экзамена
        for (Exam aExam : exams){
            System.out.printf("%s | ", aExam.toString());
        }
    }
    public boolean equals(Object o) { //сравнение  полей объектов
        if (!(o instanceof Student))
            return false;
        Student n = (Student) o;
        return n.person.equals(person)
                && n.education.equals(education) && n.groupNumber == groupNumber && Arrays.equals(n.exams, exams);
    }

    public String toString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", person, education, groupNumber);
        System.out.printf("%s\n\t", string); getExams(exams);
        return "";
    }

    String toShortString() { //вывод строки  без перегрузки
        String string = format("{0} {1} {2} ", person, education, groupNumber);
        System.out.print(string); System.out.print(getPersonAverageScore(exams));
        return "";    }

    public int compareTo(Student n) { //сравнение объектов
        int lastCmp = person.compareTo(n.person);
        return (lastCmp != 0 ? lastCmp : education.compareTo(n.education));
    }
}