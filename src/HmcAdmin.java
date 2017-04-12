
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suyash
 */
public class HmcAdmin extends User implements Serializable{
    String uId;
    char[] password;
    static void changeRoom(String roll,String toHall,String toRoom) throws IOException, ClassNotFoundException{
        Student applicant=Database.retrieveStudentRecord(roll);
        String fromHall=applicant.hallName;
        String fromRoom=applicant.roomNo;
        Hall fromHallobj=Database.retrieveHallData(fromHall);
        Hall toHallobj=Database.retrieveHallData(toHall);
        fromHallobj.removeBoarder(roll, fromRoom);
        toHallobj.addBoarder(roll, toRoom);        
        
        Database.writeStudentDetails(applicant,false);
        
    }
    static void swapRoom(String roll1,String roll2) throws IOException, ClassNotFoundException{
        Student applicant1=Database.retrieveStudentRecord(roll1);
        Student applicant2=Database.retrieveStudentRecord(roll2);
        Hall hall1=Database.retrieveHallData(applicant1.hallName);
        Hall hall2=Database.retrieveHallData(applicant2.hallName);
        hall1.removeBoarder(roll1, applicant1.roomNo);
        hall2.removeBoarder(roll2, applicant2.roomNo);
        
        hall1.addBoarder(roll2, applicant1.roomNo);
        hall2.addBoarder(roll1, applicant2.roomNo);
        
        String room1_temp=applicant1.roomNo;
        String hall1_temp=applicant1.hallName;
        
        applicant1.roomNo=applicant2.roomNo;
        applicant1.hallName=applicant2.hallName;
        
        applicant2.roomNo=room1_temp;
        applicant2.hallName=hall1_temp;
                       
        Database.writeStudentDetails(applicant2,false);
        Database.writeStudentDetails(applicant1,false);
        
    }
    
    void initializeHall(String hallName, ArrayList<String>blocks,ArrayList<String> rooms) throws IOException, ClassNotFoundException{
        Hall newHall=new Hall(hallName,blocks,rooms);
        Database.writeHallDetails(newHall,false);
        
    }
    static void doAllocation() throws IOException, ClassNotFoundException{
        List<String> stdList=Database.getStudentList();
        List<String> hallList=Database.getHallList();
        Random randomizer;
        for(String roll:stdList){
            String roomNo=null;Hall hallAllocated=null;
            while(roomNo==null){                             //WARNING: IN CASE ALL HALLS ARE FULL, THIS BECOMES AN INFINITE LOOP....ONLY FOR DEMONSTRATION PURPOSE
                randomizer = new Random();
                String hallName = hallList.get(randomizer.nextInt(hallList.size()));  
                Hall hall=Database.retrieveHallData(hallName);
                hallAllocated=hall;
                roomNo=hall.addBoarder(roll);
                if(roomNo!=null)
                    Database.writeHallDetails(hall, false);
            }
            if(hallAllocated!=null){
                Student std=Database.retrieveStudentRecord(roll);
                std.roomNo=roomNo;
                std.hallName=hallAllocated.hallName;
                Database.writeStudentDetails(std, false);
            }
        }
    }

    public HmcAdmin(String uId,char[] password) {
        super("ADMIN", uId);
        this.uId=uId;
        this.password = password;
    }
}
