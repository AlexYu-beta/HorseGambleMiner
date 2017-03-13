package MatchGenerator;

import TechSupport.DataHelper;
import bean.Match;
import bean.Sukaima;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 3/13/17.
 */
public class MatchGenerator {

    static void generateMatch_Proxy(int matchNum,ArrayList<Sukaima> sukaimas){
        Match match=new Match(matchNum,sukaimas);
        DataHelper dataHelper=new DataHelper();
        String dataPath=dataHelper.getDataPath();

    }

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String ch;
        do{
            System.out.println("This is Module MatchGenerator, do you want to generate a match? (y/n)");
            ch=scanner.next();
        }while(!ch.equals("y")&&!ch.equals("n"));

        if(ch.equals("n")){
            System.exit(0);
        }else{
            int matchNum;
            String name;
            int skill;          //技巧
            int speed;          //速度
            int toughness;      //韧性
            int feed;           //饱食
            int mood;           //心情
            int vigour;         //精力
            Sukaima sukaima=null;
            ArrayList<Sukaima> sukaimas=new ArrayList<>();
            System.out.println("Please enter the match number:");
            matchNum=scanner.nextInt();
            System.out.println("Please enter the data of six sukaimas:");
            for(int i=0;i<6;i++){
                System.out.println("Please enter the name of sukaima No."+(i+1));
                name=scanner.nextLine();
                System.out.print("skill:");
                skill=scanner.nextInt();
                System.out.println();
                System.out.print("speed:");
                speed=scanner.nextInt();
                System.out.println();
                System.out.print("toughness:");
                toughness=scanner.nextInt();
                System.out.println();
                System.out.print("feed:");
                feed=scanner.nextInt();
                System.out.println();
                System.out.print("mood:");
                mood=scanner.nextInt();
                System.out.println();
                System.out.print("vigour:");
                vigour=scanner.nextInt();
                System.out.println();
                sukaima=new Sukaima(name,matchNum,skill,speed,toughness,feed,mood,vigour);
                sukaimas.add(sukaima);
            }
            generateMatch_Proxy(matchNum,sukaimas);
        }
    }
}
