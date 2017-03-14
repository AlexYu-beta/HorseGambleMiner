package Analyzer;


/**
 * Created by alex on 3/14/17.
 * this is the main entry and test file
 */
public class Main {
    public static void main(String args[]){
        Analyzer analyzer=new Analyzer();
        //just for test
        //area
        System.out.println(analyzer.analyzeLargerAreaOfHexagonData());
        System.out.println(analyzer.analyzeSmallerAreaOfHexagonData());
        //analyzer.displayWinnerAreas();
        //one focus
        for(int i=1;i<=6;i++){
            System.out.println(analyzer.analyzeFocusOnOneAttribute(i));
        }
        //two focus
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(j==i) continue;
                System.out.println(analyzer.analyzeFocusOnTwoAttributes(i,j));
            }
        }
        //num five
        System.out.println(analyzer.analyzeNumFiveOfHexagonData());
        //num more than three
        System.out.println(analyzer.analyzeNumMoreThanThreeOfHexagonData());
        //largest sum of attributes
        System.out.println(analyzer.analyzeLargerSumOfHexagonData());
        //smallest sum of attributes
        System.out.println(analyzer.analyzeSmallerSumOfHexagonData());
    }
}
