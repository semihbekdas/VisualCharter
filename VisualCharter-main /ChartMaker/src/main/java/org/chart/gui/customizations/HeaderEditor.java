package org.chart.gui.customizations;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderEditor extends MouseAdapter {
    private final JTable table;
    private final JTextField editor;
    private int editingColumn;
    private JTableHeader header;

    public HeaderEditor(JTable table) {
        this.table = table;
        this.editor = new JTextField();
        this.editor.setFont(new Font("Arial Black", Font.PLAIN, 24));
        this.editor.setBackground(new Color(0x0E5C2F));
        this.editor.setForeground(Color.WHITE);
        this.editor.setHorizontalAlignment(JTextField.CENTER);
        this.editor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.header = table.getTableHeader();
        this.header.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = header.columnAtPoint(e.getPoint());
        if (column != -1) {
            editHeader(column);
        }
    }

    private void editHeader(int column) {
        editingColumn = column;
        editor.setText(table.getColumnName(column));
        Rectangle rect = header.getHeaderRect(column);
        editor.setBounds(rect);
        header.add(editor);
        editor.setVisible(true);
        editor.requestFocus();
        editor.selectAll();
        editor.addActionListener(event -> stopEditing());
    }

    private void stopEditing() {
        String text = editor.getText();
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(editingColumn).setHeaderValue(text);
        table.getTableHeader().repaint();
        editor.setVisible(false);
    }
}