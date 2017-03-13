package bean;

/**
 * Created by alex on 3/13/17.
 */
public class Sukaima {


    private String name;

    //match information
    private int matchNum;
    private int rank;

    //personal hexagon data
    private int skill;          //技巧
    private int speed;          //速度
    private int toughness;      //韧性
    private int feed;           //饱食
    private int mood;           //心情
    private int vigour;         //精力

    public Sukaima(String name, int matchNum, int skill, int speed, int toughness, int feed, int mood, int vigour) {
        this.name = name;
        this.matchNum = matchNum;
        this.skill = skill;
        this.speed = speed;
        this.toughness = toughness;
        this.feed = feed;
        this.mood = mood;
        this.vigour = vigour;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getRank() {
        return rank;
    }

    public int getSkill() {
        return skill;
    }

    public int getSpeed() {
        return speed;
    }

    public int getToughness() {
        return toughness;
    }

    public int getFeed() {
        return feed;
    }

    public int getMood() {
        return mood;
    }

    public int getVigour() {
        return vigour;
    }
}
