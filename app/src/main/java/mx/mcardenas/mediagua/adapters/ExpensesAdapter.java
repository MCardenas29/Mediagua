package mx.mcardenas.mediagua.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.mcardenas.mediagua.databinding.LayoutItemExpensesBinding;
import mx.mcardenas.mediagua.models.ExpenseModel;
import mx.mcardenas.mediagua.viewmodels.ExpensesViewModel;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder> {
    private ArrayList<ExpenseModel> expenses;

    public ExpensesAdapter(ArrayList<ExpenseModel> expenses) {
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public ExpensesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ExpensesViewHolder(LayoutItemExpensesBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesViewHolder holder, int position) {
        holder.bindModel(expenses.get(position));
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ExpensesViewHolder extends RecyclerView.ViewHolder {
        LayoutItemExpensesBinding binding;

        public ExpensesViewHolder(@NonNull LayoutItemExpensesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindModel(ExpenseModel model) {
            binding.setExpenseViewModel(new ExpensesViewModel(model.consumptionName, model.expense, model.minutes, model.metersConsumed));
        }
    }
}
