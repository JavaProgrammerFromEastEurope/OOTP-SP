package com.company;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Exam> firstExam  = new ArrayList<>();
        ArrayList<Test> firstTest  = new ArrayList<>();

        firstExam.add(new Exam("PL",      10, new GregorianCalendar(2017,7,10)));
        firstExam.add(new Exam("SAOD",     9, new GregorianCalendar(2017,7,15)));
        firstExam.add(new Exam("MATH",     2, new GregorianCalendar(2017,7,20)));
        firstExam.add(new Exam("ENGLISH",  9, new GregorianCalendar(2017,7,24)));
        firstExam.add(new Exam("PHYSICS",  3, new GregorianCalendar(2017,7,29)));

        firstTest.add(new Test("BLCS", true));
        firstTest.add(new Test("ICG",  true));
        firstTest.add(new Test("AOKT", true));
        firstTest.add(new Test("LOGIC",true));
        firstTest.add(new Test("MPP&U",true));

        //Step1
        System.out.println("Step 1:");
        Person p1 = new Person("Vladimir", "Malakhov", new GregorianCalendar( 1994, 7, 13));
        Person p2 = new Person("Vladimir", "Malakhov", new GregorianCalendar( 1994, 7, 13));

        System.out.println("Первый объект: \"" + p1 + "\" хеш: " +p1.hashCode());
        System.out.println("Второй объект: \"" + p2 + "\" хеш: " +p2.hashCode());
        //Step 2
        Student firstStudent  = new Student("Vladimir","Malakhov",new GregorianCalendar(1994,8,13),
                Student.Education.Specialist,101);

        //Присваивание параметров объекта
        firstStudent.AddExams(firstExam);
        firstStudent.AddTests(firstTest);

        System.out.println("Step 2:");
        System.out.printf(firstStudent.toString());
        //Step 3
        System.out.println("\nStep 3:");
        System.out.println(firstStudent.getPerson());
        //Step 4
        final Student copy = (Student) firstStudent.DeepCopy();
        firstStudent.setPerson("Oleg","D'yakov", new GregorianCalendar(1976,7,13));
        System.out.println("-----------\nStep 4:");
        System.out.printf("\tКопия исходного объекта:\n %s%n", copy);
        System.out.println("-----------");
        System.out.printf("\tИсходный объект:\n %s%n", firstStudent);
        System.out.println("-----------");
        //Step 5
        /*
        System.out.println("Step 5:");
        int in = 999;
        try {
            firstStudent.setGroupNumber(in);
        } catch (NullPointerException ex) {
            throw new NullPointerException("Значение должно быть в диапозоне 100 > и < 600: " + in);
        }
        */
        //Step 6
        System.out.println("Step 6:");
        System.out.println("Список экзаменов:");
        for (ListIterator<Exam> it = firstStudent.getExamListIterator(); it.hasNext(); ) {
            System.out.printf("%s | ", it.next());
        }
        System.out.println("\n\nСписок зачетов:");
        for (ListIterator<Test> it = firstStudent.getTestListIterator(); it.hasNext(); ) {
            System.out.printf("%s | ", it.next());
        }
        //Step 7
        System.out.println("\n\nСписок экзаменов с оценкой выше 3: ");
        for (Exam aExam : firstStudent.getExam()) {
            if (aExam.getScore() > 3) {
                System.out.printf("%s | ", aExam.toString());
            }
        }
    }
}