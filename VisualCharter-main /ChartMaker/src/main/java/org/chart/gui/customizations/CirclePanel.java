package org.chart.gui.customizations;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CirclePanel extends JPanel {
    private URL iconURL;
    private ImageIcon imageIcon;

    public CirclePanel(URL iconURL) {
        this.iconURL = iconURL;

        setOpaque(false);
        imageIcon = new ImageIcon(iconURL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int diameter = Math.min(width, height);

        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        if (imageIcon != null) {
            int imageWidth = imageIcon.getIconWidth();
            int imageHeight = imageIcon.getIconHeight();
            int imageX = x + (diameter - imageWidth) / 2;
            int imageY = y + (diameter - imageHeight) / 2;
            g.drawImage(imageIcon.getImage(), imageX, imageY, this);
        }
    }
}