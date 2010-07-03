package com.foxhole.spartan.states;

public class CollisionGameState extends AbstractGameState{

	private int colliderType;
	
	public CollisionGameState(String id, int colliderType) {
		super(id);
		this.colliderType = colliderType;
	}

	public int getColliderType(){
		return colliderType;
	}
}