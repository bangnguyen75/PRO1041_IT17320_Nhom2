/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;

import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public interface INhanVienSerivce {

    ArrayList<NhanVien> getlist();

    String them(NhanVien nv);

    String xoa(String id);

    String sua(String id, NhanVien nv);

    ArrayList<NhanVien> search(String ma);

    String checkMa(String ma);

}
