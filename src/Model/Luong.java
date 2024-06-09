/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nhanh
 */
public class Luong {

    private String MALUONG;
    private Double LUONGCOBAN;
    private String MOTA;
    
    public Luong(){}
    public Luong(String MALUONG, Double LUONGCOBAN, String MOTA) {
        this.MALUONG = MALUONG;
        this.LUONGCOBAN = LUONGCOBAN;
        this.MOTA = MOTA;
    }

    public String getMALUONG() {
        return MALUONG;
    }

    public void setMALUONG(String MALUONG) {
        this.MALUONG = MALUONG;
    }

    public Double getLUONGCOBAN() {
        return LUONGCOBAN;
    }

    public void setLUONGCOBAN(Double LUONGCOBAN) {
        this.LUONGCOBAN = LUONGCOBAN;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }
    
    	
        
        
    
}
