/*
*Получить исходную json строку из файла, используя FileReader или Scanner

Дана json строка вида:
String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
"{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
"{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.
 */

package Sem_Java_Test.Sem2_HW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UTFDataFormatException;

public class main {

    public static void main(String[] args) {
        String filePath = ("D:\\!!!GeekBrains\\HW\\!!!Specialization\\Lections\\Python\\L2\\Sem_Java_Test\\Sem2_HW\\input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String record;
       
            while ((record = br.readLine()) != null) {
                  
                String[] parts = record.split(",");
                String surname = parts[0].split(":")[1].replace("\"","");
                String mark = parts[1].split(":")[1].replace("\"", "");
                String subject = parts[2].split(":")[1].replace("\"", "");

                StringBuilder sb = new StringBuilder();
                sb.append("Студент ").append(surname).append(" получил ")
                        .append(mark).append(" по предмету ").append(subject).append(".");
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}