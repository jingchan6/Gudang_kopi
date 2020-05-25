/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.kopi;

/**
 *
 * @author Gilbert Wuaten
 */

import com.mysql.jdbc.Driver;
import java.sql.*;

public class dbSelect {
    public static Connection con; // drive connection
    public static Statement stm; // con.createStatement();
    public static ResultSet result;

public void driveConnection() throws SQLException {
// Data setup to Database
    String url = "jdbc:mysql://localhost:3306/gudang_kopi?zeroDateTimeBehavior=CONVERT_TO_NULL";// masukin sesuai nama DB lo
    String user = "root";
    String pass = "";

    if(con == null) { // menvoba buat koneksi ke DB
        new Driver();
        con = DriverManager.getConnection(url, user, pass);
    }
}

public  void main(String[] args) {
    try {
    driveConnection();
        stm = con.createStatement();
        result = stm.executeQuery("SELECT * FROM 'gudang"); // masukin SQL yang lo mau ini kalo Select,

// cara ini berlaku untuk select, tidak berlaku untuk insert update dan delete
        while(result.next()){
            System.out.println("Menampilakan Data pada tabel dengan Kolom Pertama : " + result.getString(1));
            System.out.println("Menampilakan Data pada tabel dengan Kolom Kedua : " + result.getString(2));
        }
    }catch(SQLException e){
    System.err.println("Pesan Error : " + e.getMessage());
        }
    }
    
}
