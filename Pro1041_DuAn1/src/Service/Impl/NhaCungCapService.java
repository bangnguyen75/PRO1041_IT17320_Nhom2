/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NhaCungCap;
import Reponritory.INhaCungCapReponritory;
import Reponritory.Impl.NhaCungCapReponritory;
import Service.InhaCungCapService;
import Service.InhaCungCapService;

import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public class NhaCungCapService implements InhaCungCapService{
    private INhaCungCapReponritory nccr = new NhaCungCapReponritory();
public NhaCungCapService(){
    this.nccr=new NhaCungCapReponritory();
    }
    @Override
    public ArrayList<NhaCungCap> getList() {
         return this.nccr.selectAll();
    }

    @Override
    public void them(NhaCungCap ncc) {
 this.nccr.them(ncc);
    }

    @Override
    public void sua(NhaCungCap ncc, String id) {
      this.nccr.sua(ncc, id);
    }

    @Override
    public void xoa(String id) {
       this.nccr.xoa(id);
    }

    @Override
    public ArrayList<NhaCungCap> getlist(String TenNCC) {
   return this.nccr.timTheoTen(TenNCC);
    }

    @Override
    public String checkTrungMa(String ma) {
        return this.nccr.checkTrungMa(ma);
        
    }

 
    
}
