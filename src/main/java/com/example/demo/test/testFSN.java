package com.example.demo.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/12/2 10:11
 * @PackageName:com.example.demo.test
 * @ClassName: testFSN
 * @Description: TODO
 * @Version 1.0
 */
public class testFSN {
    public static void main(String[] args) {
        String [] test = {"10", "0", "32", "0", "32", "0", "0", "0", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
                "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
                "-1", "-1", "63", "-98", "-1", "-1", "7", "0", "-2", "-1", "-63", "15", "-2", "-1", "-63", "127", "-4", "-1",
                "-31", "-1", "-4", "-1", "-63", "-1", "-4", "-1", "-64", "127", "-4", "-1", "-64", "63", "-4", "-1", "1", "30", "-4",
                "-1", "1", "0", "-1", "-1", "3", "-128", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
                "-1", "-1", "-1", "-1", "1", "-1", "-1", "-1", "-1", "-1", "-1"};
        for (int i = 0; i < test.length; i++) {
            System.out.println("第" + i + "位：" + test[i]);
        }
    }
}
