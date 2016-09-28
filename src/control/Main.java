package control;

import model.Calculator;
import view.GraphBuilding;
import view.GraphParameters;

public class Main {
    public static void main(String ... args){
        init();
    }
    private static void init(){
        GraphBuilding graph = new GraphBuilding();
        GraphParameters graphParameters = new GraphParameters(9);
        graph.init(graphParameters);
        Calculator calculator = new Calculator(graphParameters);
        System.out.println("K = " + calculator.getSteps());
        System.out.println("T = " + String.format("%.2f", calculator.getTime()));
    }
}
