package com.example.psikhe;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Dashbrd extends AppCompatActivity {

    AdapterViewFlipper adapterViewFlipper;

    int[] IMAGES = {
            R.drawable.blue,
            R.drawable.circle
    };

    String[] NAMES = {
            "Butterfly",
            "Circle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbrd);

        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.flip);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), NAMES, IMAGES);

        adapterViewFlipper.setAdapter(customAdapter);
        adapterViewFlipper.setFlipInterval(2600);
        adapterViewFlipper.setAutoStart(true);

    }
}

class CustomAdapter extends BaseAdapter {
    Context context;
    int[] images;
    String[] names;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, String[] names, int[] images) {
        this.context = applicationContext;
        this.images = images;
        this.names = names;
        inflater = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_view, null);
        TextView name = (TextView) view.findViewById(R.id.name);
        ImageView image = (ImageView) view.findViewById(R.id.imangelist);
        name.setText(names[position]);
        image.setImageResource(images[position]);
        return view;

    }
}