import java.io.File;
import java.lang.reflect.Method;

public class Main{
    public static void main(String[] args)throws Throwable {
        File plugin = new File("/Users/Student/IdeaProjects/CISC3150Homework10/plugin");
        File[] files = new File[0];
        if (plugin.isDirectory()) {
            files = plugin.listFiles();
        }
        for(int i = 0;i < files.length;i++){
            System.out.println(files[i]);
        }
    }
}
