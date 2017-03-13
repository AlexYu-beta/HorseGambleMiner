package TechSupport;

import com.google.gson.Gson;

import java.io.*;

/**
 * Created by alex on 3/12/17.
 * This tests the ability to read (maybe write) Json file by gson
 */
class Student{

    private String name;
    private int age;
    private boolean sex;            //true for male, false for female


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
public class JsonTest {

    static void writeJsonTest(){
        Student student=new Student();
        student.setName("Alex");
        student.setAge(21);
        student.setSex(true);
        Gson gson=new Gson();
        String json=gson.toJson(student);
        System.out.println(json);
    }

    static void readJsonTest(){
        File file=new File("");
        String path= null;
        try {
            path = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        path=path+"/test/JsonTestInputFile.json";
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
            String line;
            String input="";
            while((line=bufferedReader.readLine())!=null){
                input=input+line;
            }
            Gson gson=new Gson();
            Student student=gson.fromJson(input,Student.class);
            System.out.println(student.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        writeJsonTest();
        readJsonTest();
    }
}
