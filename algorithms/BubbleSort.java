package algorithms;

import core.SortingArray;
import core.Util;

public class BubbleSort implements SortingAlgorithm {
    public void sort(SortingArray array) {
        int[] arr = array.getData();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    array.getApp().repaint();
                    Util.sleepFor(Util.milliToNano(array.getDelay()));
                }
            }
        }

        array.getApp().repaint();
    }
}