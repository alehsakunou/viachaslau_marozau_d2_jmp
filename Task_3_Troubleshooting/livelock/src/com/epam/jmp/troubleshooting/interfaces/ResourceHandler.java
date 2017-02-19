package com.epam.jmp.troubleshooting.interfaces;

import com.epam.jmp.troubleshooting.impl.CommonResource;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public interface ResourceHandler
{
    boolean isActive ();
    void handle(CommonResource commonResource, ResourceHandler[] otherResourceHandlers);
}
