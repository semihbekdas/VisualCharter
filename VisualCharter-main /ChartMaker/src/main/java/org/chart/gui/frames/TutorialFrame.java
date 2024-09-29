package org.chart.gui.frames;

import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.ButtonMouseListenerMenu;
import org.chart.gui.customizations.CirclePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TutorialFrame extends JFrame implements ActionListener {
    JButton buttonPie;
    JButton buttonLine;
    JButton buttonBar;
    JButton buttonScatter;

    JLabel labelTutorialTitle;
    JLabel labelTutorialImage;
    JTextArea textAreaTutorialText;
    JButton buttonBack;

    TutorialFrame() {
        URL iconURL = getClass().getResource("/iconSmall.png");
        assert iconURL != null;
        ImageIcon icon  = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(0x363636));
        panelMenu.setBounds(0, 40, 800, 50);
        panelMenu.setLayout(null);

        CirclePanel panelCircle = new CirclePanel(iconURL);
        panelCircle.setBounds(360, 25, 80, 80);

        ImageIcon lineGreen = null;
        try {
            URL lineGreenURL = getClass().getResource("/greenLine.png");
            if (lineGreenURL != null) {
                lineGreen = new ImageIcon(lineGreenURL);
            } else {
                System.err.println("Resource not found: /greenLine.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelMenuLine1 = new JLabel();
        labelMenuLine1.setIcon(lineGreen);
        labelMenuLine1.setBounds(16, 55, 60, 20);

        JLabel labelMenuLine2 = new JLabel();
        labelMenuLine2.setIcon(lineGreen);
        labelMenuLine2.setBounds(180, 55, 60, 20);

        JLabel labelMenuLine3 = new JLabel();
        labelMenuLine3.setIcon(lineGreen);
        labelMenuLine3.setBounds(344, 55, 60, 20);

        JLabel labelMenuLine4 = new JLabel();
        labelMenuLine4.setIcon(lineGreen);
        labelMenuLine4.setBounds(456, 55, 60, 20);

        JLabel labelMenuLine5 = new JLabel();
        labelMenuLine5.setIcon(lineGreen);
        labelMenuLine5.setBounds(620, 55, 60, 20);

        JLabel labelMenuLine6 = new JLabel();
        labelMenuLine6.setIcon(lineGreen);
        labelMenuLine6.setBounds(784, 55, 60, 20);

        JLabel labelButtonEffectPie = new JLabel();
        labelButtonEffectPie.setBounds(32, 50, 129, 30);
        labelButtonEffectPie.setBackground(new Color(0x0E5C2F));
        labelButtonEffectPie.setOpaque(false);

        buttonPie = new JButton("Pie Chart");
        buttonPie.setBounds(32, 50, 129, 30);
        buttonPie.setFocusable(false);
        buttonPie.setForeground(Color.WHITE);
        buttonPie.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonPie.addActionListener(this);
        buttonPie.setBorderPainted(false);
        buttonPie.setBackground(new Color(0x262626));
        buttonPie.addMouseListener(new ButtonMouseListenerMenu(buttonPie, labelButtonEffectPie));
        buttonPie.setContentAreaFilled(false);

        JLabel labelButtonEffectLine = new JLabel();
        labelButtonEffectLine.setBounds(196, 50, 129, 30);
        labelButtonEffectLine.setBackground(new Color(0x0E5C2F));
        labelButtonEffectLine.setOpaque(false);

        buttonLine = new JButton("Line Chart");
        buttonLine.setBounds(196, 50, 129, 30);
        buttonLine.setFocusable(false);
        buttonLine.setForeground(Color.WHITE);
        buttonLine.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonLine.addActionListener(this);
        buttonLine.setBorderPainted(false);
        buttonLine.setBackground(new Color(0x262626));
        buttonLine.addMouseListener(new ButtonMouseListenerMenu(buttonLine, labelButtonEffectLine));
        buttonLine.setContentAreaFilled(false);

        JLabel labelButtonBar = new JLabel();
        labelButtonBar.setBounds(472, 50, 129, 30);
        labelButtonBar.setBackground(new Color(0x0E5C2F));
        labelButtonBar.setOpaque(false);

        buttonBar = new JButton("Bar Chart");
        buttonBar.setBounds(472, 50, 129, 30);
        buttonBar.setFocusable(false);
        buttonBar.setForeground(Color.WHITE);
        buttonBar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonBar.addActionListener(this);
        buttonBar.setBorderPainted(false);
        buttonBar.setBackground(new Color(0x262626));
        buttonBar.addMouseListener(new ButtonMouseListenerMenu(buttonBar, labelButtonBar));
        buttonBar.setContentAreaFilled(false);

        JLabel labelButtonEffectScatter = new JLabel();
        labelButtonEffectScatter.setBounds(636, 50, 129, 30);
        labelButtonEffectScatter.setBackground(new Color(0x0E5C2F));
        labelButtonEffectScatter.setOpaque(false);

        buttonScatter = new JButton("Scatter Chart");
        buttonScatter.setBounds(636, 50, 129, 30);
        buttonScatter.setFocusable(false);
        buttonScatter.setForeground(Color.WHITE);
        buttonScatter.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonScatter.addActionListener(this);
        buttonScatter.setBorderPainted(false);
        buttonScatter.setBackground(new Color(0x262626));
        buttonScatter.addMouseListener(new ButtonMouseListenerMenu(buttonScatter, labelButtonEffectScatter));
        buttonScatter.setContentAreaFilled(false);

        labelTutorialTitle = new JLabel("Choose any chart type to see the tutorial.");
        labelTutorialTitle.setBounds(0, 100, 800, 100);
        labelTutorialTitle.setFont(new Font("Arial Black", Font.PLAIN, 24));
        labelTutorialTitle.setForeground(Color.WHITE);
        labelTutorialTitle.setHorizontalAlignment(SwingConstants.CENTER);

        labelTutorialImage = new JLabel();
        labelTutorialImage.setBounds(50, 200, 700, 300);
        labelTutorialImage.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        textAreaTutorialText = new JTextArea();
        textAreaTutorialText.setBounds(50, 550, 700, 200);
        textAreaTutorialText.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textAreaTutorialText.setForeground(Color.WHITE);
        textAreaTutorialText.setBackground(new Color(0x262626));
        textAreaTutorialText.setLineWrap(true);
        textAreaTutorialText.setWrapStyleWord(true);
        textAreaTutorialText.setEditable(false);
        textAreaTutorialText.setFocusable(false);

        JLabel labelButtonEffectBack = new JLabel();
        labelButtonEffectBack.setBounds(425, 690, 300, 40);
        labelButtonEffectBack.setBackground(new Color(0x363636));
        labelButtonEffectBack.setOpaque(false);

        buttonBack = new JButton("Back to Main Frame");
        buttonBack.setBackground(new Color(0x217346));
        buttonBack.setBounds(425, 690, 300, 40);
        buttonBack.setFocusable(false);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonBack.addActionListener(this);
        buttonBack.setBorderPainted(false);
        buttonBack.addMouseListener(new ButtonMouseListener(buttonBack, labelButtonEffectBack));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 816, 800);

        this.add(layeredPane);

        layeredPane.add(panelMenu);

        layeredPane.add(panelCircle, Integer.valueOf(1));
        layeredPane.add(labelMenuLine1, Integer.valueOf(1));
        layeredPane.add(labelMenuLine2, Integer.valueOf(1));
        layeredPane.add(labelMenuLine3, Integer.valueOf(1));
        layeredPane.add(labelMenuLine4, Integer.valueOf(1));
        layeredPane.add(labelMenuLine5, Integer.valueOf(1));
        layeredPane.add(labelMenuLine6, Integer.valueOf(1));

        layeredPane.add(buttonPie, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectPie, Integer.valueOf(1));
        layeredPane.add(buttonLine, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectLine, Integer.valueOf(1));
        layeredPane.add(buttonBar, Integer.valueOf(1));
        layeredPane.add(labelButtonBar, Integer.valueOf(1));
        layeredPane.add(buttonScatter, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectScatter, Integer.valueOf(1));

        layeredPane.add(labelTutorialImage, Integer.valueOf(1));
        layeredPane.add(labelTutorialTitle, Integer.valueOf(1));
        layeredPane.add(buttonBack, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectBack, Integer.valueOf(1));
        layeredPane.add(textAreaTutorialText, Integer.valueOf(1));

        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setTitle("Tutorial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(816, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPie) {
            updateTutorialImage("/pieTutorial.jpg");
            updateTutorialTitle("Pie Chart Tutorial");
            updateTutorialText("The Pie Chart can accurately convert tables consisting of only two columns into a chart. If there are more than two columns, only the first two columns can be represented in the chart. Other actions can be performed as shown in the image.");
        }

        if (e.getSource() == buttonLine) {
            updateTutorialImage("/lineTutorial.jpg");
            updateTutorialTitle("Line Chart Tutorial");
            updateTutorialText("In the table generated to create a Line Chart, the first cell is not readable. Unlike the Pie Chart, you need to enter titles for the X and Y axes. Line Chart has similar usage to Bar Chart. Other actions can be performed as shown in the image.");
        }

        if (e.getSource() == buttonBar) {
            updateTutorialImage("/barTutorial.jpg");
            updateTutorialTitle("Bar Chart Tutorial");
            updateTutorialText("In the table generated to create a Bar Chart, the first cell is not readable. Unlike the Pie Chart, you need to enter titles for the X and Y axes. Bar Chart has similar usage to Line Chart. Other actions can be performed as shown in the image.");
        }

        if (e.getSource() == buttonScatter) {
            updateTutorialImage("/scatterTutorial.jpg");
            updateTutorialTitle("Scatter Chart Tutorial");
            updateTutorialText("To create a Scatter Chart, all data in the table should consist of numerical values except the headers. Unlike the Pie Chart, you need to provide titles for the X and Y axes. Other actions can be performed as shown in the image.");
        }

        if (e.getSource() == buttonBack) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
    }

    private void updateTutorialImage(String path) { // Updating the image of the tutorial.
        ImageIcon tutorialImage = null;
        try {
            URL tutorialImageURL = getClass().getResource(path);
            if (tutorialImageURL != null) {
                tutorialImage = new ImageIcon(tutorialImageURL);
                labelTutorialImage.setIcon(tutorialImage);
            } else {
                System.err.println("Resource not found: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTutorialTitle(String title){ // Updating the title of the tutorial.
        labelTutorialTitle.setText(title);
    }

    private void updateTutorialText(String text){// Updating the text of the tutorial.
        textAreaTutorialText.setText(text);
    }


}