/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class CaLam {
    private String maCa;
    private String tenCa;
    private String thoiGianVao;
    private String thoiGianRa;

    public CaLam() {
    }

    public CaLam(String maCa, String tenCa, String thoiGianVao, String thoiGianRa) {
        this.maCa = maCa;
        this.tenCa = tenCa;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public String getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(String thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public String getThoiGianRa() {
        return thoiGianRa;
    }

    public void setThoiGianRa(String thoiGianRa) {
        this.thoiGianRa = thoiGianRa;
    }
    
    
}
