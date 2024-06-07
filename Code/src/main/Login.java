package main;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Login extends JFrame {
    private JPanel jPanel;
    private JLabel title;
    private JButton startBtn;
    private JButton registBtn;
    private JButton findIDBtn;
    private JButton findPWBtn;
    private JPasswordField pwField;
    private JFormattedTextField idField;

    public Login() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel = new JPanel();
        startBtn = new JButton();
        idField = new JFormattedTextField();
        pwField = new JPasswordField();
        registBtn = new JButton();
        title = new JLabel();
        findIDBtn = new JButton();
        findPWBtn = new JButton();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startBtn.setText("Login");

        idField.setText("");
        idField.setFont(new java.awt.Font("맑은 고딕", 1, 18));

        pwField.setText("");
        registBtn.setText("Register");

        title.setFont(new java.awt.Font("맑은 고딕", 1, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Safe Local Lock");

        findIDBtn.setText("ID 찾기");

        findPWBtn.setText("Password 찾기");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(187, 187, 187)
                                                .addComponent(findIDBtn)
                                                .addGap(93, 93, 93)
                                                .addComponent(findPWBtn))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(idField)
                                                                        .addComponent(pwField, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                                                .addGap(56, 56, 56)
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(registBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(startBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(startBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pwField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(findIDBtn)
                                        .addComponent(findPWBtn))
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String id = idField.getText();
                    String password = new String(pwField.getPassword());
                    BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/account.txt"));
                    String line;
                    boolean idFound = false;
                    boolean passwordMatched = false;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length >= 2 && parts[2].equals(id)) {
                            idFound = true;
                            if (parts[3].equals(password)) {
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
                        dispose();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Login.this, "파일을 읽어오는 중 오류가 발생했습니다.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        registBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registBtnActionPerformed(evt);
            }
        });
        findIDBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                findIDBtnActionPerformed(evt);
            }
        });
        findPWBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                findPWBtnActionPerformed(evt);
            }
        });
    }
    private void registBtnActionPerformed(ActionEvent evt) {
        Register register = new Register();
        register.setVisible(true);
    }
    private void findIDBtnActionPerformed(ActionEvent evt) {
        FindID findID = new FindID();
        findID.setVisible(true);
    }
    private void findPWBtnActionPerformed(ActionEvent evt) {
        FindPasswd findPasswd = new FindPasswd();
        findPasswd.setVisible(true);
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