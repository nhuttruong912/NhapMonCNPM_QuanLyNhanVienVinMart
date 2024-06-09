/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CaLam;
import Model.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ChucVuControl {
        private Connection con;

    public ChucVuControl() {
        con = MyConnection.getInstance().getConnection();
    }
    
    public ChucVu GetChucVuByMa(String maCV){
        ChucVu chucVu = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from ChucVu Where MaCV = ?");
            stmt.setString(1, maCV);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                chucVu = new ChucVu(rs.getString(1),rs.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return chucVu;
    }
}
