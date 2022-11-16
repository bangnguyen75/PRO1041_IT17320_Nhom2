/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponritory.Impl;

import DomainModel.NhaCungCap;
import Reponritory.INhaCungCapReponritory;
import Utilities.Dbcontext;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BOSS
 */
public class NhaCungCapReponritory implements INhaCungCapReponritory {

    @Override
    public ArrayList<NhaCungCap> selectAll() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select * from NhaCungCap";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("MaNCC");
                String ten = rs.getString("TenNCC");
                String diaChi = rs.getString("DiaChi");
                NhaCungCap ncc = new NhaCungCap(id, ma, ten, diaChi);
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void them(NhaCungCap ncc) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "insert into NhaCungCap(MaNCC,TenNCC,DiaChi) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ncc.getMa());
            ps.setString(2, ncc.getTen());
            ps.setString(3, ncc.getDiaChi());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua(NhaCungCap ncc, String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "update NhaCungCap  set MaNCC = ?,TenNCC =?,DiaChi=? where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ncc.getMa());
            ps.setString(2, ncc.getTen());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "delete from NhaCungCap where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<NhaCungCap> timTheoTen(String tenncc) {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select  id ,MaNCC,DiaChi from NhaCungCap where TenNCC='" + tenncc + "' ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("MaNCC");

                String diaChi = rs.getString("DiaChi");
                NhaCungCap ncc = new NhaCungCap(id, ma, tenncc, diaChi);
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String checkTrungMa(String ma) {
        String maSearch = null;
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Select MaNCC from NhaCungCap where MaNCC = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String MaNCC = rs.getString("MaNCC");

                maSearch = MaNCC;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maSearch;
    }

}
