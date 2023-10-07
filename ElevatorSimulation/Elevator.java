public class Elevator {
    private int id;
    private int layer;

    Elevator(int id, int layer){
        this.id = id;
        this.layer = layer;
    }
    int getID(){
        return id;
    }
    void setLayer(int layer){
        this.layer = layer;
    }
    int getLayer(){
        return layer;
    }
}
