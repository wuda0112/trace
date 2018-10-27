package com.wuda.trace.log;

import com.wuda.trace.log.identity.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ThreadLocal} util class.
 *
 * @author wuda
 */
public class ThreadContext {

    private static String CURRENT_SUBJECT_KEY = "trace_current_subject";

    private static InheritableThreadLocal<Map<String, Object>> threadLocal;

    static {
        threadLocal = new InheritableThreadLocal() {
            protected Map<String, Object> initialValue() {
                return new HashMap<>();
            }
        };
    }

    /**
     * 绑定当前{@link Subject}到当前线程.
     *
     * @param subject
     *         current "user"
     */
    public static void bind(Subject subject) {
        threadLocal.get().put(CURRENT_SUBJECT_KEY, subject);
    }

    /**
     * {@link Subject}解除绑定.
     */
    public static void unbindSubject() {
        threadLocal.get().remove(CURRENT_SUBJECT_KEY);
    }

    /**
     * 获取当前线程绑定的{@link Subject}.
     *
     * @return 当前线程中绑定的{@link Subject},如果不存在则返回<code>null</code>.
     */
    public static Subject getSubject() {
        Object object = threadLocal.get().get(CURRENT_SUBJECT_KEY);
        if (object != null) {
            return (Subject) object;
        }
        return null;
    }

}
