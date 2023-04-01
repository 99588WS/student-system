package com.juzi.project.util;

/**
 * 字符串工具类
 *
 * @author codejuzi
 * @CreateTime 2023/4/1
 */
public class StringUtil {

    /**
     * 字符串不为空
     *
     * @param str 传入的字符串
     * @return true - 不为空
     */
    public static boolean isNotBlank(String str) {
        return str != null && !"".equals(str);
    }
}
