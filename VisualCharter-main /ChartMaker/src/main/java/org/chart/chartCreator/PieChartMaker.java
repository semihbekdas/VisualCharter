package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.text.DecimalFormat;

public class PieChartMaker {
    private static String[] headers;
    private static String[][] data;
    private static String chartTitle;
    private JFreeChart chart;

    public PieChartMaker(String[] headers, String[][] data, String chartTitle) {
        this.headers = headers;
        this.data = data;
        this.chartTitle = chartTitle;
        createChart();
    }

    private void createChart() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 0; i < data.length; i++) {
            try {
                double value = Double.parseDouble(data[i][1]); // Second column as value
                pieDataset.setValue(data[i][0], value); // First column as category
            } catch (NumberFormatException e) {
                // Skip if value is not a number
            }
        }
        chart = ChartFactory.createPieChart(
                chartTitle,
                pieDataset,
                true,
                true,
                false);

        chart.setBackgroundPaint(new Color(0x363636));

        TextTitle title = chart.getTitle();
        title.setPaint(Color.WHITE);
        title.setPadding(new RectangleInsets(10, 0, 0, 0));

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(0x363636));
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);

        plot.setLabelBackgroundPaint(new Color(0x0E5C2F));
        plot.setLabelOutlinePaint(new Color(0x262626));
        plot.setLabelShadowPaint(Color.WHITE);
        plot.setLabelPaint(Color.WHITE);
        plot.setLabelPadding(new RectangleInsets(6, 6, 6, 6));

        LegendTitle legend = chart.getLegend();
        legend.setItemPaint(Color.WHITE);
        legend.setBackgroundPaint(new Color(0x363636));
        legend.setFrame(new BlockBorder(Color.WHITE));

        chart.getLegend().setItemPaint(Color.WHITE);

        Paint[] colors = {
                new Color(0x2D7C3C),
                new Color(0xD24738),
                new Color(0x5EADD6)
        };

        int sectionCount = pieDataset.getItemCount();
        for (int i = 0; i < sectionCount; i++) {
            plot.setSectionPaint(pieDataset.getKey(i), colors[i % colors.length]);
        }

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        plot.setLabelGenerator(labelGenerator);
    }

    public ChartPanel getPanel() {
        return new ChartPanel(chart);
    }

    public JFreeChart getChart() {
        return chart;
    }
}
