import java.util.Arrays;

public class MarsRover {

    private int currX = 0;
    private int currY = 0;
    private String[] directions;
    private String curDirection;
    private int directionCount;
    private String[] instructions;
    private int curInstruction = 0;
    private Plateau plateau;
    private String lastExecutedInstruction;
    private boolean canMove;

    public MarsRover(Plateau pl, String instr, int x, int y) {
        currX = x;
        currY = y;
        plateau = pl;
        canMove = true;

        instructions = instr.split("");
        directions = new String[]{"N", "E", "S", "W"};
        directionCount = 0;

    }

    public String getInstruction() {
        return instructions[curInstruction];
    }

    public void setCurDirection(String curDic) {
        curDirection = curDic;
    }

    public int getCurrX() {
        return currX;
    }

    public int getCurY() {
        return currY;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public String getCurDirection() {
        return curDirection;
    }

    public void moveForward() {
//        System.out.println("in moveForward");
        switch (curDirection) {
            case "N":
                if ((this.currY + 1) <= this.plateau.getMaxY()) {
                    this.currY = this.currY + 1;
//                    System.out.println("moved north");
                    break;
                }
                else canMove = false;
                break;
            case "E":
                if ((this.currX + 1) <= this.plateau.getMaxX()) {
                    this.currX = this.currX + 1;
//                    System.out.println("moved east");
                    break;
                }
                else canMove = false;
                break;
            case "S":
                if ((this.currY - 1) >= 0) {
                    this.currY = this.currY - 1;
//                    System.out.println("moved south");
                    break;
                }
                else canMove = false;
                break;
            case "W":
                if ((this.currX - 1) >= 0) {
                    this.currX = this.currX - 1;
//                    System.out.println("moved west");
                    break;
                }
                else canMove = false;
                break;
        }

//        System.out.println("X: " + this.currX);
//        System.out.println("Y: " + this.currY);
//        System.out.println("end moveForward");
    }

    public void turnLeft() {
//        System.out.println("Old direction: " + curDirection);

        switch (curDirection) {
            case "N" -> curDirection = "W";
            case "E" -> curDirection = "N";
            case "S" -> curDirection = "E";
            case "W" -> curDirection = "S";
        }

//        System.out.println("Took a left turn");
//        System.out.println("New direction: " + curDirection);
    }

    public void turnRight() {
//        System.out.println("Old direction: " + curDirection);

        switch (curDirection) {
            case "N" -> curDirection = "E";
            case "E" -> curDirection = "S";
            case "S" -> curDirection = "W";
            case "W" -> curDirection = "N";
        }

//        System.out.println("Took a right turn");
//        System.out.println("New direction: " + curDirection);
    }

    public void executeInstructions(String instr) {
        for (String instruction : instructions) {
//            System.out.println("instruction: " + instruction);
            switch (instruction) {
                case "L" -> turnLeft();
                case "R" -> turnRight();
                case "M" -> moveForward();
            }
            lastExecutedInstruction = lastExecutedInstruction + instruction;
        }
    }

    public void printDetails() {
        System.out.println(currX + " " + currY + " " + curDirection);
//        System.out.println("Mars Rover is at coordinates (" + getCurrX() + "," + getCurY() + ") and is with correctly-executed instructions being " + getInstruction());
    }
}