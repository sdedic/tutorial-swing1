/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example1;

import java.util.List;

/**
 *
 * @author sdedic
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String title;
    private String nickName;
    private List<String> emails;
    private String defaultEmail;
    private MailFormat mailFormat = MailFormat.HTML;
    private DisplayFormat displayFormat = DisplayFormat.NickFirstLast;
    
    public enum MailFormat {
        HTML,
        PlainText,
        Custom
    }
    
    public enum DisplayFormat {
        NickFirstLast,
        NickLastFirst,
        LastFirst
    }

    public MailFormat getMailFormat() {
        return mailFormat;
    }

    public void setMailFormat(MailFormat mailFormat) {
        this.mailFormat = mailFormat;
    }

    public DisplayFormat getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(DisplayFormat displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String getDefaultEmail() {
        return defaultEmail;
    }

    public void setDefaultEmail(String defaultEmail) {
        this.defaultEmail = defaultEmail;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

}
