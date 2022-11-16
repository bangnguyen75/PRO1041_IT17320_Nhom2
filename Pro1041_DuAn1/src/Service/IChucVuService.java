/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import java.util.ArrayList;
import javax.print.DocFlavor;

/**
 *
 * @author BOSS
 */
public interface IChucVuService {
    ArrayList<ChucVu> getlist();
    String add(ChucVu cv);
    String checkMa(String ma);
    String sua(ChucVu cv , String id);
    String xoa(String id);
    
}
