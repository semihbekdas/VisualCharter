package org.chart.gui.customizations;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMouseListenerMenu implements MouseListener {
    JButton button;
    JLabel label;

    public ButtonMouseListenerMenu(JButton button, JLabel label) {
        this.button = button;
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        button.setContentAreaFilled(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.setContentAreaFilled(false);
        label.setOpaque(true);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setContentAreaFilled(false);
        label.setOpaque(false);
    }

    public void mouseEntered(MouseEvent e) {
        button.setContentAreaFilled(true);

    }

    public void mouseExited(MouseEvent e) {
        button.setContentAreaFilled(false);
    }
}