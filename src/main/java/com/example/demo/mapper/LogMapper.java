package com.example.demo.mapper;
import com.example.demo.entity.TestInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int insertOne(TestInfo testInfo);
    TestInfo selectByKey(TestInfo testInfo);
}
