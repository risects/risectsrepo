package com.notification.model;

public class Amount
{
    private String direction;

    private String value;

    public String getDirection ()
    {
        return direction;
    }

    public void setDirection (String direction)
    {
        this.direction = direction;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [direction = "+direction+", value = "+value+"]";
    }
}

