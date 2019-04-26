package com.company;

import static java.text.MessageFormat.format;

class Person implements Comparable<Person> {
    private String   firstName;
    private String   lastName;
    private Calendar dateOfBirth;
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
    String getDateOfBirth()  { return String.valueOf(dateOfBirth.getTime());}

    void setFirstName(String firstName)        { this.firstName   = firstName;} //приваивание данных к полям
    void setLastName(String lastName)          { this.lastName    = lastName;}
    void setDateOfBirth(Calendar dateOfBirth)  { this.dateOfBirth = dateOfBirth;}

    String getYearofBirth(){ return String.valueOf(dateOfBirth.get(Calendar.YEAR));}

    public boolean equals(Object o) {  //сравнение  полей объектов
        if (!(o instanceof Person))
            return false;
        Person n = (Person) o;
        return n.firstName.equals(firstName)
                && n.lastName.equals(lastName) && n.dateOfBirth.equals(dateOfBirth);
    }
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
}