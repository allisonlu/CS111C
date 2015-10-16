import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AirportSimulation {

   public static void main(String[] args) {

       // These two queues represent all of the take off and landing events in the whole day
       PriorityQueue<Plane> allPlaneEvents = new PriorityQueue<Plane>();

       // These are the the number of minutes that we expect a plane to take to use the runway
       final int TakeOffTime = 5;
       final int LandingTime = 3;

       // These are the number of take-offs and landings in a day. The events will be
       // randomly interspearsed throught the day
       final int AverageTakeOffRequestsPerHour = 4;
       final int AverageLandingRequestsPerHour = 4;

       // We will run our simulation for a years worth of simulated days...
       final int HoursInSimulation = 365 * 24;

       // Add the take off requests to the queue
       int totalTakeOffEventCount = HoursInSimulation * AverageTakeOffRequestsPerHour;

       for (int i = 0; i < totalTakeOffEventCount; i++) {
           Plane p = new Plane(Plane.Takeoff, getRandomMinuteInHours(HoursInSimulation));
           allPlaneEvents.add(p);
       }

       // Add the landings
       int totalLandingEventCount = HoursInSimulation * AverageLandingRequestsPerHour;

       for (int i = 0; i < totalLandingEventCount; i++) {
           Plane p = new Plane(Plane.Landing, getRandomMinuteInHours(HoursInSimulation));
           allPlaneEvents.add(p);
       }

       // variables for keeping track of longest waits
       int longestLandingWait = 0;
       int longestTakeoffWait = 0;

       // variables for keeping track of average waits
       int totalLandingWait = 0;
       int totalTakeoffWait = 0;

       // Keep track of the next minute in which the runway will be available.
       int nextMinuteRunwayWillBeAvailable = 0;

       // These two queues represent the Planes that have asked permission to take off or land
       Queue<Plane> planesInTheAir = new LinkedList<Plane>();
       Queue<Plane> planesOnTheRunway = new LinkedList<Plane>();

       // For the simulation, we will tick through every minute in the time period. We will process
       // each Plane when its time comes.
       for (int minute = 0; minute < (HoursInSimulation * 60); minute++) {

           // Check to see if there are new arrivals
           while (!allPlaneEvents.isEmpty() && minute >= allPlaneEvents.peek().getArrivalTime()) {
               Plane nextPlane = allPlaneEvents.remove();

               if (nextPlane.isLanding())
                   planesInTheAir.add(nextPlane);
               else
                   planesOnTheRunway.add(nextPlane);
           }

           // if the runWay is available, process the next plane in the air, or on the runway
           if (minute >= nextMinuteRunwayWillBeAvailable) {

               // In the air...
               if (!planesInTheAir.isEmpty()) {
                   Plane p = planesInTheAir.remove();
                   int completionTime = minute + LandingTime;

                   p.setEndTime(completionTime);
                   nextMinuteRunwayWillBeAvailable = completionTime;

                   totalLandingWait += p.elapsedTime();

                   if (p.elapsedTime() > longestLandingWait)
                       longestLandingWait = p.elapsedTime();
               }

               // One the runway
               else if (!planesOnTheRunway.isEmpty()) {
                   Plane p = planesOnTheRunway.remove();
                   int completionTime = minute + TakeOffTime;

                   p.setEndTime(completionTime);
                   nextMinuteRunwayWillBeAvailable = completionTime;

                   totalTakeoffWait += p.elapsedTime();

                   if (p.elapsedTime() > longestTakeoffWait)
                       longestTakeoffWait = p.elapsedTime();
               }
           }
       }

       System.out.println("longest landing wait: " + longestLandingWait);
       System.out.println("average landing wait: " + totalLandingWait / totalLandingEventCount);
       System.out.println();
       System.out.println("longest takeoff wait: " + longestTakeoffWait);
       System.out.println("average takeoff wait: " + totalTakeoffWait / totalTakeOffEventCount);
   }
   
   public static int getRandomMinuteInHours(int hours) {
       return (int) (Math.random() * (hours * 60));
   }
}
