/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

/**
 *
 * @author LENOVO
 */

import Controller.ChucVuControl;
import Model.NhanVien;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NhanVienModel extends AbstractTableModel {

    private List<NhanVien> ds;
    String[] headers = {"Mã NV", "Họ Tên", "Giới Tính", "Chức Vụ", "SĐT"};

    public NhanVienModel(List<NhanVien> ds) {
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
        NhanVien nhanVien = ds.get(rowIndex);
        ChucVuControl chucVuControl = new ChucVuControl();
        switch (columnIndex) {
            case 0:
                return nhanVien.getMaNV();
            case 1:
                return nhanVien.getHoNV() + " " +nhanVien.getTenNV();
            case 2:
                if (nhanVien.getGioiTinh())
                    return "Nam";
                return "Nữ";
            case 3:
                return chucVuControl.GetChucVuByMa(nhanVien.getMaCV()).getTENCV();
            case 4:
                return nhanVien.getSdt();
            default:
                return nhanVien;
        }
    }
}

