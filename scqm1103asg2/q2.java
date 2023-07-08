/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scqm1103ASG2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter binary");
        int bin = scan.nextInt();
        String strbin = Integer.toString(bin); //change integer to string 
        int length = strbin.length();
        int count[] = new int[8];
        for (int i = 7; i >= 0; i--) {
            count[i] = Character.getNumericValue(strbin.charAt(length - 1)); //store in array 
            length--;
            if (length == 0) {
                break;
            }
        }

        int dec = 0;
        int a = 7;
        for (int i = 0; i < 8; i++) {
            if (count[i] == 1) {
                if (i > 0) {
                    dec += Math.pow(2, a);
                } else if (i == 0) {
                    dec -= 128;
                }
            }
            a--;
        }
        System.out.println(dec);
    }
}
