package com.team41.boromi.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.team41.boromi.R;

/**
 * A simple {@link Fragment} subclass. Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  public WelcomeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment WelcomeFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static WelcomeFragment newInstance(String param1, String param2) {
    WelcomeFragment fragment = new WelcomeFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_welcome, container, false);
    Button login = (Button) view.findViewById(R.id.go_login);
    Button signup = (Button) view.findViewById(R.id.go_signup);
    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Fragment loginFragment = new LoginFragment();
        FragmentManager manager = getFragmentManager();
        assert manager != null;
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.auth_fragment, loginFragment).addToBackStack("login").commit();
      }
    });
    signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Fragment signupFragment = new SignupFragment();
        FragmentManager manager = getFragmentManager();
        assert manager != null;
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.auth_fragment, signupFragment).addToBackStack("signup").commit();
      }
    });
    return view;
  }

}