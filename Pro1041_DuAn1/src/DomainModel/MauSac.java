/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author ASUS
 */
public class MauSac {

    private String idMau;
    private String maMau;
    private String tenMau;

    public MauSac() {
    }

    public MauSac(String idMau, String maMau, String tenMau) {
        this.idMau = idMau;
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public String getIdMau() {
        return idMau;
    }

    public void setIdMau(String idMau) {
        this.idMau = idMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return tenMau;
    }

}
