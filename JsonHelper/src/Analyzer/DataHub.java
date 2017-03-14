package Analyzer;

import MatchReader.MatchReader;
import bean.Match;

import java.util.ArrayList;

/**
 * Created by alex on 3/14/17.
 */
public class DataHub {

    private ArrayList<Match> matchList;

    public DataHub() {
        matchList=new ArrayList<>();
        MatchReader matchReader=new MatchReader();
        int matchNum=matchReader.getMatchNum();
        for(int i=1;i<=matchNum;i++){
            matchList.add(matchReader.readMatch(i));
        }
    }

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public int getMatchNum(){
        return matchList.size();
    }
}
