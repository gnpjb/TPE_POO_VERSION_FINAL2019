package game.backend.cell;

import game.backend.Grid;

public class Jail extends DestroyableCell {


    public Jail(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isMovable() {
        //la celda no debe ser movible hasta que no se rompa
        if(getIsDestroyed()) {
            return super.isMovable();
        }else{
            return false;
        }
    }

    @Override
    public String getKey() {
        //una vez que la Jail se destruye entonces debe verse
        //y actuar como cualquier otra celda
        if(!getIsDestroyed()){
            return "JAIL";
        }
        return super.getKey();
    }
}
