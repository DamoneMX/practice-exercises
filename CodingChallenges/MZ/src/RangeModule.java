import java.util.LinkedList;

/**
 * @author  Arie Radilla Laureano
 */
public class RangeModule {
	/**
     * Linked List which holds the ranges
     */
	public LinkedList<Range> list = new LinkedList<Range>();
    
	/**
     * To insert we find the place where we need to insert, then change the range
     * A range may overlap several existing ranges so we need to process the whole list
     */
    public void AddRange(int lower, int upper){
    	Range newRange = new Range(lower, upper);	
		
		if(list.size() == 0){
			list.add(newRange);
			return;
		}
		
		int insertPosition = lookupInsertPosition(newRange);
		if(insertPosition == list.size()) { //adding at the end of list
			list.addLast(newRange);
			return;
		}
		
		Range range = list.get(insertPosition);
		if(newRange.getEnd() < range.getStart()){ //simplest insertion case
			list.add(insertPosition, newRange);
			return;
		}
		
		//ranges need to be merged
		if(newRange.getStart() <= range.getStart() || newRange.getStart() <= range.getEnd()) {
			range.setStart(Math.min(range.getStart(), newRange.getStart()));
			range.setEnd(Math.max(range.getEnd(), newRange.getEnd()));
			/*
			if(newRange.getEnd() <= range.getEnd()) {
				return;
			}
			*/
		}

		//our new end may overlap several of the ranges forward in the list
		//go through them and make appropiate end range changes
		for(int i = insertPosition + 1; i < list.size(); i++) {
			Range currentRange = list.get(i);
			if(range.getEnd() >= currentRange.getStart()) {
				int newEnd = Math.max(range.getEnd(), currentRange.getEnd());
				range.setEnd(newEnd);
				list.remove(i);
				i--;
			} 
		}		
		
    }
    
    /**
     * This function looks up the place where the new range is to be inserted
     */
    private int lookupInsertPosition(Range newRange){
    	int i = 0;
    	for(; i < list.size(); i++) {
    		Range currentRange = list.get(i);
    		if(currentRange.getEnd() < newRange.getStart()){
    			continue;
    		}
    		
    		if(newRange.getStart() <= currentRange.getEnd()){
    			break;
    		}    		
    	}
    	
    	return i;
    }

    /**
     * Loop over the list and set flags if the range is contained
     */
    public boolean QueryRange(int lower, int upper) {
    	Range newRange = new Range(lower, upper);

    	boolean contained 	   = false;
    	boolean startContained = false;
    	boolean endContained   = false;
    	for(Range range : list){
    		
    		if(startContained == false) {
    			if(newRange.getStart() >= range.getStart() && newRange.getEnd() <= range.getEnd()) {
    				startContained = true;
    			}
    		}
    		
    		if(startContained == true) {
	    		if(newRange.getEnd() >= range.getStart() && newRange.getEnd() <= range.getEnd()){ 
	    			endContained = true;
	    		}
    		}
    	}
    	
    	if(startContained && endContained) { 
    		contained = true;
    	}
    	
    	return contained;
    }

    /**
     * This was the trickiest part to come up with, 
     * I went for a solution that worked, there's cases that could be refactored
     */
    public void DeleteRange(int lower, int upper) {
       	Range newRange = new Range(lower, upper);
    	int erasePosition = lookupInsertPosition(newRange);

    	
    	for(int i = erasePosition; i < list.size() ; i++) {
    		Range currentRange = list.get(i);
    		if(newRange.getStart() <= currentRange.getStart()) { //deletion covers all current range
    			if(newRange.getEnd() >= currentRange.getEnd()) { //simplest case, we are erasing all node
    				list.remove(i);
    				i--;
    				continue;
    			}
    			
    			currentRange.setStart(newRange.getEnd() + 1);
    			return;
    		}
    		
    		//we may have to split range in two -> newRange.start > range.start && newRange.end < range.end
    		if(newRange.getStart() > currentRange.getStart() && newRange.getEnd() < currentRange.getEnd()) {
    			Range rangeToAdd = new Range(newRange.getEnd() + 1 , currentRange.getEnd());
    			currentRange.setEnd(newRange.getStart() - 1);
    			list.add(i + 1, rangeToAdd);
    			continue;
    		}
    		
    		if(newRange.getStart() <= currentRange.getEnd()) {
    			currentRange.setEnd(Math.min(newRange.getStart() - 1, currentRange.getEnd() - 1));
    		}
    		
    	}
    	
    }

    public static void main(String[] args){
    	RangeModule module = new RangeModule();
    	module.AddRange(10, 200);
    	module.AddRange(150, 180);
    	module.AddRange(350, 500);
    	module.AddRange(160, 300);
    //	module.AddRange(0, 600);
    	
    	module.DeleteRange(296, 300);
    	module.DeleteRange(20, 30);
    	
    	for(Range range : module.list){
    		System.out.println("start: " + range.getStart() + " end: " + range.getEnd());
    	}
    	
    	System.out.println(module.QueryRange(0,150) );
    	System.out.println(module.QueryRange(600,1150) );
    }
    
};
