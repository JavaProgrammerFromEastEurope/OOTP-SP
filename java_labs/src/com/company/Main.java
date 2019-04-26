package com.company;

import static com.company.Student.Education.*;

public class Main {
    public static void main(String[] args) {

        Student.Education education = Bachelor;
        String  firstName,
                lastName,
                subjectName;

        int     groupNumber,
                bYear,
                bMonth,
                bDayOfMonth,
                year,
                month,
                score,
                dayOfMonth,
                arrayI,
                marc;

        Scanner lr  = new Scanner(System.in);

        int nRow, nColumn, tRow, tColumn, nCount, aCount = 0;

        System.out.print("\n\t Введите данные студента:" +
                             "\n\t Имя: ");  firstName  = lr.next();
        System.out.print("\t Фамилия: ");    lastName   = lr.next();
        System.out.print("\t Дата рождения: \n\t День: "); bDayOfMonth = Integer.parseInt(lr.next());
        System.out.print("\t Месяц: ");      bMonth = Integer.parseInt(lr.next());
        System.out.print("\t Год: ");        bYear  = Integer.parseInt(lr.next());

        System.out.print("\t Образование: Введите '0' - 'SecondEducation', '1' - 'Specialist', '2' - 'Bachelor' ");
        marc = Integer.parseInt(lr.next());
        if(marc == 0){education = SecondEducation;          System.out.print("\t Присвоено значение - 'SecondEducation'\n");}
            else if (marc == 1) {education = Specialist;    System.out.print("\t Присвоено значение - 'Specialist'\n");}
                else if (marc == 2) {education = Bachelor;  System.out.print("\t Присвоено значение - 'Bachelor'\n");}
                    else  System.out.println("Try Again");
        System.out.print("\t Группа: ");            groupNumber  = Integer.parseInt(lr.next());
        System.out.print("\t Кол-во экзаменов: ");  arrayI  = Integer.parseInt(lr.next());

        Exam[] exam = new Exam[arrayI];
        for(int i = 0;i < arrayI; i++) {
            System.out.println("\n\t Экзамен: " + (i+1));
            System.out.print("\t Название предмета: ");    subjectName = lr.next();
            System.out.print("\t Балл: ");           score = Integer.parseInt(lr.next());
            System.out.print("\t День: ");      dayOfMonth = Integer.parseInt(lr.next());
            System.out.print("\t Месяц: ");          month = Integer.parseInt(lr.next());
            System.out.print("\t Год: ");            year  = Integer.parseInt(lr.next());

            exam[i]=new Exam(subjectName, score, new GregorianCalendar(year,month,dayOfMonth));
        }
        Student student = new Student();
        //Step 5
        System.out.println(student.toShortString());
        //Step 6
        System.out.println(student.getPersonEducationIndex(SecondEducation));
        System.out.println(student.getPersonEducationIndex(Bachelor));
        System.out.println(student.getPersonEducationIndex(Specialist));
        //Step 7
        student = new Student(
                new Person(firstName, lastName, new GregorianCalendar( bYear, bMonth, bDayOfMonth)),education, groupNumber);
        System.out.println(student.toString());
        //Step 8
        student.AddExams(exam);
        System.out.println(student.toString());
        System.out.println(student.toShortString());
        //Step 9
        System.out.println();
        System.out.print("Введите количество строк и столбцов массива: символы-разделителели '_,:-'  ");     //3,5
        String string = lr.next();
        String[] parts = string.split("[_,:-]");
        nRow    = Integer.parseInt(parts[0]);
        nColumn = Integer.parseInt(parts[1]);

        nCount  = nRow * nColumn;

        int tCount = 0, tLength = 0, tSum = 1;

        while(tLength < nCount){
            tLength += tSum++;
            tCount++;
        }
        tRow    = tCount;
        tColumn = tCount;
        //System.out.println("tLength = "+ tLength + "tCount = " + tCount);

        Exam[]   firstArray   = new Exam[nRow*nColumn];
        Exam[][] secondArray  = new Exam[nRow][nColumn];
        Exam[][] thirdArray   = new Exam[tCount][tCount];

        double  CurrentTime,
                CurrentTimeSecond,
                CurrentTimeThird,
                TotalTime,
                TotalTimeSecond,
                TotalTimeThird;

        CurrentTime = System.currentTimeMillis();

        System.out.println();
        System.out.println("First Array:");
        for (int i = 0; i < nCount; i++) {
                firstArray[i] = exam[aCount++];
                if (aCount == arrayI){aCount = 0;}
                System.out.print("  " + firstArray[i]);
        }

        TotalTime = (System.currentTimeMillis()-CurrentTime);
        System.out.print("\nВремя выполнения 1 массива мил: " + TotalTime);

        CurrentTimeSecond = System.currentTimeMillis();
        System.out.println();
        System.out.println("Second Array:");
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                    secondArray[i][j] = exam[aCount++];
                    if (aCount == arrayI){aCount = 0;}
                    System.out.print("  " + secondArray[i][j]);
            }
            System.out.println();
        }

        TotalTimeSecond = (System.currentTimeMillis()-CurrentTimeSecond);
        System.out.print("Время выполнения 2 массива мил: "  + TotalTimeSecond);

        CurrentTimeThird = System.currentTimeMillis();
        int fCounter = nCount;
        System.out.println();
        System.out.println("Third Array:");
        for (int i = 0; i < tRow; i++) {
            for (int j = 0; j < tColumn; j++) {
                    if (fCounter == 0) break;
                    thirdArray[i][j]  = exam[aCount++];
                    if (aCount == arrayI){aCount = 0;}
                    System.out.print("  " + thirdArray[i][j]);
                    fCounter--;
            }
            System.out.println();
            tColumn--;
        }
        TotalTimeThird = (System.currentTimeMillis() - CurrentTimeThird);
        System.out.print("Время выполнения 3 массива мил: "  + TotalTimeThird);
    }
}