package com.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

class Person  implements DateAndCopy, Comparable<Person>, Comparator<Person>, Serializable {
   String   firstName;
   String   lastName;
   GregorianCalendar dateOfBirth;

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
    private void setFirstName(String firstName)                 { this.firstName   = firstName;  } //приваивание данных к полям
    private void setLastName(String lastName)                   { this.lastName    = lastName;   }
    private void setDateOfBirth(GregorianCalendar dateOfBirth)  { this.dateOfBirth = dateOfBirth;}

    Person getPerson()                  { return this;       }
    String getFirstName()               { return firstName;  }
    String getLastName()                { return lastName;   }
    GregorianCalendar getDateOfBirth()  { return dateOfBirth;}

    @Override
    public Object DeepCopy() throws IOException {
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setDateOfBirth(this.dateOfBirth);
        return person;
    }
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
       int
       result = firstName != null ? firstName.hashCode() : 0;
       result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
       result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
       return result;
    }
    public String toShortString() {
        return firstName + " " + lastName;
    }
    String toListString() {
        return firstName + " " + lastName + "\t" + dateOfBirth.getTime();
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + "\t" + dateOfBirth.getTime();
    }
}