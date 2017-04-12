
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suyash
 */
public class User implements Serializable{
    private String userType,userId;
    public User(String uType, String uId){
        userId=uId;
        userType=uType;
    }
    String getType(){
        return userType;
    }
    
}
