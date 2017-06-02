package Controlador;





import Modelo.Base_Datos_Estudiantes;
import Modelo.Datos_Basico_Estudiante;
import Controlador.CustomRenderer;
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
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

public class ChartServlet1 extends HttpServlet {

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

            JFreeChart chart = getChart2();

            chart = getChart2();

            int width = 500;
            int height = 350;
            ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);

        } catch (URISyntaxException ex) {
            Logger.getLogger(ChartServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JFreeChart getChart2() throws URISyntaxException {

        List<Datos_Basico_Estudiante> arr = new LinkedList();
        Base_Datos_Estudiantes vis = new Base_Datos_Estudiantes();
        arr = vis.cargar();
      
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (int i = 0; i < arr.size(); i++) {
//            
//        dataset.addValue(arr.get(i).getEdad(), String.valueOf(arr.get(i).getId_Estudiante()), "Estudiante ID:"+String.valueOf(arr.get(i).getId_Estudiante()));   
//           
//           
//        }

        dataset.addValue(0,"hola","pepe");   
         
        

        JFreeChart chart = ChartFactory.createBarChart(
                "Edad Estudiantes", // chart title
                "Edad", // domain axis label
                "Estudiante", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // the plot orientation
                false, // include legend
                true,
                false
        );

        chart.setBackgroundPaint(Color.lightGray);

        // get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        CategoryItemRenderer renderer = new CustomRenderer(
                new Paint[]{Color.red, Color.blue, Color.green,
                    Color.yellow, Color.WHITE, Color.cyan,
                    Color.magenta, Color.blue}
        );

        renderer.setItemLabelsVisible(true);
        ItemLabelPosition p = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 45.0
        );
        renderer.setPositiveItemLabelPosition(p);
        plot.setRenderer(renderer);

        // change the margin at the top of the range axis...
        org.jfree.chart.axis.ValueAxis rangAxis = plot.getRangeAxis();
        rangAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangAxis.setLowerMargin(0.15);
        rangAxis.setUpperMargin(0.15);

        return chart;

    }

}
