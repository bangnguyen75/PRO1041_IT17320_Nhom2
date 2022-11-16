/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponritory;

import DomainModel.NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public interface INhaCungCapReponritory {
    ArrayList<NhaCungCap> selectAll();
    void them(NhaCungCap ncc);
    void sua(NhaCungCap ncc,String id);
    void xoa(String id);
    ArrayList<NhaCungCap> timTheoTen(String TenNCC);
    String checkTrungMa(String ma);
}
