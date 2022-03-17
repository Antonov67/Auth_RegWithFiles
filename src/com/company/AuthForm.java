package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AuthForm extends JFrame {
    private JPanel rootPanel;
    private JTextField loginField;
    private JPasswordField pswrdField;
    private JButton authButton;
    private JButton regButton;

    //конструктор нашей формы авторизации
    public AuthForm() {

        setLocation(300,300);
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        authButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isUserExist(loginField.getText(),pswrdField.getText(),Main.path)){
                    JOptionPane.showMessageDialog(null,"Успешный вход");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Ошибка при входе");
                }
            }
        });
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegForm();
            }
        });
    }
    //метод проверки существования данных пользователя в файле
    public static boolean isUserExist(String login, String pswrd, Path path) {

        //создаем и читаем все строки из файла
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.contains(login + " " + pswrd))
            return true;
        else
            return false;
    }
}
