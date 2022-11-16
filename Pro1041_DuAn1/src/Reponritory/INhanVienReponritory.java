/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponritory;

import DomainModel.NhanVien;
import ViewModel.IdcvViewModel;
import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public interface INhanVienReponritory {
    ArrayList<NhanVien> selectAll();
    boolean them(NhanVien nv);
    boolean xoa (String id);
    boolean sua(String id,NhanVien nv);
    ArrayList<NhanVien> search(String ten);
    String checkMa(String ma);
}
