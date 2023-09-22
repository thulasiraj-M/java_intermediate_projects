package com.recharge.nirbhay.rechargewallete.adapter;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.R;

public class PaymentListAdapter extends BaseExpandableListAdapter {
	
	double s=0;
	 double b=0;
	 double recharge=0;
	 double totalbill=0;
	 String no,opt;
	Button  seculty_proceed_on_pay_wallet;
	final String LOGIN_CASH="Login";
	TextView bl;
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
 
    public PaymentListAdapter(Context context, List<String> listDataHeader,
            HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    @Override
    public View getChildView(int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
 
        final String childText = (String) getChild(groupPosition, childPosition);
        
        if(groupPosition==0||groupPosition==4)
        	
        {
        	convertView=null;
        if (convertView == null) {
        	
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.payment_list_item, null);
        }
      
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
 
        txtListChild.setText(childText);
        
        
        RadioButton sbi,hdfc,icici,pnb;
        
        sbi=(RadioButton)convertView.findViewById(R.id.lblListItem);
        sbi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        hdfc=(RadioButton)convertView.findViewById(R.id.lblListItem2);
        sbi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        icici=(RadioButton)convertView.findViewById(R.id.icici);
        icici.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//new Paymentgetway().execute();
			}
		});
        TextView cnl=(TextView)convertView.findViewById(R.id.cnl);
        cnl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub

			}
		});
       Button proced=(Button)convertView.findViewById(R.id.procced_bt);
       proced.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Paymentgetway().execute();
				
			}
		});
        }
        else if(groupPosition==3)
        	
        {
        	convertView=null;
        	 if (convertView == null) {
             	
                 LayoutInflater infalInflater = (LayoutInflater) this._context
                         .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 convertView = infalInflater.inflate(R.layout.listview, null);
             }
        	 
        	 
        	 
        	 
        	 seculty_proceed_on_pay_wallet=(Button)convertView.findViewById(R.id.seculty_proceed_on_pay_wallet);
        	 
        	 new Getdetail().execute();

            bl=(TextView)convertView.findViewById(R.id.bal_wallet);
            

    		
            TextView rech_bal=(TextView)convertView.findViewById(R.id.rech_bal);
            
           

            
            totalbill=recharge+s;
       rech_bal.setText(""+totalbill);
////            
            if(b>totalbill)
            {
            	//seculty_proceed_on_pay_wallet.setClickable(false);
            	seculty_proceed_on_pay_wallet.getBackground().setAlpha(50);
				//seculty_proceed_on_pay_wallet.setAnimation(alphaUp);
				
            }
            else
            {
            	
           	seculty_proceed_on_pay_wallet.setOnClickListener(new View.OnClickListener() {
   				
   				@Override
   				public void onClick(View v) {

//    					 no=globale_obj.no();
//    		           opt=globale_obj.opt();
    					
    					
    					SharedPreferences pref= _context.getApplicationContext().getSharedPreferences("mobile", _context.MODE_PRIVATE);
    					  no= pref.getString("mobileno", "");          // getting String
    					 opt= pref.getString("selected", "");
    					
    					
    					// TODO Auto-generated method stub
    					//seculty_proceed_on_pay_wallet.setClickable(true);
    					new FinalPaymentservice().execute();
    				}
    			});
           	
            }
        	 Button wal=(Button)convertView.findViewById(R.id.addcash_in_wallet);
        	 wal.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

				}
			});
        	 
        }
        else if(groupPosition==1)
        {
        	convertView=null;
       	 if (convertView == null) {
            	
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.debitcardlayout, null);
            }
       	 
        }
        else if(groupPosition==2)
        {
        	convertView=null;
          	 if (convertView == null) {
               	
                   LayoutInflater infalInflater = (LayoutInflater) this._context
                           .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                   convertView = infalInflater.inflate(R.layout.creditlayout, null);
               }
          	 
        }
        
        return convertView;
    }
 
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }
 
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }
 
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.payment_list_group, null);
        }
        
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
      
       
       
        
        
        return convertView;
    }
 
    @Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
    
    
    public class Paymentgetway extends AsyncTask<String, String, String> {

		String URL1,URL2;
      String param;
		String response1=" ";
		String response2=" ";
		String success;
		String msg;
		String location;
		String operator;
      String tex;
      String amt;
      String operatorname[] ;  
      ArrayList<String> operatorAdd;
      ProgressDialog dialogProgress = new ProgressDialog(_context);


		public Paymentgetway() {
		// TODO Auto-generated constructor stub
		//tex = txt;
		}

		protected void onPreExecute() {

		dialogProgress.setCancelable(false);
		dialogProgress.setMessage("Please Wait");
		dialogProgress.setIndeterminate(false);
		dialogProgress.show();
		//loc_list.clear();
		}

		@Override
		protected String doInBackground(String... params) {
		try {

			

	     

		} catch (Exception e) {
		e.printStackTrace();
		}

		return response2;

		}

		protected void onPostExecute(String response) {

		if (response2 != "" || response2 != null) {
		try{

			JSONObject req = new JSONObject(response2);
	        String success=req.optString("response");
	       
	        
	        if(success.equals("y"))
	        {
	        	Log.e("------->", success);
	        	
	       
	        }
	        else
	        {
	        	Log.e("------->", "problm");
	        }
		
	   	        
		}
		catch(Exception e)
		{
		//Toast.makeText(getApplicationContext(), "ERROR"+e,
//			Toast.LENGTH_LONG).show();
		}

		}



		else {
	
		}

		dialogProgress.dismiss();
		

		


		}
		
		}

    
    
    public class Getdetail extends AsyncTask<String, String, String> {

		String URL1, URL2;
		String param;
		String response1 = " ";
		String response2 = " ";
		String success;
		String msg;
		String location;
		String operator;
		String tex;
		String operatorname[];
		ProgressDialog dialogProgress = new ProgressDialog(_context);

		public Getdetail() {
			// TODO Auto-generated constructor stub
			// tex = txt;
		}

		protected void onPreExecute() {
			dialogProgress.setCancelable(false);
			dialogProgress.setMessage("Please Wait");
			dialogProgress.setIndeterminate(false);
			dialogProgress.show();
			// loc_list.clear();
		}

		@Override
		protected String doInBackground(String... params) {
			try {

				SharedPreferences pref=_context. getApplicationContext().getSharedPreferences(LOGIN_CASH, _context.MODE_PRIVATE);
			    String userid= pref.getString("user", "");          // getting String
				

			} catch (Exception e) {
				e.printStackTrace();
			}

			return response2;

		}

		protected void onPostExecute(String response) {

			if (response2 != "" || response2 != null) {
				try {

					JSONObject req = new JSONObject(response2);
					success = req.optString("resp");
					msg = req.optString("message");
                    
                    String bal=req.optString("ubalance");
                    bl.setText(bal);
                   
				} catch (Exception e) {
					// Toast.makeText(getApplicationContext(), "ERROR"+e,
					// Toast.LENGTH_LONG).show();
				}

			}

			else {

			}

			dialogProgress.dismiss();

		}

	}
    
    
    public class FinalPaymentservice extends AsyncTask<String, String, String> {

		String URL1,URL2;
      String param;
		String response1=" ";
		String response2=" ";
		String success;
		String msg;
		String location;
		String operator;
      String tex;
      String amt;
      String operatorname[] ;  
      ArrayList<String> operatorAdd;
      ProgressDialog dialogProgress = new ProgressDialog(_context);


		public FinalPaymentservice() {
		// TODO Auto-generated constructor stub
		//tex = txt;
		}

		protected void onPreExecute() {

		dialogProgress.setCancelable(false);
		dialogProgress.setMessage("Please Wait");
		dialogProgress.setIndeterminate(false);
		dialogProgress.show();
		//loc_list.clear();
		}

		@Override
		protected String doInBackground(String... params) {
		try {

			

	     
	       double s_charge=0;
	       String mb="Mobile";
	       String Recharge="Recharge";
	       int vouch=1234;
	       int prom=1234;


		} catch (Exception e) {
		e.printStackTrace();
		}

		return response2;

		}

		protected void onPostExecute(String response) {

		if (response2 != "" || response2 != null) {
		try{

			JSONObject req = new JSONObject(response2);
	        String success=req.getString("response");
	        
	        
	        if(success.equals("success"))
	        {
	        	Log.e("------->", success);

	        }
	        else
	        {

	        }
		
	   	        
		}
		catch(Exception e)
		{
		Toast.makeText(_context, "ERROR"+e,
			Toast.LENGTH_LONG).show();
		Log.e("Error", ""+e);
		}

		}



		else {
	
		}

		dialogProgress.dismiss();
		
		
		
   

		}
		
		}

  
    
    
}