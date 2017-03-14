package Analyzer.Strategies;

import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy counts the number of attributes that are more than 3
 */
public class NumMoreThanThreeOfHexagonData {

    public int getNumMoreThanThreeOfHexagonData(Sukaima sukaima){
        int count=0;
        if(sukaima.getSkill()>=4) count++;
        if(sukaima.getSpeed()>=4) count++;
        if(sukaima.getToughness()>=4) count++;
        if(sukaima.getFeed()>=4) count++;
        if(sukaima.getMood()>=4) count++;
        if(sukaima.getVigour()>=4) count++;
        return count;
    }
}
