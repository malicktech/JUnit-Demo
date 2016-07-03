package demo2_testhelpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;


public abstract class Parent {

    /**
     * Logger for this class
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(Parent.class);

    public void doesStuff() {

        LOGGER.debug("doesStuff() - start");

        Date date = Calendar.getInstance().getTime();

        LOGGER.debug("doesStuff() - end");
    }
}
