package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindPasswd extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel1;
    private JTextField jTextField1;
    private JLabel jLabel2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel3;
    private JTextField jTextField2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JButton jButton1;

    public FindPasswd() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("ID");
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

        jTextField1.setText("");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("질문");
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"나의 고향은?", "나의 이름은?", "나의 첫 차는?", "나의 초등학교는?"}));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("답변");
        jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);

        jTextField2.setText("");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jLabel4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("검색된 PW");
        jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabel5.setText("");

        jButton1.setText("PW 검색");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jTextField1.getText().trim();
                String num = jComboBox1.getSelectedIndex()+"";
                String answer = jTextField2.getText().trim();
                String foundPassword = null;
                try {
                    foundPassword = searchAccount(id, num,answer);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                jLabel5.setText(foundPassword);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jButton1)))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        pack();
    }

    private void jComboBox1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
    private String searchAccount(String id, String question, String answer) throws FileNotFoundException {
        String foundPasswd = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/account.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equals(jTextField1.getText()) && parts[4].equals(question) && parts[5].equals(jTextField2.getText())) {
                    foundPasswd = parts[3];
                } else {
                    JOptionPane.showMessageDialog(FindPasswd.this, "입력한 정보에 맞는 Password가 없습니다.");
                }
            }
            reader.close();
            return foundPasswd;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindPasswd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new FindPasswd().setVisible(true));
    }
}
