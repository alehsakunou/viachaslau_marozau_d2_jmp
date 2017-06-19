package com.epam.jmp.threads.beans;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Car extends Thread
{

        private static final long MAX_DISTANCE = 10000;
        Logger log = Logger.getLogger(String.valueOf(this.getClass()));
        private long friction;
        private long distance;
        private String name;


        public Car(String name, long friction)
        {
            this.name = name;
            this.friction = friction;
        }

        @Override
        public void run()
        {
            try
            {
                while (distance < MAX_DISTANCE)
                {
                    Thread.sleep(friction);
                    if(isInterrupted()){
                        log.log(Level.INFO, String.format("%s: disqualified",name));
                        break;
                    }
                        distance += 100;
                        log.log(Level.INFO, String.format("%s: %s",name , distance));
                }
                log.log(Level.INFO, String.format("%s: finished",name));
            }
            catch (InterruptedException e)
            {
                log.log(Level.WARNING, e.getMessage());
            }
        }
}
