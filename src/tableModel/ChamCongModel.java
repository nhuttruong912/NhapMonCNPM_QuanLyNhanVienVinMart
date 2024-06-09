/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import Controller.CaLamControl;
import Controller.ChucVuControl;
import Controller.NhanVienControl;
import Model.ChamCong;
import Model.NhanVien;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ChamCongModel extends AbstractTableModel {

    private List<ChamCong> ds;
    String[] headers = {"Mã Công", "Nhân Viên", "Ca Làm", "Ngày Đăng Ký", "Ngày Làm", "Lương Ca", "Ghi Chú"};

    public ChamCongModel(List<ChamCong> ds) {
        super();
        this.ds = ds;
    }

    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ChamCong chamCong = ds.get(rowIndex);
        CaLamControl caLamControl = new CaLamControl();
        NhanVienControl nhanVienControl = new NhanVienControl();
        switch (columnIndex) {
            case 0:
                return chamCong.getMaCong();
            case 1:
                return nhanVienControl.GetNhanVienByMa(chamCong.getMaNV()).getHoNV() + " " +nhanVienControl.GetNhanVienByMa(chamCong.getMaNV()).getTenNV();
            case 2:
                return caLamControl.GetCaLamByMa(chamCong.getMaCa()).getTenCa();
            case 3:
                return chamCong.getNgayDangKy();
            case 4:
                return chamCong.getNgayLam();
            case 5:
                return chamCong.getLuongCa();
            case 6:
                return chamCong.getGhiChu();
            default:
                return chamCong;
        }
    }
}
