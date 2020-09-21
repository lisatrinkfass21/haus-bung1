/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erastothenesprimesieve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Lisa
 */
public class ErastothenesPrimeSieve implements PrimeSieve {

    private ArrayList<Integer> listZahlen = new ArrayList<Integer>();
    private int obergrenze;

    public static void main(String[] args) {
        System.out.println("Geben Sie eine Obergrenze ein");
        Scanner scan = new Scanner(System.in, "Windows-1252");
        int ober = Integer.parseInt(scan.nextLine());
        ErastothenesPrimeSieve es = new ErastothenesPrimeSieve(ober);
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
            System.out.print(listZahlen.get(i));
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
    }

    private void createListOfMultiples(int number) {
        ArrayList<Integer> listOfMultiples = new ArrayList<Integer>();
        for (int i = 2; i < listZahlen.size(); i++) {
            listOfMultiples.add(number * i);
        }
        listZahlen.removeAll(listOfMultiples);
    }

}
