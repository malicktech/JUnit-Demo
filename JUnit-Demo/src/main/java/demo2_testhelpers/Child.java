package demo2_testhelpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;


public class Child extends Parent {

    private final static Logger LOGGER = LoggerFactory.getLogger(Child.class);

    public void moreStuff() {

        LOGGER.debug("moreStuff() - start");

        Date date = Calendar.getInstance().getTime();
        LOGGER.error("bad thing", new RuntimeException("broken"));
        doesStuff();
        LOGGER.debug("moreStuff() - end");
    }
}
