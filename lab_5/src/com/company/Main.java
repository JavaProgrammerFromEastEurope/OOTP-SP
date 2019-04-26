package com.company;


import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static com.company.Student.Education.Specialist;

public class Main {
    public static void main(String[] args) {
        //Step #1
        System.out.println("***************FIRST_FUNCTIONS******************");
/*
        Student.Education education = Bachelor;
        String  firstName,
                lastName,
                subjectName;

        int     groupNumber,
                bYear,
                bMonth,
                bDayOfMonth,
                year,
                month,
                score,
                dayOfMonth,
                arrayI,
                marc;

        Scanner lr  = new Scanner(System.in);

        System.out.print("\n\t Введите данные студента:" +
                "\n\t Имя: ");  firstName  = lr.next();
        System.out.print("\t Фамилия: ");    lastName   = lr.next();
        System.out.print("\t Дата рождения: \n\t День: "); bDayOfMonth = Integer.parseInt(lr.next());
        System.out.print("\t Месяц: ");      bMonth = Integer.parseInt(lr.next());
        System.out.print("\t Год: ");        bYear  = Integer.parseInt(lr.next());

        System.out.print("\t Образование: Введите '0' - 'SecondEducation', '1' - 'Specialist', '2' - 'Bachelor' ");
        marc = Integer.parseInt(lr.next());
        if(marc == 0){education = SecondEducation;          System.out.print("\t Присвоено значение - 'SecondEducation'\n");}
            else if (marc == 1) {education = Specialist;    System.out.print("\t Присвоено значение - 'Specialist'\n");}
                else if (marc == 2) {education = Bachelor;  System.out.print("\t Присвоено значение - 'Bachelor'\n");}
                    else  System.out.println("Try Again");
        System.out.print("\t Группа: ");            groupNumber  = Integer.parseInt(lr.next());
        System.out.print("\t Кол-во экзаменов: ");  arrayI  = Integer.parseInt(lr.next());

        ArrayList<Exam> exam = new ArrayList<>(arrayI);
        for(int i = 0;i < arrayI; i++) {
            System.out.println("\n\t Экзамен: " + (i+1));
            System.out.print("\t Название предмета: ");    subjectName = lr.next();
            System.out.print("\t Балл: ");           score = Integer.parseInt(lr.next());
            System.out.print("\t День: ");      dayOfMonth = Integer.parseInt(lr.next());
            System.out.print("\t Месяц: ");          month = Integer.parseInt(lr.next());
            System.out.print("\t Год: ");            year  = Integer.parseInt(lr.next());

            exam.add(new Exam(subjectName, score, new GregorianCalendar(year,month,dayOfMonth)));
        }
        System.out.print("\t Кол-во зачетов: ");  arrayI  = Integer.parseInt(lr.next());
        ArrayList<Test> test = new ArrayList<>(arrayI);
        for(int i = 0;i < arrayI; i++) {
            boolean mark = false;
            System.out.println("\n\t Зачет: " + (i+1));
            System.out.print("\t Название предмета: ");    subjectName = lr.next();
            System.out.print("\t Зачет: Введите '0' - 'не слал', '1' - 'сдал' ");
                marc = Integer.parseInt(lr.next());
            if(marc == 0){mark = false;          System.out.print("\t Присвоено значение - 'false'\n");}
                else if (marc == 1) {mark = true;    System.out.print("\t Присвоено значение - 'true'\n");}

            else  System.out.println("Try Again");
            test.add(new Test(subjectName, mark));
        }
        Student student = new Student(
                firstName, lastName, new GregorianCalendar( bYear, bMonth, bDayOfMonth),education, groupNumber);
        student.AddExams(exam);
        student.AddTests(test);
*/
        //Создание объекта StudentCollection

        ArrayList<Exam> firstExam  = new ArrayList<>();
        ArrayList<Test> firstTest  = new ArrayList<>();

        firstExam.add(new Exam("PL",      10, new GregorianCalendar(2017,7,10)));
        firstExam.add(new Exam("SAOD",     9, new GregorianCalendar(2017,7,15)));
        firstExam.add(new Exam("MATH",     5, new GregorianCalendar(2017,7,20)));
        firstExam.add(new Exam("ENGLISH",  9, new GregorianCalendar(2017,7,24)));
        firstExam.add(new Exam("PHYSICS",  5, new GregorianCalendar(2017,7,29)));

        firstTest.add(new Test("BLCS", true));
        firstTest.add(new Test("ICG",  true));
        firstTest.add(new Test("AOKT", true));
        firstTest.add(new Test("LOGIC",true));
        firstTest.add(new Test("MPP&U",true));

        //Создание студента
        Student student  = new Student(
                "Vladimir","Malakhov",new GregorianCalendar(1994,7,13),
                    Student.Education.Specialist,681063);

        //Присваивание параметров объекта
        student.AddExams(firstExam);
        student.AddTests(firstTest);

        Student copyStudent = student.DeepCopy();
        System.out.printf("Копия студента: \n%s%n", copyStudent);
        System.out.printf("Студент: \n%s%n", student);
        System.out.println("\n***************FIRST_FUNCTIONS******************");
        //Step #2
        System.out.println("\n******************SECOND_FUNCTIONS**************");

        Scanner lr = new Scanner(System.in);
        File file    = new File("DeepCopy.dat");
        File newFile = new File("DeepCopy.dat");
        System.out.print("\n Ввелите имя файла: ");
        String filename = lr.next();

        if (file.getPath().equals(filename)) {
            student.Load("DeepCopy.dat");
        }
        else { //OOTP&SP:10:10.10.2017
            System.out.println("Файл с введенным именем " + filename + " не найден! Создан новый файл!");
            student.Save(filename);
            newFile = new File(filename);
        }
        System.out.println("\n****************SECOND_FUNCTIONS****************");
        System.out.println("\n*****************THIRD_FUNCTIONS****************");

        System.out.printf("Студент: \n%s%n", student);

        System.out.println("\n*****************THIRD_FUNCTIONS****************");
        System.out.println("\n*****************FOURTH_FUNCTIONS****************");

        student.AddFromConsole();
        student.Save(filename);
        System.out.printf("Студент: \n%s%n", student);
        System.out.println("*******************FOURTH_FUNCTIONS****************");
        System.out.println("\n*****************FIFTH_FUNCTIONS****************");

        Student.Save(filename,student);
        student.AddFromConsole();
        Student.Load(filename,student);
        System.out.printf("Студент: \n%s%n", student);

        file.deleteOnExit();
        newFile.deleteOnExit();
        System.out.println("*******************FIFTH_FUNCTIONS****************");
    }
}

