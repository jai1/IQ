package org.interview.questions;

public class SortingList {
    public static class Item implements Comparable<Item> {
        /*
         * 0 - Low 1 - Medium 2 - High
         */
        int priority;
        String name;

        public Item(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public int compareTo(Item i) {
            return this.priority - i.priority;
        }

        @Override
        public String toString() {
            return String.format("Item[name='%s', priority=%d]", name, priority);
        }
    }

    /*
     * ##Company-Microsoft
     * ##Hard
     * Given: A List of items with priority "Low", "Medium" and "High" Sort the list without requiring extra space
     */
    public static void main(String[] args) {
        Item[] items = { new Item(0, "Low1"), new Item(1, "Medium1"), new Item(0, "Low2"), new Item(2, "High1"),
                new Item(0, "Low3"), new Item(1, "Medium2"), new Item(0, "Low4"), new Item(2, "High2") };
        Item[] items1 = items.clone();
        System.out.println("Before: ");
        System.out.println(print(items));
        System.out.println("---------------------");

        sort(items); // O(N)
        System.out.println("After using specialized sort O(N)");
        System.out.println(print(items));
        System.out.println("---------------------");

        items = items1;
        System.out.println("Before: ");
        System.out.println(print(items));
        System.out.println("---------------------");
        quickSort(items, 0, items.length - 1); // O(NlogN)
        
        System.out.println("After using quick sort O(NlogN)");
        System.out.println(print(items));
        System.out.println("---------------------");
    }

    // O(NlogN)
    private static void quickSort(Item[] items, int start, int end) {
        if (start >= end) { // only 1 element
            return;
        }
        int mid = (start + end) / 2;
        Item pivotItem = items[mid];
        swap(items, mid, end);

        int pivot = start;
        for (int i = start; i < end - 1; i++) {
            // pivotItem < items[i]
            if (pivotItem.compareTo(items[i]) < 0) {
                swap(items, pivot, i);
                pivot++;
            }
        }
        swap(items, pivot, end);
        // System.out.println("-----");
        // System.out.println(print(items));
        // System.out.println("-----");

        quickSort(items, start, pivot - 1);
        quickSort(items, pivot + 1, end);
    }

    // O(N)
    private static void sort(Item[] items) {
        int index1 = 0; // Border from Low to Medium
        int index2 = items.length - 1; // Border from Medium to High
        for (int i = 0; i < items.length; i++) {
            if (items[i].priority == 0) {
                swap(items, i, index1);
                index1++;
            } else if (items[i].priority == 2) {
                swap(items, i, index2);
                index2--;
            }
        }
    }

    private static void swap(Item[] items, int i, int j) {
        Item tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private static String print(Item[] items) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        int i = 0;
        for (; i < items.length - 1; i++) {
            buffer.append("(").append(items[i]).append("),\n");
        }
        buffer.append("(").append(items[i]).append(")");
        buffer.append("}");
        return buffer.toString();
    }
}
