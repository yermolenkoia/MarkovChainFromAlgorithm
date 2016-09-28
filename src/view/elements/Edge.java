package view.elements;


public class Edge {
    private Double probability;
    private Integer amountOfTransition;
    private Double timeForTransition;
    private String from;
    private String to;
    public Edge(Double probability, String from, String to, Integer amountOfTransition, Double timeForTransition){
        this.probability = probability;
        this.from = from;
        this.to = to;
        this.timeForTransition = timeForTransition;
        this.amountOfTransition = amountOfTransition;
    }

    public Double getTimeForTransition() {
        return timeForTransition;
    }

    public Integer getAmountOfTransition() {
        return amountOfTransition;
    }

    @Override
    public String toString() {
        return String.format("%.1f", probability) + " K=" + amountOfTransition + " t="
                + String.format("%.1f", timeForTransition);
    }
}

