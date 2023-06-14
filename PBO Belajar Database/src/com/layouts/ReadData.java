package com.layouts;

import java.util.Scanner;
import com.controller.DatabaseController;

public class ReadData {


    public static void showReadData(){
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("DATA PRODUK");
        System.out.println("====================================");
        DatabaseController.getDatabase();
        System.out.println("====================================");
        
        System.out.println("1. MENU ");
        System.out.println("2. EXIT "); 
        System.out.print("Pilih: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                Menu.tampilkanMenu();
                    break;
                case 2:
                System.out.println("==========================================");
                System.out.println("\t\tTERIMA KASIH");
                System.out.println("==========================================");
                System.exit(selectMenu);
                break;
            
                default:
                System.out.println("==============================================");
                System.out.println("MAAF MENU TIDAK TERSEDIA");
                ReadData.showReadData();
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("==============================================");
               System.out.println("MASUKKAN INPUTAN BERUPA ANGKA");
               ReadData.showReadData();
        }
        
        System.out.println("====================================");
        Menu.tampilkanMenu();
        sc.close();
    }
    
}