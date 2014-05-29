/**
 *  Given an absolute path for a file (Unix-style), simplify it.
 *  path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath{
/*
 *  Solution:
 *  Use stack and pop on ..
 */
   public String simplifyPath(String path) {
        if(path.length() == 0)
            return "";
        
        if(path.length() == 1)
            return "/";
        
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(String part : parts){
            part = part.trim();
            if(part.equals(""))
                continue;
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                if(part.equals(".")){
                    continue;
                }
                else{
                    stack.push(part);
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty())
            sb.append("/");
        else{
            while(!stack.isEmpty()){
                sb.insert(0, stack.pop());
                sb.insert(0, "/");
            }
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