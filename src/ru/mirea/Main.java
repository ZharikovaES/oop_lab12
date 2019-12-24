package ru.mirea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static boolean isStr(String s) {
        return s.equals("abcdefghijklmnopqrstuv18340");
    }

    public static ArrayList<String> findAllPrices(String s) {
        Pattern p = Pattern.compile("\\d+(\\.?\\d+)?\\s?(USD|EUR|RUB)");
        Matcher m = p.matcher(s);
        ArrayList<String> arr = new ArrayList<>();
        while(m.find()) { arr.add(m.group()); }
        return arr;
    }

    public static boolean hasDigitalPlus(String s) {return Pattern.compile("\\d\\s*\\+").matcher(s).find();}

    public static boolean isDate(String s) {
        String dm = "((((\\D0?[1-9])|(1[0-9])|(2[0-8]))[/\\-](0?2))|(((\\D0?[1-9])|([12][0-9])|30)[/\\-]((0?[469])|11))|(((\\D0?[1-9])|([12][0-9])|(3[01]))[/\\-]((0?[13578])|(1[02]))))";
        return Pattern.compile("(29[/\\-]0?2[/\\-]((19|([2-9][0-9])(([13579][26])|([2468][048])))|((([2468][048])|([3579][26]))00)))|(" + dm + "[/\\-](19|([2-9][0-9]))(\\d{2}))").matcher(s).find();
    }

    public static boolean isEmail(String email) {
        Matcher m = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9!#$%&'*+\\-/=?^_`{|}~.]*@[a-zA-Z0-9\\-_.]+\\.[a-zA-Z]+").matcher(email);
        return m.find() && m.group().equals(email);
    }

    public static boolean checkPassword (String password) {
        Matcher m = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z_]{8,}").matcher(password);
        return m.find() && m.group().equals(password);
    }

    public static void main(String[] args) {
        //задание 1
//        System.out.println("Введите строку:");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println("Введите разделитель:");
//        String p = sc.nextLine();
//        System.out.println(Arrays.toString(str.split(p)));

        //задание 2
        System.out.println(isStr("abcdefghijklmnoasdfasdpqrstuv18340"));
        System.out.println(isStr("abcdefghijklmnopqrstuv18340"));

        //задание 3
        System.out.println(findAllPrices("25.98 USD, 250.9RUB, 44 ERR, 0.004 EU"));

        //задание 4
        System.out.println(hasDigitalPlus("6 / 5 – 2 * 9"));
        System.out.println(hasDigitalPlus("1 + 3 -5"));
        System.out.println(hasDigitalPlus("1 / 3+5") + "\n");

        //задание 5
        System.out.println(isDate("12/12/2001"));
        System.out.println(isDate("29/02/2000"));
        System.out.println(isDate("29/02/2001"));
        System.out.println(isDate("29/02/6400"));
        System.out.println(isDate("29/02/6200"));
        System.out.println(isDate("1/1/1923"));
        System.out.println(isDate("01/01/1345"));
        System.out.println(isDate("31/04/2003"));
        System.out.println(isDate("30-04-2003") + "\n");

        //задание 6
        System.out.println(isEmail("z.kate2000@gmail.com"));
        System.out.println(isEmail("A$$@yandex.ru"));
        System.out.println(isEmail("@my.ru"));
        System.out.println(isEmail("z.kate2000@g@mail.ru") + "\n");

        //задание 7
        System.out.println(checkPassword("123456789G"));
        System.out.println(checkPassword("a__789G"));
        System.out.println(checkPassword("_Googpass1"));
    }
}
