
public class Range {
	private int start;
	private int end;
	
	public Range(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public void setStart(int start){
		this.start = start;
	}
	
	public int getStart(){
		return this.start;
	}
	
	public void setEnd(int end){
		this.end = end;
	}
	
	public int getEnd(){
		return this.end;
	}
}
