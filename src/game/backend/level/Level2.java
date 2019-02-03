package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.cell.Jail;
import game.backend.element.Wall;

import java.util.LinkedList;

public class Level2 extends Level {
    private static int MAX_MOVES = 20;
    private LinkedList<Jail> jailCells=new LinkedList<>();

    @Override
    protected Cell initCell(int i, int j) {
        //settea como Jail a unas Cells
        //especificas sino las deja como cells normales
        if(i==SIZE/2&&j!=SIZE/2){
            Jail ret=new Jail(this);
            //guarda una referencia a todas las Jail
            jailCells.add(ret);
            //esto es para poder aprovechar la forma en que level
            //arma el Grid. si no fuera por esto no podrian caer
            ret.setIsDestroyed(true);
            return ret;
        }
        return new Cell(this);
    }

    @Override
    protected void endInit() {
        //esto settea todas las Jail como no destruidas al finalizar initialize
        for(Jail j:jailCells){
            j.setIsDestroyed(false);
        }
    }

    @Override
    protected GameState newState() {
        return new Level2.Level2State(MAX_MOVES);
    }

    private class Level2State extends GameState {
        private int maxMoves;

        public Level2State(int maxMoves) {
            this.maxMoves=maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            //si algun Jail no esta destruido
            //entonces el jugador no gano
            for(Jail j:jailCells){
                if(!j.getIsDestroyed()){
                    return false;
                }
            }
            return true;
        }
    }
}
