/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erastothenesprimesieve;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Lisa
 */
public class ErastothenesPrimeSieve implements PrimeSieve {

    ArrayList<Integer> listZahlen = new ArrayList<Integer>();
    int obergrenze;

    public static void main(String[] args) {
        System.out.println("Geben Sie eine Obergrenze ein");
        Scanner scan = new Scanner(System.in, "Windows-1252");
        int ober = Integer.parseInt(scan.nextLine());
        ErastothenesPrimeSieve es = new ErastothenesPrimeSieve(ober);
    }

    public ErastothenesPrimeSieve(int obergrenze) {
        this.obergrenze = obergrenze;
        for (int i = 0; i <= obergrenze; i++) {
            listZahlen.add(i);
        }

    }

    @Override
    public boolean isPrime(int p) {
        if (p <= 2) {
            return (p == 2);
        }
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        System.out.println("Primzahlen: ");
        System.out.println("");
        for (int i = 0; i < listZahlen.size(); i++) {
            System.out.print(listZahlen.get(i));
        }
        
    }

}
