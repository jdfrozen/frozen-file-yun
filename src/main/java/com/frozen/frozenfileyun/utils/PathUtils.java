package com.frozen.frozenfileyun.utils;

/**
 * @Auther: frozen
 * @Date: 2020/3/28 18:17
 * @Description:
 */
public class PathUtils {
    public static final char DELIMITER = '/';
    /**
     * 将域名和路径组装成 URL, 主要用来处理分隔符 '/'
     * @param domain    域名
     * @param path      路径
     * @return          URL
     */
    public static String concatPath(String domain, String path) {
        if (path != null && path.length() > 1 && path.charAt(0) != DELIMITER) {
            path = DELIMITER + path;
        }

        if (domain != null && domain.charAt(domain.length() - 1) == DELIMITER) {
            domain = domain.substring(0, domain.length() - 2);
        }

        return domain + path;
    }
}
