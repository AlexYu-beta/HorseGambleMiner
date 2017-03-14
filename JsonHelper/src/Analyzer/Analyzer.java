package Analyzer;

import Analyzer.Strategies.*;
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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////   fetch data from DataHub   ////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public ArrayList<ArrayList<Sukaima>> getSukaimas(){
        ArrayList<ArrayList<Sukaima>> result=new ArrayList<>();
        for(int rank=1;rank<=6;rank++){
            result.add(getSukaimasByRank(rank));
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////   analyze data by using methods from package Strategies   //////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double analyzeLargerAreaOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        AreaOfHexagonData areaOfHexagonData=new AreaOfHexagonData();
        System.out.println();
        System.out.println("面积最大赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerArea=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerArea=areaOfHexagonData.getAreaOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerArea<areaOfHexagonData.getAreaOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

    public double analyzeSmallerAreaOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        AreaOfHexagonData areaOfHexagonData=new AreaOfHexagonData();
        System.out.println();
        System.out.println("面积最小赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerArea=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerArea=areaOfHexagonData.getAreaOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerArea>areaOfHexagonData.getAreaOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

    public void displayWinnerAreas(){
        System.out.println();
        System.out.println("赢家面积（相对大小）：");
        ArrayList<Sukaima>sukaimas=getWinners();
        AreaOfHexagonData areaOfHexagonData=new AreaOfHexagonData();
        for(int i=0;i<dataHub.getMatchNum();i++){
            System.out.println(areaOfHexagonData.getAreaOfHexagonData(sukaimas.get(i)));
        }

    }

    public double analyzeFocusOnOneAttribute(int focus){
        FreqCounter freqCounter=new FreqCounter();
        AttributeTranslator attributeTranslator=new AttributeTranslator();
        FocusOnOneAttribute focusOnOneAttribute=new FocusOnOneAttribute(focus);
        String attribute=attributeTranslator.translateAttribute(focus);
        System.out.println();
        System.out.println("以"+attribute+"为焦点（该属性最大的赢）的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerAttribute=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerAttribute=focusOnOneAttribute.getFocusOnOneAttribute(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerAttribute<focusOnOneAttribute.getFocusOnOneAttribute(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();
    }

    public double analyzeFocusOnTwoAttributes(int focusA,int focusB){
        FreqCounter freqCounter=new FreqCounter();
        AttributeTranslator attributeTranslator=new AttributeTranslator();
        FocusOnTwoAttributes focusOnTwoAttributes=new FocusOnTwoAttributes(focusA,focusB);
        String attributeA=attributeTranslator.translateAttribute(focusA);
        String attributeB=attributeTranslator.translateAttribute(focusB);
        System.out.println();
        System.out.println("以"+attributeA+"和"+attributeB+"为焦点（这两个属性最大的赢）的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerAttributeA=0,winnerAttributeB=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerAttributeA=focusOnTwoAttributes.getFocusOnTwoAttributes(sukaimas.get(i-1)).getKey();
            winnerAttributeB=focusOnTwoAttributes.getFocusOnTwoAttributes(sukaimas.get(i-1)).getValue();
            for(int j=2;j<=6;j++){
                if(winnerAttributeA<focusOnTwoAttributes.getFocusOnTwoAttributes(getSukaimaByRank(i,j)).getKey()
                        ||winnerAttributeB<focusOnTwoAttributes.getFocusOnTwoAttributes(getSukaimaByRank(i,j)).getValue()){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();
    }

    public double analyzeNumFiveOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        NumFiveOfHexagonData numFiveOfHexagonData=new NumFiveOfHexagonData();
        System.out.println();
        System.out.println("最多属性值为5赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerCount=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerCount=numFiveOfHexagonData.getFiveNumOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerCount<numFiveOfHexagonData.getFiveNumOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

    public double analyzeNumMoreThanThreeOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        NumMoreThanThreeOfHexagonData numMoreThanThreeOfHexagonData=new NumMoreThanThreeOfHexagonData();
        System.out.println();
        System.out.println("最多属性值为4或5赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerCount=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerCount=numMoreThanThreeOfHexagonData.getNumMoreThanThreeOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerCount<numMoreThanThreeOfHexagonData.getNumMoreThanThreeOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

    public double analyzeLargerSumOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        SumOfHexagonData sumOfHexagonData=new SumOfHexagonData();
        System.out.println();
        System.out.println("6属性和最大赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerSum=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerSum=sumOfHexagonData.getSumOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerSum<sumOfHexagonData.getSumOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

    public double analyzeSmallerSumOfHexagonData(){
        FreqCounter freqCounter=new FreqCounter();
        SumOfHexagonData sumOfHexagonData=new SumOfHexagonData();
        System.out.println();
        System.out.println("6属性和最小赢的频率：");
        ArrayList<Sukaima> sukaimas=getWinners();
        int winnerSum=0;
        boolean hit=true;
        for(int i=1;i<=dataHub.getMatchNum();i++){
            hit=true;
            winnerSum=sumOfHexagonData.getSumOfHexagonData(sukaimas.get(i-1));
            for(int j=2;j<=6;j++){
                if(winnerSum>sumOfHexagonData.getSumOfHexagonData(getSukaimaByRank(i,j))){
                    hit=false;
                    break;
                }
            }
            if(hit)freqCounter.hit();
            else freqCounter.miss();
        }
        return freqCounter.getFreq();

    }

}
