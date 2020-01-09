package com.example.east2online;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
//适配器，传入名字和信息
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<message> messagelist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView message;
        View messageview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageview=itemView;
            message=(TextView) itemView.findViewById(R.id.message_T2);
        }
    }
    public MessageAdapter(List<message> Messagelist){
        messagelist=Messagelist;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message,parent,false);
        final ViewHolder holder=new ViewHolder(view);
       final Context mcontext=parent.getContext();
        holder.messageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=holder.getAdapterPosition();
                message mess=messagelist.get(position);
                String name=mess.getName();
                String message=mess.getMessage();
                Intent starter = new Intent(mcontext, DetailActivity.class);
                starter.putExtra("name",name);
                starter.putExtra("message",message);
                mcontext.startActivity(starter);
                return true;
            }
        });
        return holder;
    }

    @Override
   public void  onBindViewHolder(final ViewHolder holder, int posistion){
        message mess =messagelist.get(posistion);
        holder.message.setText(mess.getMessage());

    }

    @Override
    public int getItemCount() {
        return messagelist.size();
    }


}

