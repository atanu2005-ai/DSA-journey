# Sorting Patterns

## Adjacent Swapping (Bubble Sort)
Use when:
- Need to push largest/smallest element gradually
- Understanding basic swapping

Key Idea:
- Compare neighbors
- Swap if wrong order

---

## Select Minimum (Selection Sort)
Use when:
- Want minimum number of swaps
- Simpler logic

Key Idea:
- Find min in unsorted part
- Swap with current index

---

## Insert in Sorted Portion (Insertion Sort)
Use when:
- Array is partially sorted
- Online processing (elements come one by one)

---

# Merge Sort Patterns

---

## 1. Divide and Conquer

Use when:
- Problem can be broken into smaller independent subproblems

Steps:
1. Divide into halves
2. Solve recursively
3. Merge results

Examples:
- Merge Sort
- Quick Sort
- Binary Search

---

## 2. Merge Two Sorted Arrays

Use when:
- Two sorted parts need to be combined

Key Idea:
- Use two pointers
- Compare elements and pick smaller one

This is the CORE of merge sort

---

## 3. Counting While Merging

Use when:
- Need to count something across subarrays

Key Idea:
- While merging, track conditions

Examples:
- Count Inversions
- Reverse Pairs
- Count smaller elements after self

---

## 4. Stable Sorting Requirement

Use when:
- Relative order of equal elements matters

Merge sort is:
- Stable → preserves order

Useful in:
- Sorting objects with multiple fields

---

## 5. External Sorting (Large Data)

Use when:
- Data is too large to fit in memory

Key Idea:
- Split into chunks
- Sort individually
- Merge later

Real-world use:
- Databases
- File systems

---

## 6. Linked List Sorting

Use when:
- Sorting linked lists efficiently

Why Merge Sort?
- No random access needed
- Works well with pointers

---

## 7. When to Choose Merge Sort

Choose when:
- Need guaranteed O(n log n)
- Stability matters
- Working with linked lists

Avoid when:
- Memory is limited (extra O(n) space)

---

## Pattern Recognition Clues

If problem says:
- "count pairs"
- "count inversions"
- "two sorted halves"
- "merge sorted data"

→ Think: Merge Sort modification