# Sorting Notes

## What is Sorting?
- Arranging elements in increasing or decreasing order

## Why important?
- Required for binary search
- Makes many Array.Array.problems easier (two pointer, greedy, etc.)

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
- Helps in Array.Array.problems like:
  - Count inversions
  - Merge intervals
  - External sorting

  ---

  # Quick Sort Notes

## What is Quick Sort?
- A Divide and Conquer algorithm
- Picks a "pivot" element
- Places it at its correct position
- Then sorts left and right parts

---

## Core Idea (Very Important)

1. Pick a pivot (usually first/last element)
2. Put pivot in its correct position
3. All smaller elements go to left
4. All bigger elements go to right
5. Repeat for left and right parts

---

## Example

Array: [4, 6, 2, 5, 1]

Pick pivot = 4

After partition:
[2, 1] 4 [6, 5]

Now sort:
Left → [2, 1]
Right → [6, 5]

Final result:
[1, 2, 4, 5, 6]

---

## Key Step: Partition

- Place pivot at correct index
- Left side → smaller
- Right side → greater

---

## Time Complexity

- Best: O(n log n)
- Average: O(n log n)
- Worst: O(n^2)

Worst happens when:
- Array is already sorted
- Bad pivot choice

---

## Space Complexity

- O(log n) (recursion stack)

---

## When to Use?

- Fast in practice
- Works well for large arrays
- Default sorting in many languages (optimized version)

---

## Important Concept

Unlike merge sort:
- Merge sort → always divides equally
- Quick sort → depends on pivot

Good pivot → fast
Bad pivot → slow

---

## Base Condition

if(low >= high) return;

---

## Common Mistakes

- Wrong partition logic
- Infinite loop in partition
- Pivot not placed correctly
- Off-by-one errors

---

## Why Quick Sort Matters

- Very common in interviews
- Teaches partition logic
- Used in:
  - kth smallest/largest element
  - quick select algorithm

---

## Mistakes I made

- Forgot to swap pivot at correct place