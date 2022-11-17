/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import form.form_barang;
import java.sql.SQLException;


public interface controller_barang {
    public void Simpan(form_barang brg) throws SQLException;
    public void Hapus(form_barang brg) throws SQLException;
    public void Edit(form_barang brg) throws SQLException;
     public void Tampil(form_barang brg) throws SQLException;
     public void KlikTable(form_barang brg) throws SQLException;
}
