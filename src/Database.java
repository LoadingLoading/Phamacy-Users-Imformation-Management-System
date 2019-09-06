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
        System.out.println("mysql的操作语句为："+executeIt+" 操作类型为："+executeType);
        Connection con;
        String driver="com.mysql.jdbc.Driver";
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
            String enterDB = "use users_info;";
            statement.execute(enterDB);

            if(executeType.equals("insert")){
                statement.execute(executeIt);
            } else if(executeType.equals("update")){
                statement.execute(executeIt);
            } else if(executeType.equals("no_write")){
                statement.execute(executeIt);
            } else{
                //(executeType.equals("searchByDate") ||executeType.equals("searchByID") ||executeType.equals("searchByState") ||executeType.equals("searchByID_record")){//返回的是IDs[] 一维数组
                int dimension2=0;
                if(executeType.equals("searchByDate")){
                    dimension2=18;
                } else if(executeType.equals("searchByID")){
                    dimension2=18;
                } else if(executeType.equals("searchByState")){
                    dimension2=18;
                } else if(executeType.equals("searchByType_choice")){
                    dimension2=3;
                } else if(executeType.equals("searchByID_record")){
                    dimension2=8;
                }else if(executeType.equals("searchByAll")){
                    dimension2=18;
                }

                /**
                 dimentsion2 是需要返回的结果的长度，如果是搜索table_name那么就是18
                 如果是要搜索table_record 那么就是18
                 start_index是开始的长度，因为搜索table_name一开始的code把数据库里的index取消了，所以不需要第0个

                 返回的时候
                 searchByDate就返回id就可以了
                 searchByID就返回该id的18个信息就可以了
                 searchByState返回全部信息
                 searchByID_record返回全部信息

                 Database.insert(name, gender, ID, owner, phone, owner1, phone1, owner2, phone2, medical, disease_type, insurance_type, address, year, month, day);

                 table_name
                 0 number | 1 name | 2 gender | 3 id  | 4 owner1 | 5 phone1 | 6 owner2 | 7 phone2
                 | 8 owner3 | 9 phone3| 10 medicine   | 11 disease_type | 12 insurance_type | 13 address
                 | 14 year | 15 month | 16 day| 17 state |

                 table_record
                 0 numbers | 1 id | 2 year | 3 month | 4 day  | 5 times | 6 noti_buy | 7 record

                 table_choice
                 0 number | 1 type | 2 choice

                 choices:




                 */
                ResultSet resultSet = statement.executeQuery(executeIt);
                int i=0;
                String[][] InfosNoneExtended=new String[1000][dimension2];
                while (resultSet.next()) {
                    for(int columnIndex=0;columnIndex<dimension2;columnIndex++){
                        //System.out.println("a1.6");
                        InfosNoneExtended[i][columnIndex]= resultSet.getString(columnIndex+1);
                    }
                    i++;
                }
                Infos=new String[i][dimension2];
                for(int j=0;j<i;j++){
                    Infos[j]=InfosNoneExtended[j];
                }
                resultSet.close();













//                ResultSet resultSet = statement.executeQuery(executeIt);
//                String ids;
//                int i=0;
//                String[] IDsNoneExtended=new String[100];
//                while (resultSet.next()) {
//                    IDsNoneExtended[i]=resultSet.getString("id");
//                    i++;
//                }
//                IDs=new String[i];
//                for(int j=0;j<i;j++){
//                    IDs[j]=IDsNoneExtended[j];
//                }
//                resultSet.close();
            }
//            if(executeType.equals("searchByID")){//返回的是Infos[1][n] 二位数组，但实际上相当于一位数组
//                //之所以这样是因为统一使用Info[][]来返回数据，所以当数据是一维的时候，就用[1][]来返回
//                //这里用了一个很笨拙的方法去输出，似乎是当时的原因是没有增加id的唯一性，所以可能有很多id存在的可能
//                //但是当时没有记录，所以为了不引入新的未知bug，这里不作refacter，以后写临时方法的时候，应记录原因，以便以后refactor
//                ResultSet resultSet = statement.executeQuery(executeIt);
//                int i=0;
//                String[][] InfosNoneExtended=new String[100][18];
//                while (resultSet.next()) {
//                    for(int columnIndex=0;columnIndex<18;columnIndex++){
//                        InfosNoneExtended[i][columnIndex]=
//                                resultSet.getString(columnIndex+1);
//                    }
//                    i++;
//                    break;
//                }
//                Infos=new String[1][18];
//                if (i == 1) {
//                    Infos[0]=InfosNoneExtended[0];
//                }
//                resultSet.close();
//            }
//            if(executeType.equals("searchByState")){//返回的是Infos[]二维数组
//                ResultSet resultSet = statement.executeQuery(executeIt);
//                int i=0;
//                String[][] InfosNoneExtended=new String[100][18];
//                while (resultSet.next()) {
//                    for(int columnIndex=1;columnIndex<19;columnIndex++){
//                        //System.out.println("a1.6");
//                        InfosNoneExtended[i][columnIndex-1]=
//                                resultSet.getString(columnIndex);
//                    }
//                    i++;
//                }
//                Infos=new String[i][18];
//                for(int j=0;j<i;j++){
//                    Infos[j]=InfosNoneExtended[j];
//                }
//                resultSet.close();
//            }
//
//            if(executeType.equals("searchByID_record")){//返回的是Infos[]二维数组
//                ResultSet resultSet = statement.executeQuery(executeIt);
//                int i=0;
//                String[][] InfosNoneExtended=new String[1000][18];
//                while (resultSet.next()) {
//                    for(int columnIndex=0;columnIndex<8;columnIndex++){
//                        System.out.println("InfosNoneExtended["+i+"]"+"["+columnIndex+"]的数据为"+resultSet.getString(columnIndex+1));
//                        InfosNoneExtended[i][columnIndex]=
//                                resultSet.getString(columnIndex+1);
//                    }
//                    i++;
//                }
//                Infos=new String[i][8];
//                for (int j = 0; j < i; j++) {
//                    Infos[j]=InfosNoneExtended[j];
//                }
//                resultSet.close();
//            }

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
        String string_searchByDate="SELECT * from table_name WHERE year="+year+
                " and month= " +month+
                " and day =" +day+
                ";";
        System.out.println(string_searchByDate);
        execute(string_searchByDate,"searchByDate");
        String[] IDs=new String[Infos.length];
        for (int i = 0; i <Infos.length ; i++) {
            IDs[i]=Infos[i][3];
        }
        return IDs;
    }

    public static String[][] searchByID(String id){
        String string_searchByID="SELECT * from table_name WHERE id='"+id+ "';";
        System.out.println(string_searchByID);
        execute(string_searchByID,"searchByID");

        return Infos;
    }

    public static String[][] searchByState(String state){
        String string_searchByState="SELECT * from table_name WHERE state='"+state+ "';";
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
        String string_searchByID="SELECT * from table_record WHERE id='"+id+ "';";
        System.out.println(string_searchByID);
        execute(string_searchByID,"searchByID_record");
        //System.out.println("searchRecord:"+id+"作为id的数据库的查询结果为: 长度为 Infos["+Infos.length+"]["+Infos[0].length+"]");
        return Infos;
    }

    public static String[] serachChoice(String choice_type) {
        String string_searchByType="SELECT * from table_choice WHERE type='"+choice_type+ "';";
        System.out.println("即将执行的mysql语句"+string_searchByType);
        execute(string_searchByType,"searchByType_choice");
        String[] Choices=new String[Infos.length];
        for (int i = 0; i <Infos.length ; i++) {
            Choices[i]=Infos[i][2];
        }
        return Choices;
    }

    public static void insertChoice(String type,String choice) {
        String insertTable="INSERT INTO `users_info`.`table_choice` (`type`,`choice`) VALUES ('" +type+
                "', '" +choice+
                "');";
        execute(insertTable,"insert");
    }

    public static String[][] searchByAll(String all[]){
        /**
         *
         *
         *                     search_infos[0]=name;
         *                     search_infos[1]=gender;
         *                     search_infos[2]=ID;
         *                     search_infos[3]=phone;
         *                     search_infos[4]=medical;
         *                     search_infos[5]=disease_type;
         *                     search_infos[6]=insurance_type;
         *                     search_infos[7]=address;
         */
        String[] table_title=new String[8];
        table_title[0]="name";
        table_title[1]="gender";
        table_title[2]="ID";
        table_title[3]="phone";
        table_title[4]="medicine";
        table_title[5]="disease_type";
        table_title[6]="insurance_type";
        table_title[7]="address";



        String string_searchByAll="SELECT * from table_name WHERE ";

        for (int i = 0; i <8 ; i++) {
            if (all[i] != null) {
                if (!all[i].equals("")) {//每个飞空的都要搜搜
                    string_searchByAll += table_title[i];
                    if (i == 0 || i == 7) {//姓名和电话为模糊搜索
                        string_searchByAll += " LIKE '%" + all[i] + "%'";
                    } else if (i == 2 && all[i].length() != 18) {//ID的两种搜索设置,18位的为普通搜索
                        int thisYear = MainWindow_Labels.getTodayDate()[0];//得到现在的年份
                        if (all[i].length() == 2) {//两位数搜索特定年份
                            String birthYear = (thisYear - Integer.parseInt(all[i])) + "";
                            string_searchByAll += " LIKE '______" + birthYear + "________' ";
                        } else if (all[i].length() == 4) {//四位数搜索范围年份
                            string_searchByAll = string_searchByAll.substring(0, string_searchByAll.length() - 2) + "(";
                            String birthYear_begin = (thisYear - Integer.parseInt(all[i].substring(2, 4))) + "";
                            String birthYear_end = (thisYear - Integer.parseInt(all[i].substring(0, 2))) + "";
                            for (int each_year = Integer.parseInt(birthYear_begin); each_year < Integer.parseInt(birthYear_end) + 1; each_year++) {//把每一年的用or和()框起来
                                string_searchByAll += " id LIKE '______" + each_year + "________' OR ";
                            }
                            string_searchByAll = string_searchByAll.substring(0, string_searchByAll.length() - 3) + ")";
                        }
                    } else if (i == 3) {//三个归属人的手机号都要搜索一下
                        string_searchByAll = string_searchByAll.substring(0, string_searchByAll.length() - 5) + "(";
                        for (int j = 0; j < 3; j++) {//用or和()框起来
                            String String_phone = "phone" + (j + 1);
                            string_searchByAll += " " + String_phone + " LIKE '%" + all[i] + "%' OR ";
                        }
                        string_searchByAll = string_searchByAll.substring(0, string_searchByAll.length() - 3) + ")";

                    } else {//普通的搜索
                        string_searchByAll += " = '" + all[i] + "'";
                    }
                    string_searchByAll = string_searchByAll + " AND   ";
                }
            }

        }
        string_searchByAll = string_searchByAll.substring(0,string_searchByAll.length() - 6);//把最后的and去掉
        string_searchByAll += ";";
        System.out.println(string_searchByAll);
        execute(string_searchByAll,"searchByAll");
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

    public static void main(String[] args) {
        String[] a=new String[8];
        for (int i = 0; i <8 ; i++) {
            a[i]="";
        }
        //a[2]="2222";
        //a[3]="13787573871";
        String[][] b=searchByAll(a);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i][1]);
            }
        }else{
            System.out.println("无结果");
        }

        //backup("");
    }


}
