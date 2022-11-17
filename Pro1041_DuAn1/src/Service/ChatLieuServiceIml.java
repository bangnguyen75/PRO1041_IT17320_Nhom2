/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChatLieu;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface ChatLieuServiceIml {

    ArrayList<ChatLieu> getlist();

    void them(ChatLieu cL);

    void sua(ChatLieu cL, String id);

    void xoa(String id);

    ArrayList<ChatLieu> searchByTen(String tenCL);

    String checkTrungMa(String ma);
}
