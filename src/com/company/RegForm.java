package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RegForm extends JFrame {
    private JTextField loginField;
    private JPasswordField pswrdField1;
    private JPasswordField pswrdField2;
    private JButton regButton;
    private JPanel rootPanel;

    public RegForm() {
        setLocation(600,300);
        setContentPane(rootPanel);
        pack();
        setVisible(true);

        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pswrdField1.getText().equals(pswrdField2.getText())){
                    if (Main.isUserExist(
                            loginField.getText(),
                            pswrdField1.getText())){
                        JOptionPane.showMessageDialog(null, "пользователь существует");
                    }
                    else {
                        Main.addNewUser(loginField.getText(),pswrdField1.getText());
                        JOptionPane.showMessageDialog(null, "пользователь добавлен");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "пароли разные");
                }
            }
        });
    }

}
