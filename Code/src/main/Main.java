package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends javax.swing.JFrame {

    public Main() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btn10 = new JButton();
        btn11 = new JButton();
        btn12 = new JButton();
        btn13 = new JButton();
        btn14 = new JButton();
        btn15 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        otpButton = new JButton();
        mainTitle = new JLabel();
        randomPWButton = new JButton();
        checkbox1 = new Checkbox("Show Data (체크시 데이터 확인)");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        btn1.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn1.setText("+");

        btn2.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn2.setText("+");

        btn3.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn3.setText("+");

        btn4.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn4.setText("+");

        btn5.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn5.setText("+");

        btn6.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn6.setText("+");

        btn7.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn7.setText("+");

        btn8.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn8.setText("+");

        btn9.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn9.setText("+");

        btn10.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn10.setText("+");

        btn11.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn11.setText("+");

        btn12.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn12.setText("+");

        btn13.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn13.setText("+");

        btn14.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn14.setText("+");

        btn15.setFont(new java.awt.Font("맑은 고딕", 1, 12));
        btn15.setText("+");

        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setText("null");

        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setText("null");

        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setText("null");

        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setText("null");

        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setText("null");

        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setText("null");

        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setText("null");

        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setText("null");

        label9.setHorizontalAlignment(SwingConstants.CENTER);
        label9.setText("null");

        label10.setHorizontalAlignment(SwingConstants.CENTER);
        label10.setText("null");

        label11.setHorizontalAlignment(SwingConstants.CENTER);
        label11.setText("null");

        label12.setHorizontalAlignment(SwingConstants.CENTER);
        label12.setText("null");

        label13.setHorizontalAlignment(SwingConstants.CENTER);
        label13.setText("null");

        label14.setHorizontalAlignment(SwingConstants.CENTER);
        label14.setText("null");

        label15.setHorizontalAlignment(SwingConstants.CENTER);
        label15.setText("null");

        otpButton.setText("OTP 인증하기");

        mainTitle.setFont(new java.awt.Font("맑은 고딕", 1, 24));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setText("Safe Local Lock");

        randomPWButton.setText("Random PW 생성");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(30,30,30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btn1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btn11, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(40, 40, 40)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btn2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btn7)
                                                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btn12)
                                                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(40, 40, 40)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(btn3)
                                                                                        .addComponent(btn8)
                                                                                        .addComponent(btn13)
                                                                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(40, 40, 40)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(btn4)
                                                                                        .addComponent(btn9)
                                                                                        .addComponent(btn14)
                                                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(40, 40, 40)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(btn5)
                                                                                        .addComponent(btn10)
                                                                                        .addComponent(btn15)
                                                                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(randomPWButton)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(otpButton)
                                                                .addGap(50,50,50)
                                                                .addComponent(checkbox1)))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn10, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn11, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn12, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn13, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn14, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn15, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(randomPWButton)
                                        .addComponent(otpButton)
                                        .addComponent(checkbox1))
                                .addContainerGap())
        );


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label1.getText().equals("null")){
                            AddData addData = new AddData(btn1,label1);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label1);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label1);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label2.getText().equals("null")){
                            AddData addData = new AddData(btn2,label2);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label2);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label2);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label3.getText().equals("null")){
                            AddData addData = new AddData(btn3,label3);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label3);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label3);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label4.getText().equals("null")){
                            AddData addData = new AddData(btn4,label4);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label4);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label4);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label5.getText().equals("null")){
                            AddData addData = new AddData(btn5,label5);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label5);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label5);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label6.getText().equals("null")){
                            AddData addData = new AddData(btn6,label6);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label6);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label6);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label7.getText().equals("null")){
                            AddData addData = new AddData(btn7,label7);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label7);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label7);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label8.getText().equals("null")){
                            AddData addData = new AddData(btn8,label8);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label8);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label8);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label9.getText().equals("null")){
                            AddData addData = new AddData(btn9,label9);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label9);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label9);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label10.getText().equals("null")){
                            AddData addData = new AddData(btn10,label10);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label10);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label10);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label11.getText().equals("null")){
                            AddData addData = new AddData(btn11,label11);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label11);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label11);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label12.getText().equals("null")){
                            AddData addData = new AddData(btn12,label12);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label12);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label12);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label13.getText().equals("null")){
                            AddData addData = new AddData(btn13,label13);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label13);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label13);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label14.getText().equals("null")){
                            AddData addData = new AddData(btn14,label14);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label14);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label14);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(otpButton.getText().equals("OTP 인증완료")){
                    if(!checkbox1.getState()){
                        if(label15.getText().equals("null")){
                            AddData addData = new AddData(btn15,label15);
                            addData.setVisible(true);
                        }
                        else{
                            SaveAccount saveAccount = new SaveAccount(label15);
                            saveAccount.setVisible(true);
                        }
                    }
                    else{
                        try {
                            ShowData showData = new ShowData(label15);
                            showData.setVisible(true);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog( Main.this , "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        randomPWButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomPWButtonActionPerformed(e);
            }
        });
        otpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otpButtonActionPerformed(e);
            }
        });
    }
    private void otpButtonActionPerformed(ActionEvent evt) {
        OTP otp = new OTP(this);
        otp.setVisible(true);
    }
    private void randomPWButtonActionPerformed(ActionEvent evt) {
        GeneratePassword generatePassword = new GeneratePassword();
        generatePassword.setVisible(true);
    }
    public void updateOTPButton() {
        otpButton.setText("OTP 인증완료");
        otpButton.setEnabled(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private JPanel jPanel1;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JButton otpButton;
    private JLabel mainTitle;
    private JButton randomPWButton;
    private Checkbox checkbox1;
}
