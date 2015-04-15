package materialtest.nox.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by NOX on 05/04/2015.
 */
public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    List <Information> data= Collections.emptyList();
    private  ClickListener clickListener;

    public MyAdapter(Context context, List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row, parent, false);
        //Log.d("MMcH", "onCreateHolder called");
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        //Log.d("MMcH", "onBindViewHolder called"+position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, SubActivity.class));
        }
    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
