/*
    Copyright © 2018 OwlCodR
    https://github.com/OwlCodR
*/

package com.economic.economic;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class FragmentDevelopers extends Fragment {
    View myInflateView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myInflateView = View.inflate(getActivity(), R.layout.fragment_developers, null);

        TextView textViewInfo = (TextView) myInflateView.findViewById(R.id.textViewInfo);

        Spannable word = new SpannableString(getResources().getString(R.string.app_name));
        word.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewInfo.setText(word);
        textViewInfo.append(" ");
        textViewInfo.append(getResources().getString(R.string.info));

        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }

        return myInflateView;
    }
}
