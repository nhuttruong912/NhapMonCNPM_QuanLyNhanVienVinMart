/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class ChamCong {
    private String maCong;
    private Date ngayDangKy;
    private Date ngayLam;
    private float luongCa;
    private String maNV;
    private String maCa;
    private String ghiChu;

    public ChamCong() {
    }

    public ChamCong(String maCong, Date ngayDangKy, Date ngayLam, float luongCa, String maNV, String maCa, String ghiChu) {
        this.maCong = maCong;
        this.ngayDangKy = ngayDangKy;
        this.ngayLam = ngayLam;
        this.luongCa = luongCa;
        this.maNV = maNV;
        this.maCa = maCa;
        this.ghiChu = ghiChu;
    }

    public String getMaCong() {
        return maCong;
    }

    public void setMaCong(String maCong) {
        this.maCong = maCong;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

    public float getLuongCa() {
        return luongCa;
    }

    public void setLuongCa(float luongCa) {
        this.luongCa = luongCa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
