package temple.edu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter<T> extends BaseAdapter
{
    private Context context; //context
    private ArrayList<String> items; //data source of the list adapter
    LayoutInflater inflter;

    //public constructor
    public ColorAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        final TextView textview = new TextView(context);

        textview.setPadding(5,5,5, 5);
        textview.setText(getItem(position).toString());
        textview.setHeight(500);
        textview.setGravity(Gravity.CENTER);
        if(position != 0) {
            textview.setBackgroundColor(Color.parseColor(items.get(position)));

        }

        if(position != 0 && items.get(position).equals("BLACK")){
            textview.setTextColor(Color.LTGRAY);
        }

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = items.get(position);
                Intent x = new Intent(view.getContext(), CanvasActivity.class);
                x.putExtra("id", item);
                context.startActivity(x);
            }
        });
        // returns the view for the current row
        return textview;
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }


}