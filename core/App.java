package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import algorithms.InsertionSort;

public class App extends JPanel {
    // Setup
    public static int WIDTH = 1280, HEIGHT = 720;
    private static JFrame frame = new JFrame();

    private static SortingArray arr;

    public App() {
        setFocusable(true);

        arr = new SortingArray(this);
    }

    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;   

        arr.render(g);
    }

    public static void main(String[] args) {
        App app = new App();

        app.setDoubleBuffered(true);
        app.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.add(app);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        arr.shuffle();
        new InsertionSort().sort(arr);
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
