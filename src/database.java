import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qcl on 2017/11/18.
 * 数据库连接
 */
public class database {
    public static void execute(String executeIt) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是qcl
        String url="jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf8";
        String user="root";
        String password="123";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }

            Statement statement = con.createStatement();


            String enterDB = "use users_info;";//我的表格叫home
            statement.execute(enterDB);

//            String insertTable="INSERT INTO `users_info`.`table_name` (`name`, `gender`, `id`, `medicine`) VALUES ('1', 2, '3', 4)";


            //System.out.println(name+gender+id+medical);
            System.out.println(executeIt);
            statement.execute(executeIt);

//            String sql = "select * from table_name;";//我的表格叫home
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            String name;
//            while (resultSet.next()) {
//                name = resultSet.getString("name");
//                System.out.println("姓名：" + name);
//            }
//            resultSet.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }

    public static void insert(String name, String gender, String id, String owner1, String phone1, String owner2, String phone2, String owner3, String phone3, String medicine, String disease_type, String insurance_type, String address,String year, String month, String day) {

        String insertTable="INSERT INTO `users_info`.`table_name` (`name`, `gender`, `id`, `medicine`, `owner1`, `phone1`, `owner2`, `phone2`, `owner3`, `phone3`, `address`, `disease_type`, `insurance_type`,`year`,`month`,`day`) VALUES ('" +name+
                "', '" +gender+
                "','" +id+
                "', '" +owner1+
                "', '" +phone1+
                "','" +owner2+
                "', '" +phone2+
                "', '" +owner3+
                "','" +phone3+
                "', '" +medicine+
                "','" +disease_type+
                "', '" +insurance_type+
                "', '" +address+
                "','" +year+
                "', '" +month+
                "', '" +day+
                "');";
        execute(insertTable);
    }
}
