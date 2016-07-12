package com.tjmaco.macoMessage.Domains;

/**
 * Created by thomasmaco on 11/26/15.
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Group {

    @Id
    private String id;
    private String groupName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
//
//    public String getContactID(){
//        return contactID;
//    }
//
//    public void setContactID(String contactID){
//        this.contactID = contactID;
//    }
}
