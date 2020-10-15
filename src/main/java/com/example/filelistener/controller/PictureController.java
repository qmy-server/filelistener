package com.example.filelistener.controller;


import com.example.filelistener.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/img")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    /**
     * 获取人脸图片地址
     */
    @RequestMapping(value = "/{img}", method = RequestMethod.GET)
    public String getImageStream(@PathVariable(value = "img") String img, HttpServletResponse response) {
       String result=this.pictureService.getImg(img,response);
       return result;
    }


}
