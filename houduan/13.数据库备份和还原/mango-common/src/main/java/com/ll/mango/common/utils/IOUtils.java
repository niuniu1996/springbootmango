package com.ll.mango.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 * @author liulan
 * @version 1.0
 * @date 2020/6/6 0006 下午 21:54
 */
public class IOUtils {
    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
