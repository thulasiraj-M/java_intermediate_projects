package com.recharge.nirbhay.rechargewallete.fragmetsclass;

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.StaupActivity;
import com.recharge.nirbhay.rechargewallete.globalobject.Globaldata;
import com.recharge.nirbhay.rechargewallete.httpservice.CustomHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rakesh on 12/16/2016.
 */

public class FragmentElectricity extends Fragment {

    ArrayList<String> idArr=new ArrayList<String>();
    ArrayList<String>nameArr=new ArrayList<String>();
    Spinner eltbill,operatortype;
    Globaldata globleobj;
    Button electicity_btn;
    String regtxt,opttxt;

    String providename;
    String uuid;
    String batCurrent;
    int transactionalAmount=0;
int tempBalance=0;

    EditText mobilenoelecity,bill_amount_electicity_txt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_electicity__bill__payment, null);
        electicity_btn=(Button)view.findViewById(R.id.electicity_btn);
        bill_amount_electicity_txt=(EditText)view.findViewById(R.id.bill_amount_electicity_txt);
        mobilenoelecity=(EditText)view.findViewById(R.id.mobilenoelecity);
        electicity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {








                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(R.layout.paymentselection);
                Button netpay=(Button)dialog.findViewById(R.id.netpay);
                netpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        /*Intent payint=new Intent(getActivity(), InitialScreenActivity.class);
                        startActivity(payint);*/
                    }
                });
                Button walletbtn=(Button)dialog.findViewById(R.id.wallettpay);
                walletbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String currentbal=globleobj.getBalexisting();
                      int tmp = tempBalance;

                        if(currentbal.equals("0.0")) {
                            tmp  = 0;

                        }
                        else {
                            tmp = Integer.parseInt(currentbal);

                        }



                        int rechbal = Integer.parseInt(bill_amount_electicity_txt.getText().toString());

                        if(tmp>=rechbal) {

                            transactionalAmount=tmp-rechbal;
                            new RechargeAsyn(mobilenoelecity.getText().toString(),bill_amount_electicity_txt.getText().toString(),opttxt).execute();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"insufficient balance!",Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                });
                dialog.show();








            }
        });
        eltbill=(Spinner)view.findViewById(R.id.eltbill);
        globleobj=(Globaldata)getActivity().getApplicationContext();
        operatortype=(Spinner)view.findViewById(R.id.operatortype);
        eltbill.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opttxt=idArr.get(i).toString();
                providename=nameArr.get(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        new OperatorsList("Electricity").execute();
        new OperatorsType("region").execute();
        return view;
    }



    class OperatorsList extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        OperatorsList(String tablename)
        {
            tbName=tablename;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"getalloperator.php?tb="+tbName+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{


                JSONArray jArr=new JSONArray(s);
                for(int i=0;i<jArr.length();i++)
                {
                    JSONObject jStr=jArr.getJSONObject(i);
                    idArr.add(jStr.getString("id"));
                    nameArr.add(jStr.getString("name"));
                }
                ArrayAdapter aa1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameArr);
                aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                eltbill.setAdapter(aa1);

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }



    class OperatorsType extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        OperatorsType(String tablename)
        {
            tbName=tablename;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"regionNames.php?tb="+tbName+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{


                JSONArray jArr=new JSONArray(s);
                for(int i=0;i<jArr.length();i++)
                {
                    JSONObject jStr=jArr.getJSONObject(i);
                    idArr.add(jStr.getString("circle_id"));
                    nameArr.add(jStr.getString("circle"));
                }
                ArrayAdapter aa2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameArr);
                aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                operatortype.setAdapter(aa2);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    class RechargeAsyn extends AsyncTask<String,String,String>
    {
        String res;
        String mobi;
        String amt;
        String regionnam;
        String operatorNam;
        ProgressDialog pd;
        RechargeAsyn(String mob,String ammt,String opt)
        {
            mobi=mob;
            amt=ammt;

            operatorNam=opt;
        }

        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(getActivity());
            pd.setMessage("Please wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                String getTabId = globleobj.getIntOperatorType();

                String pagename=Globaldata.baseUrllink+"payelectricbill.php?operatortype="+getTabId+"&optname="+operatorNam+"&act="+mobi+"&amt="+amt+"";
               //String paramUrl=pagename+"operatortype="+getTabId+"&optname="+operatorNam+"&act="+mobi+"&amt="+amt+"";


                Log.d("url-------->",""+pagename);

//res=CustomHttpClient.executeHttpPost(RechargeUrl,param);
                res=CustomHttpClient.executeHttpGet(pagename);


                Log.d("url-------->",res);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{
                pd.dismiss();

                JSONObject jObj=new JSONObject(s);

                JSONArray jArr=jObj.getJSONArray("ElectricityRechargeDetails");

                JSONObject jStr=jArr.getJSONObject(0);
                String status=jStr.getString("recharge_status");
                if(status.equals("Failed")) {
                    final Dialog dialog = new Dialog(getActivity());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.setContentView(R.layout.successfail_popup);
                    Button canl=(Button)dialog.findViewById(R.id.canl);
                    canl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Intent inHome=new Intent(getActivity(),StaupActivity.class);
                            startActivity(inHome);
                            getActivity().finish();
                        }
                    });
                    TextView statustxt=(TextView)dialog.findViewById(R.id.statustxt);
                    String msg=jStr.getString("message");
                    statustxt.setText(msg);
                    dialog.show();
                }
                else {

                    final Dialog dialog = new Dialog(getActivity());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.setContentView(R.layout.successfail_popup);
                    Button canl=(Button)dialog.findViewById(R.id.canl);
                    canl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            new RechargeHistort(uuid,mobi,amt,providename,"1").execute();
                            bill_amount_electicity_txt.setText("");
                            mobilenoelecity.setText("");

                        }
                    });
                    TextView statustxt=(TextView)dialog.findViewById(R.id.statustxt);
                    String msg=jStr.getString("message");
                    statustxt.setText(msg);
                    dialog.show();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }







    class WalletUpdate extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        String battxt;
        WalletUpdate(String id)
        {
            tbName=id;

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"walletupdate.php?uuid="+uuid+"&amount="+transactionalAmount+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{
                JSONObject jObjects=new JSONObject(s);
                JSONObject JObjectSub=jObjects.getJSONObject("response");
                String flg=JObjectSub.getString("status");
                if(flg.equals("1"))
                {
                    Toast.makeText(getActivity(),"successfully ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"failed ",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }


    class GEtWalletBal extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        GEtWalletBal(String tablename)
        {
            tbName=tablename;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"getwallet.php?user_id="+tbName+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{


                JSONObject jObjetc = new JSONObject(s);
                JSONObject jsonObjectSub=jObjetc.getJSONObject("response");
                JSONArray jArr=jsonObjectSub.getJSONArray("balance");
                for(int i=0;i<jArr.length();i++);
                {
                    JSONObject indexobj=jArr.getJSONObject(0);
                    String baltxt=indexobj.getString("amount");
                    globleobj.setBalexisting(baltxt);

                    transactionalAmount=Integer.parseInt(baltxt);
                    batCurrent=baltxt;
                    // baltxdt.setText(baltxt);

                }




            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }


    class RechargeHistort extends AsyncTask<String,String,String>
    {
        String res;
        String tbName;
        String mobileNo;
        String amount;
        String provide;
        String status;
        RechargeHistort(String tablename,String mob,String amt,String provideanme,String statu)
        {

            tbName=tablename;
            mobileNo=mob;
            amount=amt;
            provide=provideanme;
            status=statu;


        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {

            String url= Globaldata.baseUrllink+"addhistory.php?uid="+tbName+"&mobile_no="+mobileNo+"&amount="+amount+"&provide_name="+provide+"&status="+status+"";
            res= CustomHttpClient.urlincoding(url);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            try{


                JSONObject jObjetc = new JSONObject(s);
                JSONObject jsonObjectSub=jObjetc.getJSONObject("response");
                JSONArray jArr=jsonObjectSub.getJSONArray("balance");
                for(int i=0;i<jArr.length();i++);
                {
                    JSONObject indexobj=jArr.getJSONObject(0);
                    String baltxt=indexobj.getString("amount");
                    globleobj.setBalexisting(baltxt);

                    transactionalAmount=Integer.parseInt(baltxt);
                    batCurrent=baltxt;
                    // baltxdt.setText(baltxt);

                }

                new WalletUpdate(tbName).execute();


            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
