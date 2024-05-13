package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This class is to enable key events.
 */
public abstract class ListenerPanel extends JPanel {
    public ListenerPanel() {
        enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.setFocusable(true);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> doMoveRight();
                case KeyEvent.VK_LEFT -> doMoveLeft();
                case KeyEvent.VK_UP -> doMoveUP();
                case KeyEvent.VK_DOWN -> doMoveDown();
                //todo: complete other move event
            }
        }
    }


    public abstract void doMoveRight();

    public abstract void doMoveLeft();

    public abstract void doMoveUP();

    public abstract void doMoveDown();

}
