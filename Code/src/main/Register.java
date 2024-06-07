package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Register extends JFrame {
    private JLabel name;
    private JTextField nameInput;
    private JLabel birth;
    private JTextField birthInput;
    private JLabel idLabel;
    private JTextField idInput;
    private JLabel pwLabel;
    private JTextField pwInput;
    private JLabel answer;
    private JTextField answerInput;
    private JLabel questionLabel;
    private JComboBox<String> questions;
    private JButton registerBtn;
    
    public Register() {
        setTitle("Register Account");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        initComponents(panel);
        setLocationRelativeTo(null);
    }

    private void initComponents(JPanel panel) {

        panel.setLayout(null);
        name = new JLabel("이름:");
        name.setBounds(20, 20, 80, 25);
        panel.add(name);
        nameInput = new JTextField(20);
        nameInput.setBounds(150, 20, 165, 25);
        panel.add(nameInput);
        birth = new JLabel("생년월일(yy/mm/dd):");
        birth.setBounds(20, 50, 130, 25);
        panel.add(birth);
        birthInput = new JTextField(20);
        birthInput.setBounds(150, 50, 165, 25);
        panel.add(birthInput);
        idLabel = new JLabel("User ID:");
        idLabel.setBounds(20, 80, 80, 25);
        panel.add(idLabel);
        idInput = new JTextField(20);
        idInput.setBounds(150, 80, 165, 25);
        panel.add(idInput);
        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(20, 110, 80, 25);
        panel.add(pwLabel);
        pwInput = new JTextField(20);
        pwInput.setBounds(150, 110, 165, 25);
        panel.add(pwInput);
        questionLabel = new JLabel("계정 찾기 질문:");
        questionLabel.setBounds(20, 140, 130, 25);
        panel.add(questionLabel);
        questions = new JComboBox<String>(new String[]{"나의 고향은?", "나의 이름은?", "나의 첫 차는?", "나의 초등학교는?"});
        questions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        questions.setBounds(150, 140, 165, 25);
        panel.add(questions);
        answer = new JLabel("답변:");
        answer.setBounds(20, 170, 150, 25);
        panel.add(answer);
        answerInput = new JTextField(20);
        answerInput.setBounds(150, 170, 165, 25);
        panel.add(answerInput);
        registerBtn = new JButton("계정 생성");
        registerBtn.setBounds(120, 200, 150, 25);
        panel.add(registerBtn);
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    if(nameInput.getText().equals("") || birthInput.getText().equals("") || idInput.getText().equals("") || pwInput.getText().equals("") || answerInput.getText().equals("") ) {
                        JOptionPane.showMessageDialog(Register.this , "빈 칸을 채워주세요");
                    }
                    else {
                        String name = nameInput.getText();
                        String birth = birthInput.getText();
                        String userID = idInput.getText();
                        String password = pwInput.getText();
                        String answer = answerInput.getText();
                        String num = "";
                        switch(questions.getSelectedIndex()) {
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
