/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChucVu;

import Reponritory.IChucVuRepository;

import Reponritory.Impl.ChucVuReponritory;
import Service.IChucVuService;

import java.util.ArrayList;

/**
 *
 * @author BOSS
 */
public class ChucVuService implements IChucVuService {

    private IChucVuRepository cvr = new ChucVuReponritory();

    public ChucVuService() {
        this.cvr = new ChucVuReponritory();
    }

    @Override
    public ArrayList<ChucVu> getlist() {
        return this.cvr.selectAll();
    }

    @Override
    public String add(ChucVu cv) {
        if (cvr.them(cv)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String checkMa(String ma) {
        return this.cvr.checkTrungMa(ma);
    }

    @Override
    public String sua(ChucVu cv, String id) {
        if (cvr.sua(cv, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String xoa(String id) {
        if (cvr.xoa(id)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

}
