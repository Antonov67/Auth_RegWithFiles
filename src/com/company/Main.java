package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Path path;

    public static void main(String[] args) throws IOException {
        new AuthForm();

        //создадим файл с учетными данными
        path = Path.of("C://Auth_Reg_Demo_Pr/");
        if (!Files.exists(path)){
            Files.createDirectory(path);
        }
        path = Path.of("C://Auth_Reg_Demo_Pr/log_pswrd.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        //запишем учетные данные в наш файл
        List<String> list = new ArrayList();
        list.add("testUser qwerty");
        list.add("demoUser 123");
        Files.write(path,list, StandardOpenOption.APPEND);
    }

    //метод проверки существования данных пользователя в файле
    public static boolean isUserExist(String login, String pswrd) {

        //создаем и читаем все строки из файла
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Проверим существования логина в списке
        boolean bool = false;
        for (String stroka : list) {
            if (stroka.contains(login)){
               bool =  true;
            }
        }
        return bool;
    }

    //добавление пользователя в систему
    static void addNewUser(String login, String pswrd){
        try {
            Files.writeString(path, login + " " + pswrd + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
