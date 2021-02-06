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
public class Aleatoria implements Lista{
    
    private Object Lista[];
    private int size;
    
   public Aleatoria(int capacidad){
       Lista=new Object[capacidad];
       size=0;
   }
   public Aleatoria(){
       this(131072);
   }
   
    /**
     *
     * @param index
     * @param x
     */
  public void add(int index, Object x){
      if(index<0|| index>size){
          throw new IllegalArgumentException("add:index<0||index>size");
      }
      if(isEmpty()){
          Lista[index]=x;
          
      }else if(index==0){
          moveR(index);
          Lista[index]=x;
          
      }else if(index==size){   
          Lista[index]=x;
            
      }else{
          moveR(index);
          Lista[index]=x;
      }
      size++;
  }
  public void remove(int index){
      if(index<0||index>(size-1)){
          throw new IllegalArgumentException("remove:index<0|| index>(size-1)");
      }
      if(index==0){
          moveL(index);
          
      }else if(index==size-1){
          
      }else{
          moveL(index);
      }
      size--;
  }
  public int indexOf(Object x){
      int i;
      for(i=0;i<size;i++){
          if(x.toString().equals(Lista[i].toString())){
              break;
          }
      }
      return i==size?-1:i;
      
  }
  public void reemplace(int index, Object x){
      Lista[index] = x;
  }
    @Override
  public Object get(int index){
      if(index<0|| index>(size-1)){
          throw new IllegalArgumentException("get: index<0|| index>(size-1)");
       
      }
      return Lista[index];
      
  }
  public void clear(){
      size=0;
  }
  public boolean isEmpty(){
      return size==0;
  }
  public int length(){
      return size;
  }
  public String toString(){
      StringBuffer sb= new StringBuffer();
      sb.append('[');
      for(int i =0;i<size;i++){
          if(i!=0){
              sb.append(","+Lista[i]);
              
          }else{
              sb.append(Lista[i]+"");
          }
      }
      sb.append(']');
      return sb.toString();
      
      
  }
 public void moveR(int top){
     for(int i=size;i>top;i--){
        Lista[i]=Lista[i-1];
         
     }
     
     
 }
 public void moveL(int top){
     for(int i=top;i<size-1;i++){
         Lista[i]=Lista[i+1];
     }
 }
  
  
   
}
