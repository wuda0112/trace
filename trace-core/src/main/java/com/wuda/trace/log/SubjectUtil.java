package com.wuda.trace.log;

import com.wuda.trace.log.identity.Subject;
import com.wuda.trace.log.ThreadContext;

/**
 * 方便的获取{@link Subject subject}.
 *
 * @author wuda
 */
public class SubjectUtil {

    /**
     * 从{@link ThreadLocal}中获取绑定的{@link Subject}
     *
     * @return current subject
     */
    public static Subject getSubject() {
        return ThreadContext.getSubject();
    }

    /**
     * 绑定当当前线程.
     *
     * @param subject
     *         {@link Subject}
     */
    public static void bind(Subject subject) {
        ThreadContext.bind(subject);
    }

    /**
     * 解除绑定.
     */
    public static void unbind() {
        ThreadContext.unbindSubject();
    }
}
