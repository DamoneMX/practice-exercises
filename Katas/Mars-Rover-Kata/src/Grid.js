function Grid(x, y){
	this.xLimit = x;
	this.yLimit = y;
	this.rover;
}



Grid.prototype.deployRover = function(rover){
	//if (array.length > 0)
    //	return array[array.length - 1];

    //x and y minus than grid size and 
    if(rover.x <= this.xLimit && rover.y <= this.yLimit){
    	this.rover = rover;
    	rover.grid = this;
    }
  	else
    	throw new Error("Rover must be inside Grid.");
}