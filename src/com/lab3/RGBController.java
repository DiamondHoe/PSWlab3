package com.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RGBController {

    private final List<RGB> colors;

    public RGBController(){
        colors = new ArrayList<>();
    }

    public int getColorsCount(){
        return colors.size();
    }

    public RGB getColor(int id){
        return colors.get(id);
    }

    public void showColors(){
        List<String> colorStrings = colors.stream()
                .map(x -> String.format("Color ID: %d, [ R: %d, G: %d, B: %d ]", x.getColorId(), x.getR_value(), x.getG_value(), x.getB_value()))
                .collect(Collectors.toList());

        colorStrings.forEach(System.out::println);
    }

    public void addColor(RGB color){
        colors.add(color);
    }

    public RGB mixColors(RGB color1, RGB color2){
        int resultRColor = color1.getR_value() + color2.getR_value();
        if(resultRColor > 255) resultRColor = 255;
        int resultGColor = color1.getB_value() + color2.getR_value();
        if(resultGColor > 255) resultGColor = 255;
        int resultBColor = color1.getG_value() + color2.getG_value();
        if(resultBColor > 255) resultBColor = 255;

        return new RGB(resultRColor, resultGColor, resultBColor);
    }
}
