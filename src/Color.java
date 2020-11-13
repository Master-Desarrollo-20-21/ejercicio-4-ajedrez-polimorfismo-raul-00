enum Color {
    WHITE("blancas"), BLACK("negras");

    private String value;

    Color(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
