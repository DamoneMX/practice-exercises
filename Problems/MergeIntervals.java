public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0 || intervals.size() == 1)
        	return intervals;
        
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> merged = new ArrayList<Interval>();
        merged.add(intervals.get(0));
        for(int i = 0; i < intervals.size(); i++){
        	if(i == 0)
        		continue;
        	Interval interval2 = intervals.get(i);
        	Interval mergedInterval = merged.get(merged.size() - 1);
        	if(interval2.start <= mergedInterval.end){
        		if(interval2.end > mergedInterval.end)
        			mergedInterval.end = interval2.end;
        	}
        	else
        		merged.add(interval2);
        }
        
        return merged;
    }
}