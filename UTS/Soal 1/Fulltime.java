class Fulltime extends Employee implements Koperasi {
    private int loanAmount;

    public Fulltime(String name, int id, int loanAmount) {
        super(name, id);
        this.loanAmount = loanAmount;
    }

    @Override
    public double loanMonthly() {
        return loanAmount / 12;
    }
}
