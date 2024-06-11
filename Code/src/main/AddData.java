package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;

public class AddData extends JFrame {
    private JPanel jPanel;
    private JLabel jLabel;
    private JButton jButton;

    private JButton addBtn;
    private JButton cancelBtn;
    private JLabel explain;
    private JLabel siteName;
    private JLabel max;
    private JTextField nameInput;

    public AddData(JButton jButton, JLabel jLabel) {
        setLocationRelativeTo(null);
        this.jLabel = jLabel;
        this.jButton = jButton;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel = new JPanel();
        explain = new JLabel();
        siteName = new JLabel();
        max = new JLabel();
        nameInput = new JTextField();
        addBtn = new JButton();
        cancelBtn = new JButton();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        explain.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        explain.setText("추가 할 데이터를 입력해주세요.");

        siteName.setText("사이트 이름");
        max.setText("최대 3자까지 가능");
        addBtn.setText("추가");

        cancelBtn.setText("취소");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(explain))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(siteName)
                                                .addGap(18, 18, 18)
                                                .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(110,110,110)
                                                .addComponent(max)))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addGap(90,90,90)
                                .addComponent(addBtn)
                                .addGap(75, 75, 75)
                                .addComponent(cancelBtn)
                                .addGap(19, 19, 19))
        );

        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(explain)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(siteName)
                                        .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(max))
                                .addGap(22,22,22)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addBtn)
                                        .addComponent(cancelBtn))
                                .addGap(16, 16, 16))
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

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addBtnActionPerformed(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    private void addBtnActionPerformed(ActionEvent evt) throws Exception{
        if(nameInput.getText().isEmpty() || nameInput.getText().length() > 3){
            JOptionPane.showMessageDialog(this, "올바른 이름을 입력해주세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
        }
        else{
            BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/Data.txt"));
            String line;
            boolean check = true;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(nameInput.getText())) {
                    check = false;
                    JOptionPane.showMessageDialog(this, "이미 사용된 이름 입니다.", "생성 오류", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(check){
                jLabel.setText(nameInput.getText());
                jButton.setText(nameInput.getText());
            }
        }
    }

}
