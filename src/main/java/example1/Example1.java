/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author sdedic
 */
public class Example1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example");
        frame.setLayout(new BorderLayout());
        
        ContactList list = new ContactList();
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(list, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
