package mx.mcardenas.mediagua.models;

public class ExpenseModel {
    public String consumptionName;
    public float expense;
    public long minutes;
    public int metersConsumed;

    public ExpenseModel(String consumptionName, float expense, long minutes, int metersConsumed) {
        this.consumptionName = consumptionName;
        this.expense = expense;
        this.minutes = minutes;
        this.metersConsumed = metersConsumed;
    }
}
