/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import org.json.Cookie;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sdedic
 */
public class JSonReadWrite {
    public static Contact readContact(JSONObject object) {
        Contact c = new Contact();
        c.setFirstName(object.getString("firstName"));
        c.setLastName(object.getString("lastName"));
        if (object.has("lastName")) {
            c.setLastName(object.getString("lastName"));
        }
        if (object.has("title")) {
            c.setTitle(object.getString("title"));
        }
        if (object.has("mailFormat")) {
            c.setMailFormat(Contact.MailFormat.valueOf(object.getString("mailFormat")));
        }
        if (object.has("displayFormat")) {
            c.setDisplayFormat(Contact.DisplayFormat.valueOf(object.getString("displayFormat")));
        }
        if (object.has("defaultEmail")) {
            c.setDefaultEmail(object.getString("defaultEmail"));
        }
        return c;
    }
    
    public static JSONObject saveContact(Contact c) {
        JSONObject jo = new JSONObject();
        jo.put("firstName", c.getFirstName());
        jo.put("lastName", c.getFirstName());
        if (c.getNickName() != null) {
            jo.put("nickName", c.getNickName());
        }
        if (c.getTitle() != null) {
            jo.put("title", c.getTitle());
        }
        jo.put("mailFormat", c.getMailFormat().name());
        jo.put("displayFormat", c.getDisplayFormat().name());
        if (c.getDefaultEmail()!= null) {
            jo.put("defaultEmail", c.getDefaultEmail());
        }
        return jo;
    }
    
    public static void saveContactList(Path p, List<Contact> list) throws IOException {
        JSONArray a = new JSONArray();
        list.forEach((c) -> a.put(saveContact(c)));
        JSONObject o = new JSONObject();
        o.put("list", a);
        Files.writeString(p, o.toString(2), 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
    }
    
    public static List<Contact> readContactList(JSONArray array) {
        List<Contact> list = new ArrayList<>();
        array.forEach((jo) -> {
            list.add(readContact((JSONObject)jo));
        });
        return list;
    }
    
    public static List<Contact> readContactList(Path p) throws IOException {
        return 
            readContactList(
                new JSONObject(Files.readString(p))
                .getJSONArray("list")
            );
    }
}
