package com.company;

import com.company.Student.Education;

import java.text.MessageFormat;
import java.util.stream.Collectors;

    public class StudentCollection  implements Comparator<Student>{

        List<Student> studentList = new ArrayList<>();

        private void AddDefaults(){
            this.studentList.add(new Student());
        }

        /*****************SortArray****************/

        void sortPersonLastNameArray(){
            studentList.sort(Person::compareTo);
        }
        void sortPersonBirthDateArray(){
            studentList.sort((a, b) -> a.compare(a, b));
        }
        void sortStudentAverageScoreArray(){
            studentList.sort(StudentCollection::compare2);
        }
        /*****************SortArray****************/

         //Вывод максимального среднего балла
        void getMaxPersonAverageScore(){
            if(studentList.size()!=0) {
                sortStudentAverageScoreArray();
                Student a = studentList.get(studentList.size() - 1);
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
                    v.stream().map(Person::toListString).collect(Collectors.joining(","))));
        }

        @Override
        public String toString() {
            return  studentList.toString();
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