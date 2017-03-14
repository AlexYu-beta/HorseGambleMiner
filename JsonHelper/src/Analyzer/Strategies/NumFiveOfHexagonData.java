package Analyzer.Strategies;

import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy counts the number of attributes that reach their values to 5
 */
public class NumFiveOfHexagonData {

    public int getFiveNumOfHexagonData(Sukaima sukaima){
        int count=0;
        if(sukaima.getSkill()==5) count++;
        if(sukaima.getSpeed()==5) count++;
        if(sukaima.getToughness()==5) count++;
        if(sukaima.getFeed()==5) count++;
        if(sukaima.getMood()==5) count++;
        if(sukaima.getVigour()==5) count++;
        return count;
    }
}
