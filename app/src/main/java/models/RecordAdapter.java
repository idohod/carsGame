package models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsgame.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import interfaces.RecordCallback;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private Context context;

    private ArrayList<Record> recordsList;
    private RecordCallback recordCallback;

    public RecordAdapter(Context context,ArrayList<Record> recordsList) {

        this.context = context;
        this.recordsList = recordsList;
    }
    public void setRecordCallback(RecordCallback recordCallback) {
        this.recordCallback = recordCallback;
    }
    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.record_item,parent,false);
    return new RecordViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record record = recordsList.get(position);
        holder.theScore.setText(""+record.getScore());
        if (recordsList.get(0)==recordsList.get(position)){
           holder.textScore.setText("best score: ");
        }
        else if (recordsList.get(1)==recordsList.get(position)){
            holder.textScore.setText("2nd score: ");
        }
        else{
            holder.textScore.setText((position+1)+"th score: ");
        }
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }
    private Record getItem(int position) {
        return this.recordsList.get(position);
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {


        public MaterialTextView textScore;
        public MaterialTextView theScore;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            textScore = itemView.findViewById(R.id.text_score);
            theScore = itemView.findViewById(R.id.the_score);
        }
    }
}
