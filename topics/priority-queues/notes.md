# Priority Queues (Heaps)

## 🧠 Key Idea
A data structure where elements are processed based on priority (not order).

## 📌 Types
- Min Heap → smallest element first
- Max Heap → largest element first

## ⚙️ Operations
- insert → O(log n)
- remove → O(log n)
- peek → O(1)

## 📌 Common Patterns
- Top K elements
- Heap (k-way merge)
- Greedy + priority selection

## 🚨 Common Pitfalls
- Forgetting Java PQ is MIN heap by default
- Wrong comparator
- Not maintaining heap size (for Top K)

## 🎯 When to Use
- Need smallest/largest repeatedly
- Dynamic ordering
- Optimization problems

## ⏱️ Time Complexity
Insert: O(log n) 

Remove: O(log n)

Peek: O(1)