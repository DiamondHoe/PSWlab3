package com.lab3;

import java.util.concurrent.atomic.AtomicInteger;

public class RGB {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int colorId;

    public int getColorId() {
        return colorId;
    }

    private Integer R_value;

    public Integer getR_value() {
        return R_value;
    }

    public void setR_value(Integer r_value) {
        if(r_value > 255) r_value = 255;
        if(r_value < 0) r_value = 0;
        R_value = r_value;
    }

    private Integer G_value;

    public Integer getG_value() {
        return G_value;
    }

    public void setG_value(Integer g_value) {
        if(g_value > 255) g_value = 255;
        if(g_value < 0) g_value = 0;
        G_value = g_value;
    }

    private Integer B_value;

    public void setB_value(Integer b_value) {
        if(b_value > 255) b_value = 255;
        if(b_value < 0) b_value = 0;
        B_value = b_value;
    }

    public Integer getB_value() {
        return B_value;
    }

    public RGB(Integer r_value, Integer g_value, Integer b_value){
        setR_value(r_value);
        setG_value(g_value);
        setB_value(b_value);
        colorId = count.incrementAndGet();
    }
}
