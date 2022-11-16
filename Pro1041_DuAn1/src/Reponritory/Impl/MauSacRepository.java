/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponritory.Impl;

import DomainModel.MauSac;
import Reponritory.MauSacRepositoryIml;
import java.sql.Connection;
import java.util.ArrayList;
import Utilities.Dbcontext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MauSacRepository implements MauSacRepositoryIml {

    public ArrayList<MauSac> selectAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            Connection conn = Utilities.Dbcontext.getConnection();
            String sql = "SELECT * FROM MAUSAC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idMau = rs.getString("id");
                String maMau = rs.getString("mamau");
                String tenMau = rs.getString("tenmau");
                MauSac mS = new MauSac(idMau, maMau, tenMau);
                list.add(mS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void them(MauSac mS) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "insert into MauSac(MaMau,TenMau) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, mS.getMaMau());
            ps.setString(2, mS.getTenMau());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sua(MauSac mS, String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "update MauSac  set TenMau =? where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, mS.getTenMau());
            ps.setString(2, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoa(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "delete from MauSac where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MauSac> timTheoTen(String tenMau) {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            Connection conn = Utilities.Dbcontext.getConnection();
            String sql = "select  id ,MaMau from MauSac where TenMau='" + tenMau + "' ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String maMau = rs.getString("MaMau");
                MauSac mS = new MauSac(id, maMau, tenMau);
                list.add(mS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String checkMa(String ma) {
        String maSearch = null;
        try {
            Connection conn = Utilities.Dbcontext.getConnection();
            String sql = "Select MaMau from MauSac where MaMau = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String MaMau = rs.getString("MaMau");

                maSearch = MaMau;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maSearch;
    }
}
