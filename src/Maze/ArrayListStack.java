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
 * @author kward60
 * @version 1.0
 * @param <T>
 */
public class ArrayListStack<T> implements StackADT {

    private ArrayList<T> list = new ArrayList<>();

    /**
     *
     * @param t
     */
    @Override
    public void push(Object t) {
        list.add((T) t);
    }

    /**
     *
     * @return @throws DataStructures.EmptyCollectionException
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (list.size() <= 0) {
            throw new EmptyCollectionException("stack");
        } else {
            T o = list.get(list.size() - 1);
            list.remove(o);

            return o;
        }
    }

    /**
     * @return @throws DataStructures.EmptyCollectionException
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (list.size() <= 0) {
            throw new EmptyCollectionException("stack");
        } else {
            T o = list.get(list.size() - 1);
            return o;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *
     * @param t - the object to search for
     * @return true or false
     */
    public boolean contains(T t) {
        return list.contains(t);
    }

}
