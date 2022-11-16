/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Reponritory.Impl.MauSacRepository;
import Service.MauSacServiceIml;
import DomainModel.MauSac;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class MauSacService implements MauSacServiceIml {

    private MauSacRepository mSRepo;

    public MauSacService() {
        this.mSRepo = new MauSacRepository();
    }

    public ArrayList<MauSac> getlist() {
        return this.mSRepo.selectAll();
    }

    public void them(MauSac mS) {
        this.mSRepo.them(mS);
    }

    public void sua(MauSac mS, String id) {
        this.mSRepo.sua(mS, id);
    }

    public void xoa(String id) {
        this.mSRepo.xoa(id);
    }

    public ArrayList<MauSac> searchByTen(String TenMau) {
        return this.mSRepo.timTheoTen(TenMau);
    }

    public String checkTrungMa(String ma) {
        return this.mSRepo.checkMa(ma);
    }
}
