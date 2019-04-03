package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.HazardBattle.Tiles.LoopbandTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

//subklasse Geest, welke erft van de zelfgemaakte AbstractObject klasse. 
//Deze klasse is 1 van de 3 vijand klasse, en heeft dus een andere implementatie dan de andere 2 klasses

public class Geest extends AbstractObject {

	private HazardBattle world; 
	
	public Geest(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/ghost.png"));
		this.world = world;
		setxSpeed(2f);
	}

	@Override
	public void mousePressed(int x, int y, int button) {

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		
		PVector vector; 
		
        for (CollidedTile ct : collidedTiles) {
            
            if (ct.theTile instanceof LoopbandTile) {
            	this.setX(getX() + 32);
            	setxSpeed(1f);
            }
        }
	}

	@Override
	public void update() {
		if(getX() == world.gameBreedte) {
			world.verminderLevens(4);
			world.deleteGameObject(this);		
		} else if(world.haalLevensOp() <= 0) {
			world.exit();
		}
	}

}
