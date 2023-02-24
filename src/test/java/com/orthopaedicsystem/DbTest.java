package com.orthopaedicsystem;

import com.orthopaedicsystem.mapper.ChinaMapper;
import com.orthopaedicsystem.po.China;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DbTest {
    @Autowired
    ChinaMapper chinaMapper;

    @Test
    void testChinaMapper(){
        List<China> list = chinaMapper.selectList(null);
        list.forEach(System.out::println);
    }

}
