package maze;

public class Maze {
    protected char maze[][];
    protected final int MAX_HEIGHT = 25;
    protected final int MAX_WIDTH = 25;
    protected int height = 0;
    protected int width = 0;
    protected int openingL = 0;
    protected int openingR = 0;
    
    public Maze(){
        this.setHeight(this.MAX_HEIGHT);
        this.setWidth(this.MAX_WIDTH);
        System.out.println(this.getHeight() + " Height");
        System.out.println(this.getWidth()+ " Width");
        System.out.println("Initializing Maze");
        
        maze = new char[this.getHeight()][this.getWidth()];
        this.initMaze();
    }
    public Maze(int tempHeight, int tempWidth){
        this.setHeight(tempHeight);
        this.setWidth(tempWidth);
        maze = new char[getHeight()][getWidth()];
        this.initMaze();
    }
    public char[][] getMaze(){
        return maze;
    }
    private int getHeight(){
        return this.height;
    }
    private int getWidth(){
        return this.width;
    }
    private void setHeight(int height){
        if(height > MAX_HEIGHT){
            System.out.println("Height exceeded max, defaulting to " + MAX_HEIGHT);
            this.height = MAX_HEIGHT;
        }else if (height < 4){
            System.out.println("Height is below minimum, defaulting to 4");
            this.height = 4;
        }else{
            this.height = height;
        }
    }
    private void setWidth(int width){
        if(width > this.MAX_WIDTH){
            System.out.println("Width exceeds maximum defaulting to " 
                    + MAX_WIDTH);
            this.width = MAX_WIDTH;
        }else if(width < 4){
            System.out.println("Width is below minimum, defaulting to 4");
        }else{
            this.width = width;
        }
    }
    private void initMaze(){
        this.buildBorder();
        this.fillMaze();
    }
    
    private void fillMaze(){
        for (int i = 1; i < this.height-1; i++) {
            for (int j = 1; j < this.width-1; j++) {
                if(Math.random() > .35){
                    maze[i][j] = '#';
                }else{
                    maze[i][j] = '.';
                }
            }
        }
        
        //make sure the square directly right of openingL is available
        this.maze[this.openingL][0] = 'Q';
        this.maze[this.openingL][1] = 'Q';
        //make sure square directly left of openingR is available
        System.out.println("L: "+openingL);
        System.out.println("R: "+openingR);
        this.maze[this.openingR][this.width-1] = 'Z';
        this.maze[this.openingR][this.width-2] = 'Z';
    }
    
    private void buildBorder(){
        
        for (int i = 0; i < this.width - 1; i++) {
            //Build top border
            this.maze[0][i] = '#';
            //Build Bottom Border
            this.maze[this.height - 1][i]= '#';
        }
        for (int i = 0; i < this.height; i++) {
            //build left border
            this.maze[i][0]='#';
            //build right border
            this.maze[i][this.width - 1]='#';
        }
        //init
        this.openingL = 0;
        this.openingR = 0;
        //set openings
        this.openingL = (int)(Math.random() * (this.height-2)) + 1;
        this.openingR = (int)(Math.random() * (this.height-2)) + 1;

    }
    
    public void printMaze(){
        char temp;
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                temp = this.maze[i][j];
                System.out.print(temp);
            }
            System.out.println("");
        }
    }
}
