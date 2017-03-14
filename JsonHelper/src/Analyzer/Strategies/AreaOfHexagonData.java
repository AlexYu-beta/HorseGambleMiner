package Analyzer.Strategies;

import bean.Sukaima;

/**
 * Created by alex on 3/14/17.
 * this strategy calculates the relative area surrounded by the six attributes of a hexagon data
 */
public class AreaOfHexagonData {

    public double getAreaOfHexagonData(Sukaima sukaima){
        double area=0.0;
        area+=sukaima.getSkill()*sukaima.getSpeed();
        area+=sukaima.getSpeed()*sukaima.getToughness();
        area+=sukaima.getToughness()*sukaima.getFeed();
        area+=sukaima.getFeed()*sukaima.getMood();
        area+=sukaima.getMood()*sukaima.getVigour();
        area+=sukaima.getVigour()*sukaima.getSkill();
        return area;
    }
}
