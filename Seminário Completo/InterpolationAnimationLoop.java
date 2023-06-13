import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterpolationAnimationLoop extends JPanel implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int DURATION = 2000; // Duração da animação em milissegundos
    private static final int OBJECT_SIZE = 50;
    private static final int START_X = 50;
    private static final int START_Y = 50;
    private static final int END_X = 300;
    private static final int END_Y = 300;

    private long startTime;
    private Timer timer;
    private int currentX;
    private int currentY;
    private boolean reverse;

    public InterpolationAnimationLoop() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        startTime = System.currentTimeMillis();
        currentX = START_X;
        currentY = START_Y;
        reverse = false;

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long elapsedTime = System.currentTimeMillis() - startTime;
        float t = (float) elapsedTime / DURATION;

        if (t < 1.0f) {
            if (!reverse) {
                currentX = interpolate(START_X, END_X, t);
                currentY = interpolate(START_Y, END_Y, t);
            } else {
                currentX = interpolate(END_X, START_X, t);
                currentY = interpolate(END_Y, START_Y, t);
            }
        } else {
            reverse = !reverse;
            startTime = System.currentTimeMillis();
        }

        g.setColor(Color.RED);
        g.fillRect(currentX, currentY, OBJECT_SIZE, OBJECT_SIZE);
    }

    private int interpolate(int value1, int value2, float t) {
        float result = value1 + (value2 - value1) * t * t;
        return (int) result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interpolation Animation Loop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new InterpolationAnimationLoop());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
