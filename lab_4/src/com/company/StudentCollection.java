package com.company;

import com.company.Student.Education;

import java.text.MessageFormat;
import java.util.stream.Collectors;

class StudentCollection  implements Comparator<Student> {

     private ArrayList<IStudentCountHandler> studentCountHandler = new ArrayList<IStudentCountHandler>();
     private ArrayList<IStudentReferenceHandler> studentReferenceHandler = new ArrayList<IStudentReferenceHandler>();

    List<Student> studentCollection = new ArrayList<>();

    private String nameOfCollection = "studentCollection";

    void addStudentCountListener(IStudentCountHandler listener) {
        if (!studentCountHandler.contains(listener)) {
            studentCountHandler.add(listener);
        }
    }

    void addStudentReferenceListener(IStudentReferenceHandler listener) {
        if (!studentReferenceHandler.contains(listener)) {
            studentReferenceHandler.add(listener);
        }
    }

     IStudentCountHandler getStudentCountListener() {
        return this.studentCountHandler.get(0);
    }

     IStudentReferenceHandler getStudentReferenceListener() {
        return this.studentReferenceHandler.get(0);
    }

     void processCountChanged(StudentListHandlerEventArgs args) {

        ArrayList<InnerClassStudentCountHandler> tempSpeedListenerList;
        synchronized (this) {
            if (studentCountHandler.size() == 0)
                return;
            tempSpeedListenerList = (ArrayList<InnerClassStudentCountHandler>) studentCountHandler.clone();
        }

        for (InnerClassStudentCountHandler listener : tempSpeedListenerList) {
            listener.StudentsCountChanged(args);
        }
    }
    void processReferenceChanged(StudentListHandlerEventArgs args) {

        ArrayList< InnerClassStudentReferenceHandler> tempSpeedListenerList;
        synchronized (this) {
            if (studentReferenceHandler.size() == 0)
                return;
            tempSpeedListenerList = (ArrayList< InnerClassStudentReferenceHandler>) studentReferenceHandler.clone();
        }

        for (InnerClassStudentReferenceHandler listener : tempSpeedListenerList) {
            listener.StudentReferenceChanged(args);
        }
    }

    void Index(int j,Student student){
        this.studentCollection.set(j, student);
        // fire StudentListEvent
        processReferenceChanged(new StudentListHandlerEventArgs(this.studentCollection, this.nameOfCollection,
                    "изменен -", student));
    }//изменение внутренних данных

    void AddDefaults(){
        this.studentCollection.add(new Student());
        processCountChanged(new StudentListHandlerEventArgs(this.studentCollection, this.nameOfCollection,
                    "добавлен -", new Student()));
    } //добавление дефолтных данных

     void AddStudents(Student student) {
        this.studentCollection.add(student);
        processCountChanged( new StudentListHandlerEventArgs(this.studentCollection,this.nameOfCollection,
                    "добавлен -", student));
    } //добавление определенных данных

    void Remove(int j){
        if(j < studentCollection.size()){
        processCountChanged(new StudentListHandlerEventArgs(this.studentCollection,this.nameOfCollection,
                    "удален -", this.studentCollection.get(j)));
            studentCollection.remove(j);
        }
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
}