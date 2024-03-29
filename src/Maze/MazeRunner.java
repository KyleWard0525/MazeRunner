package Maze;

import asset.Cheese;
import asset.Maze;

/**
 *
 * @author zeke
 * @version 1/23/2019
 */
public class MazeRunner {

    /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze(20, 20);
        maze.printWorld(new Mouse(), new Cheese()).show();
    }

}
