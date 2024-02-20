
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class FastTravel {
    static JFrame frame = new JFrame();
    static JLabel label;
    static int change=10;

    static public void move(KeyEvent e){
        int thisChange=e.isShiftDown()?change*2:change;
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_LEFT ) -> {
                if (label.getX() - thisChange >= 0)
                    label.setLocation(label.getX() - thisChange, label.getY());
                else {
                    label.setLocation((int) (frame.getContentPane().getSize().getWidth() - label.getWidth()), label.getY());
                }
            }
            case (KeyEvent.VK_RIGHT) -> {
                if (label.getX() + thisChange < (int) frame.getContentPane().getSize().getWidth() - label.getWidth())
                    label.setLocation(label.getX() + thisChange, label.getY());
                else {
                        label.setLocation(0, label.getY());
                }
            }
            case (KeyEvent.VK_UP) -> {
                if (label.getY() - thisChange >= 0)
                    label.setLocation(label.getX(), label.getY() - thisChange);
                else {

                        label.setLocation(label.getX(), (int) frame.getContentPane().getSize().getHeight() - label.getHeight());
                }
            }
            case (KeyEvent.VK_DOWN) -> {
                if (label.getY() + thisChange < (int) frame.getContentPane().getSize().getHeight() - label.getHeight())
                    label.setLocation(label.getX(), label.getY() + thisChange);
                else {

                        label.setLocation(label.getX(), 0);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Быстрое перемещение");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width=800, height=600;
        frame.setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);
        BufferedImage image = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/ogrelove/png/9.png"));
        JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT));
        panel.setFocusable(true);
        label = new JLabel(new ImageIcon(image),JLabel.RIGHT);
        panel.add(label, BorderLayout.NORTH);
        frame.add(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                move(e);
            }
        });
        frame.setVisible(true);
    }
}