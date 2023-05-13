import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class DragPanel extends JLabel {
    ImageIcon img = new ImageIcon();
    final int WIDTH = img.getIconWidth();
    final int HEIGHT = img.getIconHeight();
    Point imageCorner;
    Point prevPt;

    DragPanel(String imgpath) {
        img=new ImageIcon(imgpath);
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }

    public void paintComponent(Graphics g) {
        //repaint our component after repositioning
        super.paintComponent(g);
        img.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());

    }
    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prevPt=e.getPoint();
        }

    }
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint();
            imageCorner.translate(
                    (int) (currentPt.getX() - prevPt.getX()),
                    (int) (currentPt.getY() - prevPt.getY())
            );
            prevPt = currentPt;
            repaint();
        }

    }
}
