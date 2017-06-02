/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

public class ChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            try{
//            response.setContentType("image/png");
//            OutputStream outputStream = response.getOutputStream();
//            JFreeChart charte = getChart2();
//            int width = 500;
//            int height = 350;
//            ChartUtilities.writeChartAsPNG(outputStream, charte, width, height);
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(ChartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
        try {
            response.setContentType("image/png");
            OutputStream outputStream = response.getOutputStream();

            JFreeChart chart2 = getChart();

            chart2 = getChart();
            int width = 500;
            int height = 350;
            ChartUtilities.writeChartAsPNG(outputStream, chart2, width, height);

        } catch (URISyntaxException ex) {
            Logger.getLogger(ChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public JFreeChart getChart() throws URISyntaxException {
//
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        Crear la capa de servicios que se enlace con el DAO
//
//        List<Colmena> arr = new LinkedList();
//        DatosDao vis = new DatosDao();
//        arr = vis.findAll3();
//        double[][] data = new double[1][arr.size()];
//        int j = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            dataset.setValue(String.valueOf("Colmena ID: "+arr.get(i).getId_colmena()), arr.get(i).getPcalimento());
//        }
//
//        JFreeChart chart = ChartFactory.createPieChart(
//                "Porcentaje de paneles con Alimentos", // chart title
//                dataset, // dataset
//                true, // include legend
//                true,
//                false
//        );
//        PiePlot plot = (PiePlot) chart.getPlot();
//        plot.setNoDataMessage("No data available");
//        plot.setExplodePercent(1, 0.30);

        return null;
    }

}
