package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class SortingArray {
    private int[] arr, red, green, blue;
    private int length, boxWidth, offX, delay;
    private App app;

    public SortingArray(int length, boolean shuffle, int delay, App app) {
        initializeArray(length, shuffle, delay, app);
    }

    public SortingArray(App app) {
        initializeArray(256, true, 1, app);
    }

    public void initializeArray(int length, boolean shuffle, int delay, App app) {
        this.length = length;
        this.delay = delay;

        this.app = app;

        this.arr = new int[length];
        this.red = new int[length];
        this.green = new int[length];
        this.blue = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = ((App.HEIGHT - 100) * (i + 1)) / length;

            red[i] = green[i] = blue[i] = 0;
        }

        if (shuffle) shuffle();
    }

    public void render(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        g.clearRect(0, 0, App.WIDTH, App.HEIGHT);

        boxWidth = App.WIDTH / length;
        offX = App.WIDTH % length;

        for (int i = 0; i < length; i++) {
            g.setColor(new Color(red[i], green[i], blue[i]));
            
            g.fillRect(i * boxWidth + offX, App.HEIGHT - arr[i], boxWidth, arr[i]);
        }
    }   

    public void shuffle() {
        resetColors();

        int index;
        Random random = new Random();
        for (int i = length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                arr[index] ^= arr[i];
                arr[i] ^= arr[index];
                arr[index] ^= arr[i];
            }
        }

        app.repaint();
    }

    public void resetColors() {
        for (int i = 0; i < length; i++) {
            red[i] = 0;
            green[i] = 0;
            blue[i] = 0;
        }
    }

    public void resetRed() {
        for (int i = 0; i < length; i++) {
            red[i] = 0;
        }
    }

    public void resetGreen() {
        for (int i = 0; i < length; i++) {
            green[i] = 0;
        }
    }

    public void resetBlue() {
        for (int i = 0; i < length; i++) {
            blue[i] = 0;
        }
    }

    public int getDelay() { return delay; }
    public int getValue(int i) { return arr[i]; }

    public int[] getData() { return arr;}
    public int[] getRed() { return red; }
    public int[] getGreen() { return green; }
    public int[] getBlue() { return blue; }

    public App getApp() { return app; }
}