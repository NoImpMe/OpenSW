package main;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePassword extends JFrame {

    public GeneratePassword() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        explain = new JLabel();
        continuity = new JCheckBox();
        capitality = new JCheckBox();
        specialChar = new JCheckBox();
        eightToTen = new JCheckBox();
        elevenToThr = new JCheckBox();
        thirteenToFif = new JCheckBox();
        createBtn = new JButton();
        result = new JLabel();
        copyBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        explain.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        explain.setText("원하는 양식을 선택 후 생성 버튼을 눌러주세요.");

        continuity.setText("연속된 숫자 허용");

        capitality.setText("대문자 필요");

        specialChar.setText("특수문자 필요");

        createBtn.setText("생성");

        result.setBackground(new java.awt.Color(255, 255, 255));
        result.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setText("");
        result.setOpaque(true);

        eightToTen.setText("8~10자리");

        thirteenToFif.setText("13~15자리");

        elevenToThr.setText("11~13자리");

        copyBtn.setText("복사");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createBtn)
                                .addGap(176, 176, 176))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(32, 32, 32)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(continuity)
                                                                .addComponent(eightToTen, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(capitality, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(elevenToThr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(specialChar)
                                                                .addComponent(thirteenToFif, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(22, 22, 22)
                                                        .addComponent(explain)))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(result, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(copyBtn, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(explain)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(continuity)
                                        .addComponent(capitality)
                                        .addComponent(specialChar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(thirteenToFif)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(eightToTen)
                                                .addComponent(elevenToThr)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(result, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(copyBtn))
                                .addGap(18, 18, 18)
                                .addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        pack();
        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createBtnActionPerformed(e);
            }
        });
        copyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyBtnActionPerformed(e);
            }
        });
        eightToTen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eightToTenActionPerformed(e);
            }
        });
        thirteenToFif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thirteenToFifActionPerformed(e);
            }
        });
        elevenToThr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elevenToThrActionPerformed(e);
            }
        });
    }
    private String generatePassword() {
        int passwordLength = 0;

        if (eightToTen.isSelected()) {
            passwordLength = 8 + (int)(Math.random() * 3); // 8~10자리
        } else if (elevenToThr.isSelected()) {
            passwordLength = 11 + (int)(Math.random() * 3); // 11~13자리
        } else if (thirteenToFif.isSelected()) {
            passwordLength = 13 + (int)(Math.random() * 3); // 13~15자리
        }

        StringBuilder password = new StringBuilder();

        boolean includeUpperCase = capitality.isSelected();

        boolean includeSpecialChars = specialChar.isSelected();

        for (int i = 0; i < passwordLength; i++) {
            int category = (int)(Math.random() * 3);

            if (category == 0) {
                password.append((char)('0' + (int)(Math.random() * 10)));
            } else if (category == 1) {
                password.append((char)('a' + (int)(Math.random() * 26)));
            } else {
                if (includeUpperCase) {
                    password.append((char)('A' + (int)(Math.random() * 26)));
                } else {
                    password.append((char)('a' + (int)(Math.random() * 26)));
                }
            }
        }

        if (includeSpecialChars) {
            int index = (int)(Math.random() * password.length());
            char specialChar = (char)(33 + (int)(Math.random() * 15)); // '!'부터 '~'까지
            password.setCharAt(index, specialChar);
        }

        return password.toString();
    }
    private void copyToClipboard() {
        // 클립보드에 복사할 텍스트
        String password = result.getText();

        // 클립보드에 텍스트 복사
        StringSelection stringSelection = new StringSelection(password);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
    private void createBtnActionPerformed(ActionEvent evt) {
        // 비밀번호 생성 후 result에 출력
        String password = generatePassword();
        result.setText(password);
    }
    private void copyBtnActionPerformed(ActionEvent evt) {
        copyToClipboard();
    }
    private void eightToTenActionPerformed(ActionEvent evt) {
        if (eightToTen.isSelected()) {
            thirteenToFif.setSelected(false);
            elevenToThr.setSelected(false);
        }
    }

    private void thirteenToFifActionPerformed(ActionEvent evt) {
        if (thirteenToFif.isSelected()) {
            eightToTen.setSelected(false);
            elevenToThr.setSelected(false);
        }
    }

    private void elevenToThrActionPerformed(ActionEvent evt) {
        if (elevenToThr.isSelected()) {
            eightToTen.setSelected(false);
            thirteenToFif.setSelected(false);
        }
    }


    private JButton createBtn;
    private JButton copyBtn;
    private JCheckBox continuity;
    private JCheckBox capitality;
    private JCheckBox specialChar;
    private JCheckBox eightToTen;
    private JCheckBox thirteenToFif;
    private JCheckBox elevenToThr;
    private JLabel explain;
    private JLabel result;

}
