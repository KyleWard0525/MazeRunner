package Maze;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Maze.ArrayListStack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ArrayListStackTest {

    public ArrayListStackTest() {
    }

    /**
     * Test of push method, of class ArrayListStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object t = new Integer(5);
        ArrayListStack instance = new ArrayListStack();

        //Check the size and contents
        assertEquals(0, instance.size());
        assertFalse(instance.contains(t));

        instance.push(t);

        //Check the size and contents
        assertEquals(1, instance.size());
        assertTrue(instance.contains(t));

    }

    /**
     * Test of pop method, of class ArrayListStack.
     */
    @Test
    public void testPop() throws Exception {
        System.out.println("pop");
        ArrayListStack instance = new ArrayListStack();
        Object expResult = new String("Hello, world!");
        Object tail = new String("Tail");

        //Check the size and contents
        assertEquals(0, instance.size());
        assertFalse(instance.contains(expResult));

        instance.push(tail);
        instance.push(expResult);

        Object result = instance.pop();

        assertEquals(expResult, result);
        assertEquals(1, instance.size());
    }

    /**
     * Test of peek method, of class ArrayListStack.
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("peek");
        ArrayListStack instance = new ArrayListStack();
        Object expResult = new Double(22.6);
        Object tail = new Double(17.2);

        //Check the size and contents
        assertEquals(0, instance.size());
        assertFalse(instance.contains(expResult));

        instance.push(tail);
        instance.push(expResult);

        Object result = instance.peek();

        assertEquals(expResult, result);
        assertEquals(2, instance.size());
    }

}
