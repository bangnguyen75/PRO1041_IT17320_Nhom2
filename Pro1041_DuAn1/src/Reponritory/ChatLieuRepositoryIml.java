/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponritory;

import DomainModel.ChatLieu;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface ChatLieuRepositoryIml {

    ArrayList<ChatLieu> selectAll();

    void them(ChatLieu cL);

    void sua(ChatLieu cL, String id);

    void xoa(String id);

    ArrayList<ChatLieu> timTheoTen(String tenCL);

    String checkMa(String ma);
}
