package com.frozen.frozenfileyun.controller;

import com.frozen.frozenfileyun.model.ResultBean;
import com.frozen.frozenfileyun.service.LocalServiceImpl;
import com.frozen.frozenfileyun.service.UserServiceImpl;
import com.frozen.frozenfileyun.utils.PathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/fileUp")
@Slf4j
public class FileUpController {

    @Autowired
    private LocalServiceImpl localServiceImpl;

    @RequestMapping("/upload")
    @ResponseBody
    public ResultBean upload(@RequestParam("file") MultipartFile file) {
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = PathUtils.concatPath(localServiceImpl.getBasepath(), fileName);
        // 文件对象
        File dest = new File(filePath);
        // 判断路径是否存在，如果不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            return ResultBean.success();
        } catch (Exception e) {
            log.debug("upload error filePath={}",filePath, e);
        }
        return ResultBean.success("上传失败");
    }
}
