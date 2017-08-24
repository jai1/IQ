package org.interview.questions;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class MaxHeapTest {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();
    
    @Test(invocationCount = 100)
    public void isValidHeap() {
        List<Integer> list = new ArrayList();
        for (int i = 0; i<10000; i++) {
            list.add((int) (Math.random() * 1000));
        }
        heap.heapify(list);
        assertTrue(MaxHeap.isValidHeap(heap.getList()));
    }
    
    @Test(invocationCount = 100)
    public void getMax() {
        Integer max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        heap.clear();
        for (int i = 0; i<10000; i++) {
            int val = (int) (Math.random() * 1000);
            heap.insert(val);
            if (val > max1) {
                if (val > max2) {
                    max1 = max2;
                    max2 = val;
                } else {
                    max1 = val;
                }
            }
        }
        assertTrue(MaxHeap.isValidHeap(heap.getList()));
        assertEquals(heap.getMax(), max2);
        assertEquals(heap.getMax(), max1);
    }
}
