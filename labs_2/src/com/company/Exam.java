package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.text.MessageFormat.format;

class Exam  { //Comparable<Person>
    private String subjectName;  //поля
    private int Score;
    private Calendar examDate;
    private Exam() {   //конструктор без параметров
        this.subjectName = "not indicated!";
        this.Score = 0;
        this.examDate    = new GregorianCalendar();
    }
    Exam(String subjectName, int Score, GregorianCalendar examDate) {  //конструктор с параметрами
        if (subjectName == null || examDate == null)
            throw new NullPointerException();
        this.subjectName   = subjectName;
        this.Score         = Score;
        this.examDate      = examDate;
        this.examDate.add(Calendar.MONTH, -1);
    }

    private void setSubjectName(String subjectName) { this.subjectName   = subjectName;} //приваивание данных к полям
    private void setScore(int Score)                { this.Score    = Score;}
    private void setExamDate(Calendar examDate)     { this.examDate = examDate;}

    int getScore()                  { return Score;} //вовод полей
    public String getSubjectName()  { return subjectName;}
    public Calendar getExamDate()   { return examDate;}

    @Override
    public int hashCode() {
        int result = subjectName != null ? subjectName.hashCode() : 0;
        result = 31 * result + Score;
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam))
            return false;
        Exam person = (Exam) o;
        return (subjectName != null ? subjectName.equals(person.subjectName) : person.subjectName == null)
                    && (Score != 0 ? Score == person.Score : person.Score == 0)
                        && (examDate != null ? examDate.equals(person.examDate) : person.examDate == null);
    }
    public String toString() { //вывод строки с перегрузкой
        return format("{0} {1} {2}", subjectName, Score, examDate.getTime());
    }

    public int compareTo(Exam n) { //сравнение объектов
        int lastCmp = subjectName.compareTo(n.subjectName);
        return (lastCmp != 0 ? lastCmp : examDate.compareTo(n.examDate));
    }
}