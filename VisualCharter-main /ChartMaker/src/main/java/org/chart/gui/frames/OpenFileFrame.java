package org.chart.gui.frames;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.chart.fileReader.CSVReader;
import org.chart.fileReader.ExcelReader;
import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.ButtonMouseListenerMenu;
import org.chart.gui.customizations.CenterTextCellRenderer;
import org.chart.gui.customizations.CirclePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class OpenFileFrame extends JFrame implements ActionListener {
    JButton buttonBack;
    JButton buttonEnterData;
    JButton buttonClear;
    JButton buttonTutorial;
    JButton buttonCreate;
    JButton buttonOpenFile;

    JComboBox comboBoxChartType;

    JTextField textFieldChartTitle;
    JTextField textFieldNumberOfRows;
    JTextField textFieldNumberOfColumns;

    DefaultTableModel tableModel;

    JLabel labelException;

    int rowsCount;
    int columnsCount;

    String filePath;

    String[] headers;
    String[][] data;

    public OpenFileFrame(){
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

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(472, 50, 129, 30);
        buttonClear.setFocusable(false);
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonClear.addActionListener(this);
        buttonClear.setBorderPainted(false);
        buttonClear.setBackground(new Color(0x262626));
        buttonClear.addMouseListener(new ButtonMouseListenerMenu(buttonClear, labelButtonEffectClear));
        buttonClear.setContentAreaFilled(false);

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

        URL labelTextfieldURL = getClass().getResource("/greenChartTitle.png");
        ImageIcon labelTextfield = null;
        if (labelTextfieldURL == null) {
            System.err.println("Resource not found: /greenChartTitle.png");
        } else {
            labelTextfield = new ImageIcon(labelTextfieldURL);
        }

        JLabel labelTextfieldChartTitle = new JLabel();
        labelTextfieldChartTitle.setIcon(labelTextfield);
        labelTextfieldChartTitle.setBounds(80, 120, 160, 34);
        labelTextfieldChartTitle.setText("Chart Title");
        labelTextfieldChartTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldChartTitle.setForeground(Color.WHITE);
        labelTextfieldChartTitle.setHorizontalTextPosition(JLabel.CENTER);

        textFieldChartTitle = new JTextField("Chart Title");
        textFieldChartTitle.setBounds(60, 144, 300, 40);
        textFieldChartTitle.setBackground(new Color(0x363636));
        textFieldChartTitle.setForeground(Color.WHITE);
        textFieldChartTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldChartTitle.setCaretColor(new Color(0xC9C9C9));
        textFieldChartTitle.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelButtonEffectOpenFile = new JLabel();
        labelButtonEffectOpenFile.setBounds(425, 144, 300, 40);
        labelButtonEffectOpenFile.setBackground(new Color(0x363636));
        labelButtonEffectOpenFile.setOpaque(false);

        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setBackground(new Color(0x217346));
        buttonOpenFile.setBounds(425, 144, 300, 40);
        buttonOpenFile.setFocusable(false);
        buttonOpenFile.setForeground(Color.WHITE);
        buttonOpenFile.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonOpenFile.addActionListener(this);
        buttonOpenFile.setBorderPainted(false);
        buttonOpenFile.addMouseListener(new ButtonMouseListener(buttonOpenFile, labelButtonEffectOpenFile));

        JLabel labelTextfieldRow = new JLabel();
        labelTextfieldRow.setIcon(labelTextfield);
        labelTextfieldRow.setBounds(80, 200, 160, 34);
        labelTextfieldRow.setText("Number of Rows");
        labelTextfieldRow.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldRow.setForeground(Color.WHITE);
        labelTextfieldRow.setHorizontalTextPosition(JLabel.CENTER);

        textFieldNumberOfRows = new JTextField("Number of Rows");
        textFieldNumberOfRows.setBounds(60, 224, 300, 40);
        textFieldNumberOfRows.setBackground(new Color(0x363636));
        textFieldNumberOfRows.setForeground(Color.WHITE);
        textFieldNumberOfRows.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldNumberOfRows.setCaretColor(new Color(0xC9C9C9));
        textFieldNumberOfRows.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfRows.setEditable(false);

        JLabel labelTextfieldColumn = new JLabel();
        labelTextfieldColumn.setIcon(labelTextfield);
        labelTextfieldColumn.setBounds(445, 200, 160, 34);
        labelTextfieldColumn.setText("Number of Columns");
        labelTextfieldColumn.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldColumn.setForeground(Color.WHITE);
        labelTextfieldColumn.setHorizontalTextPosition(JLabel.CENTER);

        textFieldNumberOfColumns = new JTextField("Number of Columns");
        textFieldNumberOfColumns.setBounds(425, 224, 300, 40);
        textFieldNumberOfColumns.setBackground(new Color(0x363636));
        textFieldNumberOfColumns.setForeground(Color.WHITE);
        textFieldNumberOfColumns.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldNumberOfColumns.setCaretColor(new Color(0xC9C9C9));
        textFieldNumberOfColumns.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfColumns.setEditable(false);

        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial Black", Font.PLAIN, 12));
        table.setBackground(new Color(0x217346));
        table.setForeground(Color.WHITE);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Arial Black", Font.PLAIN, 16));
        table.getTableHeader().setBackground(new Color(0x0E5C2F));
        table.getTableHeader().setForeground(Color.WHITE);
        rowsCount = table.getRowCount();
        columnsCount = table.getColumnCount();
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        table.setSelectionBackground(new Color(0x0E5C2F));
        table.setSelectionForeground(Color.WHITE);

        CenterTextCellRenderer centerRenderer = new CenterTextCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(60, 296, 665, 370);
        scrollPane.setBackground(new Color(0x363636));
        scrollPane.getViewport().setBackground(new Color(0x363636));

        JLabel labelButtonEffectCreate = new JLabel();
        labelButtonEffectCreate.setBounds(425, 690, 300, 40);
        labelButtonEffectCreate.setBackground(new Color(0x363636));
        labelButtonEffectCreate.setOpaque(false);

        buttonCreate = new JButton("<html><div style='text-align: center;'>Create</div></html>");
        buttonCreate.setBackground(new Color(0x217346));
        buttonCreate.setBounds(425, 690, 300, 40);
        buttonCreate.setFocusable(false);
        buttonCreate.setForeground(Color.WHITE);
        buttonCreate.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonCreate.addActionListener(this);
        buttonCreate.setBorderPainted(false);
        buttonCreate.addMouseListener(new ButtonMouseListener(buttonCreate, labelButtonEffectCreate));

        labelException = new JLabel();
        labelException.setVisible(false);
        labelException.setBounds(0, 265, 800, 30);
        labelException.setHorizontalAlignment(SwingConstants.CENTER);
        labelException.setVerticalAlignment(SwingConstants.CENTER);
        labelException.setFont(new Font("Arial Black", Font.PLAIN, 16));
        labelException.setForeground(Color.RED);

        String[] chartTypes = {"Line Chart", "Bar Chart", "Scatter Chart", "Pie Chart"};
        comboBoxChartType = new JComboBox(chartTypes);
        comboBoxChartType.setBounds(60, 690, 300, 40);
        comboBoxChartType.addActionListener(this);
        comboBoxChartType.setFont(new Font("Arial Black", Font.PLAIN, 16));
        comboBoxChartType.setBackground(new Color(0x217346));
        comboBoxChartType.setForeground(Color.WHITE);
        comboBoxChartType.setFocusable(false);
        comboBoxChartType.insertItemAt("Select a Chart Type", 0);
        comboBoxChartType.setSelectedIndex(0);
        comboBoxChartType.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,816,800);

        this.add(layeredPane);
        layeredPane.add(panelMenu);

        layeredPane.add(panelCircle, Integer.valueOf(1));

        layeredPane.add(buttonBack, Integer.valueOf(1));
        layeredPane.add(buttonEnterData, Integer.valueOf(1));
        layeredPane.add(buttonClear, Integer.valueOf(1));
        layeredPane.add(buttonTutorial, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectBack, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectEnterData, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectClear, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectTutorial, Integer.valueOf(1));

        layeredPane.add(buttonOpenFile);
        layeredPane.add(labelButtonEffectOpenFile);
        layeredPane.add(buttonCreate);
        layeredPane.add(labelButtonEffectCreate);
        layeredPane.add(textFieldChartTitle);
        layeredPane.add(comboBoxChartType);

        layeredPane.add(scrollPane);
        layeredPane.add(textFieldNumberOfRows);
        layeredPane.add(textFieldNumberOfColumns);

        layeredPane.add(labelMenuLine1, Integer.valueOf(1));
        layeredPane.add(labelMenuLine2, Integer.valueOf(1));
        layeredPane.add(labelMenuLine3, Integer.valueOf(1));
        layeredPane.add(labelMenuLine4, Integer.valueOf(1));
        layeredPane.add(labelMenuLine5, Integer.valueOf(1));
        layeredPane.add(labelMenuLine6, Integer.valueOf(1));

        layeredPane.add(labelException);

        layeredPane.add(labelTextfieldChartTitle, Integer.valueOf(2));
        layeredPane.add(labelTextfieldRow, Integer.valueOf(2));
        layeredPane.add(labelTextfieldColumn, Integer.valueOf(2));

        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setTitle("Open File");
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

        if (e.getSource() == buttonClear){
            clear();
        }

        if (e.getSource() == buttonTutorial){
            this.dispose();
            TutorialFrame tutorialFrame = new TutorialFrame();
        }

        if (e.getSource() == buttonOpenFile){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel & CSV Files","xlsx", "xls", "csv");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                clear();

                filePath = String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile());

                File file = new File(filePath);
                String fileExtension = getFileExtension(file);

                buttonOpenFile.setHorizontalAlignment(SwingConstants.LEFT);
                buttonOpenFile.setText(file.getName());


                if (fileExtension.equalsIgnoreCase("xlsx") || fileExtension.equalsIgnoreCase("xls")){ // If it's an Excel file...
                    buttonOpenFile.setIcon(new ImageIcon(getClass().getResource("/excelButtonIcon.png")));

                    try {
                        WorkbookFactory.addProvider(new HSSFWorkbookFactory());
                        WorkbookFactory.addProvider(new XSSFWorkbookFactory());

                        ExcelReader excelReader = new ExcelReader(filePath);
                        rowsCount = excelReader.getRowCount();
                        columnsCount = excelReader.getColumnCount();

                        headers = excelReader.headersToArray();
                        data = excelReader.dataToArray();

                        tableModel.setColumnIdentifiers(headers);

                        for (int i = 0; i < data.length; i++){
                            tableModel.addRow(data[i]);
                        }
                    }

                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else if (fileExtension.equalsIgnoreCase("csv")){ // If it's an CSV file...
                    buttonOpenFile.setIcon(new ImageIcon(getClass().getResource("/csvButtonIcon.png")));

                    try {
                        CSVReader csvReader = new CSVReader(filePath);
                        rowsCount = csvReader.getRowCount();
                        columnsCount = csvReader.getColumnCount();

                        headers = csvReader.getHeader();
                        data = csvReader.getData();

                        tableModel.setColumnIdentifiers(headers);

                        for (int i = 0; i < data.length; i++){
                            tableModel.addRow(data[i]);
                        }
                    }

                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else {
                    labelException.setText("Please select an Excel or CSV file.");
                }

                textFieldNumberOfRows.setText(String.valueOf(rowsCount));
                textFieldNumberOfColumns.setText(String.valueOf(columnsCount));
            }
        }

        if (e.getSource() == buttonCreate){
            if(filePath == null){
                labelException.setText("Please select a file first.");
                labelException.setVisible(true);
            }

            else if (comboBoxChartType.getSelectedIndex() == 0){
                labelException.setText("Please select a chart type first.");
                labelException.setVisible(true);
            }

            else if (comboBoxChartType.getSelectedItem() == "Pie Chart"){
                this.dispose();

                try {
                    ChartFrame chartFrame = new ChartFrame(
                            String.valueOf(comboBoxChartType.getSelectedItem()),
                            headers,
                            data,
                            textFieldChartTitle.getText(),
                            "",
                            "");
                }

                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            else {
                XYTitleDialog dialog = new XYTitleDialog(null);

                if (dialog.showDialog()) {
                    this.dispose();

                    try {
                        ChartFrame chartFrame = new ChartFrame(
                                String.valueOf(comboBoxChartType.getSelectedItem()),
                                headers,
                                data,
                                textFieldChartTitle.getText(),
                                dialog.getxTitle(),
                                dialog.getyTitle());
                    }

                    catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == 0 || dotIndex == fileName.length() - 1) {
            return "";
        }
        else {
            return fileName.substring(dotIndex + 1);
        }
    }

    private void clear(){
        textFieldChartTitle.setText("Chart Title");
        textFieldNumberOfRows.setText("Number of Rows");
        textFieldNumberOfColumns.setText("Number of Columns");

        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);

        comboBoxChartType.setSelectedIndex(0);

        buttonOpenFile.setIcon(null);
        buttonOpenFile.setText("<html><div style='text-align: center;'>Open File</div></html>");
        buttonOpenFile.setHorizontalAlignment(SwingConstants.CENTER);

        filePath = null;
    }
}