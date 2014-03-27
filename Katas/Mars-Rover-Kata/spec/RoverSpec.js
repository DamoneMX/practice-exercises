describe("Rover", function() {
  var rover;

  beforeEach(function() {
    rover = new Rover();
    grid  = new Grid(rover);
  });

  describe("Grid", function(){
    it("should not allow rover to be created in an invalid position", function(){
      rover = new Rover(10,10,"N");
      grid = new Grid(0,0);

      expect(function(){ grid.deployRover(rover) }).toThrowError("Rover must be inside Grid.");
    });
  });

  describe("Rover", function(){
    beforeEach(function() {
      rover = new Rover(0, 0, "E");
      grid = new Grid(100, 100);
      grid.deployRover(rover);
    });

    it("should be created in a specific point", function(){
      expect(rover.x).toBe(0);
      expect(rover.y).toBe(0);
      expect(rover.direction).toBe("E")
    });

    describe("it should turn", function() {
      
      it("clockwise when given 'r' instruction", function() {
        rover.readInstruction("r");
        expect(rover.direction).toEqual("S");
        rover.readInstruction("r");
        expect(rover.direction).toEqual("W");
        rover.readInstruction("r");
        expect(rover.direction).toEqual("N");
      });

      it("counter-clockwise when given 'l' instruction", function(){
        rover.readInstruction("l");
        expect(rover.direction).toEqual("N");
        rover.readInstruction("l");
        expect(rover.direction).toEqual("W");
        rover.readInstruction("l");
        expect(rover.direction).toEqual("S");
      })

    });

    describe("it should move", function(){
      var currentX, currentY;

      beforeEach(function() {
        currentX = rover.x;
        currentY = rover.y;
      });

      it("to the right when facing east", function(){
        rover.readInstruction("f");
        expect(rover.x).toBe(currentX + 1);
        rover.readInstruction("b");
        expect(rover.x).toBe(currentX);
      });

      it("to the left when facing west", function(){
        rover.readInstruction("rrff");
        expect(rover.x).toBe(98);
        rover.readInstruction("bb");
        expect(rover.x).toBe(currentX);
      });

      it("down when facing south", function(){
        rover.readInstruction("rf");
        expect(rover.y).toBe(currentY + 1);
        rover.readInstruction("b");
        expect(rover.x).toBe(currentX);
      });

      it("up when facing north", function(){
        rover.readInstruction("lf");
        expect(rover.y).toBe(99);
        rover.readInstruction("b");
        expect(rover.x).toBe(currentX);
      });

    });

    

  });

});
