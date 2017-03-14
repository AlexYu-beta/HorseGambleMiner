package MatchGenerator;

import TechSupport.PathHelper;
import bean.Match;
import bean.Sukaima;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 3/13/17.
 */
public class MatchGenerator {

    static void generateMatch_Proxy(int matchNum,ArrayList<Sukaima> sukaimas){
        Match match=new Match(matchNum,sukaimas);
        PathHelper pathHelper =new PathHelper();
        String dataPath= pathHelper.getDataPath();
        File directory=new File(dataPath+"/"+matchNum);
        directory.mkdirs();
        String fileName="";
        File file=null;
        for(int i=0;i<sukaimas.size();i++){
            Sukaima sukaima=sukaimas.get(i);
            fileName=dataPath+"/"+matchNum+"/"+(i+1)+".json";
            sukaima.setRank(i+1);
            file=new File(fileName);
            try {
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream=new FileOutputStream(file,false);
                Gson gson=new Gson();
                String data=gson.toJson(sukaima);
                fileOutputStream.write(data.getBytes("utf-8"));
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    static void generateMatch_Predict(int matchNum,ArrayList<Sukaima> sukaimas){
        Match match=new Match(matchNum,sukaimas);
        PathHelper pathHelper =new PathHelper();
        String dataPath= pathHelper.getDataPath();
        File directory=new File(dataPath+"/"+matchNum);
        directory.mkdirs();
        String fileName="";
        File file=null;
        for(int i=0;i<sukaimas.size();i++){
            Sukaima sukaima=sukaimas.get(i);
            fileName=dataPath+"/"+matchNum+"/"+(i+1)+".json";
            file=new File(fileName);
            try {
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream=new FileOutputStream(file,false);
                Gson gson=new Gson();
                String data=gson.toJson(sukaima);
                fileOutputStream.write(data.getBytes("utf-8"));
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
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
                name=scanner.next();
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
