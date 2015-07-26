This repository is all about Algorithms implementation.

1. Merge sort algorithm:

Conceptually, a merge sort works as follows:

i.  Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
ii. Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.


2. Quicksort algorithm:

Quicksort is a divide and conquer algorithm. 
Quicksort first divides a large array into two smaller sub-arrays: the low elements and the high elements. 
Quicksort can then recursively sort the sub-arrays.

The steps are:

i.    Pick an element, called a pivot, from the array.
ii.   Reorder the array so that all elements with values less than the pivot come before the pivot, 
      while all elements with values greater than the pivot come after it (equal values can go either way). 
      After this partitioning, the pivot is in its final position. This is called the partition operation.
iii.  Recursively apply the above steps to the sub-array of elements with smaller values 
      and separately to the sub-array of elements with greater values.
