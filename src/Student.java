
import java.io.Serializable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suyash
 */
public class Student extends User implements Serializable{
    protected String fName,mName,lName,dob,mailId,contactNo,address,category,guardianName,program,hallName,roomNo,uType,roll;
    char[] password;
    public Student(String[] args,char[] password) {
        super(args[0], args[1]);
        uType=args[0];
        roll=args[1];
        fName=args[2];
        mName=args[3];
        lName=args[4];
        dob=args[5];       //in DD-MM-YYYY format
        mailId=args[6];
        contactNo=args[7];
        address=args[8];
        category=args[9];
        guardianName=args[10];
        program=args[11];
        this.password=password;
                
    }
    public void fillForm(String typeOfForm){
        
    }
    public void fillApplication(){
        //COMPLETE THIS
    }
    
}

