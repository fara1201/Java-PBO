package com.controller;

import java.sql.SQLException;
import com.config.Myconfig;
import com.models.Product;

public class DatabaseController extends Myconfig {
    public static void getDatabase() {
        connection();
        try {
            query = "SELECT NAMA,HARGA,STOK FROM `table_product`ORDER BY ID DESC";
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAMA") + ": Rp." +
                                resultSet.getString("HARGA") + " (" +
                                resultSet.getString("STOK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void readDB() {
        connection();
        try {
            query = "SELECT NAMA, HARGA, STOK FROM `table_product` ORDER BY ID DESC ";
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAMA") + ": Rp." +
                                resultSet.getString("HARGA") + " (" +
                                resultSet.getString("STOK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static boolean insertDB(String product, Long harga, Integer stok) {
        connection();
        query = "INSERT INTO `table_product` (NAMA, HARGA, STOK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, product);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    public static void updateNamaDB(int id, String name) {
        connection();
        query= "UPDATE `table_produk` SET NAMA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateHargaDB(int id, Long harga) {
        connection();
        query= "UPDATE `table_product` SET HARGA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStokDB(int id, Integer stok) {
        connection();
        query= "UPDATE `table_product` SET STOK=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, stok);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean deletDB(String nama) {
        connection();
        query= "DELETE FROM `table_product` WHERE NAMA=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            int rowDelete = preparedStatement.executeUpdate();
            if (rowDelete>0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Product getProdukbyNama(String nama){
        Product produk = null;
        connection();
        query = "SELECT * FROM `table_product` WHERE NAMA=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                produk = new Product(resultSet.getInt("ID"), resultSet.getString("NAMA"), resultSet.getLong("HARGA"), resultSet.getInt("STOK"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produk;
    }
}