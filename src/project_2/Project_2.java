/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2;

import java.util.Scanner;

/**
 *
 * @author kareem
 */
public class Project_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             boolean err = false ;
           do{
          try{
          int numOfqueries = 0 ;
          String[] queries ;
          Scanner inputQuery ;
          Scanner inputMatrixB ;
          Scanner inputDimensionB ;
          Scanner num;
          Scanner inputMatrixA ;
          Scanner inputDimensionA;
          Scanner numTest = new Scanner(System.in);
              
          System.out.println("Enter the number of test cases");
          System.out.println("------------------------------");
          int numOfTestCases = numTest.nextInt();
          ArrayCustomized[] arrays = new ArrayCustomized[numOfTestCases];
          for (int i = 1; i <= numOfTestCases ; i++) {
              arrays[i-1] = new ArrayCustomized();
              System.out.println("Test case "+ i);
              inputDimensionA = new Scanner(System.in);
              System.out.println("enter the dimension of Matrix A :");
              int dimension1 = inputDimensionA.nextInt();
              int dimension2 = inputDimensionA.nextInt();
               inputMatrixA = new Scanner(System.in);
              System.out.println("enter the value of rows and colunms of matrix A");
              double[][] MatrixA = new double[dimension1][dimension2];
              for (int j = 0; j < dimension2; j++) {
                  for (int k = 0; k < dimension1; k++) {
                      MatrixA[k][j] = inputMatrixA.nextInt() ;
                  }
              }
              arrays[i-1].setA(MatrixA);
              
                inputDimensionB = new Scanner(System.in);
              System.out.println("enter the dimension of Matrix B :");
              int dimension11 = inputDimensionB.nextInt();
              int dimension22 = inputDimensionB.nextInt();
               System.out.println("enter the value of rows and colunms of matrix B");
               inputMatrixB = new Scanner(System.in);
              double[][] MatrixB = new double[dimension11][dimension22];
              for (int j = 0; j < dimension22; j++) {
                  for (int k = 0; k < dimension11; k++) {
                      MatrixB[k][j] = inputMatrixB.nextInt() ;
                  }
              }
              arrays[i-1].setB(MatrixB);
               num = new Scanner(System.in);
              System.out.print("enter the number of queries ");
              numOfqueries = num.nextInt();
         
               
              queries = new String[numOfqueries];
              System.out.println("enter queries");
              inputQuery = new Scanner(System.in);
              for (int K = 0; K < numOfqueries; K++) {
                  queries[K]  = inputQuery.nextLine() ;
              }
              arrays[i-1].setQueries(queries);
               numOfqueries = 0 ;
           queries  = null;
           inputQuery  = null;
           inputMatrixB = null ;
           inputDimensionB = null;
           num = null;
           inputMatrixA = null ;
           inputDimensionA = null;
              
        }
          for (int i = 0; i < numOfTestCases; i++) {
              System.out.println("case #" + (i+1));
              System.out.println("---------------");
              double[][] temp1 ;
              for (int j = 0; j < arrays[i].getQueries().length; j++) {
                   String temp = arrays[i].getQueries()[j];
                  
                   temp1 = arrays[i].work(temp);
                   if (temp1 != null){
                   
                   System.out.println(temp);
                   for (int k = 0; k < temp1.length; k++) {
                       for (int l = 0; l < temp1[0].length; l++) {
                           System.out.print(temp1[k][l]+ "  ");
                       }
                       System.out.println();
                       
                  }
                   }else{System.out.println("sorry invalid input : " + temp);}
                   
              }
        }
        }catch(Exception ex){
        System.err.println("sorry .... unexpected error happened .. please try again"
                + " or contact us at kska213@gmail.com");
              System.out.println("-----------------");
        }
           }while(err = true);
        }
    
    }
    
    

class ArrayCustomized {
    static int numberOfObjects ;
    private double[][] A ;
    private double[][] B ;

    public void setA(double[][] A) {
        this.A = A;
    }

    public void setB(double[][] B) {
        this.B = B;
    }
    
    

    public int getNumOfqueries() {
        return numOfqueries;
    }
     public double[][] work(String s ){
         if(s.equalsIgnoreCase("Transpose B")){
          return transpos(B);
         
         }else if(s.equalsIgnoreCase("Transpose A")){
         return transpos(A);
         }
         else if(s.equalsIgnoreCase("SUM A B")|| s.equalsIgnoreCase("SUM B A")){
         return sum(A, B);
         }else if (s.equalsIgnoreCase("SUBT A B")){
         return sub(A, B);
         }else if (s.equalsIgnoreCase("SUBT B A")){
         return sub(B, A);
         }else if (s.equalsIgnoreCase("MUL A B")){
         return mul(A, B);
         }else if (s.equalsIgnoreCase("MUL B A")){
         return mul(B,A);
         }else if (s.equalsIgnoreCase("MUL A A")){
         return mul(A,A);
         }else if(s.equalsIgnoreCase("MUL B B")){
         return mul(B,B);
         }
         return null ;
     
     }
    public String[] getQueries() {
        return queries;
    }

    public void setNumOfqueries(int numOfqueries) {
        this.numOfqueries = numOfqueries;
    }

    public void setQueries(String[] queries) {
        
       this.queries = queries;
        
    }
    
    private int numOfqueries ; 
     String[] queries ;
    public ArrayCustomized() {
        
        numberOfObjects++ ;
    }
    
    public double[][] sum(double[][] a, double[][] b) {
        double[][] sum = new double[a.length][a[0].length];
        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                }
            }
        }
        return sum;
    }

    public  double[][] sub(double[][] a, double[][] b) {
        double[][] sub = new double[a.length][a[0].length];
        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    sub[i][j] = a[i][j] - b[i][j];
                }
            }
        }
        return sub;
    }

    public  double[][] transpos(double[][] m) {
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    public  double[][] mul(double[][] a, double[][] b) {
        if (a.length != b[0].length) {
            return null;
        }
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int n = 0; n < a[0].length; n++) {
                    result[i][j] += a[i][n] * b[n][j];
                }
            }
        }
        return result;
    }
}
