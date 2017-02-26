package com.epam.jmp.classloading.err;

/**
 * Created by Viachaslau_Marozau on 2/26/2017.
 */
public class AppException extends RuntimeException
{
    public AppException()
    {
    }

    public AppException(String message)
    {
        super(message);
    }

    public AppException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AppException(Throwable cause)
    {
        super(cause);
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
