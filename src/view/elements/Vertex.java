package view.elements;

/**
 * Created by igor on 25.09.16.
 */
public class Vertex {
    private Integer id;
    public Vertex(Integer id) {
        this.id = id;
    }
    public String toString() {
        return "S"+id;
    }
    public int getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}

