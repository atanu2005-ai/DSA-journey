# Sorting Notes

## What is Sorting?
- Arranging elements in increasing or decreasing order

## Why important?
- Required for binary search
- Makes many problems easier (two pointer, greedy, etc.)

---

## Bubble Sort
- Repeatedly swaps adjacent elements if they are in wrong order
- Largest element moves to the end after each pass

Time Complexity:
- Worst: O(n^2)
- Best: O(n) (if already sorted with optimization)

Space:
- O(1)

Stable: Yes

---

## Selection Sort
- Finds minimum element and places it at correct position

Time Complexity:
- Always: O(n^2)

Space:
- O(1)

Stable: No (by default)

---

## Insertion Sort
- Builds sorted array one element at a time
- Inserts element into correct position

Time Complexity:
- Worst: O(n^2)
- Best: O(n) (already sorted)

Space:
- O(1)

Stable: Yes