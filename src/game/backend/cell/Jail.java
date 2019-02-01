package game.backend.cell;

import game.backend.Grid;

public class Jail extends DestroyableCell {


    public Jail(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isMovable() {
        if(getIsDestroyed()) {
            return super.isMovable();
        }else{
            return false;
        }
    }

    @Override
    public String getKey() {
        if(!getIsDestroyed()){
            return "JAIL";
        }
        return null;
    }
}
