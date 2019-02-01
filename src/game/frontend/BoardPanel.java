package game.frontend;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class BoardPanel extends TilePane {

	private Group[][] cells;

	public BoardPanel(final int rows, final int columns, final int cellSize) {
		setPrefRows(rows);
		setPrefColumns(columns);
		setPrefTileHeight(cellSize);
		setPrefTileWidth(cellSize);
		this.cells = new Group[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Group(new ImageView(),new ImageView());
				getChildren().add(cells[i][j]);
			}
		}
	}
	
	public void setImage(int row, int column, Image imageTop,Image imageBottom) {
		((ImageView)cells[row][column].getChildren().get(0)).setImage(imageBottom);
		((ImageView)cells[row][column].getChildren().get(1)).setImage(imageTop);
	}

}