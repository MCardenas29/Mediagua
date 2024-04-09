package mx.mcardenas.mediagua.viewmodels;

import androidx.databinding.BaseObservable;

import java.util.Locale;

public class ExpensesViewModel extends BaseObservable {
    protected String consumptionName;
    protected float expense;
    protected long minutes;
    protected int metersConsumed;

    public ExpensesViewModel(String consumptionName, float expense, long minutes, int metersConsumed) {
        this.consumptionName = consumptionName;
        this.expense = expense;
        this.minutes = minutes;
        this.metersConsumed = metersConsumed;
    }

    public String getConsumptionName() {
        return consumptionName;
    }

    public void setConsumptionName(String consumptionName) {
        this.consumptionName = consumptionName;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public String getTime() {
        float hours = getMinutes() / 60f;
        return String.format(Locale.getDefault(), "%.2f", hours);
    }

    public int getMetersConsumed() {
        return metersConsumed;
    }

    public void setMetersConsumed(int metersConsumed) {
        this.metersConsumed = metersConsumed;
    }
}
