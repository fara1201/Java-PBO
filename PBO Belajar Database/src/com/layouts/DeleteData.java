package com.layouts;

import java.util.Scanner;
import com.controller.DatabaseController;

public class DeleteData {
    public static void showDeleteData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("PILIH DATA YANG INGIN DIHAPUS ");
        System.out.println("==============================================");
        DatabaseController.getDatabase();
        System.out.println("==============================================");
        System.out.println("***Catatan: input nama produk dengan benar!");
        System.out.print("Pilih Nama Produk: ");
        String nama = sc.nextLine();
        System.out.println("==============================================");
       
        if (DatabaseController.deletDB(nama)) {
            System.out.println("BERHASIL MENGHAPUS DATA");
            
        }else{
            System.out.println("GAGAL MENGHAPUS DATA");
            System.out.println("----------------------------------------------");
            DeleteData.showDeleteData();
        }

        System.out.println("----------------------------------------------");
        Menu.tampilkanMenu();
        sc.close();   
    }
}