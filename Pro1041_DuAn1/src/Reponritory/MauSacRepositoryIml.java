/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponritory;

import DomainModel.MauSac;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface MauSacRepositoryIml {

    ArrayList<MauSac> selectAll();

    void them(MauSac mS);

    void sua(MauSac mS, String id);

    void xoa(String id);

    ArrayList<MauSac> timTheoTen(String TenMau);

    String checkMa(String ma);
}
