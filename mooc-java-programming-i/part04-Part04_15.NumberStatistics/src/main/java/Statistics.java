
public class Statistics {

    private int count;
    private int sum;

    public Statistics() {
        // initialize the variable numberCount here
        this.count = 0;
        this.sum = 0;
    }

    public void addNumber(int number) {
        // write code here
        this.count = count + 1;
        this.sum = this.sum + number;
    }

    public int getCount() {
        // write code here
        return this.count;
    }

    public int sum() {
        return this.sum;
    }

    public double average() {
        double avg = 0;
        if (this.count > 0) {
            avg = (double) this.sum / this.count;
        }
        return avg;
    }
}
