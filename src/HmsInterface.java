

/**
 *
 * @author suyash
 */
    import javax.swing.*;
import javax.swing.UIManager.*;
    import java.awt.*; 
    import java.awt.event.*; 
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HmsInterface extends JFrame{

    /**
     *
     */
   
   private static JTextField nameField,mNameField,lNameField;//dateField,monthField,yearField;
   private static JTextField[] fieldText;
   private static JPasswordField pWord1_Field,pWord2_Field;
   private static char gen;
   private static JComboBox prog,categ;
   private static String programOfStudy,category;
   private static JFrame f;
   private static int dob_date,dob_month,dob_year;
        @SuppressWarnings("unchecked")

   public static void HmsInterface2(){
	try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
    }
        ImageIcon erp_header=new ImageIcon("erp_header.jpg");
        //JPanel f=new JPanel();
        f=new JFrame("ERP Registration- Hall Management System");
        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.setContentPane(pane);
        //f2.add(f);
        //f.getContentPane().setBackground(new Color(191,239,255));
        f.setLayout(new ScrollPaneLayout()); 
        /*JTextArea welcomeMessage= new JTextArea("Welcome to ERP Registartion Page\n Provide your information");
        welcomeMessage.setFont(new Font("Serif", Font.BOLD, 20));
        welcomeMessage.setBounds(300,10,1000,150);          
        welcomeMessage.setLineWrap(true);
        welcomeMessage.setWrapStyleWord(true);
        welcomeMessage.setOpaque(false);
        welcomeMessage.setEditable(false);       
        f.add(welcomeMessage);*/
        JLabel welcomeMessage=new JLabel("",erp_header,JLabel.CENTER);
        welcomeMessage.setBounds(10,5,2000,175);
        f.add(welcomeMessage);
        
        int depth=200;
        int indent=100;
        int width1=150;
        int height1=30;
        
        JLabel name=new JLabel("First Name");
        name.setBounds(indent, depth,width1 ,height1);
        f.add(name);
        nameField=new JTextField();
        nameField.setBounds(indent+100, depth,200,height1);
        f.add(nameField);
        
        JLabel mName=new JLabel("Middle Name");
        mName.setBounds(indent+300, depth,width1 ,height1);
        f.add(mName);
        mNameField=new JTextField();
        mNameField.setBounds(indent+400, depth,200,height1);
        f.add(mNameField);
        
        JLabel lName=new JLabel("Last Name");
        lName.setBounds(indent+600, depth,width1 ,height1);
        f.add(lName);
        lNameField=new JTextField();
        lNameField.setBounds(indent+700, depth,200,height1);
        f.add(lNameField);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(indent, depth+60,width1 ,height1);
        f.add(gender);
        
        JLabel male=new JLabel("Male");
        male.setBounds(indent+100, depth+60,width1 ,height1);
        f.add(male);
                
        JRadioButton radiobutton1, radiobutton2;
        radiobutton1=new JRadioButton();
        radiobutton1.setBounds(indent+150, depth+60,30,40);
        f.add(radiobutton1);
        
        JLabel female=new JLabel("Female");
        female.setBounds(indent+250, depth+60,width1 ,height1);
        f.add(female);        
        radiobutton2=new JRadioButton();
        radiobutton2.setBounds(indent+300, depth+60,30,40);
        f.add(radiobutton2);

        ButtonGroup jb = new ButtonGroup();
        jb.add(radiobutton1);
        jb.add(radiobutton2);
        radiobutton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               gen='M';
            }
        });
        radiobutton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               gen='F';
            }
        });
        
        
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(indent, depth+120,width1 ,height1);
        f.add(dob);  
        
        String[] arr1=new String[32];
        for(int i=1;i<=31;i++)
            arr1[i]=Integer.toString(i);
        arr1[0]="----";
         JComboBox date = new JComboBox(arr1);
        date.setBounds(indent+100, depth+120, 70,30);
        f.add(date);/*
        dateField=new JTextField();
        dateField.setBounds(indent+100, depth+120,40,30);
        f.add(dateField);*/

        JLabel s1,s2;
        s1=new JLabel("/");
        s1.setBounds(indent+150, depth+120,20,30);
        f.add(s1);
        
        String[] arr2={"----","JAN","FEB","MARCH","APRIL","MAY","JUNE","JULY","AUG","SEPT","OCT","NOV","DEC"};
         JComboBox month = new JComboBox(arr2);
        month.setBounds(indent+200, depth+120, 70,30);
        f.add(month);/*
        monthField=new JTextField();
        monthField.setBounds(indent+200, depth+120,40,30);
        f.add(monthField)*/;
            
        s2=new JLabel("/");
        s2.setBounds(indent+250, depth+120,20,30);
        f.add(s2);
        
        
        String[] arr3=new String[22];
        for(int i=1;i<=20;i++)
            arr3[i]=Integer.toString(1984+i);
        arr3[0]="----";
         JComboBox year = new JComboBox(arr3);
        year.setBounds(indent+300, depth+120, 70,30);
        f.add(year);/*
        yearField=new JTextField();
        yearField.setBounds(indent+300, depth+120,40,30);
        f.add(yearField);*/
        
        JLabel ddmmyyy=new JLabel("DD/MM/YYYY");
        ddmmyyy.setBounds(indent+550, depth+120,width1 ,height1);
        f.add(ddmmyyy);
        
        depth+=120;
        String[] otherFields=new String[9];
        otherFields[0]="Allotted Roll No";
        otherFields[1]="E-mail id";
        otherFields[2]="Contact No.";
        otherFields[3]="Guardian's name";
        otherFields[4]="Address Line1";
        otherFields[5]="Address Line2";
        otherFields[6]="City";
        otherFields[7]="District";
        otherFields[8]="State";
         
        JLabel[] fieldLabel=new JLabel[otherFields.length];
        fieldText= new JTextField[otherFields.length];
        int idx=-1;
        
        for(String field: otherFields){
            depth+=40;
            fieldLabel[++idx]=new JLabel(field);
            fieldText[idx]=new JTextField();
            fieldLabel[idx].setBounds(indent, depth, width1, height1);
            fieldText[idx].setBounds(indent+200, depth, width1, height1);
            f.add(fieldLabel[idx]);
            f.add(fieldText[idx]);
        }
        depth+=60;
        JLabel program=new JLabel("Program");
        program.setBounds(indent, depth, width1, height1);
        f.add(program);
        String[] pr={"----","B.Tech(Hons)","M.Tech","Ph.D","MBA","B.Sc"};
        prog=new JComboBox(pr);
        prog.setBounds(indent+200, depth, width1, height1);
        f.add(prog);
        
        depth+=60;
        JLabel categoryLabel=new JLabel("Category");
        categoryLabel.setBounds(indent, depth, width1, height1);
        f.add(categoryLabel);
        String[] cat={"----","GEN.","SC","ST","OBC"};
        categ=new JComboBox(cat);
        categ.setBounds(indent+200, depth, width1, height1);
        f.add(categ);
        
        
        
        JLabel pWord1= new JLabel("Enter a password");
        JLabel pWord2= new JLabel("Retype password");
        
        pWord1_Field= new JPasswordField();
        pWord2_Field= new  JPasswordField();
        
        pWord1.setBounds(indent, depth+60, width1, height1);
        pWord1_Field.setBounds(indent+200, depth+60,width1, height1);
        f.add(pWord1);
        f.add(pWord2);
        f.add(pWord1_Field);
        f.add(pWord2_Field);
        pWord2.setBounds(indent, depth+120, width1, height1);
        pWord2_Field.setBounds(indent+200,depth+120,width1, height1);
        
        JButton register= new JButton("Register");
        register.setBounds(indent+650, depth+180,100,40);
        f.add(register);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                programOfStudy=(String) prog.getSelectedItem();                
                category=(String)categ.getSelectedItem();
                dob_date=date.getSelectedIndex();
                dob_month=month.getSelectedIndex();
                dob_year=year.getSelectedIndex();
                try{
                processData();
                }catch(IOException | ClassNotFoundException exc){
                    System.out.println(exc);
                }
            }
        });
        
        
        JButton back= new JButton("Back");
        back.setBounds(indent+450, depth+180,100,40);
        f.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new IniInterface().main(null);
            }
        });
        
        
        f.setLayout(null);
        //f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //f.setUndecorated(true);
        f.setSize(5000, 5000);
        f.setVisible(true);
        
    }
    
    static void processData() throws IOException, ClassNotFoundException{
         try {
             int flag=0;
             String fName=nameField.getText();
             String mName=mNameField.getText();
             String lName=lNameField.getText();
             char[] password=pWord1_Field.getPassword();
             char[] password_check=pWord2_Field.getPassword();
             
             int date= dob_date;
             int month= dob_month;
             int year= dob_year;
             char gender=gen;
             String program=programOfStudy;
             String roll=fieldText[0].getText();
             String mailId=fieldText[1].getText();
             String contactNo=fieldText[2].getText();
             String guardianName=fieldText[3].getText();
             String address=fieldText[4].getText()+"\n"+fieldText[5].getText()+"\n"+fieldText[6].getText()+"\n"+fieldText[7].getText()+"\n"+fieldText[8].getText();
             
             String dialog="";
             if("".equals(nameField.getText())||" ".equals(nameField.getText())){
                 dialog+=">First name required";
                 flag=1;
             }
             if("".equals(lNameField.getText())||" ".equals(lNameField.getText())){
                 dialog+="\n>Last name required";
                 flag=1;
             }
             if(pWord1_Field.getPassword().length==0){
                 dialog+="\n>Password required";
                 flag=1;
             }
             if(pWord2_Field.getPassword().length ==0){
                 dialog+="\n>Fill password again";
                 flag=1;
             }
             else{
                 if(!(Arrays.equals(password,password_check))){
                     dialog+="\n>Passwords do not match";
                     flag=1;
                 }
             }
             if("----".equals(program)){
                 dialog+="\n>Program required";
                 flag=1;
             }
             if("".equals(fieldText[0].getText())||" ".equals(fieldText[0].getText())||fieldText[0].getText().contains(" ")){
                 dialog+="\n>Roll No invalid";
                 flag=1;
             }
             if(!(fieldText[1].getText().contains("@"))||fieldText[1].getText() == null||" ".equals(fieldText[1].getText())||!(fieldText[1].getText().contains("."))){
                 dialog+="\n>Mail ID invalid";
                 flag=1;
             }
             if(!('F'==gender||'M'==gender)){
                 dialog+="\n>Select gender";
                 flag=1;
             }
             if(date==0 || month==0 || year==0){
                 dialog+="\n>Invalid Date of Birth";
                 flag=1;
             }
             
             /*DATE CHECK*/
             if(date==31&&(month==2||month==4||month==6||month==9||month==11)){
                 dialog+="\n>Invalid Date of Birth";
                 flag=1;
             }
             if(month==2&&(date>28)){
                 dialog+="\n>Invalid Date of Birth";
                 flag=1;
             }
             
             
             if("".equals(address)){
                 dialog+=">Address required";
                 flag=1;
             }

             if(flag==1){
                 JOptionPane.showMessageDialog(f, dialog,"Invalid Inputs",JOptionPane.ERROR_MESSAGE);
                 flag=0;
             }
             else{
                 Object[] options = {"CONFIRM",
                     "GO BACK"};
                 int n = JOptionPane.showOptionDialog(f,"Are you sure the information is correct?\nThis couldn't be edited"
                         + " after submission","Confirmation Required",
                         JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
                 if(n==JOptionPane.YES_OPTION){
                     String[] args=new String[13];
             args[0]="Student";
             args[1]=roll;
             args[2]=fName;
             args[3]=mName;
             args[4]=lName;
             args[5]=Integer.toString(date)+"-"+Integer.toString(month)+"-"+Integer.toString(year);       //in DD-MM-YYYY format
             args[6]=mailId;
             args[7]=contactNo;
             args[8]=address;
             args[9]=category;
             args[10]=guardianName;
             args[11]=program;
             
             Student std=new Student(args, password);
             Database.writeStudentDetails(std, true);
             f.dispose();
                new IniInterface().main(null);
                 }//COMPLETE IT
             }
             
             
             
             
             /* System.out.println(program);
             System.out.println(fName);*/
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(HmsInterface.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    public static void main(String[] args) {
        HmsInterface2();
    }

    
}
