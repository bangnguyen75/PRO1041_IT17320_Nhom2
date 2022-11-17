/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.QuanAo;
import java.util.List;

/**
 *
 * @author KIEN TRAN
 */
public interface IQuanAoService {

    List<QuanAo> getAll();

    Integer insert(QuanAo qa);

    Integer update(QuanAo qa, String id);

    Integer delete(String id);

    List<QuanAo> search(String ten);

    String checkMa(String ma);
}
