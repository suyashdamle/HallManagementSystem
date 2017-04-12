
import java.io.IOException;
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
public class Application implements Serializable{
    String applicationText,applicationType,roll1,roll2,type;
    boolean isVerified;
    String toHall,toRoom;
 
    public Application(String roll1,String roll2,String applicationText) throws IOException, ClassNotFoundException{
        this.roll2 = roll2;
        this.applicationText = applicationText;
        this.roll1 = roll1;
        Application app2= Database.getApplicationDetails(roll2);
        if(app2!=null && (app2.roll2).equals(roll1)){
            app2.isVerified=true;
            isVerified=true;
            Database.writeApplicationDetails(app2, false);
        }
        else{
            isVerified=false;
        }
        type="swap";
        
    }

    /**
     *
     * @param roll1
     * @param toHall
     * @param toRoom
     * @param applicationText
     */
    public Application(String roll1,String toHall,String toRoom,String applicationText){
        this.roll1 = roll1;
        this.toHall = toHall;
        this.toRoom = toRoom;
        roll2=null;
        type="change";
        this.applicationText = applicationText;
    }
    
}
