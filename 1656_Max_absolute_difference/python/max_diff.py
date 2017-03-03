#!/usr/bin/env python3
#
#
# Author: Loris Reiff
# 
# 	
# Max absolute difference
# http://www.practice.geeksforgeeks.org/problem-page.php?pid=1656


def extreme_subset_sums(L, start=None, end=None):
    """
    Calculates the maximal and minimal contiguous subset sum of L
    between start and end. If start and end are not specified, the
    whole list is taken into consideration 
    Parameters:
        L : integer list
        start : integer start index
        end : integer end index
    Return:
        (max, min) : tuple maximal and minimal sum of a contiguous subset
    """
    if start is None:
        start = 0
    if end is None:
        end = len(L)

    maxi = 0
    max_count = 0
    min_ = float("inf")
    min_count = 0

    for i in range(start, end):
        max_count += L[i]
        min_count += L[i]
        if max_count > maxi:
            maxi = max_count
        if max_count < 0:
            max_count = 0
        if min_count < min_:
            min_ = min_count
        if min_count > 0:
            min_count = 0

    if min_ == float("inf"):
        min_ = 0
    return (maxi, min_)


def max_difference(L):
    max_value = 0

    for i in range(len(L)+1):
        pos_left, neg_left = extreme_subset_sums(L, 0, i)
        pos_right, neg_right = extreme_subset_sums(L, i, len(L))

        value1 = pos_left - neg_right
        value2 = pos_right - neg_left
        max_value = max(max_value, value1, value2)

    return max_value


if __name__ == "__main__":
    tests = int(input())
    for i in range(0, tests):
        n = int(input())
        inp = input()
        L = [int(i) for i in inp.split()]
        print(max_difference(L))
