package com.layouts;

import java.util.Scanner;
import com.controller.DatabaseController;

public class InsertData {
    public static void showInsertData(){
        try {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("====================================");
            System.out.println("       INPUT DATA DI BAWAH INI");
            System.out.println("====================================");
            System.out.println("NAMA");
            String name = sc.nextLine();
            System.out.println("HARGA");
            long harga = sc.nextInt();
            System.out.println("STOK");
            int stok = sc.nextInt();
            System.out.println("====================================");
            if (DatabaseController.insertDB(name, harga, stok)) {
                System.out.println("DATA TELAH DIPERBARUI");
            }else{
                System.out.println("GAGAL MENAMBAHKAN DATA");
            }
            System.out.println("------------------------------------");
            Menu.tampilkanMenu();
            sc.close();
        
        } catch (Exception e) {
            InsertData.showInsertData();
        }
    }
}