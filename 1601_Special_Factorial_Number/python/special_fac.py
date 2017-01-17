#!/usr/bin/env python
#
#
# Author: Loris Reiff
# 
# Special Factorial Number
# http://www.practice.geeksforgeeks.org/problem-page.php?pid=1601



def fac(n):
    try:
        precalculated = len(fac.factorials) - 1
    except AttributeError:
        fac.factorials = [1, 1, 2, 6, 24]
        precalculated = len(fac.factorials) - 1
    if n <= precalculated:
        return fac.factorials[n]
    while(precalculated < n):
        previous = fac.factorials[precalculated]
        precalculated += 1
        fac.factorials.append(previous * precalculated)
    return fac.factorials[n]


if __name__ == "__main__":
    tests = int(raw_input())
    for i in range(0, tests):
        x = int(raw_input())
        j = 1
        while True:
            if (fac(j) % x == 0):
                print j
                break
            j += 1
