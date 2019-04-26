package com.company;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

class Person  implements  Comparable<Person>, Comparator<Person> {
   private String   firstName;
   private String   lastName;
   private GregorianCalendar dateOfBirth;

   Person() { //конструктор без параметров
       this.firstName   = "Mikhail";
       this.lastName    = "Dubovsky";
       this.dateOfBirth = new GregorianCalendar();
   }
   Person(String firstName, String lastName, GregorianCalendar dateOfBirth) {  //конструктор с параметрами
       if (firstName == null || lastName == null || dateOfBirth == null)
           throw new NullPointerException();
       this.firstName   = firstName;
       this.lastName    = lastName;
       this.dateOfBirth = dateOfBirth;
       this.dateOfBirth.add(Calendar.MONTH, -1);
   }
    Person getPerson(){
        return this;
    }

    private GregorianCalendar getDateOfBirth()  { return dateOfBirth;}


    //вывод строки с перегрузкой
      public String toString() {
       return firstName + " " + lastName + "\t" + dateOfBirth.getTime();
   }  //вывод строки с перегрузкой

    //вывод строки с перегрузкой
    String toListString() {
        return firstName + " " + lastName + "\t" + dateOfBirth.getTime();
    }  //вывод строки с перегрузкой

   public String toShortString() {
       return firstName + " " + lastName;
   } //вывод строки  без перегрузки

    @Override
    public int compareTo(Person n) { //сравнение объектов
        int lastCmp = lastName.compareTo(n.lastName);
        if (lastCmp != 0) return lastCmp;
        else return 0;
    }
    @Override
    public int compare(Person a, Person b){
        return a.getDateOfBirth().compareTo(b.getDateOfBirth());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return (firstName != null ? firstName.equals(person.firstName) : person.firstName == null)
                && (lastName != null ? lastName.equals(person.lastName) : person.lastName == null)
                    && (dateOfBirth != null ? dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth == null);
    }
   @Override
   public int hashCode() {
       int result = firstName != null ? firstName.hashCode() : 0;
       result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
       result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
       return result;
   }
}