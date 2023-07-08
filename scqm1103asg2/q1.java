/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scqm1103ASG2;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author User
 */
public class q1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter decimal");
        int dec = scan.nextInt();
        String myString = Long.toBinaryString(dec); // change to binary string 
        int length = myString.length(); // get the length of binary string 
        System.out.println(length);
        System.out.println(Long.toBinaryString(dec));
        int bin[] = new int[8];
        for (int i = 7; length > 0; i--) {
            bin[i] = Character.getNumericValue(myString.charAt(length - 1)); //store char binary into array from last 
            System.out.print(Character.getNumericValue(myString.charAt(length - 1))); //display binary from last 
            System.out.print(i); // location in 8 bit binary string 
            System.out.println(length); // location in binary string 
            length--;
            if (i <= 0) {
                break;
            }
        }
        String bint = "";
        for (int i = 0; i < 8; i++) {
            bint += bin[i];
            System.out.print(bin[i]); // display 8 bit binary string  
        }
        System.out.println("TRAIL : " + bint);
    }
}
