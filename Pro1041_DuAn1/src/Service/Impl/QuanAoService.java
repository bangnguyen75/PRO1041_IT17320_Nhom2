/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.QuanAo;
import Reponritory.IQuanAoRepository;
import Reponritory.Impl.QuanAoRepository;
import Service.IQuanAoService;
import java.util.List;

/**
 *
 * @author KIEN TRAN
 */
public class QuanAoService implements IQuanAoService {

    private IQuanAoRepository quanAoRepo;

    public QuanAoService() {
        quanAoRepo = new QuanAoRepository();
    }

    @Override
    public List<QuanAo> getAll() {
        try {
            return quanAoRepo.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer insert(QuanAo qa) {
        try {
            return quanAoRepo.insert(qa);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer update(QuanAo qa, String id) {
        try {
            return quanAoRepo.update(qa, id);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer delete(String id) {
        try {
            return quanAoRepo.delete(id);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public List<QuanAo> search(String ten) {
        try {
            return quanAoRepo.search(ten);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String checkMa(String ma) {
        try {
            return quanAoRepo.checkMa(ma);
        } catch (Exception e) {
            return null;
        }
    }

}
