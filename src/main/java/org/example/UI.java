package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;

public class UI extends JFrame implements MouseListener, KeyListener {

    ArrayList<Ball> arrayList = new ArrayList<>();
    Random random = new Random(50);
    Player player = new Player(400,500);
    GameZone gameZone = new GameZone();

    public UI() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        add(gameZone);

        addKeyListener(gameZone);

       MyThread myThread = new MyThread(gameZone);
       myThread.start();


    }


    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}




    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}










