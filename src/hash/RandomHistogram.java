package hash;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomHistogram {

    public static void main(String[] args) {
        int N = 500; // Change N here
        long seed = System.nanoTime(); // You can fix the seed for reproducibility (e.g. 12345)

        int[] counts = sampleAndCount(N, seed);

        // Optional: print results to console
        System.out.println("N = " + N + ", seed = " + seed);
        for (int i = 0; i < N; i++) {
            System.out.printf("%2d -> %d%n", i + 1, counts[i]);
        }

        // Draw histogram using Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Histogram: N samples from 1..N");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new HistogramPanel(counts));
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    /**
     * Generates N random numbers in the range 1..N
     * and counts how many times each value appears.
     */
    private static int[] sampleAndCount(int N, long seed) {
        if (N <= 0) throw new IllegalArgumentException("N must be positive");
        int[] counts = new int[N];
        Random rnd = new Random(seed);

        for (int i = 0; i < N; i++) {
            int value = rnd.nextInt(N) + 1; // Uniform random in [1..N]
            counts[value - 1]++;
        }
        return counts;
    }

/**
 * A Swing panel that draws a simple histogram.
 */
static class HistogramPanel extends JPanel {
    private final int[] counts;
    private final int maxCount;

    HistogramPanel(int[] counts) {
        this.counts = counts.clone();

        int max = 0;
        for (int c : counts) {
            max = Math.max(max, c);
        }
        this.maxCount = Math.max(max, 1); // Avoid division by zero
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Margins
        int left = 60, right = 20, top = 20, bottom = 60;
        int plotWidth = width - left - right;
        int plotHeight = height - top - bottom;

        // Draw axes
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(left, top, left, top + plotHeight);              // Y axis
        g2.drawLine(left, top + plotHeight, left + plotWidth,
                top + plotHeight);                              // X axis

        // Y-axis ticks and labels
        int ticks = 5;
        for (int i = 0; i <= ticks; i++) {
            double ratio = i / (double) ticks;
            int y = top + plotHeight - (int) (plotHeight * ratio);
            int value = (int) Math.round(maxCount * ratio);

            g2.drawLine(left - 5, y, left, y);
            g2.drawString(String.valueOf(value), 10, y + 5);
        }

        int n = counts.length;
        double barWidth = plotWidth / (double) n;

        // Draw bars
        for (int i = 0; i < n; i++) {
            double ratio = counts[i] / (double) maxCount;
            int barHeight = (int) Math.round(ratio * plotHeight);

            int x = (int) Math.round(left + i * barWidth);
            int bw = Math.max(1, (int) Math.floor(barWidth - 2));
            int y = top + plotHeight - barHeight;

            g2.setColor(new Color(70, 130, 180)); // Steel blue
            g2.fillRect(x + 1, y, bw, barHeight);

            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(x + 1, y, bw, barHeight);

            // Draw X-axis labels every few bars to avoid clutter
            int step = Math.max(1, n / 10);
            if (i % step == 0 || i == n - 1) {
                g2.drawString(String.valueOf(i + 1),
                        x + 1, top + plotHeight + 20);
            }
        }

        // Axis titles
        g2.drawString("Value (1..N)", left + plotWidth / 2 - 30,
                height - 20);

        g2.rotate(-Math.PI / 2);
        g2.drawString("Count",
                -top - plotHeight / 2 - 10, 20);

        g2.dispose();
    }
    }
    }
