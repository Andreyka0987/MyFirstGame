package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameZone extends JPanel implements KeyListener {

    Player player = new Player(400, 500);
    ArrayList<Ball> arrayList = new ArrayList<>();
    int genSpeed;

    public GameZone() {
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : arrayList) {

            Color randomBallColor = new Color(ball.colors);

            g.setColor(randomBallColor);
            g.fillOval(getWidth() / 2 + ball.x, getHeight() / 2 + ball.y, ball.size, ball.size);
        }

        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, 25, 25);

        checkLose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char buttonPressed = e.getKeyChar();
        if (buttonPressed == 'w') {
            player.goForward();
            repaint();
        }
        if (buttonPressed == 's') {
            player.goBack();
            repaint();
        }
        if (buttonPressed == 'd') {
            player.goRight();
            repaint();
        }
        if (buttonPressed == 'a') {
            player.goLeft();
            repaint();
        }
        checkLose();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    public void ballSpawn() {
        int Colors = new Random().nextInt(0xFFFFFF + 1);
        int secSpeed = new Random().nextInt(400) + 400;
        Ball newBall = new Ball(0, 0, Colors, secSpeed);
        genSpeed = secSpeed;
        newBall.start();
        arrayList.add(newBall);
        repaint();
    }



    public void checkLose(){
        Rectangle playerBody = new Rectangle(player.x,player.y,25,25);
        for (Ball ball : arrayList){
            Rectangle circleBody = new Rectangle(getWidth() / 2 + ball.x, getHeight() / 2 + ball.y, ball.size, ball.size);
            if (playerBody.intersects(circleBody)){
                System.exit(0);
            }
        }
    }





}


class MyThread extends Thread {
    GameZone frame;

    public MyThread(GameZone frame) {
        this.frame = frame;
    }

    @Override
    public void run() {

        while (true) {
            super.run();
            try {

                sleep(300);
                frame.ballSpawn();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}