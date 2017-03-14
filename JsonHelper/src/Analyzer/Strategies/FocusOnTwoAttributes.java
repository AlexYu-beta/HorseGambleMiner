package Analyzer.Strategies;

import Exceptions.WrongValueException;
import bean.Sukaima;
import javafx.util.Pair;

/**
 * Created by alex on 3/14/17.
 * this strategy sets focus on two attributes on the hexagon data
 */
public class FocusOnTwoAttributes {

    private int focusA,focusB;


    public FocusOnTwoAttributes() {
        this.focusA=1;
        this.focusB=2;
    }

    public Pair<Integer,Integer> getFocusOnTwoAttributes(Sukaima sukaima){
        //the pair is not key-value pair but only simple combination of two numbers
        FocusOnOneAttribute fA=new FocusOnOneAttribute(focusA);
        FocusOnOneAttribute fB=new FocusOnOneAttribute(focusB);
        int attributeA=fA.getFocusOnOneAttribute(sukaima);
        int attributeB=fB.getFocusOnOneAttribute(sukaima);
        Pair<Integer,Integer> pair=new Pair<>(attributeA,attributeB);
        return pair;
    }

    public int getSumOfTwoFoci(Sukaima sukaima){
        Pair<Integer,Integer> pair=getFocusOnTwoAttributes(sukaima);
        return pair.getKey()+pair.getValue();
    }

    public FocusOnTwoAttributes(int focusA, int focusB) {
        if(focusA<=0||focusA>=7) throw new WrongValueException();
        if(focusB<=0||focusB>=7) throw new WrongValueException();
        if(focusA==focusB) throw new WrongValueException();
        this.focusA = focusA;
        this.focusB = focusB;
    }

    public int getFocusA() {
        return focusA;
    }

    public int getFocusB() {
        return focusB;
    }
}
