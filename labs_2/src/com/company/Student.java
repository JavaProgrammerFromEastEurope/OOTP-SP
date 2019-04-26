package com.company;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ListIterator;

import static java.text.MessageFormat.format;

class Student extends Person {

    enum Education {Specialist, Bachelor, SecondEducation}

    private Education education;
    private int groupNumber;
    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Exam> exams = new ArrayList<>();
    //private Exam[] exams = new Exam[]{new Exam()};
    private ListIterator<Exam> examListIterator;
    private ListIterator<Test> testListIterator;

    private Student() {  //конструктор без параметров
        super();
        education = Education.SecondEducation;
        groupNumber = 101;
    }
     Student(String firstName, String lastName, GregorianCalendar dateOfBirth, Education education, int groupNumber) {
        super(firstName, lastName, dateOfBirth);
        this.education   = education;
        this.groupNumber = groupNumber;
    }
     String getPerson(){
        return super.toString();
    }
    void setPerson(String firstName, String lastName, GregorianCalendar dateOfBirth){
         super.setFirstName(firstName);
         super.setLastName(lastName);
         super.setDateOfBirth(dateOfBirth);
    }

    public Education getEducation() {
        return education;
    }
    public int getGroupNumber()     {
        return groupNumber;
    }
    ArrayList<Exam> getExam()     {
        return this.exams;
    }
    ArrayList<Test> getTest()     {
        return this.tests;
    }

     private void setGroupNumber(int groupNumber) {
        if(groupNumber <= 100 || groupNumber > 599)
            throw new NullPointerException("Значение должно быть в диапозоне 100 > и < 600");
        this.groupNumber = groupNumber;
    }
     private void setEducation(Education education) {
        this.education = education;
    }
     private void setTests(ArrayList<Test> tests) {
        this.tests = tests;
        this.tests.listIterator();
    }
     private void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    ListIterator<Exam> getExamListIterator() {
        return examListIterator;
    }
    public void setExamListIterator(ListIterator<Exam> examListIterator) {
        this.examListIterator = examListIterator;
    }
    ListIterator<Test> getTestListIterator() {
        return testListIterator;
    }
    public void setTestListIterator(ListIterator<Test> testListIterator) {
        this.testListIterator = testListIterator;
    }
    private static double getPersonAverageScore(ArrayList<Exam> exams) { //вывод среднего балла
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
    void AddExams(ArrayList<Exam> params) {
        this.exams =  params;
        examListIterator = this.exams.listIterator();
        } //добавление экзамена

    void AddTests(ArrayList<Test> params) {
        this.tests =  params;
        testListIterator = this.tests.listIterator();
    } //добавление экзамена

    private void getArray(Object arrayList) { //вывод экзамена
        for (Object aArray :  (ArrayList)arrayList){
            System.out.printf("%s | ", aArray.toString());
        }
    }
    @Override
    public String toString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", getPerson(), education, groupNumber);
        System.out.printf("%s\n\t", string);
        System.out.println("Список экзаменов:");
        getArray(exams);
        System.out.println("\n\tСписок зачетов:");
        getArray(tests);
        return "";
    }
    public String toShortString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", getPerson(), education, groupNumber);
        System.out.printf("%s\n\t", string); getPersonAverageScore(exams);
        return "";
    }
    @Override
    public Object DeepCopy()  {
        Student student = new Student();

        student.setPerson((Person)super.DeepCopy());
        student.setEducation(this.education);
        student.setGroupNumber(this.groupNumber);
        student.setExams(new ArrayList<>(this.exams));
        student.setTests(new ArrayList<>(this.tests));
        return student;
    }
    private void setPerson(Person o) {
        super.firstName   = o.getFirstName();
        super.lastName    = o.getLastName();
        super.dateOfBirth = o.getDateOfBirth();
    }
}