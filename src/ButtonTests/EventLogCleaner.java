package ButtonTests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventLogCleaner implements MouseListener {
    private final JTextArea Event;
    private final Container Container;
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
        if(Event.getLineCount() >= 35){
            Event.setText(" Log was Cleared");
            Container.validate();
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(Event.getLineCount() >= 35){
            Event.setText(" Log was Cleared");
            Container.validate();
        }

    }
}
