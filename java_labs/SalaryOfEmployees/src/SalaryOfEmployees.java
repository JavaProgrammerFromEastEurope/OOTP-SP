import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SalaryOfEmployees {
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	   Scanner sc = new Scanner(System.in);
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Введите количество сотрудников:");
           int countSotr = Integer.parseInt(reader.readLine());
           Sotr[] sotr = new Sotr[countSotr];
           for (int i = 0; i < sotr.length; i++) {
               sotr[i] = new Sotr();
               System.out.println("Введите ФИО сотрудника:");
               sotr[i].fio = reader.readLine();
               System.out.println("Введите табельнй номер:");
               sotr[i].tabNumber = reader.readLine();
               System.out.println("Введите количество проработанных часов:");
               sotr[i].countHours = Integer.parseInt(reader.readLine());
               System.out.println("Введите почасовую ставку: ");
               sotr[i].rate = Integer.parseInt(reader.readLine());
           }
           for (int i = 0; i < sotr.length; i++) {
               System.out.println(sotr[i].fio + "\t" +sotr[i].tabNumber+"\t"+ (sotr[i].countHours * sotr[i].rate));
           }
       
           reader.close();
    }
    private static class Sotr{
        String fio, tabNumber;
        int countHours, rate;
    }
    
}
