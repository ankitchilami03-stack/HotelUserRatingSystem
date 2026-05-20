package com.lcwd.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    //extra properties you want to add
    public ResourceNotFoundException()
    {
        super("Resource not found on the server");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
