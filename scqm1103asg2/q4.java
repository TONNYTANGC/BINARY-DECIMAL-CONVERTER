/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scqm1103ASG2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class q4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER 16BITS FLOATING POINT BINARY NUMBER : ");
        String strbin = scan.nextLine();
        System.out.print("ENTER BITS OF MANTISSA : ");
        int manbit = scan.nextInt();
        System.out.print("ENTER BITS OF EXPONENT : ");
        int expbit = scan.nextInt();

        String mantissa = strbin.substring(0, manbit);
        String exponent = strbin.substring(manbit, strbin.length());
        System.out.println("MANTISSA = " + mantissa);
        System.out.println("EXPONENT = " + exponent);
        // counting exponent
        int countE[] = new int[expbit];
        for (int i = expbit - 1; i >= 0; i--) {
            countE[i] = Character.getNumericValue(exponent.charAt(i));
        }

        int decE = 0;
        int a = expbit - 1;
        for (int i = 0; i < expbit; i++) {
            if (countE[i] == 1) {
                if (i > 0) {
                    decE += Math.pow(2, a);
                } else if (i == 0) {
                    decE -= Math.pow(2, a);
                }
            }
            a--;
        }

        System.out.println("THE EXPONENT IS : " + decE);

        //counting mantissa 
        System.out.println("THE ORIGIN MANTISSA : " + mantissa);
        BigDecimal bigdecimal = new BigDecimal(mantissa);
        BigDecimal fmantissa = bigdecimal.movePointLeft(manbit - 1);
        System.out.println("THE FLOATING POINT IN MANTISSA : " + fmantissa);
        String mantissa1 = "";
        String mantissa2 = "";

        int fpoint = -decE;

        if (decE > 1) { // positive exponent 
            mantissa1 = mantissa.substring(0, decE + 1);
            mantissa2 = mantissa.substring(decE + 1, manbit);

            System.out.println("THE FIRST MANTISSA : " + mantissa1); //0110
            System.out.println("THE SECOND MANTISSA : " + mantissa2);

            // counting the first part of mantissa 
            int lengthM1 = mantissa1.length();
            int countM1[] = new int[lengthM1];

            for (int i = lengthM1 - 1; i >= 0; i--) {
                countM1[i] = Character.getNumericValue(mantissa1.charAt(lengthM1 - 1)); //store in array 
                lengthM1--;
                if (lengthM1 == 0) {
                    break;
                }
            }

            int signbit = mantissa.charAt(0);
            int lengthFM1 = mantissa1.length(); //re-declare since lengthM1 ard become 0 

            int decM1 = 0; // the value of first mantissa 
            int b = (lengthFM1 - 1);

            for (int i = 0; i < lengthFM1; i++) {
                if (countM1[i] == 1) {
                    if (i > 0) {
                        decM1 += Math.pow(2, b);
                    } else if (i == 0) {
                        if (signbit == '1') {
                            decM1 -= Math.pow(2, b);
                        } else if (signbit == '0') {
                            decM1 += Math.pow(2, b);
                        }
                    }
                }
                b--;
            }
            System.out.println("VALUE OF MANTISSA BEFORE FLOATING POINT : " + decM1);

            //counting second mantissa
            int lengthM2 = mantissa2.length();
            int countM2[] = new int[lengthM2];

            for (int i = lengthM2 - 1; i >= 0; i--) {
                countM2[i] = Character.getNumericValue(mantissa2.charAt(lengthM2 - 1)); //store in array 
                lengthM2--;
                if (lengthM2 == 0) {
                    break;
                }
            }

            int lengthFM2 = mantissa2.length();
            double decM2 = 0;

            for (int i = 0; i < lengthFM2; i++) {
                if (countM2[i] == 1) {
                    if (i >= 0) {
                        decM2 += (1 / Math.pow(2, i + 1));
                    }
                }
            }
            System.out.println("VALUE OF MANTISSA AFTER FLOATING POINT : " + decM2);

            double dec = (double) decM1 + decM2;
            System.out.println("DECIMAL : " + dec);

            // negative exponent    
        } else {
            BigDecimal newmantissa = bigdecimal.movePointLeft(manbit - 1 + fpoint);
            System.out.println("THE FLOATING POINT IN MANTISSA AFTER SHIFTING: " + newmantissa);

            String strmantissa = newmantissa.toString();

            int lengthM = strmantissa.length();
            int countM[] = new int[lengthM];

            for (int i = lengthM - 1; i >= 0; i--) {
                countM[i] = Character.getNumericValue(strmantissa.charAt(lengthM - 1)); //store in array 
                lengthM--;
                if (lengthM == 0) {
                    break;
                }
            }

            int signbitM = mantissa.charAt(0);
            int lengthFM = strmantissa.length(); //re-declare since lengthM1 ard become 0 

            double decM = 0;
            int q = strmantissa.indexOf("1");

            for (int i = 0; i < lengthFM; i++) {
                if (countM[i] == 1) {
                    if (i > q) {
                        decM += (double) (1 / (Math.pow(2, i - 1)));
                    } else if (i == q) {
                        if (signbitM == '1') {
                            decM -= (double) (1 / (Math.pow(2, i - 1)));
                        } else if (signbitM == '0') {
                            decM += (double) (1 / (Math.pow(2, i - 1)));
                        }
                    }
                }

            }
            System.out.println("DECIMAL : " + decM);

        }
    }
}
