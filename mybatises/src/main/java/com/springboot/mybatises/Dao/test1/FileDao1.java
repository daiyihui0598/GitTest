package com.springboot.mybatises.Dao.test1;

import com.springboot.mybatises.Entity.FileEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * mybatis文件上传保存与查询类
 */
public interface FileDao1 {

    List<HashMap> findUser1();
}
