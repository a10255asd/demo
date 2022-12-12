package com.example.demo.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author LiuJixue
 * @Date 2022/12/5 21:43
 * @PackageName:com.example.demo.test
 * @ClassName: BatchPreparedStatementSetter
 * @Description: TODO
 * @Version 1.0
 */
public interface BatchPreparedStatementSetter {
    void setValues(PreparedStatement var1, int var2) throws SQLException;

    int getBatchSize();
}
