/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erastothenesprimesieve;

/**
 *
 * @author Lisa
 */
public class ErastothenesPrimeSieve implements PrimeSieve {

    int obergrenze = 0;

    public static void main(String[] args) {

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
        for (int i = 0; i < obergrenze; i++) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }

}
