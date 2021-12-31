import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JPanel {
    // Setup
    private static int WIDTH = 1000, HEIGHT = 500;
    private static JFrame frame = new JFrame();

    public int[] arr;
    public int blockWidth, offX, delay = 10;
    public String algorithm = "";

    public App() {
        setFocusable(true);

        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                
            }

            public void keyReleased(KeyEvent e) {
                
            }

            public void keyTyped(KeyEvent e) {

            }
        });

        arr = new int[100];
        for (int i = 0; i < arr.length; i++) arr[i] = ((HEIGHT - 50) * (i + 1)) / arr.length;
        
        offX = WIDTH % arr.length;
        blockWidth = WIDTH / arr.length;
    }

    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.drawString("delay: " + delay, 20, 25);
        g.drawString("algorithm: " + algorithm, 20, 45);

        g.setColor(Color.BLACK);
        for (int i = 0; i < arr.length; i++) {
            g.fillRect(i * blockWidth + offX, HEIGHT - arr[i], blockWidth, arr[i]);
        }
    }

    public void shuffle() {
        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                arr[index] ^= arr[i];
                arr[i] ^= arr[index];
                arr[index] ^= arr[i];
            }
        }
    }

    public void insertion() {
        algorithm = "insertion";

        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

                repaint();
                sleepFor(milliToNano(1));
            }

            arr[j + 1] = key;
        }
    }

    public int milliToNano(int milliseconds) { return milliseconds * 1000000; }

    public void sleepFor(long nanoseconds) {
        long timeElapsed;
        final long startTime = System.nanoTime();

        do {
            timeElapsed = System.nanoTime() - startTime;
        } while (timeElapsed < nanoseconds);
    }
    
    public void update() {
        WIDTH = this.getWidth();
        HEIGHT = this.getHeight();

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

        app.shuffle();
        app.insertion();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
