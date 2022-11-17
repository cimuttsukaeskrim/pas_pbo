/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import controller.controller_barang;
import Koneksi.Koneksi;
import form.form_barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class model_barang implements controller_barang {

    @Override
    public void Simpan(form_barang brg) throws SQLException {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "insert into barang values (?,?,?,?)";
            PreparedStatement prepare=con.prepareStatement(sql);
            prepare.setString(1, brg.txt_kode_barang.getText());
            prepare.setString(2, brg.txt_nama_barang.getText());
            prepare.setString(3,brg.txt_jenis_barang.getText());
            prepare.setString(4,brg.txt_stok.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
        }catch (Exception e){
            System.out.println(e);
        }finally {
           Tampil(brg);
           }
    }

    @Override
    public void Hapus(form_barang brg) throws SQLException {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "DELETE FROM barang WHERE kode_barang =?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, brg.txt_kode_barang.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally { 
            Tampil(brg);
        }
    }

    @Override
    public void Edit(form_barang brg) throws SQLException {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "insert into barang values(?,?,?,?)";
            PreparedStatement prepare=con.prepareStatement(sql);
            prepare.setString(4, brg.txt_kode_barang.getText());
            prepare.setString(1, brg.txt_nama_barang.getText());
            prepare.setString(2, brg.txt_jenis_barang.getText());
            prepare.setString(3, brg.txt_stok.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diedit");
            prepare.close();
        }catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(brg);
        }
    }

    @Override
    public void Tampil(form_barang brg) throws SQLException {
       brg.model.getDataVector().removeAllElements();
       brg.model.fireTableDataChanged();
        try {
            Connection con = Koneksi.getConnection();
            Statement stt = con.createStatement();
            String sql = "select * from barang order by kode_barang";
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              brg.model.addRow(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void KlikTable(form_barang brg) throws SQLException {
        try { 
            int pilih  = brg.tabel.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            brg.txt_kode_barang.setText.(brg.model.getValueAt(pilih, 0).toString());
            brg.txt_nama_barang.setText(brg.model.getValueAt(pilih, 1).toString());
            brg.txt_jenis_barang.setText(brg.model.getValueAt(pilih, 2).toString());
            brg.txt_stok.setText.(brg.model.getValueAt(pilih, 3).toString());
            
        } catch (Exception e) {
        }
    }
    }

   
   