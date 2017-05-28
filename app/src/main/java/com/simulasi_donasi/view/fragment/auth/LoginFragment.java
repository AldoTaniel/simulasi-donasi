package com.simulasi_donasi.view.fragment.auth;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.User;
import com.simulasi_donasi.model.session.SessionManager;
import com.simulasi_donasi.view.activity.AuthActivity;
import com.simulasi_donasi.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    /* view component */
    private TextView register;
    private EditText email, password;
    private Button login;
    private TextInputLayout emailcontainer, passwordcontainer;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_login, container, false);

        init(_view);
        event();

        return _view;
    }

    private void init(View view) {
        register = (TextView) view.findViewById(R.id.login_register);
        email = (EditText) view.findViewById(R.id.login_email);
        password = (EditText) view.findViewById(R.id.login_password);
        login = (Button) view.findViewById(R.id.login_login);
        emailcontainer = (TextInputLayout) view.findViewById(R.id.login_email_container);
        passwordcontainer = (TextInputLayout) view.findViewById(R.id.login_password_container);
    }

    private void event() {

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AuthActivity) getActivity()).changefragment(new RegisterFragment());
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean _isvalid = true;
                emailcontainer.setErrorEnabled(false);
                passwordcontainer.setErrorEnabled(false);

                /*
                * checking data validation
                * front-end
                */
                if (TextUtils.isEmpty(email.getText())) {
                    _isvalid = false;
                    emailcontainer.setErrorEnabled(true);
                    emailcontainer.setError("Email is required");
                } else if (!AuthActivity.isemailvalid(email.getText().toString())) {
                    _isvalid = false;
                    emailcontainer.setErrorEnabled(true);
                    emailcontainer.setError("Email is not valid");
                } else if (TextUtils.isEmpty(password.getText())) {
                    _isvalid = false;
                    passwordcontainer.setErrorEnabled(true);
                    passwordcontainer.setError("Password is required");
                }

                /*
                * check the account
                * back-end
                */
                if (_isvalid) {
                    Boolean _isregistered = false, _ismatch = false;
                    User _user = new User();
                    for (User item : User.users) {
                        if (item.getEmail().equals(email.getText().toString())) {
                            if (item.getPassword().equals(password.getText().toString())) {
                                _ismatch = true;
                                _user = item;
                            }
                            _isregistered = true;
                            break;
                        }
                    }

                    if (!_isregistered) {
                        emailcontainer.setErrorEnabled(true);
                        emailcontainer.setError("Email is not registered as a user.");
                    } else if (!_ismatch) {
                        passwordcontainer.setErrorEnabled(true);
                        passwordcontainer.setError("Password is wrong.");
                    }

                    if (_isregistered && _ismatch) {
                        SessionManager.with(getContext()).createsession(_user);
                        ((AuthActivity) getActivity()).doChangeActivity(getContext(), MainActivity.class);
                    }
                }
            }
        });
    }

}
