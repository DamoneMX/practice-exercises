/**
 *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. 
 *  You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the 
 *  gas stations. 
 *  Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 
 *  Note: The solution is guaranteed to be unique. 
 * 
 *  Solution:
 *  This is a version that modifies the original tree, it modifies in order to mark the paths already visited
 *  this can also be achieved by using a node that keeps track of the last visited node
 */
public class GasStation {
/*
 *  Solution:
 *  The note is very important, the fact that solution is guaranteed to be unique means we can discard options as soon as we realize
 *  that they are not the solution. (cost[i] - gas[i] < 0)
 *  The note lets you keep the solution in a O(n) time complexity 
 *  Once you figured out you only need to keep track of the correct starting point, figure out a way to store the sum of the points you already 
 *  went through
 */
   public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length || gas.length == 0  || cost.length == 0)
            return 0;
        
        int stepSum = 0;
        int overallSum = 0;
        int initialPoint = 0;
        
        for(int i = 0; i < gas.length; i++){
            stepSum += gas[i] - cost[i];
            overallSum += stepSum;
            if(stepSum < 0){
                initialPoint = i + 1;
                stepSum = 0;
            }
        }
        
        if(overallSum >= 0)
            return initialPoint;
        
        return -1;
    }

/*
 *  Naive Solution: O(n^2)
 */
    public int canCompleteCircuitNaive(int[] gas, int[] cost) {
        int[][] register = new int[gas.length][gas.length];
        for(int i = 0; i < gas.length; i++){
            register[i][i] = gas[i];
            //gas[i] = 0;
        }
        
        
        for(int i = 0; i < gas.length; i++){
            for(int j = i; j < gas.length + i; j++){
                int cell = j;
                if(cell >= gas.length)
                    cell -= gas.length;
                
                int gasTank = register[i][cell];
                //if(i == cell)
                    //register[i][cell] = 0;
                
                int nextStation = cell + 1;
                if(nextStation == gas.length)
                    nextStation = 0;
                
                gasTank -= cost[cell];
                if(gasTank < 0)
                    register[i][nextStation] = gasTank;
                else{
                    if(nextStation != i)
                        register[i][nextStation]  = gasTank + gas[nextStation];
                    else
                        if(gasTank >= 0)
                            return gasTank;
                }
                
            }
        }
        
        return -1;
    }

}