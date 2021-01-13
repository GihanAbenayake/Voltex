package ButtonTests;

import Dice.Dice;
import Dice.D20;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DiceTest implements MouseListener {

    JTextArea Event;
    public DiceTest(JTextArea EventLog){
        Event = EventLog;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Dice D20 = new D20();

        Event.append("\n\n" + D20.Roll());
        Event.append("\n\n" + D20.RollMultipleCombinedResults(4));


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
