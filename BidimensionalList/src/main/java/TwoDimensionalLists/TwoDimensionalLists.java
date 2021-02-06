/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoDimensionalLists;
import Listas.*;
/**
 *
 * @author OmarR
 */
public class TwoDimensionalLists implements ITwoDimensionalLists{
    private Lista twoDimensionallist;
    private int nf, nc;
    private char activate = '1', inactive = '0';
    private int initialSize = 0, itemWidth, rowSize;
    private boolean isDefined;
    
    public TwoDimensionalLists(int nf, int nc){
        twoDimensionallist = new Aleatoria();
        for(int f = 0; f<nf; f++){
            Lista fila = new Aleatoria();
            for(int c = 0; c<nc; c++){
                fila.add(fila.length(), "0");
            }
            twoDimensionallist.add(twoDimensionallist.length(), fila);
        }
        isDefined = true;
    }
    
     public TwoDimensionalLists(int nf, int nc, char activate, char inactive){
        this.activate = activate; this.inactive = inactive; 
        twoDimensionallist  = new Aleatoria();
        for(int f = 0; f<nf; f++){
            Lista fila = new Aleatoria();
            for(int c = 0; c<nc; c++){
                fila.add(fila.length(), "0");
            }
            twoDimensionallist.add(twoDimensionallist.length(), fila);
        }
        isDefined = true;
    }
   
    public TwoDimensionalLists(String matrix){
        twoDimensionallist = new Aleatoria();
        String[] rows = matrix.split("\n");
        for(int i = 0; i < rows.length; i++){
            Lista row = new Aleatoria(); int k = 0;
            for(int j = 0; j< rows[i].length(); j++){
                row.add(j, rows[i].charAt(k)); k++;
            }
            twoDimensionallist.add(twoDimensionallist.length(), row);
        }
        isDefined = true;
    }
    
    public String getText(){
        String text = viewText().replace('0', inactive);
        text = text.replace('1', activate);
        return text;
    }
    
    public void MoveUp(){
        Aleatoria rowstart = (Aleatoria)twoDimensionallist.get(0);
        for(int i = 0; i < twoDimensionallist.length() - 1; i++){
            twoDimensionallist.reemplace(i, twoDimensionallist.get(i+1));
        }
        twoDimensionallist.reemplace(twoDimensionallist.length()-1, rowstart);
    }
    
    public void MoveDown(){
        Aleatoria rowend = (Aleatoria)twoDimensionallist.get(twoDimensionallist.length()-1);
        for(int i = twoDimensionallist.length(); i > 0; i--){
            twoDimensionallist.reemplace(i, twoDimensionallist.get(i-1));
        }
        twoDimensionallist.reemplace(0, rowend);
    }
    
    public void MoveRight(){
        Lista aux = new Aleatoria();
        for(int i = 0; i < twoDimensionallist.length(); i++){
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            aux.add(i, row.get(row.length()-1));
        }
        
        for(int i = 0; i < twoDimensionallist.length(); i++){ 
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            for(int j = row.length(); j > 0; j--){
                row.reemplace(j, row.get(j-1));
            }
        }
        
        for(int i = 0; i < twoDimensionallist.length(); i++){
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            row.reemplace(0, aux.get(i));
        }
    }
    
     public void MoveLeft(){
        Lista aux = new Aleatoria();
        for(int i = 0; i < twoDimensionallist.length(); i++){
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            aux.add(i, row.get(0));
        }
        
        for(int i = 0; i < twoDimensionallist.length(); i++){ 
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            for(int j = 0; j < row.length()-1; j++){
                row.reemplace(j, row.get(j+1));
            }
        }
        
        for(int i = 0; i < twoDimensionallist.length(); i++){
            Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
            row.reemplace(row.length()-1, aux.get(i));
        }
    }
    int zoom = 0;
    public void IncreaseSize(){
        if(isDefined == false){
            for(int i = 0; i < twoDimensionallist.length(); i++){ 
                Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
                for(int j = row.length(); j > 0; j--){
                    row.add(j, row.get(j-1));
                }
                rowSize = row.length();
            }
            for(int i = twoDimensionallist.length(); i > 0; i--){
                twoDimensionallist.add(i, twoDimensionallist.get(i-1));
            }
        }
    }
    
    public void IncreaseSizeWide(){
        if(isDefined == false){
            for(int i = 0; i < twoDimensionallist.length(); i++){ 
                Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
                for(int j = row.length(); j > 0; j--){
                    row.add(j, row.get(j-1));
                }
                rowSize = row.length();
            }
        }
    }
    
    public void IncreaseSizeLong(){
        if(isDefined == false){
            for(int i = twoDimensionallist.length(); i > 0; i--){
                twoDimensionallist.add(i, twoDimensionallist.get(i-1));
            }
        }
    }
    
    public void DecreaseSize(){
        if(isDefined == false){
            if(rowSize > initialSize){
                for(int i = 0; i < twoDimensionallist.length(); i++){
                    Lista aux = new Aleatoria();
                    Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
                    int k = 0;
                    for(int j = 0; j < (row.length()/2); j++){
                        aux.add(j, row.get(k));
                        k+=2;
                    }
                    twoDimensionallist.reemplace(i, aux);
                    rowSize = aux.length();
                }
                if(twoDimensionallist.length() > 8){
                    for(int i = 0; i < twoDimensionallist.length() - 1; i++){
                        twoDimensionallist.remove(i+1);
                    }
                }
            }
        }
        
    }
    
    public void DecreaseSizeWide(){
        if(isDefined == false){
            if(rowSize > initialSize){
                for(int i = 0; i < twoDimensionallist.length(); i++){
                    Lista aux = new Aleatoria();
                    Aleatoria row = (Aleatoria)twoDimensionallist.get(i);
                    int k = 0;
                    for(int j = 0; j < (row.length()/2); j++){
                        aux.add(j, row.get(k));
                        k+=2;
                    }
                    twoDimensionallist.reemplace(i, aux);
                    rowSize = aux.length();
                }
            }
        }
        
    }
    
    public void DecreaseSizeLong(){
        if(isDefined == false){
            if(twoDimensionallist.length() > 8){
                for(int i = 0; i < twoDimensionallist.length() - 1; i++){
                    twoDimensionallist.remove(i+1);
                }
            }
        }
        
    }
    
    public int lenght(){
        return rowLength()*columnLength();
    }
    
    public int rowLength(){
        return twoDimensionallist.length();
    }
    public int columnLength(){
        return ((Aleatoria)twoDimensionallist.get(0)).length();
    }
    public void changeChars(char on, char off){
        activate = on;
        inactive = off;
    }
    
    @Override
    public String toString(){
        String texto = "";
        for(int i =0; i< twoDimensionallist.length(); i++){
            Aleatoria f = (Aleatoria)twoDimensionallist.get(i);
            texto += f;
            if(i < twoDimensionallist.length()-1){
                texto += "\n";
            }
        }
        return texto;
    }
    //NEW
    public String getMatrix(){
        String texto = "";
        for(int i =0; i< twoDimensionallist.length(); i++){
            Aleatoria f = (Aleatoria)twoDimensionallist.get(i);
            if(0<i){
                texto += " ";
            }
            texto += f;
            if(i < twoDimensionallist.length()-1){
                texto += "\n";
            }
        }
        texto = texto.replace("[", "");
        texto = texto.replace("]", "");
        texto = texto.replace(",", "");
        texto = texto.replace('0', inactive);
        texto = texto.replace('1', activate);
        return texto;
    }
    
    public void setMatrix(String codeMatrix){
        String[] rows = codeMatrix.split(" ");
        for(int i = 0; i < rows.length; i++){
            Lista row = (Aleatoria)twoDimensionallist.get(i); int k = 0;
            for(int j = 0; j< rows[i].length(); j++){
                row.reemplace(j, rows[i].charAt(k)); k++;
            }
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private Object reemplace(int f, int c, Object o){
        Aleatoria fila = (Aleatoria)twoDimensionallist.get(f);
        fila.reemplace(c, o);
        return o;
    }
    
    private String viewText(){
        String texto = "";
        for(int i =0; i< twoDimensionallist.length(); i++){
            String fila = "";
            Aleatoria f = (Aleatoria)twoDimensionallist.get(i);
            for(int j = 0; j < f.length(); j++){
                fila +=  f.get(j);
            }
            texto += fila;
            if(i < twoDimensionallist.length()-1){
                texto += "\n";
            }
        }
        return texto;
    }
    
}
