/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChamCong;
import Model.NhanVien;
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
public class ChamCongControl {
    private Connection con;

    public ChamCongControl() {
        con = MyConnection.getInstance().getConnection();
    }
    
    public List<ChamCong> GetList(){
        List<ChamCong> list = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from ChamCong");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ChamCong chamCong = new ChamCong(rs.getString(1),rs.getDate(2),rs.getDate(3),
                        rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(chamCong);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addChamCong(ChamCong chamCong) {
        try {
            PreparedStatement cnAdd = con.prepareStatement("INSERT INTO ChamCong ([MaCong],[NgayDangKy],[NgayLam],[LuongCa],[MaNV]," +
                    "[MaCa],[GhiChu]) VALUES(?,?,?,?,?,?,?)");
            cnAdd.setString(1,chamCong.getMaCong());
            cnAdd.setDate(2, chamCong.getNgayDangKy());
            cnAdd.setDate(3,chamCong.getNgayLam());
            cnAdd.setFloat(4,chamCong.getLuongCa());
            cnAdd.setString(5,chamCong.getMaNV());
            cnAdd.setString(6,chamCong.getMaCa());
            cnAdd.setString(7, chamCong.getGhiChu());

            int n = cnAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
        public boolean deleteChamCong(String maCong) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete from ChamCong where Macong = ?");
            stmt.setString(1, maCong);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
        public boolean updateChamCong(ChamCong chamCong) {
        String sql = "update ChamCong set NgayDangKy = ?, NgayLam = ? , LuongCa = ?, MANV = ?, MaCa = ?, GhiChu = ? where MaCong = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, chamCong.getNgayDangKy());
            stmt.setDate(2,chamCong.getNgayLam());
            stmt.setFloat(3,chamCong.getLuongCa());
            stmt.setString(4,chamCong.getMaNV());
            stmt.setString(5,chamCong.getMaCa());
            stmt.setString(6, chamCong.getGhiChu());
            stmt.setString(7,chamCong.getMaCong());

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
