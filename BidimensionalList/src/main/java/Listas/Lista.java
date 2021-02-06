/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author alumno
 */
public interface Lista {
    void add(int index,Object x);
    void remove(int index);
    int indexOf(Object x);
    
    void reemplace(int index, Object x);
    
    Object get (int index);
    void clear();
    boolean isEmpty();
    int length();
}















