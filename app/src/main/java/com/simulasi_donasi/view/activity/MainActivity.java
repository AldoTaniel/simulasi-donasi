package com.simulasi_donasi.view.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.Data;
import com.simulasi_donasi.model.entity.User;
import com.simulasi_donasi.model.session.SessionManager;
import com.simulasi_donasi.view.fragment.user.UserASC;

public class MainActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User.users.clear();
        Data.datas.clear();
        User a = new User("STMIK - Mikroskil Medan", "a@mobile.id", "password");
        User b = new User("Kampus A", "b@mobile.id", "password");
        User c = new User("Kampus B", "c@mobile.id", "password");
        User d = new User("Kampus C", "d@mobile.id", "password");
        User e = new User("Kampus D - Thamrin Plaza", "e@mobile.id", "password");
        User f = new User("f", "f@mobile.id", "password");
        User g = new User("g", "g@mobile.id", "password");
        User h = new User("h", "h@mobile.id", "password");
        User i = new User("i", "i@mobile.id", "password");
        User j = new User("j", "j@mobile.id", "password");
        User k = new User("k", "k@mobile.id", "password");
        User l = new User("l", "l@mobile.id", "password");
        User.users.add(a);
        User.users.add(b);
        User.users.add(c);
        User.users.add(d);
        User.users.add(e);
        User.users.add(f);
        User.users.add(g);
        User.users.add(h);
        User.users.add(i);
        User.users.add(j);
        User.users.add(k);
        User.users.add(l);

        Data da = new Data("Sumbangan untuk korban gempa bumi","blablablablablablablablablabla",10000000);
        da.setImg(R.drawable.gempa);
        Data db = new Data("Sumbangan untuk korban banjir","blablablablablablablabla",15000000);
        db.setImg(R.drawable.banjir);
        Data dc = new Data("Sumbangan untuk korban tsunami","blablablablablablabla",25000000);
        dc.setImg(R.drawable.tsunami);
        Data dd = new Data("Sumbangan untuk korban gempa bumi","blablablablablablablablablabla",10000000);
        dd.setImg(R.drawable.gempa);
        Data de = new Data("Sumbangan untuk korban banjir","blablablablablablablabla",15000000);
        de.setImg(R.drawable.banjir);
        Data df = new Data("Sumbangan untuk korban tsunami","blablablablablablabla",25000000);
        df.setImg(R.drawable.tsunami);
        Data dg = new Data("Sumbangan untuk korban gempa bumi","blablablablablablablablablabla",10000000);
        dg.setImg(R.drawable.gempa);
        Data dh = new Data("Sumbangan untuk korban banjir","blablablablablablablabla",15000000);
        dh.setImg(R.drawable.banjir);
        Data di = new Data("Sumbangan untuk korban tsunami","blablablablablablabla",25000000);
        di.setImg(R.drawable.tsunami);
        Data.datas.add(da);
        Data.datas.add(db);
        Data.datas.add(dc);
        Data.datas.add(dd);
        Data.datas.add(de);
        Data.datas.add(df);
        Data.datas.add(dg);
        Data.datas.add(dh);
        Data.datas.add(di);

             /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), AuthActivity.class);
        }

        this.changefragment(new UserASC());
        this.setTitle("User");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                SessionManager.with(getApplicationContext()).clearsession();
                ParentActivity.doChangeActivity(getApplicationContext(), AuthActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void changefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).commit();
    }
}
