/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class NhanVienControl {
    private Connection con;

    public NhanVienControl() {
        con = MyConnection.getInstance().getConnection();
    }
    
    public List<NhanVien> GetList(){
        List<NhanVien> list = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Boolean gioiTinh;
                if (rs.getInt(4) == 0)
                    gioiTinh = false;
                else
                    gioiTinh = true;
                   
                NhanVien nhanVien = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),
                        gioiTinh, rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9),  rs.getString(10));
                list.add(nhanVien);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public NhanVien GetNhanVienByMa(String maNV){
        NhanVien nhanVien = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien Where MaNV = ?");
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Boolean gioiTinh;
                if (rs.getInt(4) == 0)
                    gioiTinh = false;
                else
                    gioiTinh = true;
                   
                nhanVien = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),
                        gioiTinh, rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9),  rs.getString(10));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return nhanVien;
    }
}
