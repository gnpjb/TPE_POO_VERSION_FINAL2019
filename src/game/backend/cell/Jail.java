package game.backend.cell;

import game.backend.Grid;

public class Jail extends Cell {

    boolean isDestroyed=false;

    public Jail(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isMovable() {
        if(isDestroyed) {
            return super.isMovable();
        }else{
            return false;
        }
    }

    @Override
    public void clearContent() {
        super.clearContent();
        isDestroyed=true;
    }
}
