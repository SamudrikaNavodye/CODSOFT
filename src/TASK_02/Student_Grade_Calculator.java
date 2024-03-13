/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK_02;

import java.util.Scanner;

/**
 *
 * @author sn96g
 */
public class Student_Grade_Calculator {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int numSub = sc.nextInt();
        int [] marks = new int[numSub];
        int totMarks = 0;
        
        //Get subject marks
        for (int i = 0; i < numSub; i++) {
            System.out.println("Enter the marks obtained in " +(i+1)+": ");
            marks[i] = sc.nextInt();
            totMarks +=marks[i];
        }
        
        //Total marks 
        System.out.println("Total Marks: " + totMarks);
        
        //Average percentage of marks
        double avg = (double)totMarks/numSub;
        System.out.println("Average percentage marks: "+avg+"%");
        
        //Get the grade
        char grade = getGrade(avg);
        System.out.println("Your Grade: ");
        
        sc.close();
    
    }

    private static char getGrade(double avg) {
        if (avg >= 75) {
            return 'A';
        }else if(avg < 75 && avg >= 65){
            return 'B';
        }else if (avg < 65 && avg >= 55) {
            return 'C';
        }else if(avg < 55 && avg >= 45) {
            return 'D';
        }else {
            return 'F';
        }
    }    
}
