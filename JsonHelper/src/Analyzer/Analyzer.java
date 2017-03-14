package Analyzer;

import Exceptions.WrongValueException;
import bean.Match;
import bean.Sukaima;

import java.util.ArrayList;

/**
 * Created by alex on 3/14/17.
 */
public class Analyzer {


    private static DataHub dataHub;

    public Analyzer() {
        dataHub=new DataHub();
    }

    public Match getMatch(int matchNum){
        return dataHub.getMatchList().get(matchNum-1);      //mind that the matchNum should be no less than 1
    }

    public Sukaima getSukaimaByRank(int matchNum,int rank){
        Match theMatch=getMatch(matchNum);
        return theMatch.getSukaima(rank);
    }

    public ArrayList<Sukaima> getWinners(){
        return getSukaimasByRank(1);
    }

    public ArrayList<Sukaima> getSukaimasByRank(int rank){
        if(rank>=7||rank<=0){
            throw new WrongValueException();
        }
        ArrayList<Sukaima> result=new ArrayList<>();
        for(int i=0;i<dataHub.getMatchNum();i++){
            result.add(getSukaimaByRank(i+1,rank));
        }
        return result;
    }
}
