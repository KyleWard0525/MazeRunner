/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import DataStructures.EmptyCollectionException;
import DataStructures.StackADT;
import java.util.ArrayList;

/**
 *
 * @author Kyle Ward
 */
public class ArrayListStack<T> extends ArrayList implements StackADT {

    @Override
    public void push(Object t) {
        this.add(t);
    }

    @Override
    public Object pop() {
        Object o = null;
        try {
            o = this.get(this.size() - 1);
            this.remove(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Object peek() throws EmptyCollectionException {
        return this.get(this.size() - 1);
    }

}