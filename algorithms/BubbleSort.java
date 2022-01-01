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

                    array.getRed()[j + 1] = 255;

                    for (int k = 0; k < array.getRed().length; k++) {
                        if (k != j + 1) array.getRed()[k] = 0;
                    }

                    array.getApp().repaint();
                    Util.sleepFor(Util.milliToNano(array.getDelay()));
                }
            }
        }

        array.resetColors();
        for (int i = 0; i < arr.length; i++) {
            array.getGreen()[i] = 255;
            array.getApp().repaint();
            Util.sleepFor(1000000000 / arr.length);
        }
    }
}