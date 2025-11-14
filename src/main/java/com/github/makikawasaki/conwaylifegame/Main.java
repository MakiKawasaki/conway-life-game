package com.github.makikawasaki.conwaylifegame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 10);

        for (int i = 0; i < 100; i++) {
            game.playRound();
        }
    }
}