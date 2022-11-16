/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public interface InhaCungCapService {
    ArrayList<NhaCungCap> getList();
      void them(NhaCungCap ncc) ;
      void sua(NhaCungCap ncc, String id);
      void xoa(String id);
      ArrayList<NhaCungCap> getlist(String TenNCC);
      String checkTrungMa(String ma);
    
}
