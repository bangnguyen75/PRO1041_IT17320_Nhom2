/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainModel.MauSac;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface MauSacServiceIml {

    ArrayList<MauSac> getlist();

    void them(MauSac mS);

    void sua(MauSac mS, String id);

    void xoa(String id);

    ArrayList<MauSac> searchByTen(String TenMau);

    String checkTrungMa(String ma);
}
