import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MarsRover> marsRovers = new ArrayList<>();
        Plateau plateau = null;

        int lineCounter = -1;
        int roverCounter = 0;
        int tempX = 0;
        int tempY = 0;
        String tempDirection = "";


        while (scanner.hasNextLine()) {
            String curLine = scanner.nextLine();

            // case for creating the plateau, (first line)
            if (lineCounter == -1) {
                String[] curLineArr = curLine.split(" ");
                plateau = new Plateau( Integer.parseInt(curLineArr[0]), Integer.parseInt(curLineArr[1]));
            }

            if (curLine.isEmpty()) break;

            if (lineCounter % 2 == 0 && lineCounter >= 0) {
                String[] curLineArr = curLine.split(" ");
                // TODO: convert to int
                tempX = Integer.parseInt(curLineArr[0]);
                tempY = Integer.parseInt(curLineArr[1]);
                tempDirection = curLineArr[2];
            } else if (lineCounter % 2 == 1 && lineCounter >= 0) {
                MarsRover newRover = new MarsRover(plateau, curLine, tempX, tempY);
                newRover.setCurDirection(tempDirection);
                marsRovers.add(newRover);
                newRover.executeInstructions(curLine);
//                System.out.println("after execution call");
            }
            lineCounter++;
        }

        scanner.close();



        for (MarsRover e : marsRovers) {
            e.printDetails();
        }
    }
}
