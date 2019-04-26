package com.company;

import static java.text.MessageFormat.format;

class Student extends Person {

    enum Education {Specialist, Bachelor, SecondEducation;

        public static Education valueOf(int i) {
                   if (i == 0) {
                return Education.Specialist;
            } else if (i == 1) {
                return Education.Bachelor;
            } else if (i == 2) {
                return Education.SecondEducation;
            }
            return Education.Specialist;
        }
    }
    private Education education;
    private int groupNumber;
    private List<Test> tests = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

    Student() {  //конструктор без параметров
        super();
        education = Education.SecondEducation;
        groupNumber = 101;
    }
     Student(String firstName, String lastName, GregorianCalendar dateOfBirth, Education education, int groupNumber) {
        super(firstName, lastName, dateOfBirth);
        this.education   = education;
        this.groupNumber = groupNumber;
    }

    Education getEducation() {
        return education;
    }

    double getPersonAverageScore() { //вывод среднего балла
        double aScore = 0.0,
                count = 0.0;
        for (Exam aExam : exams){
             aScore += aExam.getScore();
             count++;
        }
        return aScore / count;
    }

    void AddExams(ArrayList<Exam> params) {
        this.exams =  params;
        } //добавление экзамена

    void AddTests(ArrayList<Test> params) {
        this.tests =  params;
    } //добавление экзамена

    private void getArray(Object arrayList) { //вывод экзамена
        for (Object aArray :  (ArrayList)arrayList){
            System.out.printf("%s | ", aArray.toString());
        }
    }
        @Override
    public String toString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", super.toString(), education, groupNumber);
        System.out.printf("%s\n\t", string);
        System.out.println("Список экзаменов:");
        getArray(exams);
        System.out.println("\n\tСписок зачетов:");
        getArray(tests);
            System.out.println();
        return "";
    }

    public String toShortString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", super.toString(), education, groupNumber);
        System.out.printf("%s\n\t", string); getPersonAverageScore();
        return "";
    }
}