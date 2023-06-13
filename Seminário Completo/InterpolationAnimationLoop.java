import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimacaoEmLoopInterpolacao extends JPanel implements ActionListener {
    private static final int LARGURA = 400;
    private static final int ALTURA = 400;
    private static final int DURACAO = 2000; // Duração da animação em milissegundos
    private static final int TAM_OBJETO = 50;
    private static final int X_INICIAL = 50;
    private static final int Y_INICIAL = 50;
    private static final int X_FINAL = 300;
    private static final int Y_FINAL = 300;

    private long horaComeco;
    private Timer tempo;
    private int X_Atual;
    private int Y_Atual;
    private boolean reverso;

    public AnimacaoEmLoopInterpolacao() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        horaComeco = System.currentTimeMillis();
        X_Atual = X_INICIAL;
        Y_Atual = Y_INICIAL;
        reverso = false;

        tempo = new Timer(10, this);
        tempo.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long tempoPassado = System.currentTimeMillis() - horaComeco;
        float t = (float) tempoPassado / DURACAO;

        if (t < 1.0f) {
            if (!reverso) {
                X_Atual = interpolate(X_INICIAL, X_FINAL, t);
                Y_Atual = interpolate(Y_INICIAL, Y_FINAL, t);
            } else {
                X_Atual = interpolate(X_FINAL, X_INICIAL, t);
                Y_Atual = interpolate(Y_FINAL, Y_INICIAL, t);
            }
        } else {
            reverso = !reverso;
            horaComeco = System.currentTimeMillis();
        }

        g.setColor(Color.RED);
        g.fillRect(X_Atual, Y_Atual, TAM_OBJETO, TAM_OBJETO);
    }

    private int interpolate(int value1, int value2, float t) {
        float resultado = value1 + (value2 - value1) * t * t;
        return (int) resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animação em Loop Interpolação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AnimacaoEmLoopInterpolacao());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
