package Analyzer;

import bean.Match;
import bean.Sukaima;

import java.util.ArrayList;

/**
 * Created by alex on 3/14/17.
 * this is the main entry and test file
 */
public class Main {
    public static void main(String args[]){
        Analyzer analyzer=new Analyzer();
        //just for test
        ArrayList<Sukaima> sukaimas=analyzer.getSukaimasByRank(1);
        for(int i=0;i<sukaimas.size();i++){
            System.out.println(sukaimas.get(i).getName());
        }
    }
}
