package Analyzer.Strategies;

import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy adds all the six attributes from the hexagon data
 */
public class SumOfHexagonData {

    public int getSumOfHexagonData(Sukaima sukaima){
        int sum=0;
        sum=sukaima.getFeed()+sukaima.getMood()+sukaima.getSkill()
                +sukaima.getSpeed()+sukaima.getToughness()+sukaima.getVigour();
        return sum;
    }

}
