public class P6 {

    // Class variables
    public static Maze maze;
    public static int mazeWidth;
    public static int mazeHeight;

    public static void main(String[] args) {

        // Create maze
        String fileName = args[0]; 
        System.err.println("Maze name: " + fileName);

        // Get dimensions
        maze = new Maze(fileName);
        mazeWidth = maze.getWidth();
        mazeHeight = maze.getHeight();
        System.err.println("Maze width: " + mazeWidth);
        System.err.println("Maze height: " + mazeHeight);

        // Add code to move around maze
        do {
        	if (maze.getRow()%2==0) {
        		for(int i=0; i < maze.getWidth()-1;i++) {
        			if (!maze.moveRight()) {
        				maze.moveDown();
        				maze.moveRight();
        				maze.moveRight();
        				i++;
        				maze.moveUp();
        			}
        		}
        	}
        	maze.moveDown();
        	if (maze.getRow()%2==1) {
        		for(int i=0; i<maze.getWidth()-1;i++) {
        			if (!maze.moveLeft()) {
        				maze.moveDown();
        				maze.moveLeft();
        				maze.moveLeft();
        				i++;
        				maze.moveUp();
        			}
        		}
        	}
        }
        while (maze.moveDown());
    }
}   