/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 *
 * @author kareem
 */
public class Project_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] x = {{1,5,5},{4,6,5},{3,5,4}} ;
        double[][] b = {{1,2},{1,2},{1,2}} ;
        double[][] d = multiplyMatrix(b,x) ;
        for (int i = 0; i < d.length ; i++) {
            for (int j = 0; j < d[0].length ; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
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
         if(s.equals("Transpose B")){
          return transpos(B);
         
         }else if(s.equals("Transpose A")){
         return transpos(B);
         }
         else if(s.equals("SUM A B")|| s.equals("SUM B A")){
         return sum(A, B);
         }else if (s.equals("SUBT A B")){
         return sub(A, B);
         }else if (s.equals("SUBT B A")){
         return sub(B, A);
         }else if (s.equals("MUL A B")){
         return mul(A, B);
         }else if (s.equals("MUL B A")){
         return sub(B,A);
         }
     
     }
    public String[] getQueries() {
        return queries;
    }

    public void setNumOfqueries(int numOfqueries) {
        this.numOfqueries = numOfqueries;
    }

    public void setQueries(String[] queries) {
        
        System.arraycopy(queries, 0, this.queries, 0, queries.length) ;
        
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

    public  double[][] transpos(double[][] a) {
        if (a.length == a[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    double temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;

                }
            }
        }
        return a;

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
