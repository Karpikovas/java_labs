//фрейм посередине окна
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class t2 {
    public static void main(String[] args){
        simple1 frame=new simple1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();}
}
class simple1 extends JFrame{
    simple2 s2;
    JButton but=new JButton("Create");
    public simple1(){
        ButtonListener blistener = new ButtonListener();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screens = kit.getScreenSize();
        int w,h;
        w = screens.width;
        h = screens.height;
        setSize(w/2,h/2);
        setLocation(w/4, h/4);
        setTitle("My Frame");
        setLayout(new FlowLayout());
        setLayout(null); //отключает менеджер расположения компонентов
        add(but);
        but.addActionListener(blistener);
    }
    public void getV(){
        System.out.println("VALUES+++"+s2.r);
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(s2==null){s2=new simple2(); }
            s2.show();
            getV(); }
    }
}//class
class simple2 extends JFrame{
    int r=5;
    public simple2(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screens = kit.getScreenSize();
        int w,h;
        w = screens.width;
        h = screens.height;
        setSize(w/3,h/3);
        setLocation(w/6, h/6);
        setTitle("My Frame");
    }
}