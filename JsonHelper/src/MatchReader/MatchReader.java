package MatchReader;

import TechSupport.PathHelper;
import bean.Match;
import bean.Sukaima;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by alex on 3/14/17.
 */
public class MatchReader {

    public int getMatchNum(){
        PathHelper pathHelper=new PathHelper();
        String dataPath=pathHelper.getDataPath();
        File dataDirectory=new File(dataPath);
        File[] files=dataDirectory.listFiles();
        return files.length;
    }


    public Match readMatch(int matchNum){
        PathHelper pathHelper=new PathHelper();
        String path=pathHelper.getDataPath();
        String tempFile="";
        path=path+"/"+matchNum+"/";
        ArrayList<Sukaima> sukaimas=new ArrayList<>();
        Sukaima sukaima=null;
        for(int i=1;i<=6;i++){
            tempFile=path+i+".json";
            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader(tempFile));
                String line;
                String input="";
                while((line=bufferedReader.readLine())!=null){
                    input=input+line;
                }
                Gson gson=new Gson();
                sukaima=gson.fromJson(input,Sukaima.class);
                sukaimas.add(sukaima);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //create a match object
        Match match=new Match(matchNum,sukaimas);
        return match;
    }
}
