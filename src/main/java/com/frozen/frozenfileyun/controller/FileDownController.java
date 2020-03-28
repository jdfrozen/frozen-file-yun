package com.frozen.frozenfileyun.controller;

import com.frozen.frozenfileyun.service.LocalServiceImpl;
import com.frozen.frozenfileyun.utils.FileUtil;
import com.frozen.frozenfileyun.utils.PathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("/fileDown")
@Slf4j
public class FileDownController {
    @Autowired
    private LocalServiceImpl localServiceImpl;

    @GetMapping("/file/**")
    @ResponseBody
    public ResponseEntity<Object> downAttachment(final HttpServletRequest request) {
        String path = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        AntPathMatcher apm = new AntPathMatcher();
        String filePath = apm.extractPathWithinPattern(bestMatchPattern, path);
        File file= new File(PathUtils.concatPath(localServiceImpl.getBasepath(), filePath));
        return FileUtil.export(file);
    }
}
