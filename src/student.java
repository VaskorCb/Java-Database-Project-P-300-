
import com.mysql.cj.Query;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class student extends javax.swing.JFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet resultSet = null;

    /**
     * Creates new form student
     */
    public student() {
        initComponents();
        init();
        connection = Javadbclass.dbclass();
        updateStudentDetails();
        updatestudentdetailsSevenInfo();
        updatestudentdetailsEightInfo();
        updatestudentdetailsNineInfo();
        updatestudentdetailsTenInfo();
        currentDate();
        currentTime();
        
    }

    public void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void close() {
        WindowEvent winClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvnt);

    }

    public void updateStudentDetails() {
        try {
            String sql3 = "Select Roll,Name,Fathers_Name,Mother_Name,Class,Section,"
                    + "BG,GROUP_Name from studentdetails";
            pst = connection.prepareStatement(sql3);
            resultSet = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
            // jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
            //  jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    public void updatestudentdetailsSevenInfo() {
        try {
            String sql = "select Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name from seven";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            //  jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
            jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
            //  jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }

    }

    public void updatestudentdetailsEightInfo() {
        try {
            String sql = "select Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name from eight";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            //  jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
            // jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
            jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }
    }

    public void updatestudentdetailsNineInfo() {
        try {
            String sql = "select Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name from nine";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            //  jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
            jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
            //  jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }

    }

    public void updatestudentdetailsTenInfo() {
        try {
            String sql = "select Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name from ten";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            //  jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
            jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
            //  jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }
    }
     private Image scaledImage(byte[] img,int w,int h){
        BufferedImage resizedImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        try{
        Graphics2D g2=resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        //Convert Byte Image Back to buffered Image
        ByteArrayInputStream in=new  ByteArrayInputStream(img);
        
         BufferedImage bImageFromConvert=ImageIO.read(in);
         g2.drawImage(bImageFromConvert,0,0,w,h,null);
         g2.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        return resizedImage;
         
        
        
        
    }
     
  
         

    public void currentDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        date.setText("Current Date: " + day + "/" + (month + 1) + "/" + year);
        date.setForeground(Color.BLUE);

    }

    public void currentTime() {
        Calendar cal = new GregorianCalendar();
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        time.setText("Current Time: " + hour + ":" + (minute) + ":" + second);
        time.setForeground(Color.red);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentfname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        admissionroll = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        gurdiansname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        adclass = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        adress = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        picture = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        close = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        date = new javax.swing.JMenu();
        time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel10.setText("The Aided High School Databse System");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Action Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Algerian", 1, 14), new java.awt.Color(153, 204, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Name :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Roll :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fathers Name:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mother Name:");

        adclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adclassActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Class:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Section: ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BG:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Group Name:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Science", "Arts", "Commerce" }));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Photo :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 151, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(studentfname)
                                    .addComponent(admissionroll)
                                    .addComponent(gurdiansname)
                                    .addComponent(adclass)
                                    .addComponent(adress)
                                    .addComponent(jComboBox2, 0, 126, Short.MAX_VALUE)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admissionroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(gurdiansname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(adclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b.png"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(442, 442, 442))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel6.setText("Student Details");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database.png"))); // NOI18N
        jButton1.setText("ADD      ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear_118917.png"))); // NOI18N
        jButton4.setText("Clear  ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search By");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roll", "Name", "Fathers Name", "Mothers Name", "Class", "Sec", "BG", "Group Name" }));

        jTextField6.setText("Search.....");
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("      Six      ", jPanel6);

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database.png"))); // NOI18N
        jButton5.setText("ADD      ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jButton6.setText("Delete");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear_118917.png"))); // NOI18N
        jButton8.setText("Clear  ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search By");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roll", "Name", "Fathers Name", "Mothers Name", "Class", "Sec", "BG", "Group Name" }));

        jTextField7.setText("Search.....");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("      Seven      ", jPanel7);

        jTable3.setBorder(new javax.swing.border.MatteBorder(null));
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database.png"))); // NOI18N
        jButton9.setText("ADD      ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jButton10.setText("Delete");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear_118917.png"))); // NOI18N
        jButton12.setText("Clear  ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search By");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roll", "Name", "Fathers Name", "Mothers Name", "Class", "Sec", "BG", "Group Name" }));

        jTextField8.setText("Search.....");
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("      eight      ", jPanel8);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jTable4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable4KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database.png"))); // NOI18N
        jButton13.setText("ADD      ");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jButton14.setText("Delete");
        jButton14.setBorder(null);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear_118917.png"))); // NOI18N
        jButton16.setText("Clear  ");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTextField4.setText("Search.....");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search By");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roll", "Name", "Fathers Name", "Mothers Name", "Class", "Sec", "BG", "Group Name" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("      nine      ", jPanel9);

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
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable5KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database.png"))); // NOI18N
        jButton17.setText("ADD      ");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jButton18.setText("Delete");
        jButton18.setBorder(null);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton19.setText("Update");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear_118917.png"))); // NOI18N
        jButton20.setText("Clear  ");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search By");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roll", "Name", "Fathers Name", "Mothers Name", "Class", "Sec", "BG", "Group Name" }));

        jTextField9.setText("Search.....");
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("      ten      ", jPanel5);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconfinder.png"))); // NOI18N
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jMenu1.add(close);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText(" Help ");
        jMenuBar1.add(jMenu3);

        jMenu4.setText(" About  ");

        jMenuItem1.setText("Details");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        date.setText(" Date ");
        jMenuBar1.add(date);

        time.setText(" Time ");
        jMenuBar1.add(time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTabbedPane1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        close();
        dispose();
        Activity obj = new Activity();
        obj.setVisible(true);
    }//GEN-LAST:event_closeActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void adclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adclassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adclassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sql = "insert into studentdetails (Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name )values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, admissionroll.getText());
            pst.setString(2, studentfname.getText());
            pst.setString(3, gurdiansname.getText());
            pst.setString(4, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(5, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(6, combo2);
            pst.setString(7, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(8, combo3);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        updateStudentDetails();
        //updatestudentdetailsStrtInfo();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        studentfname.setText(null);
        studentfname.setText(null);
        gurdiansname.setText(null);
        adclass.setText(null);
        //vvvvv.setText(null);
        // age.setText(null);
        adress.setText(null);
        // ovick.setText(null);
        admissionroll.setText(null);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really Want To Delete ?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from studentdetails where Roll=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, admissionroll.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);

            }

        }
        updateStudentDetails();
        // updatestudentdetailsSevenInfo();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        String sql = "update studentdetails set Name=?,Fathers_Name=?,Mother_Name=?,Class=?,Section=?,BG=?,GROUP_Name=? where Roll=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, studentfname.getText());
            pst.setString(2, gurdiansname.getText());
            pst.setString(3, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(4, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(5, combo2);

            pst.setString(6, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(7, combo3);
            pst.setString(8, admissionroll.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
        updateStudentDetails();
        //  updatestudentdetailsSevenInfo();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:

        try {
            int row = jTable1.getSelectedRow();
            String tableClick = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from studentdetails where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        try {
            int row = jTable1.getSelectedRow();
            String tableClick = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from studentdetails where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                 byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);


            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        String sql = "insert into seven (Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name )values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, admissionroll.getText());
            pst.setString(2, studentfname.getText());
            pst.setString(3, gurdiansname.getText());
            pst.setString(4, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(5, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(6, combo2);
            pst.setString(7, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(8, combo3);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        //updateStudentDetails();
        updatestudentdetailsSevenInfo();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really Want To Delete ?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from seven where Roll=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, admissionroll.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);

            }

        }
        // updateStudentDetails();
        updatestudentdetailsSevenInfo();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String sql = "update seven set Name=?,Fathers_Name=?,Mother_Name=?,Class=?,Section=?,BG=?,GROUP_Name=? where Roll=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, studentfname.getText());
            pst.setString(2, gurdiansname.getText());
            pst.setString(3, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(4, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(5, combo2);

            pst.setString(6, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(7, combo3);
            pst.setString(8, admissionroll.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
        //  updateStudentDetails();
        updatestudentdetailsSevenInfo();


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        studentfname.setText(null);
        studentfname.setText(null);
        gurdiansname.setText(null);
        adclass.setText(null);
        //vvvvv.setText(null);
        // age.setText(null);
        adress.setText(null);
        // ovick.setText(null);
        admissionroll.setText(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        try {
            int row = jTable2.getSelectedRow();
            String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from seven where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                 byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);


            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
        // TODO add your handling code here:
        try {
            int row = jTable2.getSelectedRow();
            String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from seven where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                 byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);


            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_jTable2KeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        String sql = "insert into eight (Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name )values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, admissionroll.getText());
            pst.setString(2, studentfname.getText());
            pst.setString(3, gurdiansname.getText());
            pst.setString(4, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(5, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(6, combo2);
            pst.setString(7, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(8, combo3);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        updatestudentdetailsEightInfo();

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really Want To Delete ?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from eight where Roll=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, admissionroll.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);

            }

        }
        updatestudentdetailsEightInfo();;

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String sql = "update eight set Name=?,Fathers_Name=?,Mother_Name=?,Class=?,Section=?,BG=?,GROUP_Name=? where Roll=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, studentfname.getText());
            pst.setString(2, gurdiansname.getText());
            pst.setString(3, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(4, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(5, combo2);

            pst.setString(6, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(7, combo3);
            pst.setString(8, admissionroll.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
        updatestudentdetailsEightInfo();;

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        studentfname.setText(null);
        studentfname.setText(null);
        gurdiansname.setText(null);
        adclass.setText(null);
        //vvvvv.setText(null);
        // age.setText(null);
        adress.setText(null);
        // ovick.setText(null);
        admissionroll.setText(null);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTable3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyReleased
        // TODO add your handling code here:

        try {
            int row = jTable3.getSelectedRow();
            String tableClick = (jTable3.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from eight where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_jTable3KeyReleased

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        try {
            int row = jTable3.getSelectedRow();
            String tableClick = (jTable3.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from eight where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String sql = "insert into nine (Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name )values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, admissionroll.getText());
            pst.setString(2, studentfname.getText());
            pst.setString(3, gurdiansname.getText());
            pst.setString(4, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(5, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(6, combo2);
            pst.setString(7, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(8, combo3);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        updatestudentdetailsNineInfo();;

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really Want To Delete ?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from nine where Roll=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, admissionroll.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);

            }

        }
        updatestudentdetailsNineInfo();;

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:

        String sql = "update nine set Name=?,Fathers_Name=?,Mother_Name=?,Class=?,Section=?,BG=?,GROUP_Name=? where Roll=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, studentfname.getText());
            pst.setString(2, gurdiansname.getText());
            pst.setString(3, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(4, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(5, combo2);

            pst.setString(6, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(7, combo3);
            pst.setString(8, admissionroll.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
        updatestudentdetailsNineInfo();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        studentfname.setText(null);
        studentfname.setText(null);
        gurdiansname.setText(null);
        adclass.setText(null);
        //vvvvv.setText(null);
        // age.setText(null);
        adress.setText(null);
        // ovick.setText(null);
        admissionroll.setText(null);


    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTable4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable4KeyReleased
        // TODO add your handling code here:
        try {
            int row = jTable4.getSelectedRow();
            String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from nine where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_jTable4KeyReleased

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        try {
            int row = jTable4.getSelectedRow();
            String tableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from nine where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
         String sql = "insert into ten (Roll,Name,Fathers_Name,Mother_Name,Class,Section,BG,GROUP_Name )values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, admissionroll.getText());
            pst.setString(2, studentfname.getText());
            pst.setString(3, gurdiansname.getText());
            pst.setString(4, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(5, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(6, combo2);
            pst.setString(7, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(8, combo3);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
            updatestudentdetailsTenInfo();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
         int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really Want To Delete ?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from ten where Roll=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, admissionroll.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);

            }
        }
            updatestudentdetailsTenInfo();;

        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
          String sql = "update ten set Name=?,Fathers_Name=?,Mother_Name=?,Class=?,Section=?,BG=?,GROUP_Name=? where Roll=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, studentfname.getText());
            pst.setString(2, gurdiansname.getText());
            pst.setString(3, adclass.getText());
            String combo = jComboBox1.getSelectedItem().toString();
            pst.setString(4, combo);
            String combo2 = jComboBox2.getSelectedItem().toString();
            pst.setString(5, combo2);

            pst.setString(6, adress.getText());
            String combo3 = jComboBox3.getSelectedItem().toString();
            pst.setString(7, combo3);
            pst.setString(8, admissionroll.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
            updatestudentdetailsTenInfo();;
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        studentfname.setText(null);
        studentfname.setText(null);
        gurdiansname.setText(null);
        adclass.setText(null);
        //vvvvv.setText(null);
        // age.setText(null);
        adress.setText(null);
        // ovick.setText(null);
        admissionroll.setText(null);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
          try {
            int row = jTable5.getSelectedRow();
            String tableClick = (jTable5.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from ten where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

        
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyReleased
        // TODO add your handling code here:
          try {
            int row = jTable5.getSelectedRow();
            String tableClick = (jTable5.getModel().getValueAt(row, 0).toString());
            String sql = "Select* from ten where Roll='" + tableClick + "'";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                admissionroll.setText(resultSet.getString("Roll"));
                studentfname.setText(resultSet.getString("Name"));
                gurdiansname.setText(resultSet.getString("Fathers_Name"));
                adclass.setText(resultSet.getString("Mother_Name"));
                // ad_year.setText(resultSet.getString("Add_year"));
                // age.setText(resultSet.getString("Age"));
                adress.setText(resultSet.getString("BG"));
                byte[]imageData=resultSet.getBytes("Photo");
                ImageIcon format =new ImageIcon(scaledImage(imageData,picture.getWidth(),picture.getHeight()));
                picture.setIcon(format);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

        
    }//GEN-LAST:event_jTable5KeyReleased

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        close();
        dispose();
        Activity obj = new Activity();
        obj.setVisible(true);
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
         close();
        dispose();
        Log_in obj = new  Log_in();
        obj.setVisible(true);
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        
          String s = (String)jComboBox4.getSelectedItem();
            if("Roll".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Roll LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Name".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Fathers Name".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Fathers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Mothers Name".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Mothers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Class".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Class LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
             else if("Sec".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where Section LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("BG".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where BG LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Group Name".equals(s)){
                String tf=jTextField4.getText();
                try{
                    String query = "Select * from nine Where GROUP_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable4.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
        
        
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
      
               
           
          // String query = "null";
            String s = (String)jComboBox5.getSelectedItem();
            if("Roll".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Roll LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Name".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Fathers Name".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Fathers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Mothers Name".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Mothers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Class".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Class LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
             else if("Sec".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where Section LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("BG".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where BG LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Group Name".equals(s)){
                String tf=jTextField6.getText();
                try{
                    String query = "Select * from studentdetails Where GROUP_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
                
               
                
                
          
            
            
          
           
           
           
           
           
           
      
        
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        
         String s = (String)jComboBox6.getSelectedItem();
            if("Roll".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Roll LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Name".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Fathers Name".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Fathers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Mothers Name".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Mothers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Class".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Class LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
             else if("Sec".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where Section LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("BG".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where BG LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Group Name".equals(s)){
                String tf=jTextField7.getText();
                try{
                    String query = "Select * from seven Where GROUP_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable2.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
                
        
        
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        
         String s = (String)jComboBox7.getSelectedItem();
            if("Roll".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Roll LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Name".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Fathers Name".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Fathers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Mothers Name".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Mothers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Class".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Class LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
             else if("Sec".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where Section LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("BG".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where BG LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Group Name".equals(s)){
                String tf=jTextField8.getText();
                try{
                    String query = "Select * from eight Where GROUP_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable3.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
        
        
        
        
        
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
         String s = (String)jComboBox8.getSelectedItem();
            if("Roll".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Roll LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Name".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Fathers Name".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Fathers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Mothers Name".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Mothers_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Class".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Class LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
             else if("Sec".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where Section LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("BG".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where BG LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
            else if("Group Name".equals(s)){
                String tf=jTextField9.getText();
                try{
                    String query = "Select * from ten Where GROUP_Name LIKE '%"+tf+"%'";
                    pst = connection.prepareStatement(query);
                    resultSet = pst.executeQuery();
                    jTable5.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                }finally{
                    try{
                        if(pst!=null) {
                            resultSet.close();
                            pst.close();
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
        
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         
        dispose();
        About obj=new About();
        obj.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adclass;
    private javax.swing.JTextField admissionroll;
    private javax.swing.JTextField adress;
    private javax.swing.JMenuItem close;
    private javax.swing.JMenu date;
    private javax.swing.JTextField gurdiansname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField studentfname;
    private javax.swing.JMenu time;
    // End of variables declaration//GEN-END:variables
}
