package com.github.nettybook.ch9.service;

/**
 * <p>
 * {@code RequestParamException} and its subclasses are <em>unchecked
 * exceptions</em>. Unchecked exceptions do <em>not</em> need to be declared in
 * a method or constructor's {@code throws} clause if they can be thrown by the
 * execution of the method or constructor and propagate outside the method or
 * constructor boundary.
 */
public class RequestParamException extends Exception {
    private static final long serialVersionUID = -1583203227626153961L;

    /**
     * Constructs a new Request param exception with {@code null} as its detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public RequestParamException() {
        super();
    }

    /**
     * Constructs a new Request param exception with the specified detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param message
     *            the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public RequestParamException(String message) {
        super(message);
    }

    /**
     * Constructs a new Request param exception with the specified detail
     * message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated in this Request param exception's detail
     * message.
     *
     * @param message
     *            the detail message (which is saved for later retrieval by the
     *            {@link #getMessage()} method).
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public RequestParamException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new Request param exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>). This
     * constructor is useful for Request param exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public RequestParamException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new Request param exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable stack trace
     * enabled or disabled.
     *
     * @param message
     *            the detail message.
     * @param cause
     *            the cause. (A {@code null} value is permitted, and indicates
     *            that the cause is nonexistent or unknown.)
     * @param enableSuppression
     *            whether or not suppression is enabled or disabled
     * @param writableStackTrace
     *            whether or not the stack trace should be writable
     */
    protected RequestParamException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
