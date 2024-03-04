package mx.mcardenas.mediagua.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;

import mx.mcardenas.mediagua.BR;


public class ToolbarViewModel extends BaseObservable {
    protected String title;
    protected int notifCount;

    public ToolbarViewModel(String title, int notifCount) {
        this.title = title;
        this.notifCount = notifCount;
    }

    public ToolbarViewModel(String title) {
        this.title = title;
        this.notifCount = 0;
    }

    @Bindable
    public int getNotifCount() {
        return notifCount;
    }

    public void setNotifCount(int notifCount) {
        if (this.notifCount == notifCount)
            return;
        this.notifCount = notifCount;
        notifyPropertyChanged(BR.notifCount);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (this.title.equals(title))
            return;
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
