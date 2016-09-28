package model;

import view.GraphParameters;
import view.elements.Edge;

public class Calculator {
    private Integer steps;
    private Double time;
    public Calculator(GraphParameters graphParameters){
        this.time = 0.0;
        this.steps = 0;
        findStepsAndTime(graphParameters);
    }
    private void findStepsAndTime(GraphParameters graphParameters){
        for(Edge edge : graphParameters.getGraph().getEdges()){
            steps += edge.getAmountOfTransition();
            time += edge.getTimeForTransition() * edge.getAmountOfTransition();
        }
    }

    public Integer getSteps() {
        return steps;
    }

    public Double getTime() {
        return time;
    }
}
