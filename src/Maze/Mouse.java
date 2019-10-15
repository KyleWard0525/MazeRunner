package Maze;

import DataStructures.EmptyCollectionException;
import asset.AbstractMouse;
import grid.Location;
import java.util.ArrayList;
import java.util.List;

public class Mouse extends AbstractMouse {

    private ArrayListStack<Location> crumbs;

    /**
     * Default Constructor of Mouse Object.
     */
    public Mouse() {
        super();
        crumbs = new ArrayListStack<Location>();
        crumbs.push(getLocation());
    }

    /**
     * Constructor used for the purposes of unit testing.
     *
     * @param crumbs a previously existing stack of crumbs
     */
    public Mouse(ArrayListStack<Location> crumbs) {
        this.crumbs = crumbs;
    }

    /**
     * Determines which adjacent locations are empty for the mouse to traverse.
     *
     * @return a list of traversable empty locations
     */
    @Override
    protected List<Location> getEmptyLocations() {
        List<Location> emptyLocations = new ArrayList<Location>(4);

        // Create a list of locations adjacent to the mouse
        List<Location> adjacentLocations = getAdjacentLocations();

        // Examine each location adjacent to the mouse
        Location location;
        for (int i = 0; i < adjacentLocations.size(); i++) {
            location = adjacentLocations.get(i);

            // The location is valid if it can be traversed
            if (canTraverse(location)) {
                // If adjacent to cheese, go directly to it and find cheese
                if (seesCheeseAt(location)) {
                    moveTo(location);
                    foundCheese();
                    return emptyLocations;
                }

                /* Add the location to the empty locations list if it is not a 
                rock and has not been visited */
                if (!seesRockAt(location) && !hasVisited(location)) {
                    emptyLocations.add(location);
                }
            } else {
                /* Visited locations and rocks are considered invalid and 
                should be removed from the list of adjacent locations */
                adjacentLocations.remove(location);
            }
        }
        return emptyLocations;
    }

    /**
     * Controls the logic of how the mouse will move.
     *
     * @param emptyLocations a list of traversable empty locations
     */
    @Override
    public void move(List<Location> emptyLocations) {
        /*
        Check the number of empty locations available adjacent to the mouse's 
        current location.
        If any option exists, push the current location to the crumbs and choose 
        a new location to move to randomly.
        Otherwise, move to the last location visited and pop it from the crumbs.
         */
        try{
        //Get the number of empty spaces
        for (Location l : emptyLocations) {

            //Check that the space has not been visited
            if (!crumbs.contains(l)) {

                //Check traverseability, add crumb, move.
                if (canTraverse(l)) {
                    crumbs.push(l);
                    moveTo(l);
                }
            } else {
                Location prev = (Location) crumbs.pop();

                //Move to previous space
                if (canTraverse(prev)) {
                    moveTo(prev);
                }

                return;
            }
        }

        //If all adjacent spaces have been traversed
        if (emptyLocations.isEmpty()) {
            //Remove previous space
            crumbs.pop();

            if (crumbs.size() - 1 >= 1) {
                Location loc = (Location) crumbs.pop();
                if (canTraverse(loc)) {
                    //Move back 1 spaces
                    try {
                        if (seesCheeseAt(loc)) {
                            moveTo(loc);
                        } else if (seesRockAt(loc) || hasVisited(loc)) {
                            loc = (Location) crumbs.peek();
                        }
                        moveTo(loc);
                    } catch (Exception e) {
                        System.out.println("Exception thrown in Mouse.java in move() method.");
                        e.printStackTrace();
                    }
                } else {
                    crumbs.pop();
                    if (crumbs.size() > 0) {
                        if (canTraverse((Location) crumbs.pop())) {
                            //Move back 2 spaces
                            moveTo((Location) crumbs.pop());
                        }
                    }

                }
            } else {
                Location loc = (Location) crumbs.peek();

                if (canTraverse(loc)) {
                    moveTo(loc);
                }
            }
        }
    }
        catch(EmptyCollectionException ece)
        {
            ece.printStackTrace();
        }
    }

    /**
     * Determines whether the mouse has already visited this location.
     *
     * @param location the location to check
     * @return true if the mouse has visited this location
     */
    @Override
    public boolean hasVisited(Location location) {
        boolean visited = false;
        Location l = null;
        
        try{
        l = (Location) crumbs.peek();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if (l == location) {
            visited = true;
        }
        return visited;
    }

    /**
     * Instructs the mouse to move to the specified location.
     *
     * @param location the location to move to
     */
    @Override
    public void moveTo(Location location) {
        super.moveTo(location);
    }

    /**
     * Accessor method for crumbs field for the purposes of unit testing.
     *
     * @return the mouse's stack of crumbs
     */
    public ArrayListStack<Location> getCrumbs() {
        return crumbs;
    }

    /**
     * Generates a list of adjacent locations.
     *
     * @return the list of adjacent locations
     */
    @Override
    protected List<Location> getAdjacentLocations() {
        return super.getAdjacentLocations();
    }

    /**
     * Gets the current location of the mouse.
     *
     * @return the current location of the mouse
     */
    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    /**
     * Checks whether the mouse can traverse a location.
     *
     * @param location the location to check
     * @return whether the mouse can traverse the location
     */
    @Override
    protected boolean canTraverse(Location location) {
        return super.canTraverse(location);
    }

    /**
     * Checks whether the mouse sees cheese at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees cheese at the location
     */
    @Override
    protected boolean seesCheeseAt(Location location) {
        return super.seesCheeseAt(location);
    }

    /**
     * Checks whether the mouse sees a rock at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees a rock at the location
     */
    @Override
    protected boolean seesRockAt(Location location) {
        return super.seesRockAt(location);
    }

    /**
     * Performed when cheese has been found by the mouse to complete the maze
     * run.
     */
    private void foundCheese() {
        super.setFoundCheese(true);
    }

}
