package com.qunincey.bbs.Dao;

import com.qunincey.bbs.bean.Account;

public interface AccountPersistService
{
    public int createAccount(Account account);

    public Account getAccountById(String name);

    public int updateAccount(Account account);

    public int deleteAccount(String name);
}
