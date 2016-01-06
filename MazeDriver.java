package maze;

public class MazeDriver {

    public static void main(String[] args) {
        //@TODO code application logic here

        MazeSolver m = new MazeSolver();
        Maze q = new Maze(10,10);
        MazeSolver n = new MazeSolver(q);
    }
}
