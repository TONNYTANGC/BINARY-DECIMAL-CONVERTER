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
public class q3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter negative decimal"); // -20
        int dec = scan.nextInt();
        int Clonedec = 0;
        if (dec > 0) {
            Clonedec = dec;
        } else if (dec < 0) {
            Clonedec = dec - dec * 2; //20
            System.out.println(Clonedec);
        }
        int bin[] = new int[8];

        bin[0] = 0;

        for (int a = 7; a > 0; a--) {
            if (Clonedec > 1) {
                bin[a] = Clonedec % 2; 
            } else if (Clonedec == 1) {
                bin[a] = 1;
            }
            Clonedec = Clonedec / 2;
        }
        for (int i = 0; i < bin.length; i++) {
            System.out.print(bin[i]);
        }
        System.out.println("");
        if (dec > 0) {
            for (int i = 0; i < bin.length; i++) {
                System.out.print(bin[i]);
            }
        } else if (dec < 0) {
            for (int a = 7; a >= 0; a--) {
                if (bin[a] == 0) {
                    bin[a] = 1;
                } else if (bin[a] == 1) {
                    bin[a] = 0;
                }
            }

            System.out.println("");
            for (int i = 0; i < bin.length; i++) {
                System.out.print(bin[i]);
            }
        }
        System.out.println("");
        bin[7] += 1;
        for (int i = 7; i >= 0; i--) {

            if (bin[i] == 2 && i > 0) {
                bin[i] = 0;
                bin[i - 1] += 1;
            } else if (bin[0] == 2) {
                bin[0] = 1;
            }

        }
        for (int i = 0; i < bin.length; i++) {
            System.out.print(bin[i]);
        }

    }
}
