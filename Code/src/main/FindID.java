package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FindID extends JFrame {
    private JTextField birthInput;
    private JTextField nameInput;
    private JButton searchBtn;
    private JPanel jPanel;
    private JLabel birth;
    private JLabel name;
    private JLabel idLabel;
    private JLabel searchedID;

    public FindID() {
        setTitle("Find ID");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel = new JPanel();
        birth = new JLabel();
        name = new JLabel();
        searchedID = new JLabel();
        idLabel = new JLabel();
        birthInput = new JTextField();
        nameInput = new JTextField();
        searchBtn = new JButton();

        birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        birth.setHorizontalAlignment(SwingConstants.CENTER);
        birth.setText("생년월일");

        name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setText("    이름  ");

        birthInput.setText("");

        nameInput.setText("");

        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setText("검색된 ID");

        searchBtn.setText("ID 검색");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthdayToSearch = birthInput.getText().trim();
                String nameToSearch = nameInput.getText().trim();
                String foundId = null;
                try {
                    foundId = searchAccount(birthdayToSearch, nameToSearch);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                searchedID.setText(foundId);
            }
        });
        searchedID.setText("");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(idLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchedID, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(birth))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(birthInput, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                        .addComponent(name)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(searchBtn)
                                                                .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(birth)
                                        .addComponent(birthInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(searchBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(idLabel)
                                        .addComponent(searchedID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
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
    }
    private String searchAccount(String birthdayToSearch, String nameToSearch) throws FileNotFoundException {
        String foundId = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("Code/src/main/account.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(birthdayToSearch) && parts[0].equals(nameToSearch)) {
                    foundId = parts[2];
                }
            }
            if(foundId.isEmpty()){
                JOptionPane.showMessageDialog(FindID.this, "입력한 정보에 맞는 ID가 없습니다.");

            }
            reader.close();
            return foundId;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
