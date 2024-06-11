package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAccount extends JFrame {
    private JLabel jLabel;
    private JButton addBtn;
    private JButton cancelBtn;
    private JLabel data;
    private JLabel explain;
    private JLabel idText;
    private JLabel pwText;
    private JTextField idInput;
    private JTextField pwInput;

    public SaveAccount(JLabel jLabel) {
        setLocationRelativeTo(null);
        this.jLabel = jLabel;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        data = new JLabel();
        explain = new JLabel();
        idText = new JLabel();
        pwText = new JLabel();
        addBtn = new JButton();
        cancelBtn = new JButton();
        idInput = new JTextField();
        pwInput = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        data.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        data.setHorizontalAlignment(SwingConstants.CENTER);
        data.setText(jLabel.getText());
        explain.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        explain.setHorizontalAlignment(SwingConstants.CENTER);
        explain.setText("에 추가할 계정 정보를 입력헤주세요.");

        idText.setText("ID");

        pwText.setText("Password");

        addBtn.setText("추가");

        cancelBtn.setText("취소");

        idInput.setText("");

        pwInput.setText("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(pwText)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pwInput, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(data, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(21, 21, 21)
                                                                                .addComponent(idText)))
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(explain, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(14, 14, 14)
                                                                                .addComponent(idInput, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(addBtn)
                                                .addGap(80, 80, 80)
                                                .addComponent(cancelBtn)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(explain)
                                        .addComponent(data, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(idInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idText))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pwText)
                                        .addComponent(pwInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addBtn)
                                        .addComponent(cancelBtn))
                                .addContainerGap())
        );

        pack();
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(idInput.getText().equals("") || pwInput.getText().equals("")) {
                        JOptionPane.showMessageDialog(SaveAccount.this, "ID와 Password를 입력해주세요!");
                    }
                    else{
                        try {
                            saveAccountData();
                            dispose();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            }
        });
        cancelBtn.addActionListener(e -> dispose());


    }
    private void saveAccountData() throws Exception {
        String id = idInput.getText();
        String password = pwInput.getText();

        String encryptionKey = "1234567890123456"; // 16자리 키
        String encryptedId = AESUtil.encrypt(id, encryptionKey);
        String encryptedPassword = AESUtil.encrypt(password, encryptionKey);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Code/src/main/Data.txt", true));
            writer.write( jLabel.getText() +"," + encryptedId + "," + encryptedPassword);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
