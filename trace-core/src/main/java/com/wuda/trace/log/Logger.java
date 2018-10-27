package com.wuda.trace.log;

import com.wuda.trace.log.identity.Subject;
import org.slf4j.LoggerFactory;

/**
 * 封装了slf4j的logger,因此用法一样.
 *
 * @author wuda
 */
public class Logger {

    /**
     * application name.
     */
    private String applicationName;

    /**
     * the real logger.
     */
    private org.slf4j.Logger logger;

    /**
     * 　生成实例.
     *
     * @param applicationName
     *         应用的名称
     * @param clazz
     *         即: {@link LoggerFactory#getLogger(Class)}所需的class
     */
    public Logger(String applicationName, Class<?> clazz) {
        this.applicationName = applicationName;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    private String rewriteFormat(String format) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("【{}】【{}】【{}】【{}】");
        stringBuilder.append(format);
        return stringBuilder.toString();
    }

    private String rewriteEmptyFormat() {
        return rewriteFormat("{}{}");
    }

    public void debug(String message, Throwable throwable) {
        Subject subject = SubjectUtil.getSubject();
        logger.debug(rewriteEmptyFormat(),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), message, throwable);
    }

    public void debug(String format, Object... arguments) {
        Subject subject = SubjectUtil.getSubject();
        logger.debug(rewriteFormat(format),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), arguments);
    }

    public void info(String message, Throwable throwable) {
        Subject subject = SubjectUtil.getSubject();
        logger.info(rewriteEmptyFormat(),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), message, throwable);
    }

    public void info(String format, Object... arguments) {
        Subject subject = SubjectUtil.getSubject();
        logger.info(rewriteFormat(format),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), arguments);
    }

    public void warn(String message, Throwable throwable) {
        Subject subject = SubjectUtil.getSubject();
        logger.warn(rewriteEmptyFormat(),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), message, throwable);
    }

    public void warn(String format, Object... arguments) {
        Subject subject = SubjectUtil.getSubject();
        logger.warn(rewriteFormat(format),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), arguments);
    }

    public void error(String message, Throwable throwable) {
        Subject subject = SubjectUtil.getSubject();
        logger.error(rewriteEmptyFormat(),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), message, throwable);
    }

    public void error(String format, Object... arguments) {
        Subject subject = SubjectUtil.getSubject();
        logger.error(rewriteFormat(format),
                applicationName, subject.getIdentity(), subject.getRequestId(), subject.getDownStreamIp(), arguments);
    }

}
