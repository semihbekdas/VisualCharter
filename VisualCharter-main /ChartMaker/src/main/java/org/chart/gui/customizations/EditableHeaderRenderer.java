package org.chart.gui.customizations;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class EditableHeaderRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel(value.toString());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial Black", Font.PLAIN, 24));
        label.setBackground(new Color(0x0E5C2F));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        return label;
    }
}