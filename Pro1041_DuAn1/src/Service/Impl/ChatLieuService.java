/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChatLieu;
import Reponritory.Impl.ChatLieuRepository;
import Service.ChatLieuServiceIml;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ChatLieuService implements ChatLieuServiceIml {

    private ChatLieuRepository cLRepo;

    public ChatLieuService() {
        this.cLRepo = new ChatLieuRepository();
    }

    public ArrayList<ChatLieu> getlist() {
        return this.cLRepo.selectAll();
    }

    public void them(ChatLieu cL) {
        this.cLRepo.them(cL);
    }

    public void sua(ChatLieu cL, String id) {
        this.cLRepo.sua(cL, id);
    }

    public void xoa(String id) {
        this.cLRepo.xoa(id);
    }

    public ArrayList<ChatLieu> searchByTen(String tenCL) {
        return this.cLRepo.timTheoTen(tenCL);
    }

    public String checkTrungMa(String ma) {
        return this.cLRepo.checkMa(ma);
    }
}
