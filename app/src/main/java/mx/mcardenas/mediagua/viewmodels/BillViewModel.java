package mx.mcardenas.mediagua.viewmodels;

import androidx.databinding.BaseObservable;

public class BillViewModel extends BaseObservable {
    protected float metersConsumed;
    protected float reciptPrice;
    protected String currentRange;
    protected String currentFee;


    public BillViewModel() {
        this.metersConsumed = 120f;
        this.reciptPrice = 200000f;
        this.currentRange = "Excedente";
        this.currentFee = "Domestica A";
    }

    public BillViewModel(float metersConsumed, float reciptPrice, String currentRange, String currentFee) {
        this.metersConsumed = metersConsumed;
        this.reciptPrice = reciptPrice;
        this.currentRange = currentRange;
        this.currentFee = currentFee;
    }

    public float getMetersConsumed() {
        return metersConsumed;
    }

    public void setMetersConsumed(float metersConsumed) {
        this.metersConsumed = metersConsumed;
    }

    public float getReciptPrice() {
        return reciptPrice;
    }

    public void setReciptPrice(float reciptPrice) {
        this.reciptPrice = reciptPrice;
    }

    public String getCurrentRange() {
        return currentRange;
    }

    public void setCurrentRange(String currentRange) {
        this.currentRange = currentRange;
    }

    public String getCurrentFee() {
        return currentFee;
    }

    public void setCurrentFee(String currentFee) {
        this.currentFee = currentFee;
    }
}
