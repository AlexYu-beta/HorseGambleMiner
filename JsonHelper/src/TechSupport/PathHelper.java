package TechSupport;

import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 3/13/17.
 * a method class to support data process
 */
public class PathHelper {
    public String getDataPath(){
        File file=new File("");
        try {
            return file.getCanonicalPath()+"/data";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
