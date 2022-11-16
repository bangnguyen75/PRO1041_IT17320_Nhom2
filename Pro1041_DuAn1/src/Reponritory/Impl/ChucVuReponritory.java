/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponritory.Impl;

import DomainModel.ChucVu;
import Reponritory.IChucVuRepository;
import Service.IChucVuService;
import Utilities.Dbcontext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author BOSS
 */
public class ChucVuReponritory implements  IChucVuRepository{

    @Override
    public ArrayList<ChucVu> selectAll() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select * from ChucVu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                ChucVu cv = new ChucVu(id, ma, ten);
                list.add(cv);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean them(ChucVu cv) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "insert into chucvu (ma,ten) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("K thêm đuọc");
            return false;
        }

    }

    @Override
    public String checkTrungMa(String ma) {
        String maSearch = null;
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "select Ma from Chucvu where ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String Ma = rs.getString("ma");
                Ma = maSearch;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maSearch;
    }

    @Override
    public boolean sua(ChucVu cv, String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "update ChucVu set ma = ? , ten = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.setString(3, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sửa thất bại");
            return false;

        }
    }

    @Override
    public boolean xoa(String id) {
        try {
            Connection conn = Dbcontext.getConnection();
            String sql = "delete from chucvu where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("xoa thất bại");
            return false;

        }
    }

  

}
