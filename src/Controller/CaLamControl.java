/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CaLam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CaLamControl {
    private Connection con;

    public CaLamControl() {
        con = MyConnection.getInstance().getConnection();
    }
    
    public List<CaLam> GetList(){
        List<CaLam> list = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from CA");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                CaLam calam = new CaLam(rs.getString(1),rs.getString(2),rs.getTime(3).toString(),rs.getTime(4).toString());
                list.add(calam);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
        public CaLam GetCaLamByMa(String maCa){
        CaLam caLam = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from CA Where MaCa = ?");
            stmt.setString(1, maCa);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                caLam = new CaLam(rs.getString(1),rs.getString(2),rs.getTime(3).toString(),rs.getTime(4).toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return caLam;
    }
}
