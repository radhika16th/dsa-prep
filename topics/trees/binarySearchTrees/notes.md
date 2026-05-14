# Binary Search Trees

## A proper binary tree where each internal position stores a key-value pait such that
- keys stored in the left subtree of p are less than k
- keys stored in the right subtree of p are greater than k

## Linked Binary Search Trees combines
- The efficiency of binary search in a sorted array ( O(log n) on average )
- The efficiency of a linked list for insertion and deletion ( put and delete will be 𝑂(1) )
- Therefore put, get, delete, etc. will be 𝑂(log 𝑛) on average

## Notes
- Empty = single sentinel node (null ?)
- Proper = internal node has 2 children
- InOrder Traversal = sorted order