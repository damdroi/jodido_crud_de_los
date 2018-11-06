package com.example.yo.pgl_rgc_tabs_fragments_try_03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POSITION = "position";

    // TODO: Rename and change types of parameters
    private int mPosition;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position Parameter about position Day Tabs.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(int position) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textViewFragmento = (TextView) view.findViewById(R.id.textViewFragmento);

        Button button = view.findViewById(R.id.button);
        button.setTag(mPosition);
        //button.setText(""+mPosition);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numFragmento = (Integer) view.getTag();
                callActivity(numFragmento);
            }
        });

        switch (mPosition) {
            case 0:
                textViewFragmento.setText("Country");
                button.setText("GO to Country ");
                break;
            case 1:
                textViewFragmento.setText("Agreement");
                button.setText("GO to Agreement ");
                break;
            case 2:
                textViewFragmento.setText("Profile");
                button.setText("GO to Profile ");
                break;
            case 3:
                textViewFragmento.setText("Employee");
                button.setText("GO to Employee ");
                break;
            case 4:
                textViewFragmento.setText("Payroll");
                button.setText("GO to Payroll ");
                break;
        }

        return view;

        //return inflater.inflate(R.layout.fragment_main, container, false);
    }



    public boolean callActivity(int parameter) {

        Intent intent;

        switch (parameter) {
            case 0:
                intent = new Intent(getActivity(), CountryActivity.class);
                startActivity(intent);
                return true;
            case 1:
                intent = new Intent(getActivity(), AgreementActivity.class);
                startActivity(intent);
                return true;
            case 2:
                intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                return true;
            case 3:
                intent = new Intent(getActivity(), EmployeeActivity.class);
                startActivity(intent);
                return true;
            case 4:
                intent = new Intent(getActivity(), PayrollActivity.class);
                startActivity(intent);
                return true;
        }

        return false;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }





















/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
