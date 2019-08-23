package com.example.catalog.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catalog.Activity.ColorPicker;
import com.example.catalog.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAppTheme extends Fragment {
    TextView TVColPriDark,TVcolPri,TVcolorEmphasis,TVfontDark,TvfontLight;


    public AddAppTheme() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_app_theme, container, false);

        TVColPriDark=view.findViewById(R.id.TVcolPriDarkFill);
        TVcolPri=view.findViewById(R.id.TVcolPriFill);
        TVcolorEmphasis=view.findViewById(R.id.TVcolEmphasisFill);
        TVfontDark=view.findViewById(R.id.TVcolFontDarkFill);
        TvfontLight=view.findViewById(R.id.TVcolFontLightFill);
        TVColPriDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ColorPicker.class);
                startActivity(intent);
            }
        });
        TVcolPri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ColorPicker.class);
                startActivity(intent);
            }
        });
        TVcolorEmphasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ColorPicker.class);
                startActivity(intent);
            }
        });
        TVfontDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ColorPicker.class);
                startActivity(intent);
            }
        });
        TvfontLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ColorPicker.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
