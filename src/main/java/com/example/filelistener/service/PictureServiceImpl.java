package com.example.filelistener.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service("PictureService")
public class PictureServiceImpl implements PictureService {
    @Value("${file.path}")
    private String imgRoot;

    /**
     * 获取图片
     *
     * @param img
     * @param response
     */
    @Override
    public String getImg(String img, HttpServletResponse response) {
        String path = imgRoot + File.separator + img;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            return "error";
        } else {
            response.reset();
            response.setHeader("Content- Disposition", "attachment;filename=qmy.jpg");
            response.setContentType("image/jpeg");
            int len = 0;
            byte[] data = new byte[1024];
            try {
                OutputStream out = response.getOutputStream();
                while ((len = inputStream.read(data)) != -1) {
                    out.write(data, 0, len);
                }
                inputStream.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Success";
        }

    }


}
