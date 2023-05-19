package com.lab3;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInside = new Scanner(System.in);
        String input = "";

        RGBController rgbController = new RGBController();
        addDefaultColors(rgbController);

        System.out.println("Witaj w mendżerze kolorów");
        while (!input.equals("exit")) {
            System.out.println("""
                    Aby wyświetlić listę kolorów wpisz: show\s
                    Aby dodać kolor wpisz: add
                    Aby zmieszać kolor wpisz: mix
                    Aby zakończyć wpisz: exit""");

            input = scanner.nextLine().toLowerCase(Locale.ROOT);

            switch (input) {
                case "show" -> {
                    if(rgbController.getColorsCount() == 0) System.out.println("Brak zapamietanych kolorów");
                    else rgbController.showColors();
                }
                case "add" -> {
                    Integer rValue = getInt("Podaj wartość koloru czerwonego (Red)", "Podano niepoprawną liczbe.");
                    Integer gValue = getInt("Podaj wartość koloru zielonego (Green)", "Podano niepoprawną liczbe.");
                    Integer bValue = getInt("Podaj wartość koloru niebieskiego (Blue)", "Podano niepoprawną liczbe.");

                    RGB newColor = new RGB(rValue, gValue, bValue);
                    rgbController.addColor(newColor);
                    System.out.println("Pomyślnie dodano kolor!");
                    System.out.printf("[ R: %d, G: %d, B: %d ]%n", newColor.getR_value(), newColor.getG_value(), newColor.getB_value());
                }
                case "mix" -> {
                    int firstColorIndex;
                    int secondColorIndex;

                    rgbController.showColors();
                    do {
                        firstColorIndex = getInt("Podaj index pierwszego koloru, który chcesz wymieszać: ", "Podano niepoprawną liczbę.");

                        if (firstColorIndex >= 0 && firstColorIndex < rgbController.getColorsCount()) {
                            break;
                        } else {
                            System.out.println("Podano niepoprawną liczbę.");
                        }
                    } while (true);

                    do {
                        secondColorIndex = getInt("Podaj index drugiego koloru, który chcesz wymieszać: ", "Podano niepoprawną liczbę.");

                        if (secondColorIndex >= 0 && secondColorIndex < rgbController.getColorsCount()) {
                            break;
                        } else {
                            System.out.println("Podano niepoprawną liczbę.");
                        }
                    } while (true);

                    RGB resultColor = rgbController.mixColors(rgbController.getColor(firstColorIndex), rgbController.getColor(secondColorIndex));
                    System.out.println("Wymieszany kolor:");
                    System.out.printf("Color ID: %d,[ R: %d, G: %d, B: %d ]%n", resultColor.getColorId(), resultColor.getR_value(), resultColor.getG_value(), resultColor.getB_value());
                    System.out.println("Dodać do listy kolorów? [y/n]: ");
                    String add = scannerInside.next().toLowerCase(Locale.ROOT);
                    if (add.equals("y")) {
                        rgbController.addColor(resultColor);
                        System.out.println("Pomyślnie dodano kolor!");
                    }
                }
                case "exit" -> {}
                default -> System.out.println("Podano złe polecenie!");
            }
        }
    }

    private static void addDefaultColors(RGBController rgbController) {
        rgbController.addColor(new RGB(1 , 2, 3));
        rgbController.addColor(new RGB(2 , 40, 21));
        rgbController.addColor(new RGB(5 , 50, 123));
        rgbController.addColor(new RGB(24 , 140, 110));
    }

    public static int getInt(String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("x")) {
                return -1;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println(errorMessage);
            }
        }
    }
}
