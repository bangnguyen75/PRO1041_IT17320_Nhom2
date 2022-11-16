/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponritory.Impl;

import DomainModel.QuanAo;
import Reponritory.IQuanAoRepository;
import Utilities.Dbcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KIEN TRAN
 */
public class QuanAoRepository implements IQuanAoRepository {

    @Override
    public List<QuanAo> getAll() {
        List<QuanAo> listQuanAo = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Select Id,Ma,Ten,GiaNhap from QuanAo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                Float giaNhap = rs.getFloat("GiaNhap");

                QuanAo qa = new QuanAo(id, ma, ten, giaNhap);
                listQuanAo.add(qa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuanAo;
    }

    @Override
    public Integer insert(QuanAo qa) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Insert into QuanAo (Ma,Ten,GiaNhap) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qa.getMa());
            ps.setString(2, qa.getTen());
            ps.setFloat(3, qa.getGiaNhap());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer update(QuanAo qa, String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Update QuanAo set Ten = ?,GiaNhap = ? where Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qa.getTen());
            ps.setFloat(2, qa.getGiaNhap());
            ps.setString(3, id);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer delete(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Delete from QuanAo where Id  = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<QuanAo> search(String ten) {
        List<QuanAo> listQuanAo = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Select Id,Ma,Ten,GiaNhap from QuanAo where Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String tenSearch = rs.getString("Ten");
                Float giaNhap = rs.getFloat("GiaNhap");

                QuanAo qa = new QuanAo(id, ma, tenSearch, giaNhap);
                listQuanAo.add(qa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuanAo;
    }

    @Override
    public String checkMa(String ma) {
        String maTrung = null;
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "Select Ma from QuanAo where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maSearch = rs.getString("Ma");

                maTrung = maSearch;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maTrung;
    }

}
