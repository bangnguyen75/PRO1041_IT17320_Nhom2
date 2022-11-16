/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponritory.Impl;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Reponritory.INhanVienReponritory;

import Utilities.Dbcontext;
import ViewModel.IdcvViewModel;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author BOSS
 */
public class NhanVienReponritoty implements INhanVienReponritory {

    @Override
    public ArrayList<NhanVien> selectAll() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select * from NhanVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idStr = rs.getString("id");
                String maStr = rs.getString("ma");
                String hoTenStr = rs.getString("hoten");
                java.sql.Date ngaysinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diaChi");
                String email = rs.getString("email");
                String idcv = rs.getString("idcv");

                String idch = rs.getString("idch");
                NhanVien nv = new NhanVien(idStr, maStr, hoTenStr, ngaysinh, gioiTinh, sdt, diachi, email, idch, idcv);
                listNhanVien.add(nv);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNhanVien;

    }

    @Override
    public boolean them(NhanVien nv) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "insert into nhanvien(ma,hoten,ngaysinh,gioitinh,sdt,diachi,email,idch,idcv) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoten());
            ps.setDate(3, new java.sql.Date(nv.getNgaysinh().getTime()));
            ps.setString(4, nv.getGioitinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getEmail());
            ps.setString(8, null);
            ps.setString(9, null);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean xoa(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "delete from nhanvien where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sua(String id, NhanVien nv) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "update nhanvien set ma = ?,hoten = ?,ngaysinh=?,gioitinh=?,sdt=?,diachi=?,email=?,idch=?,idcv=? where id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoten());
            ps.setDate(3, new java.sql.Date(nv.getNgaysinh().getTime()));
            ps.setString(4, nv.getGioitinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getEmail());
            ps.setString(8, null);
            ps.setString(9, nv.getIdcv());
            ps.setString(10, id);

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public IdcvViewModel selectId(String ten) {
        IdcvViewModel  id = new IdcvViewModel();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select id from chucvu where ten = '"+ten+"'";
            PreparedStatement ps = conn .prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
        }

}
