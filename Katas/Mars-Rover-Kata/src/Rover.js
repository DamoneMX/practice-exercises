function Rover(x, y, direction){
	this.x = x;
	this.y = y;
	this.direction = direction;
}

//Rover.prototype.demo = function(){};
Rover.prototype.readInstruction = function(commandSet){

	var charArray = commandSet.split('');
	for(var i = 0; i < charArray.length; i++){
		var instruction = charArray[i];
		if(instruction == "r" || instruction == "l")
			this.changeDirection(instruction);
		else if(instruction == "f" || instruction == "b")
			this.move(instruction);
		else
			throw new Error("Invalid Instruction.");
	}

}

Rover.prototype.changeDirection = function(command){
	switch(this.direction){
		case "N":
			command == "r" ? this.direction = "E" : this.direction = "W";
		break;
		case "E":
			command == "r" ? this.direction =  "S" : this.direction = "N";
		break;
		case "S":
			command == "r" ? this.direction =  "W": this.direction = "E";
		break;
		case "W":
			command == "r" ? this.direction = "N" : this.direction = "S";
		break;
	}

}

Rover.prototype.move = function(command){
	if(!this.grid)
		throw new Error("Unable to move, rover is not in grid");

	var step;
	if(command == "f")
		var step = 1;
	else
		var step = -1;

	switch(this.direction){
		case "N":
			if(this.y - step < 0)
				this.y = this.grid.xLimit -1;
			else if(this.y = step > this.grid.xLimit - 1)
				this.y = 0;
			else
				this.y -= step;	
		break;
		case "E":
			this.x == this.grid.xLimit ? this.x = 0 : this.x += step;
		break;
		case "S":
			if(this.y + step < 0)
				this.y = this.grid.xLimit -1;
			else if(this.y + step > this.grid.xLimit - 1)
				this.y = 0;
			else
				this.y += step;	
		break;
		case "W":
			if(this.x - step < 0)
				this.x = this.grid.xLimit -1;
			else if(this.x - step > this.grid.xLimit - 1)
				this.x = 0;
			else
				this.x -= step;	
		break;
	}

}