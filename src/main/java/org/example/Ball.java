package org.example;

import java.util.Random;

public class Ball extends Thread{
    int x;
    int y;
    int size;
    int colors;
    Random randomObs = new Random();
    int ballSpeed;

    public Ball(int x, int y, int colors, int ballSpeed) {
        this.x = x;
        this.y = y;
        this.size = new Random().nextInt(50)+10;
        this.colors = colors;
        this.ballSpeed = ballSpeed;

    }

    public void movesForward(){
        if (randomObs.nextDouble() < 0.5) {
          x += 50;
        }
        else {
          x -= 50;
        }

        if (randomObs.nextDouble() < 0.5){
            y+=50;
        }
       else  {
            y-=50;
        }







    }


    @Override
    public void run() {
        super.run();
        while (true) {
            try {

                sleep(ballSpeed);
                movesForward();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
