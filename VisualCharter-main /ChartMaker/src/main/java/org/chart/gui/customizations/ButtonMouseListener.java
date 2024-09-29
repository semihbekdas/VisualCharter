package org.chart.gui.customizations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMouseListener implements MouseListener {
    private JButton button;
    private JLabel label;

    public ButtonMouseListener(JButton button, JLabel label){
        this.button = button;
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setOpaque(false);
        button.setContentAreaFilled(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setOpaque(true);
        button.setContentAreaFilled(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setBackground(new Color(0x217346));
        button.setContentAreaFilled(true);
    }

    public void mouseEntered(MouseEvent e) {
        button.setBackground(new Color(0x0E5C2F));
    }

    public void mouseExited(MouseEvent e) {
        button.setBackground(new Color(0x217346));
    }
}