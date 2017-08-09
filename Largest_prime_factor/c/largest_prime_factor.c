/*
 * Author: Loris Reiff
 * 
 * Challenge: Largest prime factor
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1679
 */

/* Force a compilation error if condition is true */
#define BUILD_BUG_ON(condition) ((void)sizeof(char[1 - 2*!!(condition)]))

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


const size_t SIEVE_SIZE = 316228;	// sqrt(N)


/* Functions */
char* create_sieve();
unsigned int* create_prime_array(char*, size_t*);
unsigned long largest_prime_factor(unsigned int*, size_t, unsigned long);


int main(int argc, char* argv[]) { 
	// unsigned long has to be 64 bit
	BUILD_BUG_ON(sizeof(long) < 8);

	int test_cases;
	unsigned long num;

	char* sieve = create_sieve();
	if(!sieve)
		return 0;

	size_t primes_size;
	unsigned int* primes = create_prime_array(sieve, &primes_size);
	free(sieve);
	sieve = NULL;
	if(!primes)
		return 0;

	scanf("%d", &test_cases);
	while(test_cases--) {
		scanf("%lu", &num);
		unsigned long f = largest_prime_factor(primes, primes_size, num);
		printf("%lu\n", f);
	}
	free(primes);
	primes = NULL;
}


char* create_sieve() {
	char* sieve = malloc(sizeof(char) * SIEVE_SIZE);
	if(!sieve)
		return 0;

	memset(sieve, 0xFF, SIEVE_SIZE);
	sieve[0] = 0;
	sieve[1] = 0;
	size_t step = 2;

	while(step * step < SIEVE_SIZE) {
		for(size_t i = step * step; i < SIEVE_SIZE; i += step) {
			sieve[i] = 0;
		}
		while(step*step < SIEVE_SIZE && !sieve[++step]);
	}

	return sieve;
}


unsigned int* create_prime_array(char* sieve, size_t* primes_size) {
	size_t counter = 0;
	unsigned int* p;

	while(counter < SIEVE_SIZE) {
		if(sieve[counter])
			(*primes_size)++;
		counter++;
	}

	unsigned int* primes = malloc(sizeof(int) * (*primes_size));
	if(!primes)
		return 0;
	counter = 0;
	p = primes;

	while(counter < SIEVE_SIZE) {
		if(sieve[counter]) {
			*p = counter;
			p++;
		}
		counter++;
	}


	return primes;
}


unsigned long largest_prime_factor(unsigned int* primes, size_t primes_size, unsigned long num) {
	unsigned long largest_factor = num;
	unsigned int* factor = primes;
	while(factor < primes+primes_size) {
		if(largest_factor % (*factor) == 0 && largest_factor != (*factor)) {
			largest_factor /= (*factor);
			factor = primes;
		}
		else {
			factor++;
		}
	}
	return largest_factor;
}
