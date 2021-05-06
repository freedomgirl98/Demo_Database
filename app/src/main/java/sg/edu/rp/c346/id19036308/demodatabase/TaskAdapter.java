package sg.edu.rp.c346.id19036308.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvID, tvDate, tvDesc;

    public TaskAdapter(Context context, int resource,  ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the task that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);

        Task currentTask = task.get(position);
//        task.add(new Task(currentTask.getId(), currentTask.getDescription(), currentTask.getDate()));

        tvID.setText(currentTask.getId()+"");
        tvDesc.setText(currentTask.getDate());
        tvDate.setText(currentTask.getDescription());

        return rowView;
    }
}
