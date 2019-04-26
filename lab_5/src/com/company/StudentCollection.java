package com.company;

import com.company.Student.Education;

import java.text.MessageFormat;
import java.util.stream.Collectors;

public class StudentCollection  implements Comparator<Student>, StudentListHandler {

    List<Student> studentCollection = new ArrayList<>();

    private String nameOfCollection = "studentCollection";

    void Index(int j,Student student){
        this.studentCollection.set(j,student);
        StudentListHandler(
                new StudentListHandlerEventArgs(studentCollection, nameOfCollection,
                        "изменен -", student));
    }

    private void AddDefaults(){
        this.studentCollection.add(new Student());
        StudentListHandler(
               new StudentListHandlerEventArgs(studentCollection, nameOfCollection,
                        "добавлен -", new Student()));
    }

    void AddStudents(Student student) {
        this.studentCollection.add(student);
        StudentListHandler(
               new StudentListHandlerEventArgs(studentCollection,nameOfCollection,
                        "добавлен -", student));
    } //добавление экзамена

    private boolean Remove(int j){
        if(j < studentCollection.size()){
        StudentListHandler(
                new StudentListHandlerEventArgs(studentCollection,nameOfCollection,
                            "удален -", studentCollection.get(j)));
            studentCollection.remove(j);
            return true;
        } else
            return false;
    }

    /*****************SortArray****************/

    void sortPersonLastNameArray(){
        studentCollection.sort(Person::compareTo);
    }
    void sortPersonBirthDateArray(){
        studentCollection.sort((a, b) -> a.compare(a, b));
    }
    void sortStudentAverageScoreArray(){
        studentCollection.sort(StudentCollection::compare2);
    }

    /*****************SortArray****************/

    //Вывод максимального среднего балла
    void getMaxPersonAverageScore(){
        if(studentCollection.size()!=0) {
            sortStudentAverageScoreArray();
            Student a = studentCollection.get(studentCollection.size() - 1);
            System.out.println(a);
            a.getPersonAverageScore();
        }
        else {
            AddDefaults();
            System.out.println("\nКоллекция пуста. Создан новый объект");
        }
    }
    void getSpecialistPersonArray(List<Student> studentList){
        Enumeration<Student> Specialist;
        Vector<Student> educationVector = new Vector<>();

        for (Student a : studentList) {
            if (a.getEducation() == Education.Specialist) {
                educationVector.add(a);
            }
        }
        Specialist = educationVector.elements();
        while (Specialist.hasMoreElements()) {
            System.out.println(Specialist.nextElement());
        }
    }
    void AverageMarkGroup(List<Student> studentList, double value) {

        System.out.println(MessageFormat.format("----Список студентов чей средний балл = {0}----", value));

        Map<Boolean, List<Student>> StudentListByValue = studentList.stream()
                .collect(Collectors.partitioningBy(s -> s.getPersonAverageScore() == value));

        StudentListByValue.forEach((k, v) -> System.out.println("Key:" + k + "  " +
                v.stream().map(Student::getPersonToString).collect(Collectors.joining(","))));
    }

    @Override
    public String toString() {
        return  studentCollection.toString();
    }

    static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static int compare2(Student a, Student b) {
        Double aPersonAverageScore = a.getPersonAverageScore();
        Double bPersonAverageScore = b.getPersonAverageScore();
        return aPersonAverageScore.compareTo(bPersonAverageScore);
    }
    @Override
    public int compare(Student a, Student b) {
        Double aPersonAverageScore = a.getPersonAverageScore();
        Double bPersonAverageScore = b.getPersonAverageScore();
        return aPersonAverageScore.compareTo(bPersonAverageScore);
    }

    @Override
    public void StudentListHandler( StudentListHandlerEventArgs args) {

    }
}