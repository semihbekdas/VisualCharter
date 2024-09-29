package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.VerticalAlignment;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class BarChartMaker {
    private static String[] headers;
    private static String[][] data;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;
    private JFreeChart chart;

    public BarChartMaker(String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) {
        this.headers = headers;
        this.data = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        createChart();
    }

    private void createChart() {
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                try {
                    double value = Double.parseDouble(data[i][j]);
                    barDataset.addValue(value, headers[j], data[i][0]);
                } catch (NumberFormatException e) {
                    // Skip if value is not a number
                }
            }
        }
        chart = ChartFactory.createBarChart(
                chartTitle, // Chart Title
                xAxisLabel, // Category axis
                yAxisLabel, // Value axis
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        chart.setBackgroundPaint(new Color(0x363636));

        TextTitle title = chart.getTitle();
        title.setPaint(Color.WHITE);
        title.setPadding(new RectangleInsets(10, 0, 0, 0));

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(0x363636));
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setOutlinePaint(Color.WHITE);
        plot.setOutlineVisible(false);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setGradientPaintTransformer(null);

        plot.getDomainAxis().setTickLabelPaint(Color.WHITE); // X-axis
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE); // Y-axis

        plot.getDomainAxis().setAxisLinePaint(Color.WHITE); // X-axis border
        plot.getRangeAxis().setAxisLinePaint(Color.WHITE); // Y-axis border

        plot.getDomainAxis().setLabelPaint(Color.WHITE); // X-axis title
        plot.getRangeAxis().setLabelPaint(Color.WHITE); // Y-axis title

        chart.getLegend().setBackgroundPaint(new Color(0x363636));
        chart.getLegend().setItemPaint(Color.WHITE);
        chart.getLegend().setVerticalAlignment(VerticalAlignment.CENTER);

        Paint[] colors = {
                new Color(0x2D7C3C),
                new Color(0xD24738),
                new Color(0x5EADD6)
        };

        // Change the default colors
        for (int i = 0; i < barDataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, colors[i % colors.length]);
        }
    }

    public ChartPanel getPanel() {
        return new ChartPanel(chart);
    }

    public JFreeChart getChart() {
        return chart;
    }
}