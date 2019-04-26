package com.company;

import static java.text.MessageFormat.format;

class Exam implements Comparable<Exam> {
    private String subjectName;  //поля
    private int Score;
    private Calendar examDate;
    Exam() {   //конструктор без параметров
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
    int getScore()                  { return Score;} //вовод полей
    public String getSubjectName()  { return subjectName;}
    public Calendar getExamDate()   { return examDate;}

    public boolean equals(Object o) { //сравнение  полей объектов
        if (!(o instanceof Exam))
            return false;
        Exam n = (Exam) o;
        return n.subjectName.equals(subjectName)
                && n.Score == Score && n.examDate.equals(examDate);
    }
    public String toString() { //вывод строки с перегрузкой
        return format("{0} {1} {2}", subjectName, Score, examDate.getTime());
    }

    public int compareTo(Exam n) { //сравнение объектов
        int lastCmp = subjectName.compareTo(n.subjectName);
        return (lastCmp != 0 ? lastCmp : examDate.compareTo(n.examDate));
    }
}