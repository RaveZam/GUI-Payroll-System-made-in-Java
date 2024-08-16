import javax.swing.*;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;

public class App extends WindowAdapter implements ActionListener {
     public static JFrame frame,rframe;
     public static JPanel panel,panel2,rPanel,rPanel2,rPanel3,mainpanel;
     public static JLabel background,space1,idlabel,nameLabel,poslabel,workhourlLabel,positionlist,ai,i1,i6,ap1,p1,rid,rid2,rn,rn2,rp,rd,rwh,rttf,raa,rLabel;
     public static JTextField idtextfield,nameTextField,postTextField,workhourtTextField,departmenTextField;
     public static JButton submit,showpos,hidepos,done;
     public static JScrollPane listScroller;
     public static int id,wh,rs = 1250, hc = 750, la = 500, ca = 350,cp = 0,whe,ide;
     public static String name,position,department;
     public static double ttf,aa,gi,p,ph,t,s,td,ni;
     public static Font lato,latoregbig,latoreg,latoregsmall;
     private static final DecimalFormat decfor = new DecimalFormat("0.00");  
     //ImageIcon logo = new ImageIcon(this.getClass().getClassLoader().getResource("dollar.jpg"));
     
    public static void main(String[] args) throws Exception {
   try {
      UIManager.setLookAndFeel( new FlatGruvboxDarkMediumIJTheme() );

      lato = Font.createFont(Font.TRUETYPE_FONT,new File("Lato-Light.ttf")).deriveFont (16F);
      latoregbig = Font.createFont(Font.TRUETYPE_FONT,new File("Lato-Regular.ttf")).deriveFont (16F);
      latoreg = Font.createFont(Font.TRUETYPE_FONT,new File("Lato-Regular.ttf")).deriveFont (15F);
      latoregsmall = Font.createFont(Font.TRUETYPE_FONT,new File("Lato-Regular.ttf")).deriveFont (13F);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Lato-Light.ttf")));
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Lato-Regular.ttf")));
      
    } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
    }
        GUI();
    }
    static void GUI(){

        
        frame = new JFrame();
        frame.setSize(400,450);
        frame.addWindowListener(new App());
        frame.setLocationRelativeTo(null);
        // frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE);
        frame.setTitle("Simple Payroll System");
        frame.setFont(lato);
        frame.setResizable(false);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        idlabel = new JLabel();
        idlabel.setBounds(20,10,50,50);
        idlabel.setText("ID:");
        idlabel.setFont(latoregbig);
        panel.add(idlabel);

        showpos = new JButton("Show Instructions");
        showpos.setBounds(180,350,180,40);
        showpos.setFocusable(false);
        showpos.addActionListener(new App());
        showpos.setFont(lato);  
        panel.add(showpos);

        hidepos = new JButton("Hide Instructions");
        hidepos.setBounds(180,350,180,40);
        hidepos.setFocusable(false);
        hidepos.addActionListener(new App());
        hidepos.setVisible(false);
        hidepos.setFont(lato);  
        panel.add(hidepos);

        panel2 = new JPanel(){

        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          Dimension arcs = new Dimension(15,15);
          int width = getWidth();
          int height = getHeight();
          Graphics2D graphics = (Graphics2D) g;
          graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  
          //Draws the rounded opaque panel with borders.
          graphics.setColor(getBackground());
          graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
          graphics.setColor(getForeground());
          graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
       }
    };  
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        panel2.setBounds(180,10,190,310);
        panel2.setVisible(false);
        panel2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
        panel.add(panel2);

        ai = new JLabel("       !! INSTRUCTIONS !!");
        ai.setFont(latoreg);
        panel2.add(ai);
        
        ai = new JLabel("                ");
        panel2.add(ai);

        ai = new JLabel(" ID:");
        ai.setFont(latoreg);
        panel2.add(ai);

        ai = new JLabel(" You Must Input Numbers only!");
        ai.setFont(latoregsmall);
        panel2.add(ai);

        ai = new JLabel("                ");
        panel2.add(ai);

        positionlist = new JLabel(" Position Titles:");
        positionlist.setFont(latoreg);
        panel2.add(positionlist);

        ai = new JLabel(" Assistant Instructor");
        ai.setFont(latoreg);
        panel2.add(ai);
        i1 = new JLabel(" Instructor 1");
        i1.setFont(latoreg);
       
        panel2.add(i1);
        i6 = new JLabel(" Instructor 6");
        i6.setFont(latoreg);
        
        panel2.add(i6);
        ap1 = new JLabel(" Assistant Professor 1");
        ap1.setFont(latoreg);
       
        panel2.add(ap1);
        p1 = new JLabel(" Professor 1");
        p1.setFont(latoreg);

        panel2.add(p1);

        p1 = new JLabel("            ");

        panel2.add(p1);
 
        p1 = new JLabel(" Department Lists:");
        p1.setFont(latoreg);

        panel2.add(p1);

        p1 = new JLabel(" Engineering");
        p1.setFont(latoreg);
        panel2.add(p1);

        p1 = new JLabel("                 ");
        panel2.add(p1); 

        p1 = new JLabel(" Workhours:");
        p1.setFont(latoreg);
        panel2.add(p1);

        p1 = new JLabel(" Value must not exceed 96 Hours");
        p1.setFont(latoregsmall);
        panel2.add(p1);

        ImageIcon bg = new ImageIcon("tree.png");
        background = new JLabel();
        background.setBounds(50,0,1000,1000);
        background.setIcon(bg);
        background.setOpaque(false);
        panel.add(background);

        idtextfield = new JTextField();
        idtextfield.setBounds(20,45,150,40);
        idtextfield.setFont(latoreg);
        panel.add(idtextfield);

        nameLabel = new JLabel();
        nameLabel.setText("Name :");
        nameLabel.setFont(latoregbig);     
        nameLabel.setBounds(20,70,100,50);
        panel.add(nameLabel);

        nameTextField = new JTextField(); 
        nameTextField.setBounds(20,105,150,40);
        nameTextField.setFont(latoreg);
        panel.add(nameTextField);

        poslabel = new JLabel("Position:");
        poslabel.setBounds(20,130,100,50);
        poslabel.setFont(latoregbig);
        panel.add(poslabel);

        postTextField = new JTextField();
        postTextField.setBounds(20,168,150,40);
        postTextField.setFont(latoreg);
        panel.add(postTextField);

        rLabel = new JLabel("Department: ");
        rLabel.setBounds(20,195,150,50);
        rLabel.setFont(latoregbig);  
        panel.add(rLabel);

        departmenTextField = new JTextField();
        departmenTextField.setBounds(20,230,150,40);
        departmenTextField.setFont(latoreg);
        panel.add(departmenTextField);

        workhourlLabel = new JLabel("Workhour: ");
        workhourlLabel.setBounds(20,255,150,50);
        workhourlLabel.setFont(latoregbig);  
        panel.add(workhourlLabel);

        workhourtTextField = new JTextField();
        workhourtTextField.setBounds(20,290,150,40);
        workhourtTextField.setFont(latoreg);
        panel.add(workhourtTextField);

        submit = new JButton("Submit");
        submit.setBounds(40,350,120,40);
        submit.setFocusable(false);
        submit.setFont(lato);  
        submit.addActionListener(new App());
        panel.add(submit);

        

      

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == showpos){
        panel2.setVisible(true);
        showpos.setVisible(false);
        hidepos.setVisible(true);
        
      }
      if (e.getSource() == hidepos){
        panel2.setVisible(false);
        showpos.setVisible(true);
        hidepos.setVisible(false);
  
      }
      if (e.getSource() == submit){
      String check,check2,check3,check4,check5;
      check = idtextfield.getText();
      check2 = nameTextField.getText();
      check3 = postTextField.getText();
      check4 = departmenTextField.getText();
      check5 = workhourtTextField.getText();
      
      if (check.equals("") && check2.equals("") && check3.equals("") && check4.equals("") && check5.equals("")){
        JOptionPane.showMessageDialog(null,"All Fields are empty Please Fill Up The Following For your Payroll ", "All Fields Empty", JOptionPane.ERROR_MESSAGE);

      }else{


        if (check5.equals("")){
          whe = 1;
          cp = 0;
        }else{
      try {
        wh = Integer.parseInt(workhourtTextField.getText());
        whe  = 0;
        cp++;
      } catch (Exception b) {
        whe = 2;
        cp = 0;
      }
        }

      if (check.equals("")){
        JOptionPane.showMessageDialog(null,"Please Input a ID number ", "Error Empty ID Field", JOptionPane.ERROR_MESSAGE);
        cp = 0;

      }else{
            try {
                id = Integer.parseInt(idtextfield.getText());  
                if (id == 12345){
                  cp++;
                }
                else{
                  JOptionPane.showMessageDialog(null,"Please Input a Valid ID number ", "Error Invalid ID", JOptionPane.ERROR_MESSAGE);
                  cp = 0;
                }
            } catch (Exception a) {
              JOptionPane.showMessageDialog(null,"Please Enter Numerical Numbers ", "Error Invalid ID", JOptionPane.ERROR_MESSAGE);
                cp = 0;
            }
          }

              name = nameTextField.getText();
              if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Your Name ", "Empty Name Field", JOptionPane.ERROR_MESSAGE);
                cp = 0;
              }else{
                cp++;
              }
              position = postTextField.getText();
              if (position.equals("Assistant Instructor") || position.equals("assistant instructor") ){
                ttf = 97 * wh;
                cp++;
              }
              else if (position.equals("Instructor 1") || position.equals("instructor 1")){
                cp++;
                ttf = 120 * wh;
              }
              else if (position.equals("Instructor 6") || position.equals("instructor 6") ){
                ttf = 130 * wh;
                cp++;
              }
              else if (position.equals("Assistant Professor 1") || position.equals("assistant professor 1")){
                ttf = 160 * wh;
                cp++;
              }
              else if (position.equals("Professor 1") || position.equals("professor 1")){
                ttf = 180 * wh;
                cp++;
              }
              else if (position.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Job Position!", "Empty Position Field", JOptionPane.ERROR_MESSAGE); 

                cp = 0;
              }else{
                JOptionPane.showMessageDialog(null, "You Have Entered A Invalid Job Position Please Check For The Job Titles on the Button Beside!", "Invalid Job Position", JOptionPane.ERROR_MESSAGE); 
                cp = 0;
              }
                   department = departmenTextField.getText();
               if (department.equals("Engineering") || department.equals("Engineering ") || department.equals("engineering")){
                   cp++;
                }
                else if(department.equals("")){
                  JOptionPane.showMessageDialog(null, "Please Enter Department Area", "Empty Department", JOptionPane.ERROR_MESSAGE); 
                  cp = 0;
                   }
                 else{
                 JOptionPane.showMessageDialog(null, "You have Entered a Invalid Department", "Invalid Department", JOptionPane.ERROR_MESSAGE); 
                   cp = 0;
                 }
                if (wh > 96){
                     JOptionPane.showMessageDialog(null, "Work Hour per week cannot exceed 24 hours thus you can only input 96 Hours per month", "Workhour Exceeded", JOptionPane.ERROR_MESSAGE);
                     cp = 0;
                     wh = 0;
                 }else{
                    cp++;
                 }
             if (whe == 1){
                JOptionPane.showMessageDialog(null, "Please Enter Amount of hours you have worked this Month", "Empty Hours field", JOptionPane.ERROR_MESSAGE); 
                 }
             if (whe == 2){
                JOptionPane.showMessageDialog(null, "Please Enter Only Numerical Numbers", "Invalid Hours field", JOptionPane.ERROR_MESSAGE); 
                wh = 0;

             }
                     aa = rs + hc + la + ca;                          
                     gi = aa + ttf;
                     p = gi * 0.02;
                     ph = gi * 0.03;
                     t = gi * 0.08;
                     s = gi * 0.05;
                     td = p + ph + t + s;
                     ni = gi - td;
      if (cp >= 6 ){
        receipt();
      }    
    }
   }
    if (e.getSource() == done){
      int a = JOptionPane.showConfirmDialog(null, "Do you want to input another User?", "Payroll", JOptionPane.YES_NO_CANCEL_OPTION);
       if (a == 0){
         rframe.setVisible(false);
         idtextfield.setText("");
         nameTextField.setText("");
         postTextField.setText("");
       departmenTextField.setText("");
       workhourtTextField.setText("");
       wh = 0;
       id = 0;
       
     }else if (a == 1){
       System.exit(0);
     }
     else if (a == 2){
     
     }
    } 
        }
        
     static void receipt(){
            rframe = new JFrame();
            rframe.setLocationRelativeTo(null);
            rframe.setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE);
            rframe.setTitle("Receipt");
            rframe.addWindowListener(new App());
            rframe.setResizable(false);
            rframe.setSize(550,600);

            rPanel2 = new JPanel();
            rPanel2.setLayout(null);
            rframe.add(rPanel2);

  
            rPanel = new JPanel(){

              protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
             }
          };  
            rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.PAGE_AXIS));
            rPanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
            rPanel.setBounds(40,40,250,450);
            
            rPanel2.add(rPanel);

            rPanel3 = new JPanel(){

              protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
             }
          };  
            rPanel3.setLayout(new BoxLayout(rPanel3, BoxLayout.PAGE_AXIS));
            rPanel3.setBounds(300,40,195,450);
            rPanel3.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
            rPanel2.add(rPanel3);

            rid = new JLabel(" ID:");
            rid.setFont(new Font("Arial", Font.PLAIN, 18));
            rPanel.add(rid);

           rn = new JLabel(" Name:");
           rn.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(rn);

           rp = new JLabel(" Position: ");
           rp.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(rp);

           rd = new JLabel(" Department: ");
           rd.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(rd);

           rwh = new JLabel(" Work Hours Rendered: ");
           rwh.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(rwh);

           space1 = new JLabel("            ");
           rPanel.add(space1);
           
           rttf = new JLabel(" Total Teaching Fee:");
           rttf.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(rttf);

           raa = new JLabel(" Additional Allowance: ");
           raa.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(raa);

           space1 = new JLabel("                 ");
           rPanel.add(space1);

           space1 = new JLabel(" Gross Income: ");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel("                    ");
           rPanel.add(space1);
           
           space1 = new JLabel(" Deduction Summary");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel(" Pagibig");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel(" Philhealth");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel(" Tax");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel(" SSS");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel("                    ");
           rPanel.add(space1);

           space1 = new JLabel(" Total Deductions: ");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           space1 = new JLabel("         ");
           rPanel.add(space1);

           space1 = new JLabel(" NetIncome: ");
           space1.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel.add(space1);

           rid = new JLabel();
           rid.setText(" " + String.valueOf(id));
           rid.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rid);

           rLabel = new JLabel();
         
           rLabel.setText(" " + name);
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);
           
           rLabel = new JLabel();
           rLabel.setText(" " + position);
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + department);
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + String.valueOf(wh));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText("            ");
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(ttf)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(aa)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText("================");
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(gi)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText("            ");
           rPanel3.add(rLabel);
           rLabel = new JLabel();
           rLabel.setText("                   ");
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(p)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(ph)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(t)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(s)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText("                  ");
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(td)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText("================");
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           rLabel = new JLabel();
           rLabel.setText(" " + "P" + String.valueOf(decfor.format(ni)));
           rLabel.setFont(new Font("Arial", Font.PLAIN, 18));
           rPanel3.add(rLabel);

           done = new JButton("Done ");
           done.addActionListener(new App());
           done.setBounds(200,500,120,50);
           done.setFocusable(false);
           rPanel2.add(done);

           ImageIcon bg = new ImageIcon("tree.png");
            background = new JLabel();
            background.setIcon(bg);
            background.setBounds(-100,10,700,1100);
            rPanel2.add(background);

            rframe.setVisible(true);
     }
     public void windowClosing(WindowEvent e) {
      if (e.getSource() == frame){
      int a = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
      if (a== 0){
        System.exit(0);   
      }else if (a== 1){
       
      }
    }else if (e.getSource() == rframe){
      int a = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
      if (a== 0){
        rframe.setVisible(false);
      }else if (a== 1){
       
      }


    }
  }
}
