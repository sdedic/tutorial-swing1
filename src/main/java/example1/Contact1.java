/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 *
 * @author sdedic
 */
public class Contact1 {
    private String firstName;
    private String lastName;
    private String title;
    private String nickName;
    private List<String> emails;
    private String defaultEmail;
    private MailFormat mailFormat = MailFormat.HTML;
    private DisplayFormat displayFormat = DisplayFormat.NickFirstLast;
    
    
        private int age;

    public static final String PROP_AGE = "age";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        propertyChangeSupport.firePropertyChange(PROP_AGE, oldAge, age);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

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
