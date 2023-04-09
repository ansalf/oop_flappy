package FlappyBird.Control;

import FlappyBird.Game;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import static FlappyBird.Util.Constant.*;

public class GameOver extends JFrame implements ActionListener {
    TextField tf;
    JButton bthSave;
    JLabel label;
    JLabel label1;
    JLabel best;

    public void setLabel1(long score) {
        label1 = new JLabel("You got " + score + " scores!");
        Font newLabelFont = new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize());
        label1.setFont(newLabelFont);
        label1.setBounds(130, 80, 200, 20);
        add(label1);
    }

    public void setBest() {
        best = new JLabel("New best!");
        Font newLabelFont = new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize());
        best.setFont(newLabelFont);
        best.setForeground(Color.WHITE);
        best.setBounds(20, 80, 100, 30);
        add(best);
    }

    public GameOver() {

        label = new JLabel("Congratulations!");
        Font newLabelFont = new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize());
        label.setFont(newLabelFont);
        label.setBounds(5, 50, 100, 20);
        tf = new TextField();
        tf.setBackground(Color.LIGHT_GRAY);
        tf.setForeground(Color.blue);
        tf.setBounds(105, 50, 150, 20);
        bthSave = new JButton("Save");
        bthSave.setBorder(BorderFactory.createEmptyBorder());
        bthSave.setContentAreaFilled(false);
        bthSave.setFocusable(false);
        bthSave.setBounds(100, 130, 100, 50);
        bthSave.addActionListener(this);
        add(bthSave);
        add(tf);
        add(label);
        setSize(300, 210);
        setLocation(frameX + frameWidth / 2 - 150, frameY + frameHeight / 2 - 50);

        setLayout(null);
        setResizable(false);
        setVisible(false);

        setUndecorated(true);
        getContentPane().setBackground(Color.PINK);
        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bthSave) {
            Game.score.NewScore(tf.getText());
            tf.setText("");
            show(false);
            remove(label1);
            try {
                remove(best);
            } catch (Exception ex) {

            }
        }
    }

    private boolean i = true;
    private int x = frameWidth;

    public void draw(Graphics g) {
        try {
            InputStream stream = ClassLoader.getSystemClassLoader()
                    .getResourceAsStream("resources/DJB Ransom Note.ttf");
            Font font;
            g.setColor((Color.WHITE));
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(98f);
            g.setFont(font);

            g.drawString("Game Over", frameWidth / 3 - font.getSize(), font.getSize() * 2);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
            g.drawString("Game Over", frameWidth / 4, 70);
        } catch (Exception e) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
            g.drawString("Game Over", frameWidth / 2, 120);

        }
        i = !i;
    }

    class MyDefaultMetalTheme extends DefaultMetalTheme {
        public ColorUIResource getWindowTitleInactiveBackground() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getWindowTitleBackground() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getPrimaryControlHighlight() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getPrimaryControlDarkShadow() {
            return new ColorUIResource(Color.CYAN);
        }

        public ColorUIResource getPrimaryControl() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControlHighlight() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControlDarkShadow() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControl() {
            return new ColorUIResource(Color.orange);
        }
    }
}