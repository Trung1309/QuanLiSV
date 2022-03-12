/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connect.DatabaseHelper;
import Student.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentDao {
    public ArrayList<Student> getListStudent() throws Exception{
        ArrayList<Student> list = new ArrayList<>();
        String sql ="SELECT * FROM SinhVien";
        Connection conn = DatabaseHelper.openConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setMaSV(rs.getString("MaSV"));
                s.setHoTen(rs.getString("HoTen"));
                s.setEmail(rs.getString("Email"));
                s.setSoDT(rs.getString("SoDT"));
                s.setGioiTinh(rs.getInt("GioiTinh"));
                s.setDiaChi(rs.getString("DiaChi"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean insert(Student student) throws Exception{
        String sql = "insert into SinhVien(maSV,HoTen,Email,SoDt,GioiTinh,DiaChi) values(?,?,?,?,?,?)";
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getMaSV());
            pstmt.setString(2, student.getHoTen());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getSoDT());
            pstmt.setInt(5, student.getGioiTinh());
            pstmt.setString(6, student.getDiaChi());
            return pstmt.executeUpdate() > 0;
        }
    public Student findByiD(String maSV) throws Exception{
        String sql = "select * "
                + "from SinhVien "
                + "where MaSV = ?";
            
        try {
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            {
            pstmt.setString(1, "MaSV");
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Student student = new Student();
                student.setHoTen(rs.getString("HoTen"));
                student.setEmail(rs.getString("Email"));
                student.setSoDT(rs.getString("SoDT"));
                student.setGioiTinh(rs.getInt("GioiTinh"));
                student.setDiaChi(rs.getString("DiaChi"));
                
                return student;
                
            }
            return null;
            }
        } catch (Exception e) {
        }
            
        return null;
            
   
        }
    public boolean update(Student stud ) throws Exception{
        String url = "update SinhVien set HoTen = ?, Email = ?, SoDT = ?, GioiTinh = ?, DiaChi = ?"
                + "where MaSV = ?";
    
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(url);
        {
            pstmt.setString(6, stud.getMaSV());
            pstmt.setString(1, stud.getHoTen());
            pstmt.setString(2, stud.getEmail());
            pstmt.setString(3, stud.getSoDT());
            pstmt.setInt(4, stud.getGioiTinh());
            pstmt.setString(5, stud.getDiaChi());

            return pstmt.executeUpdate() > 0;
        }   
   
    
}
    public boolean delete(String MaSV) throws Exception{
       String sql = " delete from SinhVien where MaSV = ?";
     
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
            {
                pr.setString(1, MaSV);
            }
       
        return pr.executeUpdate()>0;
   }
}
