package com.sse.software_testing.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

import static javax.xml.transform.OutputKeys.ENCODING;

/**
 * @author hq
 */
@RestController
@RequestMapping("/api")
public class LoadController {
    @PostMapping("/load")
    public void loadJsonFile(HttpServletResponse response) throws IOException {
        System.out.println(new Date());
        System.out.println(response);
        String outFileName = "test_triangle_boundary.xlsx";
//        String question = (String) data.get("question");
//        String caseName = (String) data.get("case");
        String filePath = this.getClass().getClassLoader().getResource("static/triangle_boundary.xlsx").getFile();
        filePath = java.net.URLDecoder.decode(filePath, "utf-8").substring(1);
        System.out.println(filePath);
//        Path file = Paths.get(filePath);
        if (Files.exists(Path.of(filePath))) {
            System.out.println("exist");
            // 告诉浏览器输出内容为流
            response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
            String message;
            try {
                // 方法1： 设置下载的文件的名称-该方式已解决中文乱码问题，swagger,postman看到的是%...等，浏览器直接输url,OK
                System.out.println(URLEncoder.encode(outFileName,"UTF-8"));
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + URLEncoder.encode(outFileName,"UTF-8"));
            }catch (UnsupportedEncodingException e) {
                message = "导入数据失败," + e.getMessage();
//                log.error(message);
//                throw new SysInnerException(message);
            }
//            try {
//                Files.copy(file, response.getOutputStream());
//            } catch (IOException ex) {
//                message = "导入数据失败," + ex.getMessage();
//                log.error(message);
//                throw new SysInnerException(message);
//            }
        }
    }
}
