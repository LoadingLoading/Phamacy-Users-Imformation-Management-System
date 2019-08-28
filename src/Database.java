import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qcl on 2017/11/18.
 * 数据库连接
 */
public class Database {
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
            if(executeType.equals("no_write")){
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
                //这里用了一个很笨拙的方法去输出，似乎是当时的原因是没有增加id的唯一性，所以可能有很多id存在的可能
                //但是当时没有记录，所以为了不引入新的未知bug，这里不作refacter，以后写临时方法的时候，应记录原因，以便以后refactor
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
                    i++;

                    //System.out.println("a1.7");
                    break;

                    //System.out.println("IDs身份证：" + IDs[i]);
                    //i++;
                }



                //System.out.println("a2");
                Infos=new String[1][18];
                if (i == 1) {

                    Infos[0]=InfosNoneExtended[0];
                }

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
                //System.out.println("a1");
                ResultSet resultSet = statement.executeQuery(executeIt);
                //System.out.println("a2");
                int i=0;

                String[][] InfosNoneExtended=new String[1000][18];
                while (resultSet.next()) {
                    //InfosNoneExtended[i][0]="0";
                            //resultSet.getString(0);

                    for(int columnIndex=0;columnIndex<8;columnIndex++){

                        System.out.println("InfosNoneExtended["+i+"]"+"["+columnIndex+"]的数据为"+resultSet.getString(columnIndex+1));
                        InfosNoneExtended[i][columnIndex]=
                                resultSet.getString(columnIndex+1);

                        //System.out.println("a5");
                    }
                    i++;
                    //System.out.println("a6");

                }
                //change Infos to return
                //System.out.println("a7");
                Infos=new String[i][8];
                for (int j = 0; j < i; j++) {
                    //System.out.println("a8");
                    Infos[j]=InfosNoneExtended[j];

                }
                //System.out.println("i为"+i);

                resultSet.close();
            }

            //end
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();

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
//        System.out.println(id+"所查询的结果之一："+Infos[0][3]);
        //Infos=[1][18] 有可能是null
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
        for(int i=1;i<insertInfo.length;i++){
            string_insertRecord=string_insertRecord+"'"+insertInfo[i]+"',";
        }
        string_insertRecord = string_insertRecord.substring(0,string_insertRecord.length() - 1);
        string_insertRecord = string_insertRecord+");";
        System.out.println("现在插入历史记录，语句为： "+string_insertRecord);
        execute(string_insertRecord,"insert");
    }

    public static void updateRecord(String[] updateInfo,int numbers){
        String string_updateRecord="UPDATE `users_info`.`table_record` t SET t.`id` = '" +
                updateInfo[1] +
                "', t.`year` = '" +
                updateInfo[2] +
                "', t.`month` = '" +
                updateInfo[3] +
                "', t.`day` = '" +
                updateInfo[4] +
                "', t.`times` = '" +
                updateInfo[5]+
                "', t.`noti_buy` = '" +
                updateInfo[6] +
                "', t.`record` = '" +
                updateInfo[7] +
                "' WHERE t.`numbers` = " +
                numbers+
                ";";
            System.out.println("现在更新历史记录，语句为： "+string_updateRecord);
            execute(string_updateRecord,"update");
    }

    public static String[][] searchRecord(String id){//this method will return a String[i][8]
        //0 is the new one, 1 is the first record of noti, 2 is the first record of buy
        String string_searchByID="SELECT * from table_record WHERE id='"+id+
                "';";
        System.out.println(string_searchByID);
        execute(string_searchByID,"searchByID_record");
        //System.out.println("searchRecord:"+id+"作为id的数据库的查询结果为: 长度为 Infos["+Infos.length+"]["+Infos[0].length+"]");
        return Infos;
    }
    public static void lock_unlock(String excute_sentence){

        execute(excute_sentence,"no_write");
    }

    public static void backup(String excute_sentence) {
        String tem_excute_sentence="mysqldump -u root -B -p users_info > /usr/local/backups";
        execute(tem_excute_sentence,"backup");
    }

    public static void recover(String excute_sentence) {
        execute(excute_sentence,"recover");
    }

//    public static void main(String[] args) {
//        backup("");
//    }


}
