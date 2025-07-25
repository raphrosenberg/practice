/*
printPrimes(max):

	for n in range(2, max+1):
	  if n is 2:
	    n is prime, print it
	  if n is even:
	    n is not prime, skip to next n
	  for i in range (3, sqrt(n), 2):
	    if n can be evenly divided by i:
	      n is not prime, skip to next n
	  n is prime, print it
*/
package main

import (
	"fmt"
)

func printPrimes(max int) {
outer:
	for n := 2; n < max+1; n++ {
		if n == 2 {
			fmt.Println(n)
		}
		if n%2 == 0 {
			continue
		}
		for i := 3; i*i <= n; i++ {
			if n%i == 0 {
				continue outer
			}
		}
		fmt.Println(n)
	}
}

// don't edit below this line

func test(max int) {
	fmt.Printf("Primes up to %v:\n", max)
	printPrimes(max)
	fmt.Println("===============================================================")
}

func main() {
	test(10)
	test(20)
	test(30)
}
