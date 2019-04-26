package com.company;

import org.jetbrains.annotations.Contract;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static java.text.MessageFormat.format;

class Student extends Person implements DateAndCopy, Serializable {

    enum Education {Specialist, Bachelor, SecondEducation;

        @Contract(pure = true)
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

    Person getPerson(){
        return super.getPerson();
    }
    String getPersonToString(){
        return super.toString();
    }
    Education getEducation() {
        return education;
    }
    List<Exam> getExams() {
        return exams;
    }
    List<Test> getTests() {
        return tests;
    }
    int getGroup() {
        return groupNumber;
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


    private void AddExam(String subjectName, int score, GregorianCalendar examDate) {
        this.exams.add(new Exam(subjectName,score,examDate));
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
    private void setPerson(Person o) {
        super.firstName   = o.getFirstName();
        super.lastName    = o.getLastName();
        super.dateOfBirth = o.getDateOfBirth();
    }
    private void setStudent(Student o) {
        setPerson(o.getPerson());
        this.exams = o.getExams();
        this.tests = o.getTests();
        this.groupNumber = o.getGroup();
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

    boolean Save(String filename) {
        // сохранения данных объекта в файле с помощью сериализации;
        FileOutputStream   fos = null;
        ObjectOutputStream oos = null;
        boolean mark;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(this);
                mark = true;
            }
            catch (NullPointerException ex){
                ex.printStackTrace();
                mark = false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            mark = false;
        } finally {
            try {
                assert fos != null;
                assert oos != null;
                oos.flush();
                oos.close();
                fos.flush();
                fos.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
                mark = false;
            }
        }
        return mark;
    }
    boolean Load(String filename) {
        // инициализации объекта данными из файла с помощью десериализации;
        FileInputStream   fis = null;
        ObjectInputStream oin = null;
        boolean mark;
        try {
            fis = new FileInputStream(filename);
            oin = new ObjectInputStream(fis);
            try {
                this.setStudent((Student) oin.readObject());
                mark = true;
            }
            catch (ClassNotFoundException ex){
                ex.printStackTrace();
                mark = false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            mark = false;
        } finally {
            try {
                assert fis != null;
                assert oin != null;
                oin.close();
                fis.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
                mark = false;
            }
        }
        return mark;
    }

    static boolean Save(String filename, Student o) {
        // сохранения объекта в файле с помощью сериализации;
        FileOutputStream   fos = null;
        ObjectOutputStream oos = null;
        boolean mark;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(o);
                mark = true;
            }
            catch (NullPointerException ex){
                ex.printStackTrace();
                mark = false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            mark = false;
        } finally {
            try {
                assert fos != null;
                assert oos != null;
                oos.flush();
                oos.close();
                fos.flush();
                fos.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
                mark = false;
            }
        }
        return mark;
    }
    static boolean Load(String filename, Student o) {
        // восстановления объекта из файла с помощью десериализации.
        FileInputStream   fis = null;
        ObjectInputStream oin = null;
        boolean mark;
        try {
             fis = new FileInputStream(filename);
             oin = new ObjectInputStream(fis);
            try {
                o = (Student) oin.readObject();
                mark = true;
            }
            catch (ClassNotFoundException ex){
                ex.printStackTrace();
                mark = false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            mark = false;
        } finally {
            try {
                assert fis != null;
                assert oin != null;
                oin.close();
                fis.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
                mark = false;
            }
        }
        return mark;
    }
    boolean AddFromConsole()  {
        // добавление в один из списков класса нового элемента,
        // данные для которого вводятся с консоли
        Scanner    lr = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar examDate = Calendar.getInstance();
        String   subjectName;
        int      Score;
        boolean  mark;

        System.out.print("\n Введите эл-ты экзамена студента: " +
                "\n\t Название, оценка, дата {'String','int','dd.MM.yyyy'} символы-разделителели '_ , : - '  ");
        String string = lr.next();
        String[] parts = string.split("[_, :-]");
        try {
                        subjectName = parts[0];
             Score = Integer.parseInt(parts[1]);
            examDate.setTime(df.parse(parts[2]));

            this.AddExam(subjectName,Score, (GregorianCalendar) examDate);
            mark = true;
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            mark = false;
        }
        return mark;
    }

    @Override
    public Student DeepCopy()  {
        // инициализации объекта данными из файла с помощью десериализации;
        FileOutputStream   fos = null;
        ObjectOutputStream oos = null;

        FileInputStream    fis = null;
        ObjectInputStream  oin = null;

        Student tampStudent = this;
        String filename = "DeepCopy.dat";
        boolean mark;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(this);
            }
            catch (NullPointerException ex){
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert fos != null;
                assert oos != null;
                oos.flush();
                oos.close();
                fos.flush();
                fos.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        // восстановления объекта из файла с помощью десериализации.
        try {
            fis = new FileInputStream(filename);
            oin = new ObjectInputStream(fis);
            try {
                tampStudent.setStudent((Student) oin.readObject());
            }
            catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert fis != null;
                assert oin != null;
                oin.close();
                fis.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return tampStudent;
    }
    public String toShortString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", getPersonToString(), education, groupNumber);
        System.out.printf("%s\n\t", string); getPersonAverageScore();
        return "";
    }
    @Override
    public String toString() { //вывод строки с перегрузкой
        String string = format("{0} {1} {2} ", getPersonToString(), education, groupNumber);
            System.out.printf("%s\n\t", string);
            System.out.println("Список экзаменов:");
        getArray(exams);
            System.out.println("\n\tСписок зачетов:");
        getArray(tests);
            System.out.println();
        return "";
    }
}