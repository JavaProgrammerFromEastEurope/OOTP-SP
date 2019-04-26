package com.company;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static com.company.StudentCollection.checkString;

public class Main {
    public static void main(String[] args) {
        //Step #1
        System.out.println("\n***************FIRST_FUNCTIONS******************");
        //Создание объекта StudentCollection
        StudentCollection studentCollection = new StudentCollection();

        ArrayList<Exam> firstExam  = new ArrayList<>();
        ArrayList<Exam> secondExam = new ArrayList<>();

        ArrayList<Test> firstTest  = new ArrayList<>();
        ArrayList<Test> secondTest = new ArrayList<>();

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

        //Создание студента
        Student firstStudent  = new Student("Vladimir","Malakhov",new GregorianCalendar(1994,8,13),
                Student.Education.Specialist,681063);
        Student secondStudent = new Student("Mikhail","Dubovsky",new GregorianCalendar(1995,10,24),
                Student.Education.SecondEducation,681063);

        //Присваивание параметров объекта
        firstStudent.AddExams(firstExam);
        firstStudent.AddTests(firstTest);

        secondStudent.AddExams(secondExam);
        secondStudent.AddTests(secondTest);

        studentCollection.studentList.add(0, firstStudent);
        studentCollection.studentList.add(1, secondStudent);

        System.out.println(studentCollection.toString());
        System.out.println("***************FIRST_FUNCTIONS******************");
        //Step #2
        System.out.println("\n******************SECOND_FUNCTIONS**************");
        //Сортировка по Фамилии
        studentCollection.sortPersonLastNameArray();
        System.out.printf("\tВывод данных сортировки по Фамилии:\n\n %s%n",
                studentCollection.toString());
        //Сортировка по Дате Рождения
        studentCollection.sortPersonBirthDateArray();
        System.out.printf("\tВывод данных сортировки по Дате Рождения:\n\n %s%n",
                studentCollection.toString());
        //Сортировка по Среднему баллу
        studentCollection.sortStudentAverageScoreArray();
        System.out.printf("\tВывод данных сортировки по Среднему Баллу:\n\n %s%n",
                studentCollection.toString());
        System.out.println("******************SECOND_FUNCTIONS**************");
        //Step #3
        System.out.println("\n*****************THIRD_FUNCTIONS*****************");
        //Нахождение максимального среднего балла
        System.out.println("Максимальный средний балл: ");
        studentCollection.getMaxPersonAverageScore();

        // фильтрация списка с формой обучения Education.Specialist
        System.out.println("Вывод данных формой обучения Specialist: ");
        studentCollection.getSpecialistPersonArray(studentCollection.studentList);

        //группировку элементов списка по значению среднего балла;
        System.out.println("Группировка элементов по значению: ");
        studentCollection.AverageMarkGroup(studentCollection.studentList,7.6);
        System.out.println("*****************THIRD_FUNCTIONS*****************");
        //Step #4
        System.out.println("\n*****************FOURTH_FUNCTIONS****************");
        //Создание объекта TestCollection
        //Инициализация внутренних элементов объекта
        Scanner lr  = new Scanner(System.in);

        System.out.print("\t Введите количество элементов массива: ");
        String  string = lr.next();
        while(!checkString(string)) {
            System.out.print("\t Введите значение заново: ");
            string = lr.next();
        }
        int element = Integer.parseInt(string);

        TestCollections<Person,Student> testCollections = new TestCollections<>(element);

        testCollections.generateCollections(element);

        //Поиск заданных элементов, первого:
        System.out.println("\nПервый элемент:");
        testCollections.findElementCollections(1, testCollections.firstKey, testCollections.firstValue);

        //Поиск заданных элементов, среднего:
        System.out.println("\nСредний элемент:");
        testCollections.findElementCollections(testCollections.partInitialCapacity, testCollections.halfKey, testCollections.halfValue);

        //Поиск заданных элементов, последнего:
        System.out.println("\nПоследний элемент:");
        testCollections.findElementCollections(element, testCollections.lastKey, testCollections.lastValue);
        //Поиск заданных элементов, другого:
        //testCollections.findElementCollections(element+1, testCollections.lastKey, testCollections.lastValue);
        System.out.println("*****************FOURTH_FUNCTIONS****************");
    }
}