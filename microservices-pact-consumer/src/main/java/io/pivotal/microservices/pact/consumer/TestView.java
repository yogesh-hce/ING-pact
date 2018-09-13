package io.pivotal.microservices.pact.consumer;

public class TestView {

    private int value;

    public TestView() {
    }

    public TestView(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
        if (o == null || getClass() != o.getClass()) {
			return false;
		}

        TestView testView = (TestView) o;

        if (this.value != testView.value) {
			return false;
		}

        return true;
    }



    @Override
	public String toString() {
		return "TestView [value=" + this.value + "]";
	}

	@Override
    public int hashCode() {
        return this.value;
    }
}
