/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeemanagementsystem.model;

/**
 *
 * @author Quang Vinh
 */
public class Account {
    private int idAccount, role;
    private String username, password;

    public Account() {
    }

    public Account(int idAcc, int role, String username, String password) {
        this.idAccount = idAcc;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public int getIdAcc() {
        return idAccount;
    }

    public void setIdAcc(int idAcc) {
        this.idAccount = idAcc;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
