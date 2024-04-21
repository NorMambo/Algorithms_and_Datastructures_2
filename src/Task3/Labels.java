package Task3;

public enum Labels {
    LEFT("Left Child"),
    RIGHT("Right Sibling"),
    ROOT("Root");
    String status;
    Labels(final String status) {
        this.status = status;
    }
}
