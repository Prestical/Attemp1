import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorSimulation {
    public static void mapMaker(ArrayList<Elevator> elevators){
        Elevator[] lifts = elevators.toArray(new Elevator[elevators.size()]);
        System.out.println("\t\t\s\s\s\sELEVATORS");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tLeft\t|\tMid\t|\tRight\t|");
        System.out.println(String.format("|\t%d\t|\t%d\t|\t%d\t|",lifts[0].getLayer(),lifts[1].getLayer(),lifts[2].getLayer()));
        System.out.println("-------------------------------------------------");
    }
    public static int whichLiftCloser(Elevator[] lifts, int requestedLayer){
        int listPosition = 0;
        int min = Math.abs(lifts[0].getLayer() - requestedLayer);
        for (int i = 0; i < lifts.length; i++) {
            if (min > Math.abs(lifts[i].getLayer() - requestedLayer)) {
                min = Math.abs(lifts[i].getLayer() - requestedLayer);
                listPosition = i;
            }
        }
        return listPosition;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Elevator> elevators = new ArrayList<Elevator>();
        // Creating elevators.
        for (int i = 0; i < 3; i++) {
            Elevator lift = new Elevator(i,0); 
            elevators.add(i,lift);
        }
        Elevator[] lifts = elevators.toArray(new Elevator[elevators.size()]);

        while (true) {
            System.out.print("Enter the layer number (-1 to exit program): ");
            int calledLayer = sc.nextInt();
            int liftPosition = whichLiftCloser(lifts, calledLayer);

            if (calledLayer == -1) {
                sc.close();
                break;
            }
            while(true){
                mapMaker(elevators);
                if(calledLayer != lifts[liftPosition].getLayer()){
                    if(calledLayer  - lifts[liftPosition].getLayer() >= 0){
                        lifts[liftPosition].setLayer(lifts[liftPosition].getLayer()+1);
                    }else{
                        lifts[liftPosition].setLayer(lifts[liftPosition].getLayer()-1);
                    }
                }else{
                    break;
                }
                // Waiting part.
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Clearing terminal.
                try {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}