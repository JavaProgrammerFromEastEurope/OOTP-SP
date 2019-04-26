package com.company;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Step #1

        //Создание объекта StudentCollection
        StudentCollection firstStudentCollection  = new StudentCollection();
        StudentCollection secondStudentCollection = new StudentCollection();

        ArrayList<Exam> firstExam  = new ArrayList<>();
        ArrayList<Exam> secondExam = new ArrayList<>();

        ArrayList<Test> firstTest  = new ArrayList<>();
        ArrayList<Test> secondTest = new ArrayList<>();

        ArrayList<Student> firstStudentList  = new ArrayList<>();
        ArrayList<Student> secondStudentList = new ArrayList<>();

        Random random = new Random();

        String firstNameArray[] = new String[]{
                "Oliver", "Jack", "Jacob", "Charlie", "Thomas", "Linda", "Patricia", "Karen", "Barbara", "Lisa"};
        String secondNameArray[] = new String[]{
                "Smith",  "Williams", "Miller","Moore","Anderson", "Davis", "Wild", "Harris","Wilson", "Garcia"};
        GregorianCalendar birthDateArray[] = new GregorianCalendar[]{
                new GregorianCalendar(1994,8,13),
                new GregorianCalendar(1995,8,14),
                new GregorianCalendar(1994,5,25),
                new GregorianCalendar(1996,7,15),
                new GregorianCalendar(1995,2,23),
                new GregorianCalendar(1995,7,18),
                new GregorianCalendar(1996,8,12),
                new GregorianCalendar(1994,3,17),
                new GregorianCalendar(1995,6,15),
                new GregorianCalendar(1994,7,13)};

        firstExam.add(new Exam("PL",      10, new GregorianCalendar(2017,7,10)));
        firstExam.add(new Exam("SAOD",     9, new GregorianCalendar(2017,7,15)));
        firstExam.add(new Exam("MATH",     5, new GregorianCalendar(2017,7,20)));
        firstExam.add(new Exam("ENGLISH",  9, new GregorianCalendar(2017,7,24)));
        firstExam.add(new Exam("PHYSICS",  5, new GregorianCalendar(2017,7,29)));

        secondExam.add(new Exam("PL",      9, new GregorianCalendar(2017,7,10)));
        secondExam.add(new Exam("SAOD",    9, new GregorianCalendar(2017,7,15)));
        secondExam.add(new Exam("MATH",    6, new GregorianCalendar(2017,7,20)));
        secondExam.add(new Exam("ENGLISH", 7, new GregorianCalendar(2017,7,24)));
        secondExam.add(new Exam("PHYSICS", 5, new GregorianCalendar(2017,7,29)));

        firstTest.add(new Test("BLCS", true));
        firstTest.add(new Test("ICG",  true));
        firstTest.add(new Test("AOKT", true));
        firstTest.add(new Test("LOGIC",true));
        firstTest.add(new Test("MPP&U",true));

        secondTest.add(new Test("BLCS", true));
        secondTest.add(new Test("ICG",  true));
        secondTest.add(new Test("AOKT", true));
        secondTest.add(new Test("LOGIC",true));
        secondTest.add(new Test("MPP&U",true));

        for (int i = 0; i < 9; i++) {

            Student student = new Student(firstNameArray[random.nextInt(9) + 1],
                    secondNameArray[random.nextInt(9) + 1], birthDateArray[random.nextInt(9) + 1],
                    Student.Education.valueOf(random.nextInt(3)), random.nextInt(499) + 100);

            student.AddExams(firstExam);
            student.AddTests(firstTest);

            firstStudentCollection.studentCollection.add(i,student);
            secondStudentCollection.studentCollection.add(i,student);
        }


        //Создание студента
        Student firstStudent  = new Student("Vladimir","Malakhov",new GregorianCalendar(1994,7,13),
                Student.Education.Specialist,681063);
        Student secondStudent = new Student("Mikhail","Dubovsky",new GregorianCalendar(1995,10,24),
                Student.Education.SecondEducation,681063);

        //Присваивание параметров объекта
        firstStudent.AddExams(firstExam);
        firstStudent.AddTests(firstTest);

        secondStudent.AddExams(secondExam);
        secondStudent.AddTests(secondTest);

        firstStudentCollection.studentCollection.add(0, firstStudent);
        secondStudentCollection.studentCollection.add(0, secondStudent);

        //Step #2
        Journal firstJournal = new Journal();
        Journal secondJournal = new Journal();

        //инициализация слушателей - Count
        IStudentCountHandler firstStudentsCountChangedHandler  = new InnerClassStudentCountHandler();
        IStudentCountHandler secondStudentsCountChangedHandler = new InnerClassStudentCountHandler();

        //инициализация слушателей - Reference
        IStudentReferenceHandler firstStudentReferenceChangedHandler  =  new InnerClassStudentReferenceHandler();
        IStudentReferenceHandler secondStudentReferenceChangedHandler =  new InnerClassStudentReferenceHandler();

        //присваивание слушателей - Count
         firstStudentCollection.addStudentCountListener(firstStudentsCountChangedHandler);
        secondStudentCollection.addStudentCountListener(secondStudentsCountChangedHandler);

        //присваивание слушателей - Reference
         firstStudentCollection.addStudentReferenceListener(firstStudentReferenceChangedHandler);
        secondStudentCollection.addStudentReferenceListener(secondStudentReferenceChangedHandler);

        //присваивание слушателей Count и Reference первого объекта
        firstJournal.addStudentCountListener(firstStudentCollection.getStudentCountListener());
        firstJournal.addStudentReferenceListener(firstStudentCollection.getStudentReferenceListener());

        //присваивание слушателей Reference первого и второго объекта
        secondJournal.addStudentReferenceListener(firstStudentCollection.getStudentReferenceListener());
        secondJournal.addStudentReferenceListener(secondStudentCollection.getStudentReferenceListener());


         firstStudentCollection.AddStudents(firstStudent);
        secondStudentCollection.AddStudents(secondStudent);

         firstStudentCollection.Remove(1);
        secondStudentCollection.Remove(1);

        firstStudentCollection.Index(0,new Student(
                "Oleg","D'akov",new GregorianCalendar(1972,10,24),
                Student.Education.SecondEducation,101));
        secondStudentCollection.Index(0,new Student(
                "Mikhail","D'akov",new GregorianCalendar(1972,10,24),
                Student.Education.SecondEducation,101));

        System.out.println("\nЖурнал первого слушателя");
        System.out.println(firstJournal.toString());

        System.out.println("\nЖурнал второго слушателя");
        System.out.println(secondJournal.toString());
    }
}