package com.example.filelistener.service;

import javax.servlet.http.HttpServletResponse;

public interface PictureService {
    String  getImg(String imgUrl, HttpServletResponse response);

}
