package com.company;

import com.company.Student.Education;

import java.io.Serializable;

class TestCollections<K,V>  extends HashMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {
    //field's
    private List<Person> personList;
    private List<String> stringList;

    private HashMap<Person, Student> personStudentMap;
    private HashMap<String, Student> stringStudentMap;

    Person firstKey,   halfKey,   lastKey;
    Student firstValue, halfValue, lastValue;

    int partInitialCapacity;

    private Random random = new Random();

    private String firstNameArray[] = new String[]{
            "Oliver", "Jack", "Jacob", "Charlie", "Thomas", "Linda", "Patricia", "Karen", "Barbara", "Lisa"};
    private String secondNameArray[] = new String[]{
            "Smith",  "Williams", "Miller","Moore","Anderson", "Davis", "Wild", "Harris","Wilson", "Garcia"};
    private static GregorianCalendar birthDateArray[] = new GregorianCalendar[]{
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
    //Constructor
    TestCollections(int initialCapacity) {
        super(initialCapacity);
        this.personList = new ArrayList<>(initialCapacity);
        this.stringList = new ArrayList<>(initialCapacity);
        this.personStudentMap = new HashMap<>(initialCapacity);
        this.stringStudentMap = new HashMap<>(initialCapacity);
    }
    //Заполнение таблиц элементов значениями
    void generateCollections(int initialCapacity) {

        partInitialCapacity = (int)Math.ceil((double) initialCapacity / 2) ;
            System.out.println("partInitialCapacity = " +partInitialCapacity);
        for (int i = 0; i < initialCapacity; i++) {

            Student student = new Student(firstNameArray[random.nextInt(9) + 1],
                    secondNameArray[random.nextInt(9) + 1], birthDateArray[random.nextInt(9) + 1],
                        Education.valueOf(random.nextInt(3)), random.nextInt(499) + 100);

            String StringList = student.getPerson().toListString();
            personList.add(i,student.getPerson());
            stringList.add(i,StringList);
            personStudentMap.put(student.getPerson(), student);
            stringStudentMap.put(StringList, student);

            if(i == 0){
                firstKey = student.getPerson();
                firstValue = student;
            }
            if(i == partInitialCapacity - 1){
                halfKey = student.getPerson();
                halfValue = student;
            }
            if(i == initialCapacity - 1){
                lastKey = student.getPerson();
                lastValue = student;
            }
        }
    }
    //Вывод элементов массивов
    void findElementCollections(int element, Person key, Student value) {
        double  CurrentTime, totalTime;

        CurrentTime = System.currentTimeMillis();
        Person a = personList.get(element - 1);
        totalTime = System.currentTimeMillis() - CurrentTime;
        System.out.printf("personList:  Элемент - %d\n %sВремя выполнения: %s%n\n", element, a, totalTime);

        CurrentTime = System.currentTimeMillis();
        String b = stringList.get(element - 1);
        totalTime = System.currentTimeMillis() - CurrentTime;
        System.out.printf("stringList:  Элемент - %d\n%s\nВремя выполнения: %s%n\n", element, b, totalTime);

        CurrentTime = System.currentTimeMillis();
        Student c = personStudentMap.get(key);
        totalTime = System.currentTimeMillis() - CurrentTime;
        System.out.printf("personStudentMap:  Элемент - %d\n %sВремя выполнения: %s%n\n", element, c, totalTime);

        CurrentTime = System.currentTimeMillis();
        Student d = new Student();
        for (Entry<String,Student> pair : stringStudentMap.entrySet()) {
            if(value.equals(pair.getValue())){
                 d = stringStudentMap.get(pair.getKey());
                break;
            }
        }
        totalTime = System.currentTimeMillis() - CurrentTime;
        System.out.printf("stringStudentMap:  Элемент - %d\n%sВремя выполнения: %s%n", element, d, totalTime);
    }
}
