package Maze;

import DataStructures.*;
import asset.Cheese;
import asset.StaticMaze;
import grid.Location;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul Franklin
 */
public class MouseTest {

    private StaticMaze maze;
    private Mouse mouse;
    private final int TRAVERSABLE_EMPTY_LOCATIONS = 282;

    /**
     * Test constructor, prepares fields for unit tests.
     */
    public MouseTest() {
        maze = new StaticMaze(9, 16);
        mouse = new Mouse();
        maze.printStaticWorld(mouse, new Cheese());
    }

    /**
     * Test of move method, of class Mouse.
     */
    @Test
    public void testMove() {
        for (int i = 0; i < 2 * TRAVERSABLE_EMPTY_LOCATIONS + 1; i++) {

            int crumbsSize = mouse.getCrumbs().size();
            List<Location> emptyLocations = mouse.getEmptyLocations();
            Location crumbsTop = null;

            // Get peek if exists
            if (!mouse.getCrumbs().isEmpty()) {
                crumbsTop = (Location) (mouse.getCrumbs().peek());
            }

            mouse.act();

            if (mouse.hasFoundCheese()) {
                break;
            }

            // Case: Empty locations exist
            if (emptyLocations.size() > 0) {
                //assertEquals(crumbsSize, mouse.getCrumbs().size());
                assertTrue(emptyLocations.contains(mouse.getLocation()));
                assertNotEquals(mouse.getLocation(), crumbsTop);
            }

            // Case: No empty locations exist
            if (emptyLocations.isEmpty()) {
                assertEquals(crumbsSize - 1, mouse.getCrumbs().size());
                assertFalse(emptyLocations.contains(mouse.getLocation()));
                assertEquals(mouse.getLocation(), crumbsTop);
            }
        }

        assertTrue(mouse.hasFoundCheese());
    }

}
