package Model;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class DBModel {
    static private Connection conn;
    static private Statement myStmt;
    static private ResultSet myRs;
    static private String query;
    static private PreparedStatement pStmt;
    
    public static void main(String args[])throws Exception{
        DBModel x = new DBModel();
        //System.out.println(GenTransection_ID());
        //System.out.println(getrateCS_kmitl_Coin());
        //Insert();
        //getSW();
        //getAP();
        Scanner sc = new Scanner(System.in);
        
        boolean loops = true;
        while(loops){
            System.out.println("1 : โอนเงิน ");
            System.out.println("2 : ค้นหาหมายเลขธุรกรรมที่สำเร็จแล้วก่อนหน้า ");
            System.out.println("3 : ยืนยันการทำธุรกรรม ");
            System.out.println("4 : ออก ");
            System.out.print("กรุณาเลือกหมายเลข => "); 
            int choose = sc.nextInt();
            System.out.println();
            
        if(1 <= choose ||choose <=4){
                switch(choose){
                    case 1 : Insert();
                             System.out.println("Insert Success");
                             break;
                    case 2 : getSW();
                             System.out.println("Search Wallet");
                             break;
                    case 3 : getAP();
                             System.out.println("Approve Success");
                             break;
                    case 4 : loops = false;
                             break;   
                    default: System.out.println("Please Try Again\n");  
                               
                }
        }
    }
    }
    
    public DBModel(){
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("DB.properties"));
            
            String theuser = props.getProperty("user");
            String thepassword = props.getProperty("password");
            String thedburl = props.getProperty("dburl");
            
            System.out.println("Connection to database...");
            System.out.println("user = "+ theuser);
            System.out.println("password = "+ thepassword);
            
            
            conn = DriverManager.getConnection(thedburl ,theuser, thepassword);
            System.out.println("Connection Success");
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.println("unable to connection to database");
        }
    }
    
     public static void Insert() throws Exception{
         Scanner sc = new Scanner(System.in);
         String souce_wallet = sc.next();
         String destination_wallet = sc.next();
         Double quantity = sc.nextDouble();
         //rateCSkmitlCoin x = new rateCSkmitlCoin();
         double y = new rateCSkmitlCoin().getrateCS_kmitl_Coin();
         String state = "Awaiting";
         query = "INSERT INTO transaction_coin(id_transaction, souce_wallet, destination_wallet, quantity, rate, state) VALUE(?, ?, ?, ?, ?, ?);";
         pStmt = conn.prepareStatement(query);
         pStmt.setString(1, GenTransection_ID());
         pStmt.setString(2, souce_wallet);
         pStmt.setString(3, destination_wallet);
         pStmt.setDouble(4, quantity);
         pStmt.setDouble(5, y);
         pStmt.setString(6, state);
         pStmt.execute();
         pStmt.close();
     }
     
     public static ArrayList<Model_SearchWallet> getSW() throws Exception{
        ArrayList<Model_SearchWallet> SW_list = new ArrayList<>();
        Model_SearchWallet tempSW;
        String id_transaction, souce_wallet,destination_wallet;
        Double quantity,rate;
        String walletid = "12345";
        
        query = "SELECT * from kmitl_coin.transaction_coin WHERE souce_wallet = \""+walletid+"\";" ;
        
        myStmt = conn.createStatement();
        myRs = myStmt.executeQuery(query);
        while(myRs.next()){
            System.out.println(id_transaction = myRs.getString(1));
            System.out.println(souce_wallet = myRs.getString(2));
            System.out.println(destination_wallet = myRs.getString(3));
            System.out.println(quantity = myRs.getDouble(4));
            System.out.println(rate = myRs.getDouble(5));
            tempSW = new Model_SearchWallet(id_transaction, souce_wallet, destination_wallet, quantity, rate);
            SW_list.add(tempSW);
        }
        myStmt.close();
        myRs.close();
         System.out.println("Search Success");
        return SW_list;
        
        
    } 
     
    public static ArrayList<Model_SearchWallet> getAP() throws Exception{
        ArrayList<Model_SearchWallet> AP_list = new ArrayList<>();
        String walletid = "12345";
       
        query = "update kmitl_coin.transaction_coin SET state = \"Complete\" where souce_wallet = \""+walletid+"\"" ;
        myStmt = conn.createStatement();
        int myRs = myStmt.executeUpdate(query);
        myStmt.close();
         System.out.print("UPDATE Success");
        return AP_list;
    }
    
    
    public static String GenTransection_ID(){
        String Transection_id = "";
        String [] arr = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O"
                        ,"P","Q","R","S","T","U","V","X","Y","Z"};
        Random random = new Random();
        String s = String.valueOf(System.currentTimeMillis());
        int select1 = random.nextInt(arr.length);
        int select2 = random.nextInt(arr.length);
        Transection_id = arr[select1]+arr[select2]+s; 
        return Transection_id;
    }
    
    
}