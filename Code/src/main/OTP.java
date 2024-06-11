package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.*;

public class OTP extends JFrame {
    public OTP(Main mainFrame) {
        setLocationRelativeTo(null);
        initComponents();
        initAction();
        this.mainFrame = mainFrame;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel = new JPanel();
        decodeOTP = new Checkbox();
        otpText = new JLabel();
        otpInput = new JTextField();
        verifyBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        decodeOTP.setLabel("decode");

        otpText.setBackground(new Color(122, 232, 241));
        otpText.setFont(new Font("맑은 고딕", Font.BOLD, 18)); // NOI18N
        otpText.setHorizontalAlignment(SwingConstants.CENTER);
        otpText.setText("");
        otpText.setOpaque(true);

        otpInput.setFont(new Font("맑은 고딕", Font.PLAIN, 18)); // NOI18N
        otpInput.setHorizontalAlignment(JTextField.CENTER);
        otpInput.setText("");

        verifyBtn.setText("인증하기");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(otpInput, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(decodeOTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(otpText, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(verifyBtn)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(otpText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(decodeOTP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addComponent(otpInput, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(verifyBtn)
                                .addContainerGap(51, Short.MAX_VALUE))
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
        verifyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verifyInput();

            }
        });
        decodeOTP.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    otpText.setText(formatNumber(decodeNumber(otpText.getText())));
                }
                else{
                    otpText.setText(formatNumber(encodeNumber(generateRandomNumber())));
                }
            }
        });
    }
    private void initAction() {
        if (decodeOTP.getState()) {
            String randomNumbers = generateRandomNumber();
            otpText.setText(formatNumber(randomNumbers));
        } else {
            String randomNumbers = generateRandomNumber();
            String encodedNumbers = encodeNumber(randomNumbers);
            otpText.setText(formatNumber(encodedNumbers));
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
        String input = otpInput.getText().replace(" ", "");
        String labelValue = otpText.getText().replace(" ", ""); // 공백 제거

        if (!input.equals(labelValue) || !decodeOTP.getState()) {
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

    private Main mainFrame;
    private JPanel jPanel;
    private JButton verifyBtn;
    private JLabel otpText;
    private JTextField otpInput;
    private Checkbox decodeOTP;
}
