package com.springboot.mybatises.service;

import com.springboot.mybatises.Dao.test1.FileDao1;
import com.springboot.mybatises.Dao.test2.FileDao2;
import com.springboot.mybatises.Entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FileService {


    @Autowired
    private FileDao1 fileDao1;
    @Autowired
    private FileDao2 fileDao2;

    public List<HashMap> findUser1(){
        return fileDao1.findUser1();
    }

    public List<HashMap> findUser2(){
        return fileDao2.findUser2();
    }
}
