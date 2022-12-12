package com.example.demo.test;

import org.apache.commons.collections.map.ListOrderedMap;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author LiuJixue
 * @Date 2022/12/5 21:42
 * @PackageName:com.example.demo.test
 * @ClassName: QfjCashBatchPreparedStatementSetters
 * @Description: TODO
 * @Version 1.0
 */
public class QfjCashBatchPreparedStatementSetters implements BatchPreparedStatementSetter {
        List temList;

        /** 通过构造函数把要插入的数据传递进来处理 */
	public QfjCashBatchPreparedStatementSetters(List list) {
            temList = list;
        }

        public int getBatchSize() {
            return temList.size();
        }

        public void setValues(PreparedStatement ps, int i) throws SQLException {
            ListOrderedMap map = (ListOrderedMap) temList.get(i);
            for (int l = 0; l < map.size(); l++) {
                Object value = map.get(map.get(l));
                if (value != null)
                    ps.setString(l + 1, value.toString());
                else
                    ps.setString(l + 1, null);
            }

        }
}
