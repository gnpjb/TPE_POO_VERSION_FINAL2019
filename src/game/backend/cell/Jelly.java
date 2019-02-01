package game.backend.cell;

import game.backend.Grid;

public class Jelly extends DestroyableCell {

    public Jelly(Grid grid) {
        super(grid);
    }

    @Override
    public String getKey() {
        if(!getIsDestroyed()){
            return "JELLY";
        }
        return null;
    }
}
