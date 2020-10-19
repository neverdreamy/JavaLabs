public class Formula {
    private Double sum;
    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {
        return Math.pow(2*Math.log(1+z)+Math.cos(3.14*Math.pow(y,3)),0.25)/(Math.pow(Math.cos(Math.exp(x))+Math.pow(1/x,0.5)+Math.exp(Math.pow(x,2)),Math.sin(x)));
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(Math.sin(Math.pow(z,y)),2)/Math.pow(1+Math.pow(x,3),0.5);
    }
    //Получение доступа к приватному полю sum
    public Double Get() {
        return sum;
    }
    public void Set(Double x) {
        sum = x;
    }
    //Прибавление результата к сумме
    public void Sum(Double result) {
        sum += result;
    }
    //Конструктор по умолчанию
    public Formula() {
        sum = 0.0;
    }
}
