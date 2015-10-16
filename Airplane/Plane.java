import java.util.Comparator;

public class Plane implements Comparable<Plane> {

   public static final int Landing = 0;
   public static final int Takeoff = 1;

   private int priority;
   private int arrivalTime;
   private int endTime;

   public Plane(int priority, int startTime) {
       this.priority = priority;
       this.arrivalTime = startTime;
   }

   // Only endTime has a setter
   public void setEndTime(int value) {
       endTime = value;
   }

   // Getters
   public int getPriority() {
       return priority;
   }

   public int getArrivalTime() {
       return arrivalTime;
   }

   public int getEndTime() {
       return endTime;
   }

   public int elapsedTime() {
       return endTime - arrivalTime;
   }

   public boolean isLanding() {
       return priority == Landing;
   }

   // Compares two planes based on priority first, and start time second.
   public int compareTo(Plane p2) {
       //System.out.println("about to return " + (startTime - p2.startTime) + " for " + this + " and " + p2);
       return arrivalTime - p2.arrivalTime;
   }
   
   // For debugging
   public String toString() {
       String type = isLanding()? "landing" : "takingoff";
      return "Plane - " + type + ", arrivalTime: " + arrivalTime;
   }
}
