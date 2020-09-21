/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erastothenesprimesieve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Lisa
 */
public class ErastothenesPrimeSieve implements PrimeSieve {

    private ArrayList<Integer> listZahlen = new ArrayList<Integer>();
    private TreeSet<Integer> listOfMultiples = new TreeSet<Integer>();
    private final int obergrenze;

    public static void main(String[] args) {
        System.out.println("Geben Sie eine Obergrenze ein");
        Scanner scan = new Scanner(System.in, "Windows-1252");
        int ober = 0;
        while (ober < 1) {
            try {
                ober = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fehler - Sie haben keine Zahl eingegeben");
            }
            if (ober < 1) {
                System.out.println("bitte geben Sie eine positive Zahl ein");
            }
        }

        ErastothenesPrimeSieve es = new ErastothenesPrimeSieve(ober);
        es.printPrimes();
    }

    public ErastothenesPrimeSieve(int obergrenze) {
        this.obergrenze = obergrenze;
        for (int i = 1; i <= obergrenze; i++) {
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
        calcPrime();
        System.out.println("Primzahlen: ");
        System.out.println("");
        for (int i = 0; i < listZahlen.size(); i++) {
            System.out.print(listZahlen.get(i) + " ");
        }

    }

    private void calcPrime() {
        Iterator<Integer> it = listZahlen.iterator();
        int temp = 0;
        while (it.hasNext()) {
            temp = it.next();
            if (isPrime(temp)) {
                createListOfMultiples(temp);
            } else {
                createListOfMultiples(temp);
                it.remove();
            }
        }
        listZahlen.remove(listOfMultiples);
    }

    private void createListOfMultiples(int number) {
        for (int i = 2; i < listZahlen.size(); i++) {
            listOfMultiples.add(number * i);
        }

    }

}
