/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.kopi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Database {
    public static Connection conn;
    public static Statement stm;
    public static ResultSet rs;
    
    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/gudang_kopi","root","");
        stm = conn.createStatement();
    }
    
    public void transaksi(String id_item, String nama_item, int jumlah, String nama_gudang, Date tanggal, String keterangan) throws SQLException{
        String query = "INSERT INTO transaksi VALUES ('"+id_item+"', '"+nama_item+"', "+jumlah+", '"+nama_gudang+"'"+tanggal+", '"+keterangan+"');";
        stm.execute(query);
    }
    
    public ResultSet tampil(String sql) throws SQLException{
        rs = stm.executeQuery(sql);
        return rs;
    }
}
