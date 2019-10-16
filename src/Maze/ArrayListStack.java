/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import DataStructures.EmptyCollectionException;
import DataStructures.StackADT;
import grid.Location;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle Ward
 * @param <T>
 */
public class ArrayListStack<T> implements StackADT {

    private ArrayList<T> list = new ArrayList<T>();
    
    /**
     *
     * @param t
     */
    @Override
    public void push(Object t) {
        list.add((T)t);
    }

    /**
     *
     * @return
     * @throws DataStructures.EmptyCollectionException
     */
    @Override
    public T pop() throws EmptyCollectionException{
        T o = list.get(list.size()- 1);
        
        if(list.size() > 0)
        {
         o = list.get(list.size()- 1);
         list.remove(o);
        }
        
        if(list.size() <= 0)
        {
            o = list.get(list.size());
            list.remove(o);
        }
        return o;
    }

    /**
     * @return
     * @throws DataStructures.EmptyCollectionException
     */
    @Override
    public T peek() throws EmptyCollectionException{
        T o = list.get(list.size()- 1);
        if(list.size() > 0)
        {
         o = list.get(list.size()- 1);
        }
        
        if(list.size() <= 0)
        {
            o = list.get(list.size());
        }
        return o;
    }

    @Override
    public boolean isEmpty() {
         return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    boolean contains(T t) {
        return list.contains(t);
    }
    
}
