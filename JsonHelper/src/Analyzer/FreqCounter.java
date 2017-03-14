package Analyzer;

/**
 * Created by alex on 3/14/17.
 */
public class FreqCounter {

    private int count;
    private int hit;

    public FreqCounter() {
        count=0;
        hit=0;
    }

    public int getCount() {
        return count;
    }

    public int getHit() {
        return hit;
    }

    public void hit(){
        hit++;
        count++;
    }

    public void miss(){
        count++;
    }

    public double getFreq(){
        return hit/(count+0.0);
    }
}
