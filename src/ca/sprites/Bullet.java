package ca.sprites;

import java.lang.reflect.Constructor;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;

public class Bullet extends Sprite {
	
	public Bullet(Animation anim) {
        super(anim);
        ownerType = PLAYER_BULLET;
    }
	
	public Bullet(Animation anim, int ownership) {
        super(anim);
        if (ownership == ENEMY_BULLET){
        	ownerType = ENEMY_BULLET;
        }
        else{
        	ownerType = PLAYER_BULLET;
        }
    }
	
	public static final int PLAYER_BULLET = 0;
	public static final int ENEMY_BULLET = 1;
	
	private int ownerType;

	public int getType(){
		return ownerType;
	}
	
    public Object clone() {
        // use reflection to create the correct subclass
        Constructor constructor = getClass().getConstructors()[0];
        try {
            return constructor.newInstance(
                new Object[] {(Animation)anim.clone()});
        }
        catch (Exception ex) {
            // should never happen
            ex.printStackTrace();
            return null;
        }
    }
}
