package org.example;

public class Player extends Thread{
    int x;
    int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void goForward(){
        y -= 15;
    }
    public void goBack(){
        y += 15;
    }
    public void goRight(){
        x += 15;
    }
    public void goLeft(){
        x -= 15;
    }


}
