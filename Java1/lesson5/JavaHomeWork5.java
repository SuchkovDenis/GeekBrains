/**
* Geekbrains Java1 Homework 5
* @author Suchkov Denis
* @version dated Feb 12, 2018
* @link https://github.com/suchkovdenis
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

class JavaHomeWork5 {
    public static Person[] persArray = new Person[5];
    public static Person[] persArrayFromFile = new Person[5];

    public static void main(String[] args) {
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89165152233", 60000, 46);
        persArray[1] = new Person("Petrov Vladislav", "Developer", "petrov12@mail.ru","89230012345", 130000, 52);
        persArray[2] = new Person("Dorin Denis", "FrontEnd Developer", "dorin@yandex.ru", "84952347703", 70000, 41);
        persArray[3] = new Person("Burenko Alexandra", "Manager", "burenko@gmail.com", "89772800011", 120000, 25);
        persArray[4] = new Person("Prokopuev Stas", "Trader", "sp1545@gmail.com", "89270232300", 300000, 23);

        // запись массива persArray в текстовый файл
        printToFile("persArray.txt",persArray);

        // считывание данных из текстового файла в массив
        readFromFile("persArray.txt",persArrayFromFile);
        
        /* Выведение информации о пользователях старше 40 лет в удобном виде.
         * Считывание происходит НЕ из первоначального массива, а из того, 
         * кторый был получен считыванием из файла (для демонстрации правильной работы метода). */
        System.out.println("Information about persons older than 40");
        for (Person person : persArrayFromFile)
            if (person.getAge()>=40) {
                person.showInfo();
                System.out.println("----------------------------");
            }

    }

    // Метод для записи массива Person в файл. Каждая запись - отдельная строка. Данные разделены "," 
    public static void printToFile(String fileName, Person[] p) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            for (Person person : p) {
                    out.println(person.getName()     + ',' +
                                person.getPosition() + ',' +
                                person.getEmail()    + ',' +
                                person.getPhone()    + ',' +
                                person.getPay()      + ',' +
                                person.getAge());
            }
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /* Метод для считывание данных в массив Person.
     * В случае, если данных в файле больше чем длина массива  
     * выводит предупреждение и прерывает считывание */
    public static void readFromFile(String fileName, Person[] p) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            int i = 0;
            while (sc.hasNextLine()) {
                String[] s = new String[6];
                s = sc.nextLine().split(Pattern.quote(","));
                p[i] = new Person(s[0],s[1],s[2],s[3],Integer.parseInt(s[4]),Integer.parseInt(s[5]));
                i++;
                if (i>p.length) {
                    System.out.println("The data doesn't completely downloaded. The length of array is not enough...");
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int    pay;
    private int    age;

    public Person() {
        setName("Unknown");
        setPosition("Unknown");
        setEmail("Unknown");
        setPhone("Unknown");
        setPay(0);
        setAge(0);
    }

    public Person(String name, String position, String email, String phone, int pay, int age) {
        setName(name);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setPay(pay);
        setAge(age);
    }      

    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPay(int pay) {
        this.pay = pay; 
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public int getPay() {
        return pay;
    }
    public int getAge() {
        return age;
    }

    public void showInfo() {
        System.out.println("Name     : " + getName());
        System.out.println("Position : " + getPosition()); 
        System.out.println("Email    : " + getEmail());
        System.out.println("Phone    : " + getPhone());
        System.out.println("Pay      : " + getPay());
        System.out.println("Age      : " + getAge());
    }

}