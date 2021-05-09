package com.sse.software_testing;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

/**
 * @author hq
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void loadJsonFile() throws IOException {
//        System.out.println(new Date());
//        String question = (String) data.get("question");
//        String caseName = (String) data.get("case");
        //获取文件的URL
        String filePath = this.getClass().getClassLoader().getResource("static/triangle_boundary.xlsx").getFile();
        filePath  =  java.net.URLDecoder.decode(filePath,"utf-8").substring(1);
        System.out.println(filePath);
//        Path file = Paths.get(filePath);
        if (Files.exists(Path.of(filePath))){
            System.out.println("exist");
//            response.setHeader("Content-Type", "application/octet-stream;charset=utf-8"); // 告诉浏览器输出内容为流

        }
    }
}
