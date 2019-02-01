package game.backend.cell;

import game.backend.Grid;

public abstract class DestroyableCell extends Cell {

    private boolean isDestroyed=false;

    public DestroyableCell(Grid grid) {
        super(grid);
    }

    public void setIsDestroyed(boolean isDestroyed){
        this.isDestroyed=isDestroyed;
    }

    public boolean getIsDestroyed(){
        return this.isDestroyed;
    }

    @Override
    public void clearContent() {
        super.clearContent();
        isDestroyed=true;
    }

    @Override
    public String getKey() {
        return "DESTROYABLE_CELL";
    }
}
