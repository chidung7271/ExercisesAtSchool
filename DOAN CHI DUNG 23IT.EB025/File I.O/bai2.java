
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class bai2 extends javax.swing.JFrame {

    public bai2() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        btnSaveAs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveAs.setText("Save as");
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 264,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(141, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 152,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(234, 234, 234)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 147,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 77,
                                                Short.MAX_VALUE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSaveAs, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        fileChooser.showSaveDialog(null);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fi = fileChooser.getSelectedFile();
            String f = fi.getPath();
            String line;
            txtPath.setText(f);
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                text.setText(content.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FileOutputStream fout = new FileOutputStream(txtPath.getText());
            String s = text.getText();
            byte b[] = s.getBytes();
            fout.write(b);
            fout.close();
            JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JFileChooser jf = new JFileChooser();
            int returnV = jf.showOpenDialog(this);
            File sF = jf.getSelectedFile();
            saveToFile(sF, text.getText());
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new bai2().setVisible(true);
        });
    }

    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField txtPath;

    private void saveToFile(File sF, String content) {
        try (FileWriter writer = new FileWriter(sF)) {
            writer.write(content);
            JOptionPane.showMessageDialog(this, "Tệp đã được lưu thành công.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
