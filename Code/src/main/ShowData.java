package main;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ShowData extends JFrame {

    public ShowData(JLabel data) throws Exception {
        setLocationRelativeTo(null);
        this.data = data;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws Exception {

        dataName = new JLabel();
        dataText = new JLabel();
        idText = new JLabel();
        pwText = new JLabel();
        idData = new JLabel();
        pwData = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        dataName.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        dataName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataName.setText(data.getText());

        dataText.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        dataText.setText("의 정보입니다.");

        idText.setText("ID");

        pwText.setText("Password");

        idData.setText("");

        pwData.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pwText)
                                                .addGap(18, 18, 18)
                                                .addComponent(pwData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dataName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(idText)
                                                                .addGap(12, 12, 12)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dataText))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(idData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dataName)
                                        .addComponent(dataText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idText)
                                        .addComponent(idData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pwText)
                                        .addComponent(pwData))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        loadAndDisplayData();
        pack();
    }

    public void loadAndDisplayData() throws Exception {
        String encryptionKey = "1234567890123456"; // 16자리 키
        BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/Data.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(data.getText())) {
                String encryptedId = parts[1];
                String encryptedPassword = parts[2];
                String decryptedId = AESUtil.decrypt(encryptedId, encryptionKey);
                String decryptedPassword = AESUtil.decrypt(encryptedPassword, encryptionKey);
                idData.setText(decryptedId);
                pwData.setText(decryptedPassword);
            }
        }
    }

    private JLabel data;
    private JLabel dataName;
    private JLabel dataText;
    private JLabel idText;
    private JLabel pwText;
    private JLabel idData;
    private JLabel pwData;
}
