package ButtonTests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventLogCleaner implements MouseListener {
    private JTextArea Event;
    private Container Container;
    public  EventLogCleaner(JTextArea EventLog, Container cont){
        Event = EventLog;
        Container = cont;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Line Count " + Event.getLineCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(Event.getLineCount() >= 29){
            Event.setText(" Log was Cleared");
            Container.validate();
        }else{

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(Event.getLineCount() >= 29){
            Event.setText(" Log was Cleared");
            Container.validate();
        }else{

        }

    }
}