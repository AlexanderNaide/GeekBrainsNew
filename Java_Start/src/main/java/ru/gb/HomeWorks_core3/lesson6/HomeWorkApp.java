package ru.gb.HomeWorks_core3.lesson6;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
//import java.util.logging.Logger;

public class HomeWorkApp {
//    private static final Logger logger = Logger.getLogger("");
    private static final Logger logger = LogManager.getLogger(HomeWorkApp.class);
    public static void main(String[] args) {
/*        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.log(Level.INFO, "Connection");
        logger.setLevel(Level.WARNING);*/


        logger.info("Info");

        if(logger.isDebugEnabled()) {
            logger.debug("Debug");
        }

        logger.info("Info message {}", "(Insert message)");
        logger.warn("Warning");
        logger.error("Error");


        HomeWork6 homeWork6 = new HomeWork6();
        Integer[] integers = homeWork6.arrayAfterFour(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        System.out.println(Arrays.toString(integers));

        System.out.println(homeWork6.containsOneAndFour(new Integer[]{1, 1, 4, 4, 1, 4, 4, 1, 4}));
        System.out.println(homeWork6.containsOneAndFour(new Integer[]{1, 1}));
        System.out.println(homeWork6.containsOneAndFour(new Integer[]{4, 4}));
        System.out.println(homeWork6.containsOneAndFour(new Integer[]{4, 1, 7}));

    }
}
