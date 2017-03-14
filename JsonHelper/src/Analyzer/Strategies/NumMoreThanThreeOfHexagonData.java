package Analyzer.Strategies;

import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy counts the number of attributes that are more than 3
 */
public class NumMoreThanThreeOfHexagonData {

    public int getNumMoreThanThreeOfHexagonData(Sukaima sukaima){
        int count=0;
        if(sukaima.getSkill()>=3) count++;
        if(sukaima.getSpeed()>=3) count++;
        if(sukaima.getToughness()>=3) count++;
        if(sukaima.getFeed()>=3) count++;
        if(sukaima.getMood()>=3) count++;
        if(sukaima.getVigour()>=3) count++;
        return count;
    }
}
