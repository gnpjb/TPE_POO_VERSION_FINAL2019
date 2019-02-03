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
        //cuando una celda destruible es destruida
        //isDestroyed debe pasar a ser true
        super.clearContent();
        isDestroyed=true;
    }

    @Override
    public String getKey() {
        if(!isDestroyed){
            return "DESTROYABLE_CELL";
        }
        return "DESTROYED_CELL";
    }
}
