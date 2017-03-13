package bean;

import java.util.ArrayList;

/**
 * Created by alex on 3/13/17.
 */
public class Match {

    public Match(int matchNum, ArrayList<Sukaima> sukaimas) {
        this.matchNum = matchNum;
        this.sukaimas = sukaimas;
    }

    private int matchNum;
    private ArrayList<Sukaima> sukaimas;

    public ArrayList<Sukaima> getSukaimas() {
        return sukaimas;
    }

    public Sukaima getSukaima(int rank){
        for(Sukaima sukaima: sukaimas){
            if(sukaima.getRank()==rank) return sukaima;
        }
        return null;
    }
}
