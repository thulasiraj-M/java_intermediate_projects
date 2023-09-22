package com.recharge.nirbhay.rechargewallete.fragmetsclass;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.StaupActivity;
import com.recharge.nirbhay.rechargewallete.globalobject.Globaldata;
import com.recharge.nirbhay.rechargewallete.httpservice.CustomHttpClient;

import org.json.JSONObject;

/**
 * Created by Rakesh on 12/16/2016.
 */

public class FragmentChangePass extends Fragment {
    EditText oldpass,newpass;
    Button updatepassbt;
    Globaldata obj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changepass, null);
        obj=(Globaldata)getActivity().getApplicationContext();
        oldpass=(EditText)view.findViewById(R.id.oldpass);
        newpass=(EditText)view.findViewById(R.id.newpass);
        updatepassbt=(Button)view.findViewById(R.id.updatepassbt);
        updatepassbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
new UpdateProfileUser(obj.getUserMob(),oldpass.getText().toString(),newpass.getText().toString()).execute();
            }
        });
        return view;
    }


    class UpdateProfileUser extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        String mobileNo;
        String mail;
        ProgressDialog pd;
        UpdateProfileUser(String tablename,String mail1,String mob)
        {

            tbName=tablename;
            mobileNo=mob;
            mail=mail1;



        }

        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(getActivity());
            pd.setMessage("Please wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"change_password.php?email="+tbName+"&old_password="+mobileNo+"&new_password="+mail+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{

                pd.dismiss();
                JSONObject jObjetc = new JSONObject(s);
                JSONObject jsonObjectSub=jObjetc.getJSONObject("response");
                String flg1=jsonObjectSub.getString("status");
                if(flg1.equals("1"))
                {
                    Toast.makeText(getActivity(),"Password Update successfully!!",Toast.LENGTH_SHORT).show();
                    Intent tran=new Intent(getActivity(),StaupActivity.class);
                    startActivity(tran);
                    getActivity().finish();
                }
                else
                {
                    Toast.makeText(getActivity(),"Please try again !",Toast.LENGTH_SHORT).show();
                }



            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

}
