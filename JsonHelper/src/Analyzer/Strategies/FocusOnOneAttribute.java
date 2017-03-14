package Analyzer.Strategies;

import Exceptions.WrongValueException;
import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy sets focus on one attribute on the hexagon data
 */
public class FocusOnOneAttribute {

    private int focus;

    public FocusOnOneAttribute() {
        focus=1;
    }

    public FocusOnOneAttribute(int focus){
        if(focus<=0||focus>=7) throw new WrongValueException();
        this.focus=focus;
    }

    public int getFocus(){
        return focus;
    }

    public int getFocusOnOneAttribute(Sukaima sukaima){
        switch (this.focus){
            case 1: return sukaima.getSkill();
            case 2: return sukaima.getSpeed();
            case 3: return sukaima.getToughness();
            case 4: return sukaima.getFeed();
            case 5: return sukaima.getMood();
            case 6: return sukaima.getVigour();
            default: return 0;
        }
    }
}
