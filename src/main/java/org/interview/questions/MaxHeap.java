package org.interview.questions;

import java.util.ArrayList;
import java.util.List;

/*
 * ##Heap
 * Don't see heap as BonaryTree, see it as an array with root at index 0 with children-parent relation given in functions below
 * Advantage of using array - by adding elements to the end of the array you always ensure that the size of the heap is minimum.
 * Property:-
 * a. Height is minimum 
 * b. Height(leftNode) - Height(rightNode) <= 1   => Note that there is no absolute here since left node should always be populated first
 * c. Parent val >= child val
 * 
 * Using an array property a and b come free of cost.
 */
public class MaxHeap<T extends Comparable<T>> {
    List<T> heap = new ArrayList<T>();

    // Add element to the end and keep swapping with parent till element reaches the right position
    public void insert(T val) {
        heap.add(val);
        int elementIndex = heap.size() - 1;
        siftUp(elementIndex);
    }

    public static <T extends Comparable<T>> boolean isValidHeap(List<T> h) {
        if (h.size() < 2) {
            return true;
        }
        return isValidHeap(h, 0, 1);
    }

    private static <T extends Comparable<T>> boolean isValidHeap(List<T> h, int parentIndex, int currentIndex) {
        assert (parentIndex >= 0 && parentIndex < h.size() && currentIndex >= 0);

        if (currentIndex >= h.size() || currentIndex == parentIndex) {
            return true;
        }

        if (h.get(currentIndex).compareTo(h.get(parentIndex)) > 0) {
            return false;
        }
        return isValidHeap(h, currentIndex, leftChildIndex(currentIndex))
                && isValidHeap(h, currentIndex, rightChildIndex(currentIndex));
    }

    private void siftUp(int elementIndex) {
        // Index won't go below 0 since parentIndex(0) == 0
        // Won't go into infinite loop since never (element > element)
        while (heap.get(elementIndex).compareTo(heap.get(parentIndex(elementIndex))) > 0) {
            swap(elementIndex, parentIndex(elementIndex));
            elementIndex = parentIndex(elementIndex);
        }
    }

    public void heapify(List<T> list) {
        heap.clear();
        heap.addAll(list);
        if (heap.size() == 0) {
            return;
        }
        int startIndex = (heap.size() - 1) / 2;
        for (int i = startIndex; i >= 0; i--) {
            siftDown(i);
        }
    }

    public T getMax() {
        if (heap.size() == 0) {
            return null;
        }
        swap(0, heap.size() - 1);
        T maxValue = heap.remove(heap.size() - 1);
        if (heap.size() > 1) {
            siftDown(0);
        }
        return maxValue;
    }

    private void siftDown(int elementIndex) {
        assert (elementIndex >= 0 && elementIndex < heap.size());
        int childIndex = findGreatestChildIndex(elementIndex);
        while (childIndex != -1 && heap.get(elementIndex).compareTo(heap.get(childIndex)) < 0) {
            assert (childIndex < heap.size());
            swap(childIndex, elementIndex);
            elementIndex = childIndex;
            childIndex = findGreatestChildIndex(elementIndex);
        }
    }

    private int findGreatestChildIndex(int elementIndex) {
        int leftChildIndex = leftChildIndex(elementIndex);
        int rightChildIndex = rightChildIndex(elementIndex);
        if (leftChildIndex >= heap.size() && rightChildIndex >= heap.size()) {
            return -1;
        } else if (leftChildIndex >= heap.size()) {
            return rightChildIndex;
        } else if (rightChildIndex >= heap.size()) {
            return leftChildIndex;
        } else {
            return heap.get(leftChildIndex).compareTo(heap.get(rightChildIndex)) >= 0 ? leftChildIndex : rightChildIndex;
        }
    }

    private void swap(int elementIndex1, int elementIndex2) {
        assert (elementIndex1 >= 0 && elementIndex2 >= 0 && elementIndex1 < heap.size() && elementIndex2 < heap.size());
        T tmp = heap.get(elementIndex1);
        heap.set(elementIndex1, heap.get(elementIndex2));
        heap.set(elementIndex2, tmp);
    }

    private int parentIndex(int elementIndex) {
        return (elementIndex - 1) / 2;
    }

    private static int leftChildIndex(int elementIndex) {
        return (elementIndex * 2) + 1;
    }

    private static int rightChildIndex(int elementIndex) {
        return (elementIndex * 2) + 2;
    }

    public List<T> getList() {
        return heap;
    }

    public void clear() {
        heap.clear();
        return;
    }
}
