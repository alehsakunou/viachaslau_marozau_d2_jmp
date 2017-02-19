package com.epam.jmp.troubleshooting.impl;

import com.epam.jmp.troubleshooting.interfaces.ReadWriteResource;

/**
 * Created by Viachaslau_Marozau on 2/19/2017.
 */
public class SimpleReadWriteThread extends Thread
{
    ReadWriteResource readRecourse;
    ReadWriteResource writeResource;

    public SimpleReadWriteThread(String threadName, ReadWriteResource readRecourse,
        ReadWriteResource writeResource)
    {
        super(threadName);
        this.readRecourse = readRecourse;
        this.writeResource = writeResource;
    }

    @Override
    public void run()
    {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " started");
        synchronized (readRecourse)
        {
            System.out.println(threadName + " locked resource " + readRecourse);

            byte[] data = readRecourse.read();

            System.out.println(threadName + " read data from resource " + readRecourse);
            System.out.println(threadName + " sleep");

            try
            {
                final long timeToSleap = 5000L;
                Thread.sleep(timeToSleap);
            }
            catch (InterruptedException e)
            {
                System.out.println(threadName + " interrupted");
            }
            System.out.println(threadName + " awaken");

            synchronized (writeResource)
            {
                System.out.println(threadName + " locked resource " + writeResource);
                System.out.println(threadName + " write data to resource " + writeResource);

                writeResource.write(data);
            }
            System.out.println(threadName + " unlocked resource " + writeResource);
        }
        System.out.println(threadName + " unlocked resource " + readRecourse);

        System.out.println(threadName + " ended");
    }
}
