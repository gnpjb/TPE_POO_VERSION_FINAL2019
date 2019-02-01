package game.frontend;

import game.backend.cell.Jail;
import game.backend.cell.Jelly;
import game.backend.element.Bomb;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.HorizontalStripedCandy;
import game.backend.element.Nothing;
import game.backend.element.VerticalStripedCandy;
import game.backend.element.Wall;
import game.backend.element.WrappedCandy;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageManager {

	private static final String IMAGE_PATH = "images/";
	private Map<String, Image> images;

	public ImageManager() {
		WrappedCandy wc = new WrappedCandy();
		VerticalStripedCandy vc = new VerticalStripedCandy();
		HorizontalStripedCandy hc = new HorizontalStripedCandy();

		images = new HashMap<>();
		images.put(new Nothing().getKey(), new Image(IMAGE_PATH + "nothing.png"));
		images.put(new Bomb().getKey(),  new Image(IMAGE_PATH + "bomb.png"));
		images.put(new Wall().getKey(),  new Image(IMAGE_PATH + "wall.png"));
		for (CandyColor cc: CandyColor.values()) {
			images.put(new Candy(cc).getFullKey(),   new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Candy.png"));
		}
		for (CandyColor cc: CandyColor.values()) {
			wc.setColor(cc);
			images.put(wc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Wrapped.png"));
		}
		for (CandyColor cc: CandyColor.values()) {
			vc.setColor(cc);
			images.put(vc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "VStripped.png"));
		}
		for (CandyColor cc: CandyColor.values()) {
			hc.setColor(cc);
			images.put(hc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "HStripped.png"));
		}

		//agregado para mostrar jail y jelly
		String jailKey = new Jail(null).getKey();
		String jellyKey= new Jelly(null).getKey();
		images.put(jailKey, new Image(IMAGE_PATH + "jail.png"));
        images.put(jellyKey, new Image(IMAGE_PATH + "jelly.png"));
    }

	public Image getImage(String key) {
		return images.get(key);//para poder obtener jail y jelly
	}

}
