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
        System.out.println("操作语句为："+executeIt+" 操作类型为："+executeType);

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
                statement.execute(executeIt);
            }
            if(executeType.equals("update")){
                statement.execute(executeIt);
            }
            if(executeType.equals("searchByDate")){
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

            if(executeType.equals("searchByState")){
                ResultSet resultSet = statement.executeQuery(executeIt);

                int i=0;
                String[][] InfosNoneExtended=new String[100][18];
                while (resultSet.next()) {
                    for(int columnIndex=1;columnIndex<19;columnIndex++){
                        //System.out.println("a1.6");
                        InfosNoneExtended[i][columnIndex-1]=
                                resultSet.getString(columnIndex);
                    }
                    i++;
                }
                Infos=new String[i][18];
                for(int j=0;j<i;j++){
                    Infos[j]=InfosNoneExtended[j];
                }
                resultSet.close();
            }

            if(executeType.equals("searchByID_record")){
                ResultSet resultSet = statement.executeQuery(executeIt);
                int i=0;
                String[][] InfosNoneExtended=new String[1000][18];
                while (resultSet.next()) {

                    for(int columnIndex=0;columnIndex<8;columnIndex++){
                        InfosNoneExtended[i][columnIndex]=
                                resultSet.getString(columnIndex);
                        i++;
                    }

                }
                //change Infos to return
                Infos=new String[i][8];
                for (int j = 0; j < i; j++) {
                    Infos[j]=InfosNoneExtended[j];

                }
                resultSet.close();
            }

            //end
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
        System.out.println(id+"所查询的结果之一："+Infos[0][3]);
        return Infos;
    }

    public static String[][] searchByState(String state){
        String string_searchByState="SELECT * from table_name WHERE state='"+state+
                "';";
        execute(string_searchByState,"searchByState");
        return Infos;
    }

    public static void insertRecord(String[] insertInfo){
        String string_insertRecord="INSERT INTO `users_info`.`table_record` (`id`, `year`, `month`, `day`, `times`, `noti_buy`, `record`) VALUES (";
        for(int i=0;i<insertInfo.length;i++){
            string_insertRecord=string_insertRecord+"'"+insertInfo[i]+"',";
        }
        string_insertRecord = string_insertRecord.substring(0,string_insertRecord.length() - 1);
        string_insertRecord = string_insertRecord+");";
        System.out.println("现在插入历史记录，语句为： "+string_insertRecord);
        execute(string_insertRecord,"insert");
    }

    public static void updateRecord(String[] updateInfo,int numbers){
        String string_updateRecord="UPDATE `users_info`.`table_record` t SET t.`id` = '" +
                updateInfo[0] +
                "', t.`year` = '" +
                updateInfo[1] +
                "', t.`month` = '" +
                updateInfo[2] +
                "', t.`day` = '" +
                updateInfo[3] +
                "', t.`times` = '" +
                updateInfo[4]+
                "', t.`noti_buy` = '" +
                updateInfo[5] +
                "', t.`record` = '" +
                updateInfo[6] +
                "' WHERE t.`numbers` = " +
                numbers+
                ";";
            System.out.println("现在更新历史记录，语句为： "+string_updateRecord);
            execute(string_updateRecord,"update");
    }

    public static String[][] searchRecord(String id){
        String string_searchByID="SELECT * from table_record WHERE id='"+id+
                "';";
        System.out.println(string_searchByID);
        execute(string_searchByID,"searchByID_record");
        System.out.println(id+"作为id的数据库的查询结果为： "+Infos[0][3]);
        return Infos;
    }

}
