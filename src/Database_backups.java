import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Database_backups {
    public static void useLinuxCommond(){
        try {
            Process p = Runtime.getRuntime().exec("mysqldump -u root -B -p users_info > /usr/local/backups/users_info_blank_ty.bak");  //调用Linux的相关命令
            p.waitFor();

            Process t = Runtime.getRuntime().exec("123");  //调用Linux的相关命令
            //Process a= Runtime.getRuntime().

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        useLinuxCommond();
    }
}
