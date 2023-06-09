import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimacaoInterpolacaoQuadratica extends JFrame implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Timer timer;
    private int currentStep;

    private int startX = 100;
    private int startY = 100;
    private int controlX = 400;
    private int controlY = 500;
    private int endX = 700;
    private int endY = 100;
    private int objectX;
    private int objectY;

    public AnimacaoInterpolacaoQuadratica() {
        setTitle("Animação com a Interpolação Quadrática");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentStep = 0;

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenha a curva de interpolação quadrática
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        for (int i = 0; i <= currentStep; i++) {
            double t = (double) i / currentStep;
            int x = interpolacaoQuadratica(startX, controlX, endX, t);
            int y = interpolacaoQuadratica(startY, controlY, endY, t);
            g2d.fillOval(x - 5, y - 5, 10, 10);
        }

        // Desenha o objeto animado
        g2d.setColor(Color.RED);
        g2d.fillOval(objectX - 10, objectY - 10, 20, 20);
    }

    public int interpolacaoQuadratica(int p0, int p1, int p2, double t) {
        double u = 1 - t;
        double tt = t * t;
        double uu = u * u;

        return (int) (uu * p0 + 2 * u * t * p1 + tt * p2);
    }

    public void actionPerformed(ActionEvent e) {
        if (currentStep <= 100) {
            currentStep++;
        } else {
            currentStep = 0;
        }

        double t = (double) currentStep / 100;
        objectX = interpolacaoQuadratica(startX, controlX, endX, t);
        objectY = interpolacaoQuadratica(startY, controlY, endY, t);

        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AnimacaoInterpolacaoQuadratica animation = new AnimacaoInterpolacaoQuadratica();
                animation.setVisible(true);
            }
        });
    }
}