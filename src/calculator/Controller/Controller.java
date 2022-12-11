package calculator.Controller;

public class Controller {
    private double results;
    //Getter and setters
    public double getResults() {
        return results;
    }
    public void setResults(double results) {
        this.results = results;
    }

    public String percentageOf(int x){
        setResults((double) x/100);
        return String.valueOf(getResults());
    }

    public String squareRoot(int num){
        setResults((double) Math.sqrt(num));
        return String.valueOf(results);
    }

    public String Reciprocal(int num){
        setResults((double) 1/num);
        return String.valueOf(getResults());
    }

}
