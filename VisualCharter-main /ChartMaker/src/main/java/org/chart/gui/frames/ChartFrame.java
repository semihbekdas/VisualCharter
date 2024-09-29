package org.chart.gui.frames;

import org.chart.chartCreator.BarChartMaker;
import org.chart.chartCreator.LineChartMaker;
import org.chart.chartCreator.PieChartMaker;
import org.chart.chartCreator.ScatterChartMaker;
import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.ButtonMouseListenerMenu;
import org.chart.gui.customizations.CirclePanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChartFrame extends JFrame implements ActionListener {
    String choose;
    String[] headers;
    String[][] data;
    String chartTitle;
    String xAxisLabel;
    String yAxisLabel;

    JButton buttonBack;
    JButton buttonEnterData;
    JButton buttonOpenFile;
    JButton buttonTutorial;

    JLabel labelException;

    JTextField textFieldSaveWidth;
    JTextField textFieldSaveHeight;

    JButton buttonSave;

    public ChartFrame(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.headers = headers;
        this.data = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;

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
        }
        catch (Exception e)
        {
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

        JLabel labelButtonEffectBack = new JLabel();
        labelButtonEffectBack.setBounds(32, 50, 129, 30);
        labelButtonEffectBack.setBackground(new Color(0x0E5C2F));
        labelButtonEffectBack.setOpaque(false);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(32, 50, 129, 30);
        buttonBack.setFocusable(false);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonBack.addActionListener(this);
        buttonBack.setBorderPainted(false);
        buttonBack.setBackground(new Color(0x262626));
        buttonBack.addMouseListener(new ButtonMouseListenerMenu(buttonBack, labelButtonEffectBack));
        buttonBack.setContentAreaFilled(false);

        JLabel labelButtonEffectEnterData = new JLabel();
        labelButtonEffectEnterData.setBounds(196, 50, 129, 30);
        labelButtonEffectEnterData.setBackground(new Color(0x0E5C2F));
        labelButtonEffectEnterData.setOpaque(false);

        buttonEnterData = new JButton("Enter Data");
        buttonEnterData.setBounds(196, 50, 129, 30);
        buttonEnterData.setFocusable(false);
        buttonEnterData.setForeground(Color.WHITE);
        buttonEnterData.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonEnterData.addActionListener(this);
        buttonEnterData.setBorderPainted(false);
        buttonEnterData.setBackground(new Color(0x262626));
        buttonEnterData.addMouseListener(new ButtonMouseListenerMenu(buttonEnterData, labelButtonEffectEnterData));
        buttonEnterData.setContentAreaFilled(false);

        JLabel labelButtonEffectClear = new JLabel();
        labelButtonEffectClear.setBounds(472, 50, 129, 30);
        labelButtonEffectClear.setBackground(new Color(0x0E5C2F));
        labelButtonEffectClear.setOpaque(false);

        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setBounds(472, 50, 129, 30);
        buttonOpenFile.setFocusable(false);
        buttonOpenFile.setForeground(Color.WHITE);
        buttonOpenFile.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonOpenFile.addActionListener(this);
        buttonOpenFile.setBorderPainted(false);
        buttonOpenFile.setBackground(new Color(0x262626));
        buttonOpenFile.addMouseListener(new ButtonMouseListenerMenu(buttonOpenFile, labelButtonEffectClear));
        buttonOpenFile.setContentAreaFilled(false);

        JLabel labelButtonEffectTutorial = new JLabel();
        labelButtonEffectTutorial.setBounds(636, 50, 129, 30);
        labelButtonEffectTutorial.setBackground(new Color(0x0E5C2F));
        labelButtonEffectTutorial.setOpaque(false);

        buttonTutorial = new JButton("Tutorial");
        buttonTutorial.setBounds(636, 50, 129, 30);
        buttonTutorial.setFocusable(false);
        buttonTutorial.setForeground(Color.WHITE);
        buttonTutorial.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonTutorial.addActionListener(this);
        buttonTutorial.setBorderPainted(false);
        buttonTutorial.setBackground(new Color(0x262626));
        buttonTutorial.addMouseListener(new ButtonMouseListenerMenu(buttonTutorial, labelButtonEffectTutorial));
        buttonTutorial.setContentAreaFilled(false);

        ChartPanel chartPanel = getPanel();
        chartPanel.setBounds(50, 120, 700, 500);
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        ImageIcon saveIcon = null;
        try {
            URL saveIconURL = getClass().getResource("/saveIconWhite.png");
            if (saveIconURL != null) {
                saveIcon = new ImageIcon(saveIconURL);
            } else {
                System.err.println("Resource not found: /saveIconWhite.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        labelException = new JLabel();
        labelException.setVisible(false);
        labelException.setBounds(0, 620, 800, 30);
        labelException.setHorizontalAlignment(SwingConstants.CENTER);
        labelException.setVerticalAlignment(SwingConstants.CENTER);
        labelException.setFont(new Font("Arial Black", Font.PLAIN, 16));
        labelException.setForeground(Color.RED);

        URL labelTextfieldURL = getClass().getResource("/greenChartTitle.png");
        ImageIcon labelTextfield = null;
        if (labelTextfieldURL == null) {
            System.err.println("Resource not found: /greenChartTitle.png");
        } else {
            labelTextfield = new ImageIcon(labelTextfieldURL);
        }

        JLabel labelTextfieldSaveWidth = new JLabel();
        labelTextfieldSaveWidth.setIcon(labelTextfield);
        labelTextfieldSaveWidth.setBounds(70, 651, 160, 34);
        labelTextfieldSaveWidth.setText("Save Width");
        labelTextfieldSaveWidth.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldSaveWidth.setForeground(Color.WHITE);
        labelTextfieldSaveWidth.setHorizontalTextPosition(JLabel.CENTER);

        textFieldSaveWidth = new JTextField("700");
        textFieldSaveWidth.setBounds(50, 675, 300, 40);
        textFieldSaveWidth.setBackground(new Color(0x363636));
        textFieldSaveWidth.setForeground(Color.WHITE);
        textFieldSaveWidth.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldSaveWidth.setCaretColor(new Color(0xC9C9C9));
        textFieldSaveWidth.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelTextfieldSaveHeight = new JLabel();
        labelTextfieldSaveHeight.setIcon(labelTextfield);
        labelTextfieldSaveHeight.setBounds(400, 651, 160, 34);
        labelTextfieldSaveHeight.setText("Save Height");
        labelTextfieldSaveHeight.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldSaveHeight.setForeground(Color.WHITE);
        labelTextfieldSaveHeight.setHorizontalTextPosition(JLabel.CENTER);

        textFieldSaveHeight = new JTextField("500");
        textFieldSaveHeight.setBounds(380, 675, 300, 40);
        textFieldSaveHeight.setBackground(new Color(0x363636));
        textFieldSaveHeight.setForeground(Color.WHITE);
        textFieldSaveHeight.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldSaveHeight.setCaretColor(new Color(0xC9C9C9));
        textFieldSaveHeight.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelButtonEffectSave = new JLabel();
        labelButtonEffectSave.setBounds(710, 675, 40, 40);
        labelButtonEffectSave.setBackground(new Color(0x363636));
        labelButtonEffectSave.setOpaque(false);

        buttonSave = new JButton();
        buttonSave.setBackground(new Color(0x217346));
        buttonSave.setBounds(710, 675, 40, 40);
        buttonSave.setIcon(saveIcon);
        buttonSave.setFocusable(false);
        buttonSave.addActionListener(this);
        buttonSave.setBorderPainted(false);
        buttonSave.addMouseListener(new ButtonMouseListener(buttonSave, labelButtonEffectSave));

        JLabel labelInfoText = new JLabel("This app made by Kerem YILMAZ, Salih Kerim ASLAN, Semih BEKDAŞ, Ahmet Emin ÇAKIR in 2024");
        labelInfoText.setFont(new Font("Cambria Math", Font.PLAIN, 12));
        labelInfoText.setForeground(Color.WHITE);
        labelInfoText.setBounds(0,730,800,20);
        labelInfoText.setHorizontalAlignment(JLabel.CENTER);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,816,800);

        this.add(layeredPane);
        layeredPane.add(panelMenu);

        layeredPane.add(panelCircle, Integer.valueOf(1));

        layeredPane.add(buttonBack, Integer.valueOf(1));
        layeredPane.add(buttonEnterData, Integer.valueOf(1));
        layeredPane.add(buttonOpenFile, Integer.valueOf(1));
        layeredPane.add(buttonTutorial, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectBack, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectEnterData, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectClear, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectTutorial, Integer.valueOf(1));

        layeredPane.add(chartPanel, Integer.valueOf(1));

        layeredPane.add(labelException, Integer.valueOf(1));

        layeredPane.add(labelTextfieldSaveWidth, Integer.valueOf(1));
        layeredPane.add(textFieldSaveWidth);
        layeredPane.add(labelTextfieldSaveHeight, Integer.valueOf(1));
        layeredPane.add(textFieldSaveHeight);

        layeredPane.add(buttonSave, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectSave, Integer.valueOf(1));

        layeredPane.add(labelMenuLine1, Integer.valueOf(1));
        layeredPane.add(labelMenuLine2, Integer.valueOf(1));
        layeredPane.add(labelMenuLine3, Integer.valueOf(1));
        layeredPane.add(labelMenuLine4, Integer.valueOf(1));
        layeredPane.add(labelMenuLine5, Integer.valueOf(1));
        layeredPane.add(labelMenuLine6, Integer.valueOf(1));
        layeredPane.add(labelInfoText);


        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setTitle(chartTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(816, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack){
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }

        if (e.getSource() == buttonEnterData){
            this.dispose();
            EnterDataFrame enterDataFrame = new EnterDataFrame();
        }

        if (e.getSource() == buttonOpenFile){
            this.dispose();
            OpenFileFrame openFileFrame = new OpenFileFrame();
        }

        if (e.getSource() == buttonTutorial){
            this.dispose();
            TutorialFrame tutorialFrame = new TutorialFrame();
        }

        if (e.getSource() == buttonSave){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Files","jpeg");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                if (!file.getAbsolutePath().endsWith(".jpg")) {
                    file = new File(file.getAbsolutePath() + ".jpg");
                }
                try {
                    ChartUtils.saveChartAsJPEG(file, getChart(), Integer.parseInt(textFieldSaveWidth.getText()), Integer.parseInt(textFieldSaveHeight.getText()));
                    labelException.setVisible(false);
                } catch (Exception exception) {
                    labelException.setText("Please input only positive integer values in the text fields.");
                    labelException.setVisible(true);
                }
            }
        }
    }

    public ChartPanel getPanel() {
        if (choose.equals("Line Chart")){
            LineChartMaker chartMaker = new LineChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            return chartPanel;
        }
        else if (choose.equals("Pie Chart")){
            PieChartMaker chartMaker = new PieChartMaker(headers, data, chartTitle);
            ChartPanel chartPanel = chartMaker.getPanel();
            return chartPanel;
        }
        else if (choose.equals("Scatter Chart")){
            ScatterChartMaker chartMaker = new ScatterChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            return chartPanel;
        }
        else if (choose.equals("Bar Chart")){
            BarChartMaker chartMaker = new BarChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            return chartPanel;
        }
        return null;
    }

    public JFreeChart getChart() {
        if (choose.equals("Line Chart")) {
            LineChartMaker chartMaker = new LineChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            return chartMaker.getChart();
        } else if (choose.equals("Pie Chart")) {
            PieChartMaker chartMaker = new PieChartMaker(headers, data, chartTitle);
            return chartMaker.getChart();
        } else if (choose.equals("Scatter Chart")) {
            ScatterChartMaker chartMaker = new ScatterChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            return chartMaker.getChart();
        } else if (choose.equals("Bar Chart")) {
            BarChartMaker chartMaker = new BarChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            return chartMaker.getChart();
        }
        return null;
    }
}