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
    static String[] IDs;//=new String[100];
    static String[][] Infos;
    public static void execute(String executeIt,String executeType) {
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
            if(executeType.equals("insert")){
                System.out.println(executeIt);
                statement.execute(executeIt);
            }
            if(executeType.equals("update")){
                System.out.println(executeIt);
                statement.execute(executeIt);
            }
            if(executeType.equals("searchByDate")){
                System.out.println(executeIt);
                ResultSet resultSet = statement.executeQuery(executeIt);
                String ids;
                int i=0;
                String[] IDsNoneExtended=new String[100];

                while (resultSet.next()) {

                    //IDs[i]=resultSet.getString("id");

                    //String[] IDs=new String[100];
                    IDsNoneExtended[i]=resultSet.getString("id");
                    //System.out.println("IDs身份证：" + IDs[i]);
                    i++;
                }
                IDs=new String[i];
                for(int j=0;j<i;j++){
                    IDs[j]=IDsNoneExtended[j];

                }
                resultSet.close();
                //statement.execute(executeIt);
            }

            if(executeType.equals("searchByID")){
                System.out.println(executeIt);
                ResultSet resultSet = statement.executeQuery(executeIt);
                //System.out.println("a0");
                //String ids;
                int i=0;
                String[][] InfosNoneExtended=new String[100][18];
               // System.out.println("a1");

                while (resultSet.next()) {
                    //System.out.println("a1.5");

                    //IDs[i]=resultSet.getString("id");

                    //String[] IDs=new String[100];
                    for(int columnIndex=1;columnIndex<19;columnIndex++){
                        //System.out.println("a1.6");
                        InfosNoneExtended[i][columnIndex-1]=
                                resultSet.getString(columnIndex);
                    }
                    //System.out.println("a1.7");
                    break;

                    //System.out.println("IDs身份证：" + IDs[i]);
                    //i++;
                }

                //System.out.println("a2");
                Infos=new String[1][18];
                Infos[0]=InfosNoneExtended[0];
//                for(int j=1;j<18;j++){
//                    Infos[j]=InfosNoneExtended[j];
//                    System.out.println(Infos[j]);
//
//                }
                //System.out.println("a3");
                resultSet.close();
                //statement.execute(executeIt);
            }


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

        String insertTable="INSERT INTO `users_info`.`table_name` (`name`, `gender`, `id`,  `owner1`, `phone1`, `owner2`, `phone2`, `owner3`, `phone3`, `medicine`, `disease_type`, `insurance_type`,`address`,`year`,`month`,`day`) VALUES ('" +name+
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
        execute(insertTable,"insert");
    }

    public static void update(String name, String gender, String id, String owner1, String phone1, String owner2, String phone2, String owner3, String phone3, String medicine, String disease_type, String insurance_type, String address,String year, String month, String day,String state) {

        String updateTable="UPDATE `users_info`.`table_name` SET `name`='" +name+
                "', `gender`='" +gender+
                "', `id`='" +id+
                "',  `owner1`='" +owner1+
                "', `phone1`='" +phone1+
                "', `owner2`='" +owner2+
                "', `phone2`='" +phone2+
                "', `owner3`='" +owner3+
                "', `phone3`='" +phone3+
                "', `medicine`='" +medicine+
                "', `disease_type`='" +disease_type+
                "', `insurance_type`='" +insurance_type+
                "',`address`='" +address+
                "',`year`='" +year+
                "',`month`='" +month+
                "',`day`='" +day+
                "',`state`='" +state+
                "' WHERE id ='" +id+
                "';";
        execute(updateTable,"update");
    }

    public static String[] searchByDate(String year, String month, String day){
        //IDs=null;
        String string_searchByDate="SELECT id from table_name WHERE year="+year+
                " and month= " +month+
                " and day =" +day+
                ";";
        //SELECT * from table_name WHERE year=1234 and month=12 and day=12;
        //execute(string_searchByDate);
        System.out.println(string_searchByDate);
        execute(string_searchByDate,"searchByDate");
        return IDs;
    }

    public static String[][] searchByID(String id){
        //IDs=null;
        String string_searchByID="SELECT * from table_name WHERE id='"+id+
                "';";
        //SELECT * from table_name WHERE year=1234 and month=12 and day=12;
        //execute(string_searchByDate);
        System.out.println(string_searchByID);
        execute(string_searchByID,"searchByID");
        System.out.println(id+"fanhuijieguo"+Infos[0][3]);
        return Infos;
    }
}
