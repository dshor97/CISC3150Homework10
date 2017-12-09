import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)throws Throwable {
        String myPlugin = new String("public abstract class myPlugin {\n" +
                "    public void whoSaysHello(){}\n" +
                "    public void whoSaysBye(){}\n" +
                "}");
        File plugin = new File("/Users/Student/IdeaProjects/CISC3150Homework10/plugin");
        File[] files = new File[0];
        if (plugin.isDirectory()) {
            files = plugin.listFiles();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Which plug in would you like to use:");
        for(int i = 0;i < files.length;i++){
            System.out.println("Press " + (i+1) + " for " + files[i]);
        }
        int numPick = input.nextInt();
        if(numPick > files.length || numPick <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        BufferedReader br = new BufferedReader(new FileReader(files[numPick-1]));
        String classStuff = new String();
        classStuff += myPlugin;
        String l = new String();

        while((l = br.readLine()) != null){
            classStuff += l;
        }


        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/Student/IdeaProjects/CISC3150Homework10/src/myPlugin.java"));
        bw.write(classStuff,0,classStuff.length());
        bw.flush();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, new File("/Users/Student/IdeaProjects/CISC3150Homework10/src/myPlugin.java").getAbsolutePath());

        //System.out.println(classStuff);


        Class cls = Class.forName(files[numPick-1].getName().replaceFirst(".java",""));
        System.out.println(cls);
        Object obj =  cls.newInstance();
        Method mtdHi = cls.getMethod("whoSaysHello");
        Method mtdBye = cls.getMethod("whoSaysBye");

        mtdHi.invoke(obj);
        mtdBye.invoke(obj);
    }
}