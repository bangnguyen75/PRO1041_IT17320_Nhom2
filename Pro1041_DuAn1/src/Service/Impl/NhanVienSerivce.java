/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NhanVien;
import Reponritory.INhanVienReponritory;
import Reponritory.Impl.NhanVienReponritoty;
import Service.INhanVienSerivce;

import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public class NhanVienSerivce implements INhanVienSerivce{
 private INhanVienReponritory nvr = new NhanVienReponritoty();
 public NhanVienSerivce(){
     this.nvr = new NhanVienReponritoty();
 }
    @Override
    public ArrayList<NhanVien> getlist() {
       return this.nvr.selectAll();
    }

    @Override
    public String them(NhanVien nv) {
       if(this.nvr.them(nv)){
           return"thêm thành công";
       }else{
           return "xoá thành công";
       }
    }

    @Override
    public String xoa(String id) {
     if(this.nvr.xoa(id)){
         return "xoá thành công";
    }else {
         return "xoá thất bại";
         }
     }

    @Override
    public String sua(String id, NhanVien nv) {
        if(this.nvr.sua(id, nv)){
         return "sửathành công";
    }else {
         return "sửa thất bại";
         }
    }

    @Override
    public ArrayList<NhanVien> search(String ma) {
     return this.nvr.search(ma);
    }

    @Override
    public String checkMa(String ma) {
    return this.nvr.checkMa(ma);
    }

   

    

  
    
}
