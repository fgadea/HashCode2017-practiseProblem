/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author felipegadeallopis
 */
public class Pizza {

    /**
     * @param args the command line arguments
     */
    public static void read(String fileName) {

        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream
                    = new FileInputStream(fileName);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while ((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println(new String(buffer));
                total += nRead;
            }

            // Always close files.
            inputStream.close();

            System.out.println("Read " + total + " bytes");
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        read("prueba.txt");
        int filas = 6;
        int columnas = 7;
        int minTypeIng = 1;
        String tomates = "";
        String setas = "";
        int maxCells = 5;
        boolean[][] map1 = new boolean[filas][columnas];
        boolean[][] map2 = new boolean[filas][columnas];
        boolean[][] map3 = new boolean[filas][columnas];
        char[][] pizza = new char[filas][columnas];
        pizza[0][0] = 'T';
        pizza[0][1] = 'M';
        pizza[0][2] = 'M';
        pizza[0][3] = 'M';
        pizza[0][4] = 'T';
        pizza[0][5] = 'T';
        pizza[0][6] = 'T';
        pizza[1][0] = 'M';
        pizza[1][1] = 'M';
        pizza[1][2] = 'M';
        pizza[1][3] = 'M';
        pizza[1][4] = 'T';
        pizza[1][5] = 'M';
        pizza[1][6] = 'M';
        pizza[2][0] = 'T';
        pizza[2][1] = 'T';
        pizza[2][2] = 'M';
        pizza[2][3] = 'T';
        pizza[2][4] = 'T';
        pizza[2][5] = 'M';
        pizza[2][6] = 'T';
        pizza[3][0] = 'T';
        pizza[3][1] = 'M';
        pizza[3][2] = 'M';
        pizza[3][3] = 'T';
        pizza[3][4] = 'M';
        pizza[3][5] = 'M';
        pizza[3][6] = 'M';
        pizza[4][0] = 'T';
        pizza[4][1] = 'T';
        pizza[4][2] = 'T';
        pizza[4][3] = 'T';
        pizza[4][4] = 'T';
        pizza[4][5] = 'T';
        pizza[4][6] = 'M';
        pizza[5][0] = 'T';
        pizza[5][1] = 'T';
        pizza[5][2] = 'T';
        pizza[5][3] = 'T';
        pizza[5][4] = 'T';
        pizza[5][5] = 'T';
        pizza[5][6] = 'M';
        System.out.print("\nLa pizza \n\n");
         for(int i = 0; i < filas;i++){
            for(int j = 0; j< columnas; j++){
                System.out.print(pizza[i][j] + " ");
            }
            System.out.print("\n");
         }
         
         System.out.print("\n");
        for(int i = 0; i<minTypeIng;i++){
            tomates+=tomates;
            setas+=setas;
        }
        for(int i = 0; i < filas; i++){
            
            String n = "";
            
            for(int j = 0; j < columnas; j++){
                n+=pizza[i][j];
            }
            
            if((n.contains(tomates) && n.contains(setas)) && n.length()<=maxCells)
                for(int k = 0; k<columnas;k++) map1[i][k]=true;
            
            else if(columnas>0){
                columnas--;
                i--;
            }
        }
        
        filas = 6;
        columnas = 7;
        
        for(int i = 0; i < columnas; i++){
            
            String n = "";
            
            for(int j = 0; j < filas; j++){
                n+=pizza[j][i];
            }
            
            if((n.contains(tomates) && n.contains(setas)) && n.length()<=maxCells)
                for(int k = 0; k<filas;k++) map2[k][i]=true;
            
            else if(filas>0){
                filas--;
                i--;
            }
        }
        
        filas = 6;
        columnas = 7;
        
        for(int i = 0; i < filas; i++){
            
            String n = "", n2="";
            
            for(int j = 0; j < columnas; j++){
                n+=pizza[i][j];
                n2+=pizza[i+1][j];
            }
            
            if((n.contains(tomates) && n.contains(setas)) && n.length()<=(maxCells/2)){
                for(int k = 0; k<columnas;k++) {
                    map3[i][k]=true;
                    map3[i+1][k]=true;
                }
                i+=2;
            }
            else if((n2.contains(tomates) && n2.contains(setas)) && n.length()<=(maxCells/2))
            {
                for(int k = 0; k<columnas;k++) {
                    map3[i][k]=true;
                    map3[i+1][k]=true;
                }
                i+=2;
            }
            else if(columnas > 0){
                columnas--;
                i--;
            }
        }
        
        filas = 6;
        columnas = 7;
        
        int count1=0,count2=0,count3=0;
        
        System.out.print("Los Resultados -->\n\n");
        
        for(int i = 0; i < filas;i++){
            for(int j = 0; j< columnas; j++){
                if(map1[i][j]==true) count1++;
                if(map1[i][j]==true)System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
        for(int i = 0; i < filas;i++){
            for(int j = 0; j< columnas; j++){
                if(map2[i][j]==true) count2++;
                if(map2[i][j]==true)System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
        for(int i = 0; i < filas;i++){
            for(int j = 0; j< columnas; j++){
                if(map3[i][j]==true) count3++;
                if(map3[i][j]==true)System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.print("\n");
        }

    }

}
