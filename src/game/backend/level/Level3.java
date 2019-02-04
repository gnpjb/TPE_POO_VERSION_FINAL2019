package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.Jelly;

import java.util.LinkedList;

public class Level3 extends Level {
    private static int MAX_MOVES = 20;
    private LinkedList<Jelly> jellyCells=new LinkedList<>();

    @Override
    protected GameState newState() {
        return new Level3.Level3State(MAX_MOVES);
    }

    @Override
    protected Cell initCell(int i, int j) {
        //settea unas Cells especificas como Jelly
        if((i==SIZE/2  || i==SIZE/2+1) && j%2!=0){
            Jelly ret=new Jelly(this);
            jellyCells.add(ret);
            return ret;
        }
        return new Cell(this);
    }

    @Override
    protected void endInit() {
        //esto se hace por si alguna Jelly se destruyo
        //en el proceso de inicializacin del Grid
        for(Jelly j:jellyCells){
            j.setIsDestroyed(false);
        }
    }

    private class Level3State extends GameState {
        private long maxMoves;

        public Level3State(int maxMoves) {
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            for(Jelly j:jellyCells){
                if(!j.getIsDestroyed()){
                    return false;
                }
            }
            return true;
        }
    }
}
