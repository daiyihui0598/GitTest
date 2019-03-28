package com.springboot.mybatises.Controller;

import com.springboot.mybatises.Dao.test1.FileDao1;
import com.springboot.mybatises.Dao.test2.FileDao2;
import com.springboot.mybatises.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RestController
public class FileController {


    @Autowired
    private FileService fileService;

    @RequestMapping("/findUser1")
    public List<HashMap> findUser1(HttpSession session){
        System.out.println("==============");  System.out.println("==============");  System.out.println("==============");  System.out.println("==============");
        System.out.println(session.getId());
        return fileService.findUser1();
    }

    @RequestMapping("/findUser2")
    public List<HashMap> findUser2(){
        return fileService.findUser2();
    }
}
