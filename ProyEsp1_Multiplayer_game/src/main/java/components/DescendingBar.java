package components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bebi_
 */
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DescendingBar extends JPanel implements Runnable {

    private final int WIDTH = 300;
    private final int HEIGHT = 40;
    private final int MAX_TIME = 10000;
    private int timeRemaining = MAX_TIME;
    private Color green = new Color(0, 255, 0);
    private Timer timer;

    /**
     * Constructor of the class, initializes the bar, sets the color, size and start time.
     */
    public DescendingBar() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        timer = new Timer();
        timer.schedule(new UpdateTimerTask(), 0, 100);
    }

    /**
     * This class extends the TimerTask class and is used as a Runnable to update the bar's width.
     */
    private class UpdateTimerTask extends TimerTask {

        @Override
        public void run() {
            timeRemaining -= 100;
            repaint();
            if (timeRemaining <= 0) {
                timer.cancel();
            }
        }
    }

    /**
     * This method is used to paint the bar.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color to green and fill the rectangle from 0 to the calculated width of the bar.
        g.setColor(green);
        g.fillRect(0, 0, calculateWidth(), HEIGHT);
    }

    /**
     * This method calculates the width of the bar based on the remaining time and the maximum time.
     * @return the width of the bar
     */
    private int calculateWidth() {
        return WIDTH - (int) (((double) timeRemaining / (double) MAX_TIME) * WIDTH);
    }

    /**
     * This method is used to start the timer.
     */
    public void start() {
        new Thread(this).start();
    }

    /**
     * This method executes the timer.
     */
    @Override
    public void run() {
        timer.scheduleAtFixedRate(new UpdateTimerTask(), 0, 100);
    }
}