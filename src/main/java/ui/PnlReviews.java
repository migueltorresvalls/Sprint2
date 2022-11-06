package main.java.ui;

import javax.swing.*;
import java.awt.*;

public class PnlReviews extends JPanel {

    JLabel text1 = new JLabel("Review1");
    JLabel text2 = new JLabel("Review2");
    JLabel text3 = new JLabel("Review3");
    JLabel text4 = new JLabel("Review4");
    JLabel text5 = new JLabel("Review5");
    JLabel text6 = new JLabel("Review6");
    JLabel text7 = new JLabel("Review7");
    JLabel text8 = new JLabel("Review8");
    JLabel text9 = new JLabel("Review9");

    JPanel pnl1;
    JPanel pnl2;
    JPanel pnl3;
    JPanel pnl4;
    JPanel pnl5;
    JPanel pnl6;
    JPanel pnl7;
    JPanel pnl8;
    JPanel pnl9;

    public PnlReviews(){

        setLayout(new GridLayout(3,3));  //reviews

        initPnls();

    }

    public void initPnls(){
        pnl1 = new JPanel();
        pnl1.add(text1);
        pnl1.setBackground(Color.WHITE);
        add(pnl1);

        pnl2 = new JPanel();
        pnl2.add(text2);
        pnl2.setBackground(Color.BLUE);
        add(pnl2);

        pnl3 = new JPanel();
        pnl3.add(text3);
        pnl3.setBackground(Color.CYAN);
        add(pnl3);

        pnl4 = new JPanel();
        pnl4.add(text4);
        pnl4.setBackground(Color.RED);
        add(pnl4);

        pnl5 = new JPanel();
        pnl5.add(text5);
        pnl5.setBackground(Color.BLACK);
        add(pnl5);

        pnl6 = new JPanel();
        pnl6.add(text6);
        pnl6.setBackground(Color.ORANGE);
        add(pnl6);

        pnl7 = new JPanel();
        pnl7.add(text7);
        pnl7.setBackground(Color.yellow);
        add(pnl7);

        pnl8 = new JPanel();
        pnl8.add(text8);
        pnl8.setBackground(Color.GREEN);
        add(pnl8);

        pnl9 = new JPanel();
        pnl9.add(text9);
        pnl9.setBackground(Color.MAGENTA);
        add(pnl9);

    }


}
