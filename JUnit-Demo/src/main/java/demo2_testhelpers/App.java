package demo2_testhelpers;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class App implements Serializable, Comparable<App> {
    
	private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final long serialVersionUID = 1L;
    private String field;

    public App(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("field", getField()).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(field);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        App other = (App) obj;
        return Objects.equal(getField(), other.getField());
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public int compareTo(App obj) {
        return ComparisonChain.start().compare(field, obj.getField()).result();
    }
}
