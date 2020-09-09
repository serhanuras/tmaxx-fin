package com.xinerji.tmaxxfinrest.resourcebundles;

import java.util.Locale;
import java.util.ResourceBundle;


public class Resource {

    private static Resource resource = null;


    public static Resource getInstance()
    {
        if (resource == null)
            resource = new Resource();

        return resource;
    }

    public String getString(String key){
        try {
            //TODO : Get Locale from HTTP Request HEADER
            Locale locale = new Locale("tr", "TR");
            return ResourceBundle.getBundle("messages", locale).getString(key);
        }
        catch (Exception ex){
            return "#" + key + "#";
        }
    }
}
