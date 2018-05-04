package com.qunincey.bbs.Dao.Impl;

import com.qunincey.bbs.Dao.AccountPersistService;
import com.qunincey.bbs.bean.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.qunincey.bbs.util.DBconn.conn;

public class AccountPersistServiceImpl
    implements AccountPersistService
{
    public int createAccount(Account account )
    {
        String createAccount=" insert into account(id,name,email,password) values (null,?,?,?) ";
        int avail=0;
        try {
            Connection conn=conn();
            PreparedStatement prep=conn.prepareStatement(createAccount);
            prep.setString(1,account.getName());
            prep.setString(2,account.getEmail());
            prep.setString(3,account.getPassword());
            avail=prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avail;
    }

    public Account getAccountById(String name) {

        String getAccountById=" select * from account where name= ? ";
        Connection conn=conn();
        Account account=null;
        try {
            PreparedStatement prep=conn.prepareStatement(getAccountById);
            prep.setString(1,name);
            ResultSet rs=prep.executeQuery();
            while (rs.next()){
                account=new Account();
                account.setId(rs.getInt(1));
                account.setName(name);
                account.setEmail(rs.getString(3));
                account.setPassword(rs.getString(4));
                account.setActivated(rs.getBoolean(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

	public int deleteAccount(String name)
    {
        String deleteAccount=" delete from account where name = ? ";
        Connection conn=conn();
        int rows=0;
        try {
            PreparedStatement prep=conn.prepareStatement(deleteAccount);
            prep.setString(1,name);
            rows=prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public int updateAccount(Account account )
    {
        int getId=getId(account.getName());
        String updateAccount=" update account set name = ?,email = ? ,password= ? ,acticated = ? where id=? ";
        Connection conn=conn();
        int rows=0;
        try {
            PreparedStatement prep=conn.prepareStatement(updateAccount);
            prep.setString(1,account.getName());
            prep.setString(2,account.getEmail());
            prep.setString(3,account.getPassword());
            prep.setBoolean(4,account.isActivated());
            prep.setInt(5,getId);
            rows=prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public int getId(String name){
        String getId=" select id from account where name= ? ";
        Connection conn=conn();
        int account=0;
        try {
            PreparedStatement prep=conn.prepareStatement(getId);
            prep.setString(1,name);
            ResultSet rs=prep.executeQuery();
            while (rs.next()){
                account=rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
