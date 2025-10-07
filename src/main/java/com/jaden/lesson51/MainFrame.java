package com.jaden.lesson51;

import com.jaden.lesson51.DestTableModel;
import com.jaden.lesson51.SrcTableModel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import org.apache.commons.net.ftp.*;

public class MainFrame extends javax.swing.JFrame {

    String dirName = "";
    FTPClient ftp = new FTPClient();
    int dividerLocation;
    DestTableModel desttablemodel = new DestTableModel();
    SrcTableModel srctablemodel = new SrcTableModel();
    FilesTableModel filestablemodel = new FilesTableModel();
    Stack<FTPFile> stack = new Stack();

    public MainFrame() {
        initComponents();
        destTable.setModel(desttablemodel);
        destTable.setRowHeight(20);
        srcTable.setModel(srctablemodel);
        srcTable.setRowHeight(20);
        filesTable.setModel(filestablemodel);
        filesTable.setRowHeight(20);
    }

    private java.util.List<FTPFile> withParentEntry(FTPFile[] files) {
        java.util.List<FTPFile> fileList = new java.util.ArrayList<>();
        FTPFile parentEntry = new FTPFile() {
            @Override
            public String getName() {
                return "..";
            }

            @Override
            public boolean isDirectory() {
                return true;
            }

        };
        fileList.add(parentEntry);
        if (files != null) {
            fileList.addAll(Arrays.asList(files));
        }
        System.out.println("time: " + parentEntry.getTimestamp());
        return fileList;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        splitpanelButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        refreshButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hostTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        quickconnButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        localpathTextField = new javax.swing.JTextField();
        jSplitPane5 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        srcTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSplitPane4 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        destTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        filesTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setToolTipText("");
        jToolBar1.setAlignmentY(0.2F);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.setEnabled(false);
        jToolBar1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/server.png"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        uploadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/folder_go.png"))); // NOI18N
        uploadButton.setFocusable(false);
        uploadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uploadButton.setMinimumSize(new java.awt.Dimension(58, 23));
        uploadButton.setPreferredSize(new java.awt.Dimension(58, 58));
        uploadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(uploadButton);
        jToolBar1.add(jSeparator1);

        splitpanelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/page.png"))); // NOI18N
        splitpanelButton.setFocusable(false);
        splitpanelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        splitpanelButton.setMinimumSize(new java.awt.Dimension(58, 23));
        splitpanelButton.setPreferredSize(new java.awt.Dimension(58, 58));
        splitpanelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        splitpanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splitpanelButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(splitpanelButton);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/layout.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/layout_content.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/arrow_switch.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator2);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/arrow_refresh_small.png"))); // NOI18N
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setMinimumSize(new java.awt.Dimension(58, 23));
        refreshButton.setPreferredSize(new java.awt.Dimension(58, 58));
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(refreshButton);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/cog.png"))); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton7.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/cancel.png"))); // NOI18N
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMinimumSize(new java.awt.Dimension(58, 23));
        deleteButton.setPreferredSize(new java.awt.Dimension(58, 58));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteButton);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/server_delete.png"))); // NOI18N
        logoutButton.setFocusable(false);
        logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButton.setMinimumSize(new java.awt.Dimension(58, 23));
        logoutButton.setPreferredSize(new java.awt.Dimension(58, 58));
        logoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(logoutButton);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/server_add.png"))); // NOI18N
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton10.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton10);
        jToolBar1.add(jSeparator3);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/layout_sidebar.png"))); // NOI18N
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton11.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton11);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/folder_explore.png"))); // NOI18N
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton14.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/folder_bug.png"))); // NOI18N
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton15.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton15);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/eye.png"))); // NOI18N
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setMinimumSize(new java.awt.Dimension(58, 23));
        jButton16.setPreferredSize(new java.awt.Dimension(58, 58));
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton16);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Host");

        hostTextField.setText("61.244.87.154");
        hostTextField.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        usernameTextField.setText("jaden");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Port");

        portTextField.setText("21");

        quickconnButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        quickconnButton.setText("Quick Connect");
        quickconnButton.setToolTipText("");
        quickconnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickconnButtonActionPerformed(evt);
            }
        });

        passwordField.setText("jaden12--");

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(100);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jSplitPane2.setTopComponent(jScrollPane1);

        jSplitPane3.setDividerLocation(430);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Local slite");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        localpathTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localpathTextFieldKeyPressed(evt);
            }
        });

        jSplitPane5.setDividerLocation(150);
        jSplitPane5.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        srcTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(srcTable);

        jSplitPane5.setLeftComponent(jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable2);

        jSplitPane5.setRightComponent(jScrollPane8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(localpathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSplitPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localpathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane3.setLeftComponent(jPanel2);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Remote slite");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSplitPane4.setDividerLocation(150);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        destTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        destTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                destTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(destTable);

        jSplitPane4.setBottomComponent(jScrollPane3);

        filesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(filesTable);

        jSplitPane4.setLeftComponent(jScrollPane7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSplitPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane3.setRightComponent(jPanel3);

        jSplitPane2.setRightComponent(jSplitPane3);

        jSplitPane1.setTopComponent(jSplitPane2);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jTabbedPane1.addTab("Queued files", null, jScrollPane4, "");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jTabbedPane1.addTab("Failed transfers", jScrollPane5);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable5);

        jTabbedPane1.addTab("Successful transfers", jScrollPane6);

        jSplitPane1.setRightComponent(jTabbedPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(quickconnButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSplitPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quickconnButton)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void splitpanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splitpanelButtonActionPerformed

        if (jSplitPane2.getDividerLocation() > 1) {
            dividerLocation = jSplitPane2.getDividerLocation();
            jSplitPane2.setDividerLocation(0);
        } else {
            jSplitPane2.setDividerLocation(dividerLocation);
        }
    }//GEN-LAST:event_splitpanelButtonActionPerformed

    private void quickconnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickconnButtonActionPerformed

        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);
        boolean error = false;
        try {
            int reply;
            String server = hostTextField.getText();
            System.out.println(">" + server + "<");
            System.out.println(">" + usernameTextField.getText() + "<" + "\n" + "> " + new String(passwordField.getPassword()) + "<");
            ftp.connect(server);
//            ftp.login(usernameTextField.getText(), passwordField.toString());
            if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) != "") {
                ftp.login(usernameTextField.getText(), new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() == "" & new String(passwordField.getPassword()) != "") {
                ftp.login("anonymous", new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) == "") {
                ftp.login(usernameTextField.getText(), "anonymous");
            } else {
                ftp.login("anonymous", "anonymous");
            }
            System.out.println("Connected to " + server + ".");
            System.out.print(ftp.getReplyString());

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftp.getReplyCode();

            FTPFile dir[] = ftp.listFiles();
            List<FTPFile> directories = new ArrayList<>();
            for (FTPFile dirs : dir) {
                System.out.println(dirs.getName());
                System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dirs.getTimestamp().getTime()));
                if (dirs.isDirectory() == true) {
                    directories.add(dirs);
                }
            }
            System.out.println("dir=" + dir.length);
//            desttablemodel.files = Arrays.asList(dir);
            desttablemodel.files = withParentEntry(dir);
            desttablemodel.fireTableStructureChanged();
            filestablemodel.files = directories;
            filestablemodel.fireTableStructureChanged();
//            ftp.logout();
//            ftp.disconnect();

            //System.err.println("FTP server refused connection.");
            //System.exit(0);
//      }
        } catch (IOException e) {
            error = true;
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    // do nothing
                }
                System.out.println(error);
            }
            //System.exit(error ? 1 : 0);
        }
        File dir = new File(".");

    }//GEN-LAST:event_quickconnButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        FTPClient ftp = new FTPClient();
        try {
            FTPClientConfig config = new FTPClientConfig();
            ftp.configure(config);
            String server = hostTextField.getText();
            ftp.connect(server);
//            ftp.login("anonymous", "anonymous");
            ftp.login(usernameTextField.getText(), passwordField.toString());
            if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) != "") {
                ftp.login(usernameTextField.getText(), new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() == "" & new String(passwordField.getPassword()) != "") {
                ftp.login("anonymous", new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) == "") {
                ftp.login(usernameTextField.getText(), "anonymous");
            } else {
                ftp.login("anonymous", "anonymous");
            }

            int[] selectedRows = srcTable.getSelectedRows();
            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "No files selected for upload.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (int row : selectedRows) {
                File file = srctablemodel.files.get(row);
                System.out.println(file.getPath());
                String localFilePath = file.getPath();
                String remoteFilePath = "/" + file.getName();
                System.out.println(remoteFilePath);
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    boolean success = ftp.storeFile(remoteFilePath, inputStream);
                    if (success) {
                        System.out.println("Uploaded: " + localFilePath + " to " + remoteFilePath);
                    } else {
                        System.err.println("Failed to upload: " + localFilePath);
                    }
                    FTPFile dir[] = ftp.listFiles();
                    desttablemodel.files = Arrays.asList(dir);
                    desttablemodel.fireTableStructureChanged();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "FTP Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            try {
                if (ftp.isConnected()) {
                    ftp.disconnect();
                }
            } catch (IOException e) {
                // ignore
            }
        }

    }//GEN-LAST:event_uploadButtonActionPerformed

    private void localpathTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localpathTextFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String path = localpathTextField.getText().trim();
            System.out.println("Entered path: " + path);
            File dir = new File(path);
            System.out.println("Exists: " + dir.exists() + ", Directory: " + dir.isDirectory() + ", CanRead: " + dir.canRead());
            if (dir.exists() && dir.isDirectory() && dir.canRead()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    srctablemodel.files = Arrays.asList(files);
                    System.out.println("Files found: " + files.length);
                    for (File f : files) {
                        System.out.println("  - " + f.getName() + (f.isDirectory() ? " [dir]" : ""));
                    }
                } else {
                    srctablemodel.files = Arrays.asList();
                    System.out.println("No files found (null array)");
                }
            } else {
                srctablemodel.files = Arrays.asList();
                String reason = "";
                if (!dir.exists()) {
                    reason += " (does not exist)";
                } else if (!dir.isDirectory()) {
                    reason += " (not a directory)";
                } else if (!dir.canRead()) {
                    reason += " (cannot read)";
                }
                JOptionPane.showMessageDialog(this, "Invalid directory: " + path + reason, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Invalid directory: " + path + reason);
            }
            srctablemodel.fireTableStructureChanged();
        }

    }//GEN-LAST:event_localpathTextFieldKeyPressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            FTPClientConfig config = new FTPClientConfig();
            ftp.configure(config);
            String server = hostTextField.getText();
            ftp.connect(server);
            ftp.login(usernameTextField.getText(), passwordField.toString());
            if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) != "") {
                ftp.login(usernameTextField.getText(), new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() == "" & new String(passwordField.getPassword()) != "") {
                ftp.login("anonymous", new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) == "") {
                ftp.login(usernameTextField.getText(), "anonymous");
            } else {
                ftp.login("anonymous", "anonymous");
            }

            int[] selectedRows = destTable.getSelectedRows();
            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "No files selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (int row : selectedRows) {
                FTPFile file = desttablemodel.files.get(row);
                String remoteFilePath = "/" + file.getName();
                boolean deleted = ftp.deleteFile(remoteFilePath);
                if (deleted) {
                    System.out.println("Deleted: " + remoteFilePath);
                } else {
                    System.err.println("Failed to delete: " + remoteFilePath);
                }
            }

            // Refresh the remote file list
            FTPFile[] dir = ftp.listFiles();
            desttablemodel.files = Arrays.asList(dir);
            desttablemodel.fireTableStructureChanged();

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "FTP Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            try {
                if (ftp.isConnected()) {
                    ftp.disconnect();
                }
            } catch (IOException e) {
                // ignore
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            FTPClientConfig config = new FTPClientConfig();
            FTPFile dir[] = ftp.listFiles();
            ftp.configure(config);
            String server = hostTextField.getText();
            ftp.connect(server);
            if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) != "") {
                ftp.login(usernameTextField.getText(), new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() == "" & new String(passwordField.getPassword()) != "") {
                ftp.login("anonymous", new String(passwordField.getPassword()));
            } else if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) == "") {
                ftp.login(usernameTextField.getText(), "anonymous");
            } else {
                ftp.login("anonymous", "anonymous");
            }

            desttablemodel.files = Arrays.asList(dir);
            desttablemodel.fireTableStructureChanged();
            String path = localpathTextField.getText().trim();
            System.out.println("Entered path: " + path);
            File dir2 = new File(path);
            System.out.println("Exists: " + dir2.exists() + ", Directory: " + dir2.isDirectory() + ", CanRead: " + dir2.canRead());
            if (dir2.exists() && dir2.isDirectory() && dir2.canRead()) {
                File[] files = dir2.listFiles();
                if (files != null) {
                    srctablemodel.files = Arrays.asList(files);
                    System.out.println("Files found: " + files.length);
                    for (File f : files) {
                        System.out.println("  - " + f.getName() + (f.isDirectory() ? " [dir]" : ""));
                    }
                } else {
                    srctablemodel.files = Arrays.asList();
                    System.out.println("No files found (null array)");
                }
            } else {
                srctablemodel.files = Arrays.asList();
                String reason = "";
                if (!dir2.exists()) {
                    reason += " (does not exist)";
                } else if (!dir2.isDirectory()) {
                    reason += " (not a directory)";
                } else if (!dir2.canRead()) {
                    reason += " (cannot read)";
                }
                JOptionPane.showMessageDialog(this, "Invalid directory: " + path + reason, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Invalid directory: " + path + reason);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void destTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_destTableMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                FTPClientConfig config = new FTPClientConfig();
                ftp.configure(config);
                String server = hostTextField.getText();
                ftp.connect(server);
                if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) != "") {
                    ftp.login(usernameTextField.getText(), new String(passwordField.getPassword()));
                } else if (usernameTextField.getText() == "" & new String(passwordField.getPassword()) != "") {
                    ftp.login("anonymous", new String(passwordField.getPassword()));
                } else if (usernameTextField.getText() != "" & new String(passwordField.getPassword()) == "") {
                    ftp.login(usernameTextField.getText(), "anonymous");
                } else {
                    ftp.login("anonymous", "anonymous");
                }
                int row = destTable.rowAtPoint(evt.getPoint());

                FTPFile file = desttablemodel.files.get(row);
                System.out.println(">>>" + file.getName());
                if ("..".equals(file.getName())) {

                    stack.pop();
                } else if (file.isDirectory()) {

                    stack.push(file);
                    //String dirName = file.getName();.

                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Selected file: " + file.getName() + " but it is not directory");
                }
                dirName = "";
                for (FTPFile temp : stack.toArray(new FTPFile[0])) {

                    dirName += "/" + temp.getName();
                }
                System.out.println("d=" + dirName);

                ftp.changeWorkingDirectory(dirName);
                FTPFile[] dirFiles = ftp.listFiles();
                desttablemodel.files = withParentEntry(dirFiles);
                desttablemodel.fireTableStructureChanged();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_destTableMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable destTable;
    private javax.swing.JTable filesTable;
    private javax.swing.JTextField hostTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField localpathTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton quickconnButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton splitpanelButton;
    private javax.swing.JTable srcTable;
    private javax.swing.JButton uploadButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
