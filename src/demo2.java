import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class demo2 {
    private static String PATH = "demo1.txt";
    private static File file;
    public static boolean check_new(){
        file = new File(PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }
//    public static void main(String[] args) throws IOException {
//        Student stu = new Student(1,"张三",90);
//        writeDataToFile(file,stu);
//        readDataFromFile(file);
//    }
//    private static void readDataFromFile(File file) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        String str = "";
//        while((str = reader.readLine())!=null){
//            String[] stuInfo = str.split("@");
//            System.out.println("学号："+stuInfo[0]+" 姓名："+stuInfo[1]+" score："+stuInfo[2]);
//        }
//    }
//    private static void writeDataToFile(File file,Student stu) throws FileNotFoundException {
//        PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
//        out.println(stu.toString());
//        out.close();
//    }
}
//class Student{
//    int stuNo;
//    String name;
//    int score;
//    public Student() {
//// TODO Auto-generated constructor stub
//    }
//    public Student(int stuNo, String name, int score) {
//        super();
//        this.stuNo = stuNo;
//        this.name = name;
//        this.score = score;
//    }
//    public int getStuNo() {
//        return stuNo;
//    }
//    public void setStuNo(int stuNo) {
//        this.stuNo = stuNo;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getScore() {
//        return score;
//    }
//    public void setScore(int score) {
//        this.score = score;
//    }
//    @Override
//    public String toString() {
//        return this.stuNo+"@"+this.name+"@"+this.score;
//    }
//}