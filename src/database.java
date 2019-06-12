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
    public static void insert(String name, String gender, String id, String medical) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是qcl
        String url="jdbc:mysql://localhost:3306";
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
            String insertTable="INSERT INTO `users_info`.`table_name` (`name`, `gender`, `id`, `medicine`) VALUES ('" +name+
                    "', '" +gender+
                    "','" +id+
                    "', '" +medical+
                    "')";

            System.out.println(name+gender+id+medical);
            System.out.println(insertTable);
            statement.execute(insertTable);

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
}
