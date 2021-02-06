/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoDimensionalLists;

/**
 *
 * @author alumno
 */
 public interface ITwoDimensionalLists{
        String getText();
        
        String getMatrix();
        void setMatrix(String codeMatrix);
        
        void MoveUp();
        void MoveDown();
        void MoveRight();
        void MoveLeft();
        
        void IncreaseSize();
        void IncreaseSizeLong();
        void IncreaseSizeWide();
        void DecreaseSize();
        void DecreaseSizeLong();
        void DecreaseSizeWide();
        
        int lenght();
        int rowLength();
        int columnLength();
        void changeChars(char on, char off);
 }


