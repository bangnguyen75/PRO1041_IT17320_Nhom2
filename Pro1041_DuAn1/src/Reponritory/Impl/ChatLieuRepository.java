/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponritory.Impl;

import DomainModel.ChatLieu;
import Reponritory.ChatLieuRepositoryIml;
import Utilities.Dbcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ChatLieuRepository implements ChatLieuRepositoryIml {

    public ArrayList<ChatLieu> selectAll() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            Connection conn = Utilities.Dbcontext.getConnection();
            String sql = "SELECT * FROM CHATLIEU";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idCL = rs.getString("id");
                String maCL = rs.getString("ma");
                String tenCL = rs.getString("ten");
                ChatLieu cL = new ChatLieu(idCL, maCL, tenCL);
                list.add(cL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void them(ChatLieu cL) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "insert into ChatLieu(ma,ten) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cL.getMa());
            ps.setString(2, cL.getTen());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sua(ChatLieu cL, String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "update ChatLieu  set ten =? where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cL.getTen());
            ps.setString(2, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoa(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "delete from chatlieu where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ChatLieu> timTheoTen(String tenCL) {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            Connection conn = Utilities.Dbcontext.getConnection();
            String sql = "select  id ,ma from chatlieu where ten='" + tenCL + "' ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String macl = rs.getString("ma");
                ChatLieu cL = new ChatLieu(id, macl, tenCL);
                list.add(cL);
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
            String sql = "Select ma from chatlieu where ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String macl = rs.getString("ma");

                maSearch = macl;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maSearch;
    }
}
