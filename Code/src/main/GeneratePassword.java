package main;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePassword extends javax.swing.JFrame {

    public GeneratePassword() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("원하는 양식을 선택 후 생성 버튼을 눌러주세요.");

        jCheckBox1.setText("연속된 숫자 허용");

        jCheckBox2.setText("대문자 필요");

        jCheckBox3.setText("특수문자 필요");

        jButton1.setText("생성");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("");
        jLabel2.setOpaque(true);

        jCheckBox4.setText("8~10자리");

        jCheckBox5.setText("13~15자리");

        jCheckBox6.setText("11~13자리");

        jButton2.setText("복사");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(176, 176, 176))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(32, 32, 32)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jCheckBox1)
                                                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jCheckBox3)
                                                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(22, 22, 22)
                                                        .addComponent(jLabel1)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jCheckBox3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox5)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jCheckBox4)
                                                .addComponent(jCheckBox6)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        pack();
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });
        jCheckBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox4ActionPerformed(e);
            }
        });
        jCheckBox5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox5ActionPerformed(e);
            }
        });
        jCheckBox6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox6ActionPerformed(e);
            }
        });
    }
    private String generatePassword() {
        // 비밀번호 길이를 결정하기 위한 변수
        int passwordLength = 0;

        // 체크박스에 따라 비밀번호 길이 설정
        if (jCheckBox4.isSelected()) {
            passwordLength = 8 + (int)(Math.random() * 3); // 8~10자리
        } else if (jCheckBox6.isSelected()) {
            passwordLength = 11 + (int)(Math.random() * 3); // 11~13자리
        } else if (jCheckBox5.isSelected()) {
            passwordLength = 13 + (int)(Math.random() * 3); // 13~15자리
        }

        // 비밀번호 생성을 위한 문자열 초기화
        StringBuilder password = new StringBuilder();

        // 연속된 숫자가 허용되는지 체크
        boolean allowConsecutiveNumbers = jCheckBox1.isSelected();

        // 대문자 포함 여부 체크
        boolean includeUpperCase = jCheckBox2.isSelected();

        // 특수문자 포함 여부 체크
        boolean includeSpecialChars = jCheckBox3.isSelected();

        // 비밀번호 생성
        for (int i = 0; i < passwordLength; i++) {
            // 랜덤 숫자를 결정 (0: 숫자, 1: 영어 소문자, 2: 영어 대문자)
            int category = (int)(Math.random() * 3);

            // 랜덤 숫자에 따라 문자 추가
            if (category == 0) {
                // 숫자 추가
                password.append((char)('0' + (int)(Math.random() * 10)));
            } else if (category == 1) {
                // 영어 소문자 추가
                password.append((char)('a' + (int)(Math.random() * 26)));
            } else {
                // 영어 대문자 추가 (대문자 포함 여부에 따라)
                if (includeUpperCase) {
                    password.append((char)('A' + (int)(Math.random() * 26)));
                } else {
                    // 영어 소문자 추가
                    password.append((char)('a' + (int)(Math.random() * 26)));
                }
            }
        }

        // 특수문자 포함 여부 확인
        if (includeSpecialChars) {
            // 비밀번호의 랜덤한 위치에 특수문자 삽입
            int index = (int)(Math.random() * password.length());
            // ASCII 코드에서 특수문자 범위 선택
            char specialChar = (char)(33 + (int)(Math.random() * 15)); // '!'부터 '~'까지
            password.setCharAt(index, specialChar);
        }

        // 생성된 비밀번호 반환
        return password.toString();
    }
    private void copyToClipboard() {
        // 클립보드에 복사할 텍스트
        String password = jLabel2.getText();

        // 클립보드에 텍스트 복사
        StringSelection stringSelection = new StringSelection(password);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        // 비밀번호 생성 후 jLabel2에 출력
        String password = generatePassword();
        jLabel2.setText(password);
    }
    private void jButton2ActionPerformed(ActionEvent evt) {
        copyToClipboard();
    }
    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox4.isSelected()) {
            jCheckBox5.setSelected(false);
            jCheckBox6.setSelected(false);
        }
    }

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox5.isSelected()) {
            jCheckBox4.setSelected(false);
            jCheckBox6.setSelected(false);
        }
    }

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox6.isSelected()) {
            jCheckBox4.setSelected(false);
            jCheckBox5.setSelected(false);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneratePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratePassword().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;

}
