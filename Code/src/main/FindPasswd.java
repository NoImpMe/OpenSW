package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FindPasswd extends JFrame {

    private JPanel jPanel;
    private JLabel idLabel;
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JLabel pwLabel;
    private JLabel resultLabel;
    private JTextField idInput;
    private JComboBox<String> questions;
    private JTextField answerInput;
    private JButton searchBtn;

    public FindPasswd() {
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel = new JPanel();
        idLabel = new JLabel();
        idInput = new JTextField();
        questionLabel = new JLabel();
        questions = new JComboBox<>();
        answerLabel = new JLabel();
        answerInput = new JTextField();
        pwLabel = new JLabel();
        resultLabel = new JLabel();
        searchBtn = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setText("ID");
        idLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        idInput.setText("");

        questionLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setText("질문");
        questionLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        questions.setModel(new DefaultComboBoxModel<>(new String[]{"나의 고향은?", "나의 이름은?", "나의 첫 차는?", "나의 초등학교는?"}));
      

        answerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        answerLabel.setText("답변");
        answerLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        answerInput.setText("");

        pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pwLabel.setText("검색된 PW");
        pwLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        resultLabel.setText("");

        searchBtn.setText("PW 검색");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idInput.getText().trim();
                String num = questions.getSelectedIndex()+"";
                String answer = answerInput.getText().trim();
                String foundPassword = null;
                try {
                    foundPassword = searchAccount(id, num,answer);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                resultLabel.setText(foundPassword);
            }
        });
        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(pwLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                        .addComponent(answerLabel)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(answerInput, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                                .addComponent(idLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(idInput, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                                .addComponent(questionLabel)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(questions, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(searchBtn)))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(idLabel)
                                        .addComponent(idInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(questions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(questionLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(answerLabel)
                                        .addComponent(answerInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn)
                                .addGap(19, 19, 19)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pwLabel)
                                        .addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        pack();
    }


    private String searchAccount(String id, String question, String answer) throws FileNotFoundException {
        String foundPasswd = "";
        try {
            File dataFile = new File("Code/src/main/account.txt");
            if(!dataFile.exists()){
                JOptionPane.showMessageDialog(this, "계정을 먼저 생성해주세요!");
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/account.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equals(idInput.getText()) && parts[4].equals(question) && parts[5].equals(answerInput.getText())) {
                    foundPasswd = parts[3];
                }
            }
            if(foundPasswd.isEmpty()){
                JOptionPane.showMessageDialog(FindPasswd.this, "입력한 정보에 맞는 Password가 없습니다.");

            }
            reader.close();
            return foundPasswd;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
