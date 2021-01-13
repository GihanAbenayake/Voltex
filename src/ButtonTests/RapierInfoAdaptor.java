package ButtonTests;

import Units.Humanity.F_Rapier;
import Units.Unit;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RapierInfoAdaptor implements MouseListener {

    JTextArea Events;
    JButton AppliedButton;
    public RapierInfoAdaptor(JTextArea EventLog, JButton button){
        Events = EventLog;
        AppliedButton = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse Click detected");
        F_Rapier DemoRapier = new F_Rapier("RapierDemo", "Rapier");
        Events.append("\n\n"+ DemoRapier.toString());
        AppliedButton.removeMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
