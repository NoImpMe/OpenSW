package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.*;

public class OTP extends JFrame {
    private Main mainFrame;
    public OTP(Main mainFrame) {
        setLocationRelativeTo(null);
        initComponents();
        initAction();
        this.mainFrame = mainFrame;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        checkbox1 = new Checkbox();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        checkbox1.setLabel("encode");

        jLabel1.setBackground(new Color(122, 232, 241));
        jLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("");
        jLabel1.setOpaque(true);

        jTextField1.setFont(new Font("맑은 고딕", Font.PLAIN, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setText("");

        jButton1.setText("인증하기");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(checkbox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(jButton1)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkbox1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton1)
                                .addContainerGap(51, Short.MAX_VALUE))
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
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verifyInput();

            }
        });
        checkbox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    jLabel1.setText(formatNumber(decodeNumber(jLabel1.getText())));
                }
                else{
                    jLabel1.setText(formatNumber(encodeNumber(generateRandomNumber())));
                }
            }
        });
    }
    private void initAction() {
        if (checkbox1.getState()) {
            String randomNumbers = generateRandomNumber();
            jLabel1.setText(formatNumber(randomNumbers));
        } else {
            String randomNumbers = generateRandomNumber();
            String encodedNumbers = encodeNumber(randomNumbers);
            jLabel1.setText(formatNumber(encodedNumbers));
        }
    }

    private String generateRandomNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10); // Generates a random digit between 0 and 9
            sb.append(digit);
        }
        return sb.toString();
    }

    private String formatNumber(String number) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                formatted.append(" ");
            }
            formatted.append(number.charAt(i));
        }
        return formatted.toString();
    }

    private String encodeNumber(String number) {
        StringBuilder encoded = new StringBuilder();
        for (char c : number.toCharArray()) {
            if(c == ' '){
                continue;
            }
            encoded.append((char) (c + 17));
        }
        return encoded.toString();
    }
    private void verifyInput() {
        String input = jTextField1.getText().replace(" ", "");
        String labelValue = jLabel1.getText().replace(" ", ""); // 공백 제거

        if (!input.equals(labelValue) || !checkbox1.getState()) {
            JOptionPane.showMessageDialog(this, "인증에 실패하였습니다.", "인증 실패", JOptionPane.ERROR_MESSAGE);
            initAction();
        }
        else{
            mainFrame.updateOTPButton();
            dispose();
        }
    }
    private String decodeNumber(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            if (c == ' '){
                continue;
            }
            char decodedChar = (char) (c - 17);
            decoded.append(decodedChar);
        }
        return decoded.toString();
    }
    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }

    private JPanel jPanel1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JTextField jTextField1;
    private Checkbox checkbox1;
}
