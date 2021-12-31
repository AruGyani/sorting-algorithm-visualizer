package algorithms;

import core.SortingArray;
import core.Util;

public class InsertionSort implements SortingAlgorithm {
    public void sort(SortingArray array) {
        int[] arr = array.getData();

        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

                array.getApp().repaint();
                Util.sleepFor(Util.milliToNano(array.getDelay()));
            }

            arr[j + 1] = key;
        }

        array.getApp().repaint();
    }
}