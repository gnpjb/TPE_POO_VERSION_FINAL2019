package game.backend.cell;

import game.backend.Grid;

public class Jelly extends DestroyableCell {

    public Jelly(Grid grid) {
        super(grid);
    }

    @Override
    public String getKey() {
        //una vez destruida debe verse como una cell normal
        if(!getIsDestroyed()){
            return "JELLY";
        }
        return super.getKey();
    }
}
