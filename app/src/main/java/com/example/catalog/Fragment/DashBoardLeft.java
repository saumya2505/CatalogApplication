package com.example.catalog.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalog.Activity.BasicActivity;
import com.example.catalog.Activity.MainActivity;
import com.example.catalog.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardLeft extends Fragment {
    static SharedPreferences sharedPreferencesAppTheme;
    public static final String myPreferenceAppTheme="myprefAppTheme";
    TextView TVeditProfile,TVlogout,TVaddStore,TVviewStore,TVaddRole,TVviewRole,TVaddAppTheme;
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";


    public DashBoardLeft() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dash_board_left, container, false);

        sharedPreferences=getActivity().getSharedPreferences(myPreference,getActivity().MODE_PRIVATE);
        final SharedPreferences.Editor editor1=sharedPreferences.edit();

        sharedPreferencesAppTheme = getActivity().getSharedPreferences(myPreferenceAppTheme, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor= sharedPreferencesAppTheme.edit();
        String appThemeFontColorLight = sharedPreferencesAppTheme.getString("appThemeFontColorLight", "");
        String appThemeFontColorDark = sharedPreferencesAppTheme.getString("appThemeFontColorDark", "");

        view.setBackgroundColor(Color.parseColor(appThemeFontColorLight));
        TVeditProfile=view.findViewById(R.id.TVeditProfile);
        TVlogout=view.findViewById(R.id.TVlogout);
        TVaddStore=view.findViewById(R.id.TVaddStore);
        TVaddStore.setTextColor(Color.parseColor(appThemeFontColorDark));
        TVeditProfile.setTextColor(Color.parseColor(appThemeFontColorDark));
        TVlogout.setTextColor(Color.parseColor(appThemeFontColorDark));
        TVviewStore=view.findViewById(R.id.TVviewStore);
        TVaddRole=view.findViewById(R.id.TVaddRole);
        TVaddAppTheme=view.findViewById(R.id.TVaddAppTheme);
        TVviewRole=view.findViewById(R.id.TVviewRole);
        TVeditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "1");
                startActivity(intent);
            }
        });
        TVlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                editor1.putString("username","");
                editor.commit();
                startActivity(intent);
                Toast.makeText(getActivity(),"Logged Out",Toast.LENGTH_SHORT).show();
            }
        });
        TVaddStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "2");
                startActivity(intent);
            }
        });
        TVviewStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "3");
                startActivity(intent);
            }
        });
        TVaddRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "4");
                startActivity(intent);
            }
        });
        TVviewRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "5");
                startActivity(intent);
            }
        });
        TVaddAppTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), BasicActivity.class);
                intent.putExtra("value", "6");
                startActivity(intent);
            }
        });




        return view;
    }

}
