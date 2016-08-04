package ydstest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author seracettin
 */
public class YDSJFrame extends javax.swing.JFrame {

    ArrayList<Questions> listQuestin = new ArrayList<>();
    String ablPath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\data\\question.txt";
    private static int correctQues = 0;
    private static int wrongQues = 0;
    private static int[] checkCell = new int[80];

    public YDSJFrame() {
        readQuestions();
        initComponents();
        lblAnswerTotalQues.setText("" + listQuestin.size());
        for (int i = 0; i < 80; i++) {
            checkCell[i] = 0;
        }
    }

    private void readQuestions() {
        if (listQuestin.size() != 0) {
            listQuestin.clear();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(ablPath)));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] spl = line.split("\\.");
                Questions qs = new Questions(Integer.parseInt(spl[0]), spl[1]);
                listQuestin.add(qs);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YDSJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(YDSJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processTable(int row, int column, String value) {

        String cu = null;
        for (int i = 0; i < listQuestin.size(); i++) {
            if (listQuestin.get(i).getNumber() == row + 1) {
                if (listQuestin.get(i).getQuestionMark().contains(value)) {
                    correctQues++;
                    lblAnswerCorrectQues.setText("" + correctQues);
                } else {
                    wrongQues++;
                    lblAnswerWronglQues.setText("" + wrongQues);
                }
                cu = listQuestin.get(i).getQuestionMark();
                break;
            }
        }
        tblYdsTable.setValueAt((Object) cu, row, column + 1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splPnlMain = new javax.swing.JSplitPane();
        splPnlLeft = new javax.swing.JPanel();
        cmbxlOneQuesAns = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnClearYdsTable = new javax.swing.JButton();
        lblAnsOneQues = new javax.swing.JLabel();
        splPnlRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblYdsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblTotalQues = new javax.swing.JLabel();
        lblCorrectQues = new javax.swing.JLabel();
        lblWrongQues = new javax.swing.JLabel();
        lblAnswerTotalQues = new javax.swing.JLabel();
        lblAnswerCorrectQues = new javax.swing.JLabel();
        lblAnswerWronglQues = new javax.swing.JLabel();
        menuBarUst = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(562, 440));
        setResizable(false);
        setSize(new java.awt.Dimension(562, 440));

        splPnlLeft.setBackground(new java.awt.Color(255, 102, 51));

        cmbxlOneQuesAns.setBackground(new java.awt.Color(255, 153, 102));
        cmbxlOneQuesAns.setEditable(true);
        cmbxlOneQuesAns.setForeground(new java.awt.Color(255, 255, 255));
        cmbxlOneQuesAns.setMaximumRowCount(180);
        cmbxlOneQuesAns.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        cmbxlOneQuesAns.setToolTipText("");
        cmbxlOneQuesAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxlOneQuesAnsActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tek Cevap Goster");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnClearYdsTable.setBackground(new java.awt.Color(255, 153, 102));
        btnClearYdsTable.setForeground(new java.awt.Color(255, 255, 255));
        btnClearYdsTable.setText("Tabloyu temizle");
        btnClearYdsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearYdsTableActionPerformed(evt);
            }
        });

        lblAnsOneQues.setForeground(new java.awt.Color(255, 255, 255));
        lblAnsOneQues.setText("Cevap Yok");

        javax.swing.GroupLayout splPnlLeftLayout = new javax.swing.GroupLayout(splPnlLeft);
        splPnlLeft.setLayout(splPnlLeftLayout);
        splPnlLeftLayout.setHorizontalGroup(
            splPnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(splPnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbxlOneQuesAns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnsOneQues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearYdsTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addContainerGap())
        );
        splPnlLeftLayout.setVerticalGroup(
            splPnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPnlLeftLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnClearYdsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxlOneQuesAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnsOneQues, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        for(int i=0;i<listQuestin.size();i++)
        cmbxlOneQuesAns.addItem(i);
        Object child = cmbxlOneQuesAns.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = popup.getList();
        list.setSelectionBackground(Color.cyan);

        splPnlMain.setLeftComponent(splPnlLeft);

        splPnlRight.setBackground(new java.awt.Color(0, 204, 204));
        splPnlRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblYdsTable.setBackground(new java.awt.Color(255, 204, 204));
        tblYdsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblYdsTable.setForeground(new java.awt.Color(0, 0, 255));
        tblYdsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Soru Numarasi", "Cevap", "Doğru Cevap"
            }
        ));
        TableColumn gradeColumn = tblYdsTable.getColumnModel().getColumn(1);

        javax.swing.JComboBox comboBox=new javax.swing.JComboBox();
        comboBox.removeAllItems();
        try {
            comboBox.addItem("A");
            comboBox.addItem("B");
            comboBox.addItem("C");
            comboBox.addItem("D");
            comboBox.addItem("E");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        gradeColumn.setCellEditor(new DefaultCellEditor(comboBox));
        tblYdsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tblYdsTable.setGridColor(new java.awt.Color(0, 204, 204));
        tblYdsTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                int row=e.getLastRow();
                int column =e.getColumn();
                if(row>=0&&column>=0){
                    if(tblYdsTable.getValueAt(row, column)!=null)
                    if(column==1&&checkCell[row]==0){
                        checkCell[row]=1;
                        String str=tblYdsTable.getValueAt(row, column).toString();
                        processTable(row, column, str);

                    }
                }

            }
        });
        //set value
        DefaultTableModel model = (DefaultTableModel) tblYdsTable.getModel();

        for(int i=1;i<81;i++){

            Vector row = new Vector();
            row.add(i);
            row.add("");
            row.add("");
            model.addRow(row);
        }
        jScrollPane1.setViewportView(tblYdsTable);

        splPnlRight.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 420, 350));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("YDS Deneme Çözme Tablosu");
        splPnlRight.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 11, 315, -1));

        lblTotalQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalQues.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalQues.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalQues.setText("Toplam Soru Sayısı:");
        splPnlRight.add(lblTotalQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 139, -1));

        lblCorrectQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorrectQues.setForeground(new java.awt.Color(255, 255, 255));
        lblCorrectQues.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCorrectQues.setText("Doğru Soru Sayısı  :");
        splPnlRight.add(lblCorrectQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 139, -1));

        lblWrongQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWrongQues.setForeground(new java.awt.Color(255, 255, 255));
        lblWrongQues.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWrongQues.setText("Yanlış Soru Sayısı   :");
        splPnlRight.add(lblWrongQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 139, -1));

        lblAnswerTotalQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswerTotalQues.setForeground(new java.awt.Color(255, 204, 102));
        splPnlRight.add(lblAnswerTotalQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 39, 116, 17));

        lblAnswerCorrectQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswerCorrectQues.setForeground(new java.awt.Color(255, 204, 102));
        lblAnswerCorrectQues.setText("    ");
        splPnlRight.add(lblAnswerCorrectQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 62, 116, -1));

        lblAnswerWronglQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswerWronglQues.setForeground(new java.awt.Color(255, 204, 102));
        splPnlRight.add(lblAnswerWronglQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 87, 116, 17));

        splPnlMain.setRightComponent(splPnlRight);

        menuBarUst.setBackground(new java.awt.Color(255, 255, 153));
        menuBarUst.setForeground(new java.awt.Color(255, 102, 51));
        menuBarUst.setToolTipText("");

        jMenu1.setBackground(new java.awt.Color(255, 102, 51));
        jMenu1.setText("File");

        jMenuItem2.setBackground(new java.awt.Color(255, 204, 102));
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("cevap anahtarı yükleyin");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                File workingDirectory = new File(System.getProperty("user.home") + "/Desktop");

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(workingDirectory);
                fileChooser.setBackground(Color.ORANGE);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                fileChooser.setFileFilter(filter);

                int returnValue = fileChooser.showOpenDialog(rootPane);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    try{
                        BufferedReader br=new BufferedReader(new FileReader(new File(selectedFile.getAbsolutePath())));
                        BufferedWriter bw=new BufferedWriter(new FileWriter(new File(ablPath)));

                        String cfline=null;
                        while((cfline=br.readLine())!=null){
                            bw.write(cfline+"\n");
                        }
                        br.close();
                        bw.close();
                    }catch(FileNotFoundException fle){

                    }catch(IOException ioe){

                    }
                    readQuestions();
                    lblAnswerTotalQues.setText("" + listQuestin.size());
                    for (int i = 0; i < 80; i++) {
                        checkCell[i] = 0;
                    }
                    JOptionPane.showMessageDialog(jScrollPane1,
                        "Dosya kopyalaması başarılı.",
                        "Dosya Kopyalaması",
                        JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

            }
        });

        menuBarUst.add(jMenu1);

        jMenu2.setText("Edit");
        menuBarUst.add(jMenu2);

        setJMenuBar(menuBarUst);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splPnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splPnlMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearYdsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearYdsTableActionPerformed
        for (int i = 1; i < 81; i++) {
            tblYdsTable.setValueAt((Object) i, i - 1, 0);
            tblYdsTable.setValueAt((Object) "", i - 1, 1);
            tblYdsTable.setValueAt((Object) "", i - 1, 2);
        }
        lblAnswerCorrectQues.setText("");
        lblAnswerWronglQues.setText("");
        for (int i = 0; i < 80; i++) {
            checkCell[i] = 0;
        }
        correctQues = 0;
        wrongQues = 0;
    }//GEN-LAST:event_btnClearYdsTableActionPerformed

    private void cmbxlOneQuesAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxlOneQuesAnsActionPerformed
        if (1 <= Integer.parseInt(cmbxlOneQuesAns.getSelectedItem().toString()) && Integer.parseInt(cmbxlOneQuesAns.getSelectedItem().toString()) <= 80) {
            lblAnsOneQues.setText(cmbxlOneQuesAns.getSelectedItem().toString() + "." + listQuestin.get(Integer.parseInt(cmbxlOneQuesAns.getSelectedItem().toString()) - 1).getQuestionMark());
        } else {
            JOptionPane.showMessageDialog(splPnlLeft,
                    "Girilen değer 80'den küçük ve eşit olmak zorunda.",
                    "Hata Mesaji",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbxlOneQuesAnsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearYdsTable;
    private javax.swing.JComboBox cmbxlOneQuesAns;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnsOneQues;
    private javax.swing.JLabel lblAnswerCorrectQues;
    private javax.swing.JLabel lblAnswerTotalQues;
    private javax.swing.JLabel lblAnswerWronglQues;
    private javax.swing.JLabel lblCorrectQues;
    private javax.swing.JLabel lblTotalQues;
    private javax.swing.JLabel lblWrongQues;
    private javax.swing.JMenuBar menuBarUst;
    private javax.swing.JPanel splPnlLeft;
    private javax.swing.JSplitPane splPnlMain;
    private javax.swing.JPanel splPnlRight;
    private javax.swing.JTable tblYdsTable;
    // End of variables declaration//GEN-END:variables
}
