# Maps & HashMaps

## 🧠 Key Idea
Store key → value pairs with fast lookup.

## 📌 Why HashMap?
- Average O(1) insert, delete, search
- Uses hashing to map keys → indices

## 📌 Collision Handling
- Chaining (Linked List)
- Open Addressing (not implemented here)

## 📌 Common Patterns
- Frequency counting
- Prefix sum + map
- Two sum (lookup complement)

## 🚨 Pitfalls
- Poor hash function → collisions
- Not resizing → performance drop

## ⏱️ Time Complexity
Put: O(1)

Get: O(1)

Remove: O(1)