package maze;


public class MazeSolver {
    /* Solves the Maze */
    protected boolean finished;
    public MazeSolver(){
        Maze m = new Maze(50,50);
        System.out.println("Generating new Maze:");
        m.printMaze();
    }
    public MazeSolver(Maze m){
        System.out.println("Using maze:");
        m.printMaze();
    }   
}
