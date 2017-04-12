/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suyash
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    static void writeStudentDetails(Student std,boolean newAdmission) throws IOException, ClassNotFoundException{
        String fileName=std.roll;
        fileName+="_det.txt";
        fileName="userdet/"+fileName;
        
        try {
            ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream(fileName));
            outStream.writeObject(std);
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newAdmission){/*
            try {
                ObjectInputStream inStream=new ObjectInputStream(new FileInputStream("userdet/list.txt"));
                StudentList studentListObj= (StudentList) inStream.readObject();
                studentListObj.studentList.add(std.roll);
                try {
                    ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream("userdet/list.txt"));
                    outStream.writeObject(studentListObj);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                        }
                } catch (FileNotFoundException ex) {

        }*/
            try{
                BufferedWriter bw=new BufferedWriter(new FileWriter("userdet/list.txt", true));
                bw.write(std.roll+"\n");
                bw.flush();
                bw.close();
	}catch(IOException ex){
	    System.out.println(ex);
	}
    }
    }
    static Student retrieveStudentRecord(String roll) throws IOException, ClassNotFoundException{
        String fileName=roll;
        fileName+="_det.txt";
        fileName="userdet/"+fileName;
        try {
            ObjectInputStream inStream=new ObjectInputStream(new FileInputStream(fileName));
            Student std= (Student) inStream.readObject();
            return std;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    static void writeHallDetails(Hall hall,boolean newHall) throws IOException, ClassNotFoundException{
        String fileName=hall.hallName;
        fileName+="_det.txt";
        fileName="halldet/"+fileName;
        try {
            ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream(fileName));
            outStream.writeObject(hall);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        if(newHall){
            try{
                BufferedWriter bw=new BufferedWriter(new FileWriter("halldet/list.txt", true));
                bw.write(hall.hallName+"\n");
                bw.flush();
                bw.close();
	}catch(IOException ex){
	    System.out.println(ex);
	}
        }
    }
    
    static Hall retrieveHallData(String hallName) throws IOException, ClassNotFoundException{
        String fileName=hallName;
        fileName+="_det.txt";
        fileName="halldet/"+fileName;
        try {
            ObjectInputStream inStream=new ObjectInputStream(new FileInputStream(fileName));
            Hall hall= (Hall) inStream.readObject();
            return hall;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    static ArrayList<String> getHallList() throws IOException, ClassNotFoundException{
        ArrayList<String> halls = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("halldet/list.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                halls.add(sCurrentLine);
            }
            return halls;
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return null;
    }
    static ArrayList<String> getStudentList() throws IOException, ClassNotFoundException{
        ArrayList<String> students = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("userdet/list.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                students.add(sCurrentLine);
            }
            return students;
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return null;
    }
    static Application getApplicationDetails(String roll) throws IOException, ClassNotFoundException{
        String fileName="";
        fileName="app_"+roll+".txt";
        fileName="adminfiles/"+fileName;
        try {
            ObjectInputStream inStream=new ObjectInputStream(new FileInputStream(fileName));
            Application app= (Application) inStream.readObject();
            return app;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
        }
    static void writeApplicationDetails(Application app,boolean newApplication) throws IOException, ClassNotFoundException{
        String fileName="app_"+app.roll1+".txt";
        fileName="adminfiles/"+fileName;
        try {
            ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream(fileName));
            outStream.writeObject(app);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        if(newApplication){
            try {
                BufferedWriter bw=new BufferedWriter(new FileWriter("adminfiles/app_list.txt", true));
                bw.write(app.roll1+"\n");
                bw.flush();
                bw.close();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
    }
    static ArrayList<String> getApplicationList() throws IOException, ClassNotFoundException{
        ArrayList<String> students = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("adminfiles/app_list.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                students.add(sCurrentLine);
            }
            return students;
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return null;
    }
    static void writeAdminDetails(HmcAdmin admin) throws IOException, ClassNotFoundException{
        try {
            ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream("adminfiles/ADMIN_"+admin.uId+".txt"));
            outStream.writeObject(admin);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
    }
     static HmcAdmin retrieveAdminData(String uId) throws IOException, ClassNotFoundException{
        try {
            ObjectInputStream inStream=new ObjectInputStream(new FileInputStream("adminfiles/ADMIN_"+uId+".txt"));
            HmcAdmin admin= (HmcAdmin) inStream.readObject();
            return admin;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

}

