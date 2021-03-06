package com.foxhole.tools.spartan.actions.movement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import com.foxhole.tools.spartan.actions.BasicGameAction;
import com.foxhole.tools.spartan.entity.IGameEntityObject;
import com.foxhole.tools.spartan.exception.SpartanException;
import com.foxhole.tools.spartan.forms.IGameFormObject;
import com.foxhole.tools.spartan.states.PositionalGameState;

public class AreaContainmentAction extends BasicGameAction {

	float minX;
	float minY;
	float maxX;
	float maxY;
	
	
	
	public AreaContainmentAction(String name, 
			float minX, float minY, float maxX, float maxY)
	throws SpartanException {
		super(name);
		
		
		
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
	
		PositionalGameState posState = null;
		
		for(IGameEntityObject entity : targetEntities){
			IGameFormObject form = entity.getForm();
			
			if(form != null){
				posState = (PositionalGameState) form.getState(PositionalGameState.class.getCanonicalName());
				
				if(posState.getX() < minX)
					posState.setX(minX);
				else if( posState.getX() > maxX)
					posState.setX(maxX);
				
				if(posState.getY() < minY)
					posState.setY(minY);
				else if( posState.getY() > maxY)
					posState.setY(maxY);
			}
		}
	}

}
