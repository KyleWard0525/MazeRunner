/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import DataStructures.StackADT;
import java.util.ArrayList;

/**
 *
 * @author Kyle Ward
 * @param <T>
 */
public class ArrayListStack<T> extends ArrayList implements StackADT {

    /**
     *
     * @param t
     */
    @Override
    public void push(Object t) {
        this.add(t);
    }

    /**
     *
     * @return
     */
    @Override
    public Object pop() {
        Object o = null;
        o = this.get(this.size() - 1);
        this.remove(o);
        return o;
    }

    /**
     *
     * @return
     */
    @Override
    public Object peek() {
        return this.get(this.size() - 1);

    }

}
