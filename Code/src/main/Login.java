package main;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Login extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JFormattedTextField jFormattedTextField1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;

    public Login() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jFormattedTextField1 = new JFormattedTextField();
        jPasswordField1 = new JPasswordField();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jButton1.setText("Login");

        jFormattedTextField1.setText("ID");
        jFormattedTextField1.setFont(new java.awt.Font("맑은 고딕", 1, 18));

        jPasswordField1.setText("jPasswordField1");
        jButton2.setText("Register");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 36));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Safe Local Lock");

        jButton3.setText("ID 찾기");

        jButton4.setText("Password 찾기");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(187, 187, 187)
                                                .addComponent(jButton3)
                                                .addGap(93, 93, 93)
                                                .addComponent(jButton4))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jFormattedTextField1)
                                                                        .addComponent(jPasswordField1, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                                                .addGap(56, 56, 56)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFormattedTextField1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String id = jFormattedTextField1.getText();
                    String password = new String(jPasswordField1.getPassword());
                    BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/account.txt"));
                    String line;
                    boolean idFound = false;
                    boolean passwordMatched = false;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length >= 2 && parts[0].equals(id)) {
                            idFound = true;
                            if (parts[1].equals(password)) {
                                passwordMatched = true;
                                break;
                            }
                        }
                    }
                    reader.close();

                    if (!idFound) {
                        JOptionPane.showMessageDialog(Login.this, "ID가 없습니다.");
                    } else if (!passwordMatched) {
                        JOptionPane.showMessageDialog(Login.this, "비밀번호가 틀렸습니다.");
                    } else {
                        Main main = new Main();
                        main.setVisible(true);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Login.this, "파일을 읽어오는 중 오류가 발생했습니다.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        Register register = new Register();
        register.setVisible(true);
    }

    private void jPasswordField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        Login login = new Login();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(login);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        login.setVisible(true);
    }


}