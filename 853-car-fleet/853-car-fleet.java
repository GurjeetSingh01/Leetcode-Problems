class Solution {

public class Car implements Comparable<Car>{
    int position , speed;
    Car(int position , int speed){
        this.position = position;
        this.speed = speed;
    }
    public int compareTo(Car c){
        return c.position - this.position;
    }
}

public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length , countFleet = 0;
    Car[] cars = new Car[n];
    
    for(int i = 0 ; i < n ; i++) cars[i] = new Car(position[i] , speed[i]);
    
    Arrays.sort(cars);
    
    double fastestTime = -1.0;
    
    for(int i = 0 ; i < n ; i++){
        double currTime = ((target - cars[i].position)*1.0) / cars[i].speed;
        if(currTime > fastestTime){
            countFleet++;
            fastestTime = currTime;
        }
    }
    
    return countFleet;
}
}