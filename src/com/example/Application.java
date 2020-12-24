package com.example;

import java.time.Month;
import java.util.Scanner;

public class Application {

    static void menu() {
        System.out.println("Натисніть 1, щоб перевірити чи є такий місяць");
        System.out.println("Натисніть 2, щоб вивести всі місяці з такою ж порою року");
        System.out.println("Натисніть 3, щоб вивести місяці які мають таку ж саму к-сть днів");
        System.out.println("Натисніть 4 , щоб вивести на екран місяці, які мають більшу к-сть днів");
        System.out.println("Натисніть 5, щоб вивести на екран місяці, які мають меншу к-сть днів");
        System.out.println("Натисніть 6, щоб вивести на екран наступниу пору року");
        System.out.println("Натисніть 7, щоб вивести на екран попередню пору року");
        System.out.println("Натисніть 8, щоб вивести на екран всі місяці, які мають парну к-сть днів");
        System.out.println("Натисніть 9, щоб вивести на екран всі місяці, які мають не парну к-сть днів");
        System.out.println("Натисніть 10, щоб вивести на екран, чи введений місяць має парну к-сть днів");
    }

    public static void main(String[] args) {

        Months[] months = Months.values();
        Seasons[] seasons = Seasons.values();
        Scanner scan = new Scanner(System.in);

        while (true) {
            menu();

            switch (scan.next()) {

                case "1": {
                    System.out.println("Введіть місяць: ");
                    scan = new Scanner(System.in);
                    String month = scan.next().toUpperCase();

                    boolean flag = isMonthPresent(months, month);
                    if (!flag) {
                        System.out.println("Місяць не їснує");
                    }
                    break;
                }

                case "2": {
                    System.out.println("Введіть пору року: ");
                    scan = new Scanner(System.in);
                    String season = scan.next().toUpperCase();

                    boolean flag = false;

                    for (Months m : months) {
                        if (m.getSeason().name().equals(season)) {
                            flag = true;
                        }
                    }

                    if (flag) {

                        for (Months mon : months) {
                            if (mon.getSeason().toString().equals(season)) {
                                System.out.println(mon);
                            }
                        }
                    }

                    if (!flag) {
                        System.out.println("Такого сезону не існує");
                    }
                    break;
                }

                case "3": {
                    System.out.println("Введіть к-сть днів (28, 30 або 31) : ");
                    scan = new Scanner(System.in);
                    int day = scan.nextInt();

                    boolean flag = false;

                    for (Months m : months) {
                        if (m.getDays() == day) {
                            flag = true;
                        }
                    }
                    if (flag) {

                        for (Months mon : months) {
                            if (mon.getDays() == day) {
                                System.out.println(mon);
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("Вказана не вірна к-сть днів. Доступні значення 28, 30, 31");
                    }
                    break;

                }

                case "4": {

                    System.out.println("Введіть к-сть днів (28, 30  або 31) : ");
                    scan = new Scanner(System.in);
                    int day = scan.nextInt();

                    boolean flag = false;

                    for (Months m : months) {
                        if (m.getDays() == day) {
                            flag = true;
                        }
                    }

                    if (flag) {

                        for (Months mon : months) {
                            if (mon.getDays() > day) {
                                System.out.println(mon);
                            }
                        }
                    }

                    if (!flag) {
                        System.out.println("Вказана не вірна к-сть днів. Доступні значення 28, 30, 31");
                    }
                    break;
                }

                case "5": {

                    System.out.println("Введіть к-сть днів ( 28, 30 або 31) : ");
                    scan = new Scanner(System.in);
                    int day = scan.nextInt();

                    boolean flag = false;

                    for (Months m : months) {
                        if (m.getDays() == day) {
                            flag = true;
                        }
                    }

                    if (flag) {

                        for (Months mon : months) {
                            if (mon.getDays() < day) {
                                System.out.println(mon);
                            }
                        }
                    }

                    if (!flag) {
                        System.out.println("Вказана не вірна к-сть днів. Доступні значення 28, 30, 31");
                    }
                    break;
                }

                case "6":{

                    System.out.println("Введіть пору року : ");
                    scan = new Scanner(System.in);
                    String season = scan.next().toUpperCase();

                    boolean flag = isSeasonsPresent(seasons, season);

                    if(flag){
                        Seasons s = Seasons.valueOf(season);
                        int ordinal = s.ordinal();

                        if( ordinal == (seasons.length -1)){
                            ordinal = 0;
                            System.out.println(seasons[ordinal]);
                        } else {
                            System.out.println(seasons[ordinal + 1]);
                        }
                    }

                    if (!flag) {
                        System.out.println("Такої пори року не існує");
                    }
                    break;
                }

                case "7":{

                    System.out.println("Введіть пору року: ");
                    scan = new Scanner(System.in);
                    String season = scan.next().toUpperCase();

                    boolean flag = isSeasonsPresent(seasons, season);

                    if(flag){
                        Seasons s = Seasons.valueOf(season);
                        int ordinal = s.ordinal();

                        if( ordinal == (seasons.length + 1)){
                            ordinal = 1;
                            System.out.println(seasons[ordinal]);
                        }
                        else {
                            System.out.println(seasons[ordinal - 1]);
                        }
                    }

                    if (!flag) {
                        System.out.println("Такої пори року не існує");
                    }
                    break;
                }

                case "8": {

                    for (Months m : months) {
                        if (m.getDays() % 2 == 0) {
                            System.out.println(m);
                        }
                    }
                    break;
                }

                case "9": {

                    for (Months mon : months) {
                        if (mon.getDays() % 2 == 1) {
                            System.out.println(mon);
                        }
                    }
                    break;
                }
                case "10": {

                    System.out.println("Введіть місяць: ");
                    scan = new Scanner(System.in);
                    String month = scan.next().toUpperCase();

                    boolean flag = false;

                    for (Months m : months) {
                        if (m.name().equals(month)) {
                            flag = true;
                        }
                    }

                    if (flag) {
                            Months m = Months.valueOf(month);
                            if(m.getDays() % 2 == 0){
                                System.out.println("ВВедений місяць має парну к-сть днів");
                            }
                    }

                    if (!flag) {
                        System.out.println("Введений місяць має не парну к-сть днів");
                    }
                    break;
                }
            }
        }

    }

    private static boolean isMonthPresent(Months[] months, String month) {
        boolean flag = false;

        for (Months m : months) {
            if (m.name().equals(month)) {
                System.out.println("Місяць існує");
                flag = true;
            }
        }

        return flag;
    }

    private static  boolean isSeasonsPresent(Seasons[] seasons, String season){
        boolean flag = false;

        for (Seasons seas : seasons) {
            if (seas.name().equals(season)) {
                flag = true;
            }
        }
        return flag;
    }



}
