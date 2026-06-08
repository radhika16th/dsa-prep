# Adel’son-Vel’ski and Landis (AVL) Trees

# Keep height of right and left subtrees within 1 throughout the tree

## The Height Balance Property
- For every internal position p in an AVL tree, the heights of the children of p differ by at most 1 (Must be in [-1, 1])
- Guarantees 𝑂(log 𝑛) height
- Balance Factor = height(left) - height(right)

## Maintaining Balance
- Each node must store its height
- Work is required only for put and remove
- Trinode Restructuring as necessary => from affected node up to root
- Finishes in 𝑂(log 𝑛) time if 𝑂(log 𝑛) height