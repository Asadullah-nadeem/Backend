package in.codeaxe.apiapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterR extends RecyclerView.Adapter<AdapterR.MyHolder> {

    private Context context;
    private ArrayList<list> empPojos;

    public AdapterR(Context context, ArrayList<list> empPojos) {
        this.context = context;
        this.empPojos = empPojos;
    }

    public void setEmpPojos(ArrayList<list> empPojos) {
        this.empPojos = empPojos;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        list item = empPojos.get(position);
        holder.i.setText(String.valueOf(item.getId()));  // Set ID
        holder.f.setText(item.getFirst_name());
        holder.l.setText(item.getLast_name());
        holder.e.setText(item.getEmail());
        holder.g.setText(item.getGender());
    }

    @Override
    public int getItemCount() {
        return empPojos.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView i, f, l, e, g;

        public MyHolder(@NonNull View view) {
            super(view);
            i = view.findViewById(R.id.id);
            f = view.findViewById(R.id.FN);
            l = view.findViewById(R.id.LN);
            e = view.findViewById(R.id.Email);
            g = view.findViewById(R.id.gender);
        }
    }
}