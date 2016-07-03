package demo2_testhelpers;

public class SampleImpl implements Sample {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void setOtherSample(final Sample sample) {
    }
}
