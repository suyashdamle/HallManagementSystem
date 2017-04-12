
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suyash
 */
public class Hall implements Serializable{
    public String hallName;
    private ArrayList<String> blocks;
    private ArrayList<String> rooms;
    public Map<String,ArrayList<String>> roomsInHall;
    public Hall(String hallName,ArrayList<String>blocks,ArrayList<String> rooms){
        this.roomsInHall = new HashMap<String, ArrayList<String>>();
        this.hallName = hallName;
        this.blocks = blocks;
        this.rooms = rooms;
        for(String block:blocks){
            for(String room:rooms){
                ArrayList<String> occupants=new ArrayList<String>();
                boolean success = occupants.add("");
                String combination=block+"  "+room;
                System.out.println(combination);
                ArrayList<String> put = roomsInHall.put(combination, occupants);
            }
        }
        
    }
    void addBoarder(String roll,String room){
        boolean success = roomsInHall.get(room).add(roll);
    }
    String addBoarder(String roll){
        for(String room:roomsInHall.keySet()){
            if(roomsInHall.get(room).size()<4){
                addBoarder(roll, room);
                return room;
            }
        }
        return null;
    }
    void removeBoarder(String roll,String room){
        boolean success = roomsInHall.get(room).remove(roll);
    }
}
class HallList implements Serializable{
    List<String> hallList;
}
