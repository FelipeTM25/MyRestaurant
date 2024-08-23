package com.upb.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void renderWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView tvTitle = view.findViewById(R.id.title);

        if (title != null && !title.equals("")) {
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = view.findViewById(R.id.snippet);

        if (snippet != null && !snippet.equals("")) {
            tvSnippet.setText(snippet);
        }

        ImageView imageView = view.findViewById(R.id.image);
        // Set the image based on the title or some other logic
        switch (title) {
            case "Sede Laureles":
                imageView.setImageResource(R.drawable.laureles_image);
                break;
            case "Sede Poblado":
                imageView.setImageResource(R.drawable.poblado_image);
                break;
            case "Sede Centro":
                imageView.setImageResource(R.drawable.centro_image);
                break;
            case "Sede Belen":
                imageView.setImageResource(R.drawable.belen_image);
                break;
            default:
                imageView.setImageResource(R.drawable.default_image);
                break;
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
