public class Hotel {
    private String name;
    private int rating;
    private int rateForRegularCustomer;
    private int rateForRewardCustomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRateForRegularCustomer() {
        return rateForRegularCustomer;
    }

    public void setRateForRegularCustomer(int rateForRegularCustomer) {
        this.rateForRegularCustomer = rateForRegularCustomer;
    }

    public int getRateForRewardCustomer() {
        return rateForRewardCustomer;
    }

    public void setRateForRewardCustomer(int rateForRewardCustomer) {
        this.rateForRewardCustomer = rateForRewardCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", rateForRegularCustomer=" + rateForRegularCustomer +
                ", rateForRewardCustomer=" + rateForRewardCustomer +
                '}';
    }
}
