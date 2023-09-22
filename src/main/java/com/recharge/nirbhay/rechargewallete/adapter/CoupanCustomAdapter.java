package com.recharge.nirbhay.rechargewallete.adapter;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.R;

public class CoupanCustomAdapter extends BaseAdapter implements OnClickListener {

	
	  Bitmap bitmap;
	  ProgressDialog pDialog;
	 
	
	
	Button free,pick;
	 private Activity activity;
     private ArrayList data;
     private static LayoutInflater inflater=null;
     public Resources res;
     CoupanListModel tempValues=null;
     int i=0;
	String []operatorarray;
	Spinner decs;
     public CoupanCustomAdapter( Activity a, ArrayList d ) {
		// TODO Auto-generated constructor stub
    	 
    	 activity=a;
    	 data=d;
    	 inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	 
	}
     
     
     
     
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(data.size()<=0)
		return 1;
		return data.size();
	}

	@Override
	public Object getItem(int possion) {
		// TODO Auto-generated method stub
		return possion;
	}

	@Override
	public long getItemId(int possion) {
		// TODO Auto-generated method stub
		return possion;
	}
public static class ViewHolder
{
	
	 ImageView img;
	public TextView text;
     public TextView text1;
    // public Button fr,pc;
     public TextView text2;
    public ImageView text3;
    TextView name;
    
    ImageView pic;
}
	@Override
	public View getView(int possion, View convertview, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View vi=convertview;
		ViewHolder holder;
		if(convertview==null)
		{
			vi=inflater.inflate(R.layout.care_for_few_deals_layour,null);
			holder=new ViewHolder();
			holder.text1=(TextView)vi.findViewById(R.id.txt1);
			holder.text2=(TextView)vi.findViewById(R.id.txt2);
			holder.img=(ImageView)vi.findViewById(R.id.img);
			//new Imagfill().execute();
			
			
			// holder.name = (TextView) vi.findViewById(R.id.name);
	           
			
			vi.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)vi.getTag();
		}
		if(data.size()<=0)
        {
            holder.text1.setText("No Data");
             
        }
		else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
             
            tempValues = ( CoupanListModel ) data.get( possion );
             
             
            /************  Set Model values in Holder elements ***********/

//             holder.text.setText( tempValues.getcol() );
             holder.text1.setText( tempValues.getcol1());
             holder.text2.setText( tempValues.getcol2());
             new LoadImage().execute(tempValues.getimgurl());
             holder.img.setImageBitmap(bitmap);
         
              
             /******** Set Item Click Listner for LayoutInflater for each row *******/

           
        }
		
		Button free=(Button)vi.findViewById(R.id.free_btn);
		free.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		Button pickc=(Button)vi.findViewById(R.id.pick_btn);
		pickc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(activity, "Click on pick", 1000).show();
				new Pickdataservices().execute();
			}
		});
		
		new DescroptionDrapDown().execute();
		
		decs=(Spinner)vi.findViewById(R.id.des);
		decs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		return vi;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		
		
		 Log.v("CustomAdapter", "=====Row button clicked=====");
		
		
		 class OnItemClickListener  implements OnClickListener{           
             private int mPosition;
              
             OnItemClickListener(int position){
                  mPosition = position;
             }
              
             @Override
             public void onClick(View arg0) {
 

             }               
         }   
	}

	
	
	
	


 class Pickdataservices extends AsyncTask<String, String, String> {
	String TITLE, id, level;
	String response = " ";
	String param;
	String success;
	
	ProgressDialog dialogProgress = new ProgressDialog(activity);
	String tex;

	public Pickdataservices() {
	//TODO Auto-generated constructor stub
	//tex = text;
	}

	protected void onPreExecute() {

	dialogProgress.setCancelable(false);
	dialogProgress.setMessage("Please Wait");
	dialogProgress.setIndeterminate(false);
	dialogProgress.show();

	}

	@Override
	protected String doInBackground(String... params) {
	try {
		String data="50-3-132134";

	

	} catch (Exception e) {
	e.printStackTrace();
	}

	return response;
	}

	protected void onPostExecute(String response) {

		if (response != "" || response != null) {
		try{


	
		JSONObject req = new JSONObject(response);
		success=req.optString("response");
		
		if(success.equals("y"))
		{
			
			Log.e("response", "pick");
		}
	   	        
	   	        
		}
		catch(Exception e)
		{
	
			Log.e("response", "pick faild");	
		}

		}



		else {
	
		}

		dialogProgress.dismiss();
		
		
		
     

		}


}

 
 
 
 class DescroptionDrapDown extends AsyncTask<String, String, String> {
		String TITLE, id, level;
		String response = " ";
		String param;
		String success;
		
		//ProgressDialog dialogProgress = new ProgressDialog(activity);
		String tex;

		public DescroptionDrapDown() {
		//TODO Auto-generated constructor stub
		//tex = text;
		}

		protected void onPreExecute() {

//		dialogProgress.setCancelable(false);
//		dialogProgress.setMessage("Please Wait");
//		dialogProgress.setIndeterminate(false);
//		dialogProgress.show();

		}

		@Override
		protected String doInBackground(String... params) {
		try {
			


		} catch (Exception e) {
		e.printStackTrace();
		}

		return response;
		}

		protected void onPostExecute(String response) {

			if (response != "" || response != null) {
			try{

			JSONObject req = new JSONObject(response);
				ArrayList<String> operatorAdd=new ArrayList<String>();
			//JSONArray array = new req.JSONArray("terms_conditions");
			
				JSONArray array=req.getJSONArray("terms_conditions");
			for(int i = 0; i<array.length() ; i++){
			   String productInfo = (String) array.get(i);


			   
			   		operatorAdd.add(productInfo);
			   		
			
			 }
			

			
	 	  
			operatorarray = operatorAdd.toArray(new String[operatorAdd.size()]);
	  
		   		 ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,operatorarray);  
		   	      
		   		decs.setAdapter(aa); 
		   	 
		   	     ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, operatorAdd );

		   	  decs.setAdapter(arrayAdapter);  
				    
			       
		   	        
			}
			catch(Exception e)
			{
		
				Log.e("response", "pick faild");	
			}

			}



			else {
		
			}

			//dialogProgress.dismiss();
			
			
			
	     

			}


	}
 
 
 
 
 class Imagfill extends AsyncTask<String, String, String> {
		String TITLE, id, level;
		String response = " ";
		String param;
		String success;
		
		//ProgressDialog dialogProgress = new ProgressDialog(activity);
		String tex;

		public Imagfill() {
		//TODO Auto-generated constructor stub
		//tex = text;
		}

		protected void onPreExecute() {

//		dialogProgress.setCancelable(false);
//		dialogProgress.setMessage("Please Wait");
//		dialogProgress.setIndeterminate(false);
//		dialogProgress.show();

		}

		@Override
		protected String doInBackground(String... params) {
		try {
			


		} catch (Exception e) {
		e.printStackTrace();
		}

		return response;
		}

		protected void onPostExecute(String response) {

			if (response != "" || response != null) {
			try{

				JSONObject object = new JSONObject(response);
				
				 
				   JSONArray response12 = object.getJSONArray("voucher_id");
					for(int i=0;i<response12.length();i++){
						
						
		          String uri=object.getJSONArray("merchant_largeimage").getString(i);
		           
		          new LoadImage().execute(uri);
		     
					}
			   	        
			
			}
			catch(Exception e)
			{
		
				Log.e("response", "pick faild");	
			}

			}



			else {
		
			}

			//dialogProgress.dismiss();
			
			
			
	     

			}


	}
 

 
 
 private class LoadImage extends AsyncTask<String, String, Bitmap> {
	    @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            
	    }
	       protected Bitmap doInBackground(String... args) {
	         try {
	        	 String x=args[0];
	        	 Log.i("url",x);
	               bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
	        } catch (Exception e) {
	              e.printStackTrace();
	        }
	      return bitmap;
	       }
	       protected void onPostExecute(Bitmap image) {
	         
	          // pDialog.dismiss();
	          // Toast.makeText(activity, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
	         }
	       }
	   
 
 
 
 
 
 
 
 
 
 
}
