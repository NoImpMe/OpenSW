package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Register extends JFrame {
    public Register() {
        setTitle("Register Account");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        setLocationRelativeTo(null);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("이름:");
        userLabel.setBounds(20, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 20, 165, 25);
        panel.add(userText);

        JLabel nameLabel = new JLabel("생년월일(yy/mm/dd):");
        nameLabel.setBounds(20, 50, 130, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(150, 50, 165, 25);
        panel.add(nameText);

        JLabel dobLabel = new JLabel("User ID:");
        dobLabel.setBounds(20, 80, 80, 25);
        panel.add(dobLabel);

        JTextField dobText = new JTextField(20);
        dobText.setBounds(150, 80, 165, 25);
        panel.add(dobText);

        JLabel phoneLabel = new JLabel("Password:");
        phoneLabel.setBounds(20, 110, 80, 25);
        panel.add(phoneLabel);

        JTextField phoneText = new JTextField(20);
        phoneText.setBounds(150, 110, 165, 25);
        panel.add(phoneText);

        JLabel passwordLabel = new JLabel("계정 찾기 질문:");
        passwordLabel.setBounds(20, 140, 130, 25);
        panel.add(passwordLabel);

        JComboBox<String> passwordText = new JComboBox<String>(new String[]{"나의 고향은?", "나의 이름은?", "나의 첫 차는?", "나의 초등학교는?"});
        passwordText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        passwordText.setBounds(150, 140, 165, 25);
        panel.add(passwordText);

        JLabel securityQuestionLabel = new JLabel("답변:");
        securityQuestionLabel.setBounds(20, 170, 150, 25);
        panel.add(securityQuestionLabel);

        JTextField securityQuestionText = new JTextField(20);
        securityQuestionText.setBounds(150, 170, 165, 25);
        panel.add(securityQuestionText);

        JButton registerButton = new JButton("계정 생성");
        registerButton.setBounds(120, 200, 150, 25);
        panel.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    if(userText.getText().equals("") || nameText.getText().equals("") || dobText.getText().equals("") || phoneText.getText().equals("") || securityQuestionText.getText().equals("") ) {
                        JOptionPane.showMessageDialog(Register.this , "빈 칸을 채워주세요");
                    }
                    else {
                        String name = userText.getText();
                        String birth = nameText.getText();
                        String userID = dobText.getText();
                        String password = phoneText.getText();
                        String answer = securityQuestionText.getText();
                        String num = "";
                        switch(passwordText.getSelectedIndex()) {
                            case 0: num = "0"; break;
                            case 1: num = "1"; break;
                            case 2: num = "2"; break;
                            case 3: num = "3";
                        }
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("Code/src/main/account.txt",true));
                            writer.write(name+","+birth+","+userID+","+password+","+num+","+answer);
                            writer.newLine();
                            writer.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(Register.this , "계정 생성 완료");
                        Register.this.setVisible(false);
                    }
                }
        });
    }

}
