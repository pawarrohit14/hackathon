package info.androidhive.navigationdrawer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.json.BackoutRec;

/**
 * Created by Rohit Pawar on 18-01-2018.
 */

public class BackoutListAdapter extends RecyclerView.Adapter<BackoutListAdapter.MyViewHolder> {

    public BackoutListAdapter.UpdateList updateList;
    private Context context;
    private String username;
    private List<BackoutRec> backoutRecs;
    private LayoutInflater inflater;


    public BackoutListAdapter(Context context, String userName, List<BackoutRec> backoutRecs) {

        this.context = context;
        this.username = userName;
        this.backoutRecs = backoutRecs;
    }

    @Override
    public BackoutListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.backout_list_row, parent, false);

        return new BackoutListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BackoutListAdapter.MyViewHolder holder, final int i) {


        holder.tvName.setText(backoutRecs.get(i).getInterfaceName());
        holder.tvType.setText(backoutRecs.get(i).getInterfaceType());
        holder.tvSubType.setText(backoutRecs.get(i).getInterfaceSubType());
        holder.tvInternalId.setText(backoutRecs.get(i).getInternalID());

    }

    @Override
    public int getItemCount() {
        return backoutRecs.size();
    }


    public interface UpdateList {
        void update();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvType, tvSubType, tvInternalId;

        public MyViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tv_name);
            tvType = view.findViewById(R.id.tv_type);
            tvSubType = view.findViewById(R.id.tv_subtype);
            tvInternalId = view.findViewById(R.id.tv_internalid);
        }
    }


  /*  public BackoutListAdapter(Context context, Cursor cursor) {
        super(context, cursor , 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.backout_list_row, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);
        TextView tvSubType = (TextView) view.findViewById(R.id.tv_subtype);
        TextView tvInternalId = (TextView) view.findViewById(R.id.tv_internalid);

        // Extract properties from cursor
        String  str_Name = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
        String  str_Type = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
        String  str_SubType = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3)));
        String str_Internal = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(4)));


        tvName.setText(str_Name);
        tvType.setText(str_Type);
        tvSubType.setText(str_SubType);
        tvInternalId.setText(str_Internal);

    }

    @Override
    protected void onContentChanged() {
        // TODO Auto-generated method stub
        super.onContentChanged();
        notifyDataSetChanged();
    }*/

}
