/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.model.Account;

/**
 *
 * @author Admin
 */
public interface AccountController {
    Account checkLogin(String username, String password);
    boolean update(Account acc);
    
}
