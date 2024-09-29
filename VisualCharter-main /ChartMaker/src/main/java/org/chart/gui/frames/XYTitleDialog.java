package org.chart.gui.frames;

import org.chart.gui.customizations.ButtonMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class XYTitleDialog extends JDialog implements ActionListener {
    JButton buttonCreate;
    JButton buttonCancel;

    JTextField textFieldXAxis;
    JTextField textFieldYAxis;

    private boolean gotoChartFile = false;

    public XYTitleDialog(Frame parent) {
        super(parent, "Enter X-Y Title", true);

        URL iconURL = getClass().getResource("/icon.png");
        assert iconURL != null;
        ImageIcon icon  = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());

        URL labelTextfieldURL = getClass().getResource("/greenChartTitle.png");
        ImageIcon labelTextfield = null;
        if (labelTextfieldURL == null) {
            System.err.println("Resource not found: /greenChartTitle.png");
        } else {
            labelTextfield = new ImageIcon(labelTextfieldURL);
        }

        JLabel labelTextfieldXAxis = new JLabel();
        labelTextfieldXAxis.setIcon(labelTextfield);
        labelTextfieldXAxis.setBounds(60, 20, 160, 34);
        labelTextfieldXAxis.setText("X Axis Title");
        labelTextfieldXAxis.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldXAxis.setForeground(Color.WHITE);
        labelTextfieldXAxis.setHorizontalTextPosition(JLabel.CENTER);

        textFieldXAxis = new JTextField("X Axis Title");
        textFieldXAxis.setBounds(40, 44, 300, 40);
        textFieldXAxis.setBackground(new Color(0x363636));
        textFieldXAxis.setForeground(Color.WHITE);
        textFieldXAxis.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldXAxis.setCaretColor(new Color(0xC9C9C9));
        textFieldXAxis.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelTextfieldYAxis = new JLabel();
        labelTextfieldYAxis.setIcon(labelTextfield);
        labelTextfieldYAxis.setBounds(400, 20, 160, 34);
        labelTextfieldYAxis.setText("Y Axis Title");
        labelTextfieldYAxis.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldYAxis.setForeground(Color.WHITE);
        labelTextfieldYAxis.setHorizontalTextPosition(JLabel.CENTER);

        textFieldYAxis = new JTextField("Y Axis Title");
        textFieldYAxis.setBounds(380, 44, 300, 40);
        textFieldYAxis.setBackground(new Color(0x363636));
        textFieldYAxis.setForeground(Color.WHITE);
        textFieldYAxis.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldYAxis.setCaretColor(new Color(0xC9C9C9));
        textFieldYAxis.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelButtonEffectCreate = new JLabel();
        labelButtonEffectCreate.setBounds(380, 104, 300, 40);
        labelButtonEffectCreate.setBackground(new Color(0x363636));
        labelButtonEffectCreate.setOpaque(false);

        buttonCreate = new JButton("Create");
        buttonCreate.setBackground(new Color(0x217346));
        buttonCreate.setBounds(380, 104, 300, 40);
        buttonCreate.setFocusable(false);
        buttonCreate.setForeground(Color.WHITE);
        buttonCreate.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonCreate.addActionListener(this);
        buttonCreate.setBorderPainted(false);
        buttonCreate.addMouseListener(new ButtonMouseListener(buttonCreate, labelButtonEffectCreate));

        JLabel labelButtonEffectCancel = new JLabel();
        labelButtonEffectCancel.setBounds(40, 104, 300, 40);
        labelButtonEffectCancel.setBackground(new Color(0x363636));
        labelButtonEffectCancel.setOpaque(false);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(new Color(0x217346));
        buttonCancel.setBounds(40, 104, 300, 40);
        buttonCancel.setFocusable(false);
        buttonCancel.setForeground(Color.WHITE);
        buttonCancel.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonCancel.addActionListener(this);
        buttonCancel.setBorderPainted(false);
        buttonCancel.addMouseListener(new ButtonMouseListener(buttonCancel, labelButtonEffectCancel));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 736, 200);

        this.add(layeredPane);

        layeredPane.add(labelTextfieldXAxis, Integer.valueOf(1));
        layeredPane.add(textFieldXAxis);

        layeredPane.add(labelTextfieldYAxis, Integer.valueOf(1));
        layeredPane.add(textFieldYAxis);

        layeredPane.add(buttonCreate);
        layeredPane.add(buttonCancel);
        layeredPane.add(labelButtonEffectCreate);
        layeredPane.add(labelButtonEffectCancel);

        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(736, 200);
        this.setLocationRelativeTo(parent);
        this.setTitle("Enter X-Y Title");
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCreate) {
            gotoChartFile = true;
            dispose();
        } else if (e.getSource() == buttonCancel) {
            gotoChartFile = false;
            dispose();
        }
    }

    public boolean showDialog() {
        this.setVisible(true);
        return gotoChartFile;
    }

    public String getxTitle() {
        return textFieldXAxis.getText();
    }

    public String getyTitle() {
        return textFieldYAxis.getText();
    }
}