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

---

## Merge Sort

## Core Idea
1. Divide the array into two halves
2. Recursively sort both halves
3. Merge the two sorted halves

---

## Dry Flow Example

Array: [5, 3, 8, 4]

Divide:
[5, 3]   [8, 4]

Divide again:
[5] [3]   [8] [4]

Merge:
[3, 5]   [4, 8]

Final Merge:
[3, 4, 5, 8]

---

## Time Complexity

- Best: O(n log n)
- Average: O(n log n)
- Worst: O(n log n)

Why?
- log n levels (splitting)
- n work at each level (merging)

---

## Space Complexity

- O(n) → extra array used for merging

---

## Properties

- Stable: Yes
- In-place: No
- Consistent performance (unlike quick sort)

---

## When to Use?

- When stability is required
- When guaranteed O(n log n) is needed
- Used in external sorting (large data)

---

## Key Implementation Points

- mid = low + (high - low) / 2 (avoid overflow)
- Always copy merged result back to original array
- Use temporary array for merging

---

## Common Mistakes

- Forgetting to copy temp array back
- Wrong mid calculation
- Infinite recursion (wrong base case)
- Mixing indices in merge step

---

## Recursion Insight

Merge sort works like:
- Break → Break → Break (until single elements)
- Then Combine → Combine → Combine

---

## Base Condition

if(low >= high) return;

---

## Merge Logic (Important)

- Use two pointers:
  left → start of left half
  right → start of right half

- Compare and push smaller into temp array

---

## Why Merge Sort Matters

- Teaches Divide & Conquer
- Helps in problems like:
  - Count inversions
  - Merge intervals
  - External sorting