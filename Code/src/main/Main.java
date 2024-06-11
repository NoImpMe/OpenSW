package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;


public class Main extends javax.swing.JFrame {
    private JPanel jPanel;
    private JButton[] buttons;
    private JLabel[] labels;
    private JButton otpbuttons;
    private JLabel mainTitle;
    private JButton randomPWbuttons;
    private Checkbox showCheck;
    private Checkbox deleteCheck;
    private class ButtonActionListener implements ActionListener {
        private final int index;

        public ButtonActionListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (otpbuttons.getText().equals("OTP 인증완료")) {
                if (!showCheck.getState()) {
                    if (buttons[index].getText().equals("+")) {
                        AddData addData = new AddData(buttons[index], labels[index]);
                        addData.setVisible(true);
                        buttons[index].setFont(new java.awt.Font("맑은 고딕", 1, 14));
                    }
                    else {
                        BufferedReader reader = null;
                        BufferedWriter writer = null;
                        String[] parts = null;
                        String line;
                        ArrayList<String> lines = new ArrayList<>();
                        ArrayList<String> header = new ArrayList<>();
                        try {
                            reader = new BufferedReader(new FileReader("Code/src/main/Data.txt"));
                            if(deleteCheck.getState()){
                                while((line = reader.readLine()) != null){
                                    parts = line.split(",");
                                    header.add(line.substring(0,parts[0].length()));
                                    lines.add(line);
                                }
                                reader.close();
                                int delete = JOptionPane.showConfirmDialog(null, "데이터를 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                                if(delete == JOptionPane.YES_OPTION){
                                    lines.remove(header.indexOf(buttons[index].getText()));
                                    writer = new BufferedWriter(new FileWriter("Code/src/main/Data.txt"));
                                    for(String l : lines){
                                        writer.write(l);
                                        writer.newLine();
                                    }
                                    writer.close();
                                }
                                buttons[index].setText("+");
                                labels[index].setText("null");
                                buttons[index].setFont(new java.awt.Font("맑은 고딕", 1, 28));
                            }
                            else if(!buttons[index].getText().equals("+")){
                                while((line = reader.readLine()) != null){
                                    parts = line.split(",");
                                    header.add(line.substring(0,parts[0].length()));
                                    lines.add(line);
                                }
                                reader.close();
                                if(!header.contains(buttons[index].getText())){
                                    SaveAccount saveAccount = new SaveAccount(labels[index]);
                                    saveAccount.setVisible(true);
                                }

                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }


                    }

                }
                else {
                    try {
                        ShowData showData = new ShowData(labels[index]);
                        showData.setVisible(true);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(Main.this, "OTP 인증을 마쳐주세요", "인증 오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public Main() throws Exception {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws Exception {
        jPanel = new JPanel();
        buttons = new JButton[15];
        labels = new JLabel[15];
        File dataFile = new File("Code/src/main/Data.txt");
        if(!dataFile.exists()){
            dataFile.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/Data.txt"));
        String line;
        for (int i = 0; i < 15; i++) {
            if((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                buttons[i] = new JButton(parts[0]);
                buttons[i].setFont(new java.awt.Font("맑은 고딕", 1, 14));
                buttons[i].addActionListener(new ButtonActionListener(i));
                labels[i] = new JLabel(parts[0], SwingConstants.CENTER);
                labels[i].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i].setVerticalAlignment(SwingConstants.CENTER);
            }
            else{
                buttons[i] = new JButton("+");
                buttons[i].setFont(new java.awt.Font("맑은 고딕", 1, 28));
                buttons[i].addActionListener(new ButtonActionListener(i));
                labels[i] = new JLabel("null", SwingConstants.CENTER);
                labels[i].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i].setVerticalAlignment(SwingConstants.CENTER);
            }
        }
        otpbuttons = new JButton();
        mainTitle = new JLabel();
        randomPWbuttons = new JButton();
        showCheck = new Checkbox("Show Data (체크시 데이터 확인)");
        deleteCheck = new Checkbox("Delete Data (체크시 데이터 삭제)");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        otpbuttons.setText("OTP 인증하기");

        mainTitle.setFont(new java.awt.Font("맑은 고딕", 1, 24));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setText("Safe Local Lock");

        randomPWbuttons.setText("Random PW 생성");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(buttons[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttons[5], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[5], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttons[10], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[10], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(40, 40, 40)
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(buttons[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttons[6], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[6], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttons[11],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labels[11], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(40, 40, 40)
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(buttons[2],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[7],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[12],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[2], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[7], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[12], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(40, 40, 40)
                                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(buttons[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[8], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[13], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[8], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[13], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(40, 40, 40)
                                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(buttons[4],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[9],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(buttons[14],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[4], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[9], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(labels[14], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                        .addGap(289,289,289)
                                                        .addComponent(deleteCheck))
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(randomPWbuttons)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(otpbuttons)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(showCheck)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[0], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labels[0], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[1], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[2], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[3], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[4], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[9], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labels[5], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[6], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[7], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[8], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[9], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[10], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[11], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[12], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[13], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[14], GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labels[10], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[11], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[12], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[13], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labels[14], GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                .addGap(23,23,23)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteCheck))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(randomPWbuttons)
                                        .addComponent(otpbuttons)
                                        .addComponent(showCheck))
                                .addContainerGap())
        );


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        deleteCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(deleteCheck.isEnabled()){
                    showCheck.setState(false);
                }
            }
        });
        showCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(showCheck.isEnabled()){
                    deleteCheck.setState(false);
                }
            }
        });

        randomPWbuttons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomPWbuttonsActionPerformed(e);
            }
        });
        otpbuttons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otpbuttonsActionPerformed(e);
            }
        });
    }
    private void otpbuttonsActionPerformed(ActionEvent evt) {
        OTP otp = new OTP(this);
        otp.setVisible(true);
    }
    private void randomPWbuttonsActionPerformed(ActionEvent evt) {
        GeneratePassword generatePassword = new GeneratePassword();
        generatePassword.setVisible(true);
    }
    public void updateOTPButton() {
        otpbuttons.setText("OTP 인증완료");
        otpbuttons.setEnabled(false);
    }



}
