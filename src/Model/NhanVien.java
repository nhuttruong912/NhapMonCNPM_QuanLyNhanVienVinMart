/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author nhanh
 */
public class NhanVien {
    private String maNV;
    private String hoNV;
    private String tenNV;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String cccd;
    private String sdt;
    private String email;
    private String maCV;

    public NhanVien(String maNV, String hoNV, String tenNV, Boolean gioiTinh, Date ngaySinh, String diaChi, String cccd, String sdt, String email, String maCV) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.cccd = cccd;
        this.sdt = sdt;
        this.email = email;
        this.maCV = maCV;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }
    
    
}
