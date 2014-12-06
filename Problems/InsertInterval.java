public class InsertInterval {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval == null) {
            return intervals;
        }
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        for(int i = 0; i < intervals.size(); i++) {
            if(newInterval != null) {
                Interval current = intervals.get(i);
                
                if(current.start > newInterval.end) {
                    result.add(newInterval);
                    newInterval = null;
                    i--;
                } else if(current.end < newInterval.start) {
                    result.add(current);
                } else {
                    //merge
                    //check if need to merge with last inserted
                    Interval toInsert = new Interval();
                    toInsert.start = Math.min(newInterval.start, current.start);
                    toInsert.end   = Math.max(newInterval.end, current.end);
                    newInterval = null;
                    
                    if(result.size() > 0) {
                        Interval past = result.get(result.size() - 1);
                        if(past.end < toInsert.start) {
                            result.add(toInsert);
                        } else {
                            past.start = Math.min(past.start, toInsert.start);
                            past.end   = Math.max(past.end, toInsert.end);
                        }
                        
                    } else {
                        result.add(toInsert);
                    }
                    
                }
                
                
            } else{
                Interval toInsert = intervals.get(i);
                if(result.size() > 0) {
                    Interval past = result.get(result.size() - 1);
                    if(past.end < toInsert.start) {
                        result.add(toInsert);
                    } else {
                        past.start = Math.min(past.start, toInsert.start);
                        past.end   = Math.max(past.end, toInsert.end);
                    }
                        
                } else {
                    //check if last overlaps
                    result.add(intervals.get(i));
                }
            }
        }
        
        if(newInterval != null) {
            result.add(newInterval);
        }
        
        return result;
    }
}