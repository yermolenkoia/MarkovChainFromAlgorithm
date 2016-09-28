package view;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.PickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import org.apache.commons.collections15.Transformer;
import view.elements.Edge;
import view.elements.Vertex;

import javax.swing.*;
import java.awt.*;

public class GraphBuilding {

    public void init(GraphParameters sgv){
        Layout<Vertex, Edge> layout = new KKLayout<Vertex, Edge>(sgv.getGraph());
        layout.setSize(new Dimension(700, 600));
        VisualizationViewer<Vertex, Edge> vv = new VisualizationViewer<>(layout);
        vv.setPreferredSize(new Dimension(720, 620));
        PluggableGraphMouse graphMouse = new PluggableGraphMouse();
        graphMouse.add( new PickingGraphMousePlugin<Vertex, Edge>() );
        vv.setGraphMouse(graphMouse);
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<>());
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        Transformer<Vertex, Paint> vertexColor = new Transformer<Vertex, Paint>(){
            public Paint transform (Vertex javaItem){
                return Color.GREEN;
            }
        };
        vv.getRenderContext().setVertexFillPaintTransformer(vertexColor);
        JFrame frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
