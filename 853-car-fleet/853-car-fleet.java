// class Solution {

// public class Car implements Comparable<Car>{
//     int position , speed;
//     Car(int position , int speed){
//         this.position = position;
//         this.speed = speed;
//     }
//     public int compareTo(Car c){
//         return c.position - this.position;
//     }
// }

// public int carFleet(int target, int[] position, int[] speed) {
//     int n = position.length , countFleet = 0;
//     Car[] cars = new Car[n];
    
//     for(int i = 0 ; i < n ; i++) cars[i] = new Car(position[i] , speed[i]);
    
//     Arrays.sort(cars);
    
//     double fastestTime = -1.0;
    
//     for(int i = 0 ; i < n ; i++){
//         double currTime = ((target - cars[i].position)*1.0) / cars[i].speed;
//         if(currTime > fastestTime){
//             countFleet++;
//             fastestTime = currTime;
//         }
//     }
    
//     return countFleet;
// }
// }

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length==1)
            return 1;
        Stack<Double> stack=new Stack<>();
        int[][] combine=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            combine[i][0]=position[i];
            combine[i][1]=speed[i];
        }
        
        
        
        Arrays.sort(combine,java.util.Comparator.comparingInt(o->o[0]));
        for(int i=combine.length-1;i>=0;i--){
            double currentTime=(double)(target-combine[i][0])/combine[i][1];
            if(!stack.isEmpty() && currentTime<=stack.peek()){
                continue;
            }
            else{
            stack.push(currentTime);
            }
        }
        return stack.size();
    }
}