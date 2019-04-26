package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.text.MessageFormat.format;

class Person  implements  IDateAndCopy {

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
    String getFirstName()    { return firstName;  } //вывод полей
    String getLastName()     { return lastName;   }
    GregorianCalendar getDateOfBirth()  { return dateOfBirth;}

    void setFirstName(String firstName)        { this.firstName   = firstName;} //присваивание данных к полям
    void setLastName(String lastName)          { this.lastName    = lastName;}
    void setDateOfBirth(GregorianCalendar dateOfBirth)  { this.dateOfBirth = dateOfBirth;}

    String getYearofBirth(){ return String.valueOf(dateOfBirth.get(Calendar.YEAR));}

    public String toString() {
        return format("{0} {1}\t{2}", firstName, lastName, dateOfBirth.getTime());
    }  //вывод строки с перегрузкой

    public String toShortString() {
        return format("{0} {1}", firstName, lastName);
    } //вывод строки  без перегрузки

    public int compareTo( Person n) { //сравнение объектов
        int lastCmp = firstName.compareTo(n.firstName);
        return (lastCmp != 0 ? lastCmp : dateOfBirth.compareTo(n.dateOfBirth));
    }
    @Override
    public Object DeepCopy()  {
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setDateOfBirth(this.dateOfBirth);
        return person;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return (firstName != null ? firstName.equals(person.firstName) : person.firstName == null)
                && (lastName != null ? !lastName.equals(person.lastName) : person.lastName == null)
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