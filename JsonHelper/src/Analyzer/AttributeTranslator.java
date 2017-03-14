package Analyzer;

/**
 * Created by alex on 3/14/17.
 */
public class AttributeTranslator {

    public String translateAttribute(int attribute){
        switch(attribute){
            case 1:return "技巧";
            case 2:return "速度";
            case 3:return "韧性";
            case 4:return "饱食";
            case 5:return "心情";
            case 6:return "精力";
            default:return "";
        }
    }
}
