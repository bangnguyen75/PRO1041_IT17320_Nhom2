/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponritory;

import DomainModel.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public interface IChucVuRepository {
    public ArrayList<ChucVu> selectAll();
    boolean them(ChucVu cv);
    String checkTrungMa(String ma);
    boolean sua(ChucVu cv,String id);
    boolean xoa(String id);
}
