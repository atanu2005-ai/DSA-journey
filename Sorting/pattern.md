# Sorting Patterns

## 1. Adjacent Swapping (Bubble Sort)
Use when:
- Need to push largest/smallest element gradually
- Understanding basic swapping

Key Idea:
- Compare neighbors
- Swap if wrong order

---

## 2. Select Minimum (Selection Sort)
Use when:
- Want minimum number of swaps
- Simpler logic

Key Idea:
- Find min in unsorted part
- Swap with current index

---

## 3. Insert in Sorted Portion (Insertion Sort)
Use when:
- Array is partially sorted
- Online processing (elements come one by one)

Key Idea:
- Take element
- Shift left elements until correct position found

---

## 4. Stability Awareness
- Bubble Sort → Stable
- Insertion Sort → Stable
- Selection Sort → Not stable

Used when:
- Relative order matters (e.g., objects with same keys)

---

## 5. When to use which?

- Bubble Sort → Rarely used (conceptual)
- Selection Sort → When swaps are costly
- Insertion Sort → Small arrays / nearly sorted arrays