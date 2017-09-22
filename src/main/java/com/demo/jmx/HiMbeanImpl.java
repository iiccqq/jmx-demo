package com.demo.jmx;

public class HiMbeanImpl implements HiMBean {  
  
    private final String     name               = "Reginald";  
    private int              cacheSize          = DEFAULT_CACHE_SIZE;  
    private static final int DEFAULT_CACHE_SIZE = 200;  
  
    public void sayHello() {  
        System.out.println("Hello," + getName());  
    }  
  
    public int add(int x, int y) {  
        return x + y;  
    }  

    public String getName() {  
        return name;  
    }  
  
    public int getCacheSize() {  
        return cacheSize;  
    }  
  
    public void setCacheSize(int size) {  
        cacheSize = size;  
    }  
  
}