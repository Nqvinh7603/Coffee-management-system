/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagementsystem.controller.impl;

import com.employeemanagementsystem.controller.AccountController;
import com.employeemanagementsystem.controller.utils.ConnectionUtils;
import com.employeemanagementsystem.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class AccountImpl implements AccountController {

    @Override
    public Account checkLogin(String username, String password)  {
      String sql = "select * from account where username = ? and password = ?";
        try(
                Connection con = ConnectionUtils.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(2, username);
            psmt.setString(3, password);
            
            try(ResultSet rs = psmt.executeQuery();){
                if(rs.next()){
                    Account user = new Account();
                    user.setIdAcc(rs.getInt("idaccount"));
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setRole(rs.getInt("role"));
                    return user;
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public boolean update(Account acc) {
        String sql = "update account set password = ? where id = ?";
        try(
                Connection con = ConnectionUtils.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            psmt.setString(1, acc.getPassword());
            psmt.setInt(2, acc.getIdAcc());
            
            return psmt.executeUpdate() > 0;
        }catch(Exception e){
            e.getMessage();
        
        }
        return false;
    }
   
}