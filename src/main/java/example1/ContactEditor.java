/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package example1;

import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class ContactEditor extends javax.swing.JPanel {
    private ComboBoxModel displayFormatModel;
    private Window parent;
    // Zavreno pomoci OK tlacitka
    private boolean result;
    private JDialog dialog;
    
    private KeyListener escapeListener;
    
    /**
     * Creates new form ContactEditor
     */
    public ContactEditor() {
        initComponents();
        displayFormatModel = comboDisplayFormat.getModel();

        InputMap im = getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = getActionMap();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke("ESCAPE"); 
        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke("ENTER"); 
        im.put(escapeKeyStroke, "ESCAPE");
        im.put(enterKeyStroke, "ENTER");
        
        am.put("ESCAPE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCancelActionPerformed(null);
            }
        });
        am.put("ENTER", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonOKActionPerformed(null);
            }
        });
    }

    public void setParent(Window parent) {
        this.parent = parent;
    }
    
    private String nonNullString(String s) {
        return s == null ? "" : s;
    }
    
    private String nullEmptyString(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        return s.isBlank() ? null : s;
    }
    
    public boolean showDialog(String title) {
        JDialog jd = new JDialog(parent, Dialog.ModalityType.APPLICATION_MODAL);
        jd.setTitle(title);
        jd.setContentPane(this);
        jd.pack();
        jd.setLocationRelativeTo(parent);
        
        dialog = jd;
        
        jd.setVisible(true);
        
        return result;
    }
    
    public void setContactData(Contact contact) {
        textFirstName.setText(nonNullString(contact.getFirstName()));
        textLastName.setText(nonNullString(contact.getLastName()));
        textNickName.setText(nonNullString(contact.getNickName()));
        textTitle.setText(nonNullString(contact.getTitle()));
        
        displayFormatModel.setSelectedItem(
            displayFormatModel.getElementAt(
                contact.getDisplayFormat().ordinal()
            )
        );
        
        switch (contact.getMailFormat()) {
            case HTML:
                radioHtmlFormat.setSelected(true);
                break;
            case PlainText:
                radioPlaintextFormat.setSelected(true);
                break;
            case Custom:
                radioCustomFormat.setSelected(true);
                break;
            default:
                throw new AssertionError(contact.getMailFormat().name());
            
        }
    }
    
    public boolean checkValidInput() {
        String fn = textFirstName.getText().trim();
        String ln = textLastName.getText().trim();
        if (fn.isEmpty() || ln.isEmpty()) {
            // error: first+last name must be present
            JOptionPane.showMessageDialog(this, "First and last names must not be empty.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void saveContactData(Contact c) {
        Contact.MailFormat mf = mf = Contact.MailFormat.HTML;
        if (radioHtmlFormat.isSelected()) {
            mf = Contact.MailFormat.HTML;
        } else if (radioPlaintextFormat.isSelected()) {
            mf = Contact.MailFormat.PlainText;
        } else if (radioCustomFormat.isSelected()) {
            mf = Contact.MailFormat.Custom;
        }
        
        Contact.DisplayFormat df = Contact.DisplayFormat.values()[
            comboDisplayFormat.getSelectedIndex()
        ];
        
        c.setFirstName(textFirstName.getText().trim());
        c.setLastName(textLastName.getText().trim());
        c.setNickName(nullEmptyString(textNickName.getText().trim()));
        c.setTitle(nullEmptyString(textTitle.getText().trim()));
        c.setMailFormat(mf);
        c.setDisplayFormat(df);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFirstName = new javax.swing.JTextField();
        textLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textNickName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboDisplayFormat = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsitEmails = new javax.swing.JList();
        emailAdd = new javax.swing.JButton();
        emailEdit = new javax.swing.JButton();
        emailRemove = new javax.swing.JButton();
        emailDefault = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        radioHtmlFormat = new javax.swing.JRadioButton();
        radioPlaintextFormat = new javax.swing.JRadioButton();
        radioCustomFormat = new javax.swing.JRadioButton();
        buttonCancel = new javax.swing.JButton();
        buttonOK = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Name "));

        jLabel1.setLabelFor(textFirstName);
        jLabel1.setText("First Name:");

        jLabel2.setText("Last Name:");

        textFirstName.setText("John");

        textLastName.setText("Guy");

        jLabel3.setText("Title:");

        textTitle.setText("Prof, DrSC");

        jLabel4.setText("Nickname:");

        textNickName.setText("gui-master");

        jLabel5.setText("Display Format:");

        comboDisplayFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[Nickname]  First_Name + Last_Name", "[Nickname]  Last_Name, First Name", "Last_Name, First Name" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(textFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(textNickName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                    .addComponent(comboDisplayFormat, 0, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboDisplayFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" E-mail "));

        jLabel6.setText("E-mail Address:");

        lsitEmails.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "john.guy@xxxxxx.yyy", "gui@yyyyyy.xxx" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lsitEmails);

        emailAdd.setText("Add");

        emailEdit.setText("Edit");

        emailRemove.setText("Remove");

        emailDefault.setText("Default");

        jLabel7.setText("Mail Format:");

        buttonGroup1.add(radioHtmlFormat);
        radioHtmlFormat.setSelected(true);
        radioHtmlFormat.setText("HTML");
        radioHtmlFormat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radioHtmlFormat.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(radioPlaintextFormat);
        radioPlaintextFormat.setText("Plain Text");
        radioPlaintextFormat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radioPlaintextFormat.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(radioCustomFormat);
        radioCustomFormat.setText("Custom");
        radioCustomFormat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radioCustomFormat.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(radioHtmlFormat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioPlaintextFormat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioCustomFormat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailEdit)
                            .addComponent(emailAdd)
                            .addComponent(emailRemove)
                            .addComponent(emailDefault)))
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emailAdd, emailDefault, emailEdit, emailRemove});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(emailEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailDefault))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioHtmlFormat)
                    .addComponent(radioPlaintextFormat)
                    .addComponent(radioCustomFormat))
                .addContainerGap())
        );

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel))
                    .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCancel, buttonOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonOK))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // just close the window, do nothing
        dialog.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        if (!checkValidInput()) {
            return;
        }
        result = true;
        dialog.setVisible(false);
    }//GEN-LAST:event_buttonOKActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactEditor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox comboDisplayFormat;
    private javax.swing.JButton emailAdd;
    private javax.swing.JButton emailDefault;
    private javax.swing.JButton emailEdit;
    private javax.swing.JButton emailRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lsitEmails;
    private javax.swing.JRadioButton radioCustomFormat;
    private javax.swing.JRadioButton radioHtmlFormat;
    private javax.swing.JRadioButton radioPlaintextFormat;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textNickName;
    private javax.swing.JTextField textTitle;
    // End of variables declaration//GEN-END:variables
    
}
