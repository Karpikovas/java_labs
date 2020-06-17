import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Scribble3 extends Applet {
    int last_x, last_y;
    Color last_color = Color.blue;
    final Random random = new Random();

    public void init() {
// Определяет, создает и регистрирует объект MouseListener.
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                last_x = e.getX(); last_y = e.getY();
                if((e.getModifiers()&MouseEvent.BUTTON1_MASK)==0){
                    last_color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                }
            }
        });
        // Определяет, создает и регистрирует объект MouseMotionListener.
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                g.setColor(last_color);
                int x = e.getX(), y= e.getY();
                if((e.getModifiers()&MouseEvent.BUTTON1_MASK)!=0){
                    g.fillOval(x, y, 10, 10);
                    last_x = x; last_y = y;
                }

            }
        });
        // Создает кнопку Clear.
        Button b = new Button("Clear");
// Определяет, создает и регистрирует объект слушателя
// для обработки события, связанного с нажатием кнопки.
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
// стирание каракулей
                Graphics g = getGraphics();
                g.setColor(getBackground());
                g.fillRect(0, 0, getSize().width, getSize().height);
            }
        });
// Добавляет кнопку в апплет.
        this.add(b);
    }
}