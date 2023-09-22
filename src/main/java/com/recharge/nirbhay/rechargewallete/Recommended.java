package com.recharge.nirbhay.rechargewallete;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.adapter.CustomAdapterRecommed;
import com.recharge.nirbhay.rechargewallete.adapter.ListModelrecomd;

public class Recommended extends Activity {

	 ListView list;
     CustomAdapterRecommed adapter;
     public  Recommended CustomListView = null;
     public  ArrayList<ListModelrecomd> CustomListViewValuesArr = new ArrayList<ListModelrecomd>();
	  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recommended);
		 CustomListView = this;
		 list=(ListView)findViewById(R.id.list1);
		try
		{
		// setListData();
       
        // Resources res =getResources();
         
          
         /**************** Create Custom Adapter *********/
         
		}
		catch(Exception e)
		{
	//	Toast.makeText(getApplicationContext(), ""+e, 1000).show();
		}
		new Allpaln().execute();
        
	}

	
	// setliist data here ...
//	public void setListData()
//    {
//		JSONArray arr=new JSONArray();
//		
//		
//		
//         
//        for (int i = 0; i < 100; i++) {
//        
//        	try {
//				JSONObject obj=arr.getJSONObject(i);
//				obj.getJSONObject("dinesh");
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            final ListModelrecomd sched = new ListModelrecomd();
//                 
//              /******* Firstly take data in model object ******/
//               sched.setcol("col"+i);
//               sched.setcol1("col1"+i);
//               sched.setcol2("col2"+i);
//               sched.setcol3("col3"+i);
//                
//               
//            /******** Take Model Object in ArrayList **********/
//            CustomListViewValuesArr.add( sched );
//        }
//         
//    }
	
	 public void onItemClick(int mPosition)
     {
         ListModelrecomd tempValues = ( ListModelrecomd ) CustomListViewValuesArr.get(mPosition);


        // SHOW ALERT                  

         Toast.makeText(CustomListView,
                 ""+tempValues.getcol()   +" col"+tempValues.getcol1()
                   +" col2"+tempValues.getcol2(), Toast.LENGTH_LONG).show();
     }

	
	


	
	
	
	
//	*************************************Async task SELECT PROVIDER FOR DthProviderservice ***************************************************************************
	
	
	
	
	
	
	public class Allpaln extends AsyncTask<String, String, String> {

		String URL1,URL2;
        String param;
		String response1=" ";
		String response2=" ";
		String success;
		String msg;
		String location;
		String operator;
        String tex;
        String operatorname[] ;  
        ArrayList<String> operatorAdd;
		ProgressDialog dialogProgress = new ProgressDialog(Recommended.this);


		
		public Allpaln() {
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
			  //ListModel sched = new ListModel();
		if (response2 != "" || response2 != null) {
		try{


			    
			
			
			JSONObject object = new JSONObject(response2);
		  JSONArray response12 = object.getJSONArray("amount");
			for(int i=0;i<response12.length();i++){
				final ListModelrecomd sched1 = new ListModelrecomd();
//		    String legislators = object.getJSONArray("message").getJSONArray(i).getString(0);
//		    String legislators1 = object.getJSONArray("message").getJSONArray(i).getString(5);
//		    String legislators2 = object.getJSONArray("message").getJSONArray(i).getString(8);
//		    String legislators3 = object.getJSONArray("message").getJSONArray(i).getString(12);
//		    
//		    
		    
            
            /******* Firstly take data in model object ******/
				
//				String date=object.getJSONArray("date").getString(i);
//	             String time=object.getJSONArray("time").getString(i);
//	             String datetime=date+time;
//				
               sched1.setcol(object.getJSONArray("amount").getString(i));
             
             sched1.setcol1(object.getJSONArray("talktime").getString(i));
             sched1.setcol2(object.getJSONArray("validity").getString(i));
           sched1.setcol3(object.getJSONArray("description").getString(i));
              
             
          /******** Take Model Object in ArrayList **********/
           CustomListViewValuesArr.add(sched1 );
           adapter=new CustomAdapterRecommed( CustomListView, CustomListViewValuesArr );
           list.setAdapter( adapter );
		    
			}
			
			
			
			
			
//			for(int i=0;i<30;i++)
//			{
//			  final ListModel sched = new ListModel();
//	          
//	          /******* Firstly take data in model object ******/
//	           sched.setcol("dt"+i);
//	           sched.setcol1(""+i);
//	           sched.setcol2(""+i);
//	          sched.setcol3(""+i);
//	            
//	           
//	        /******** Take Model Object in ArrayList **********/
//	        CustomListViewValuesArr.add( sched );
//			}
//	    
			
			
			
		   	
		}
		catch(Exception e)
		{
		Toast.makeText(getApplicationContext(), "Error reading data from server.Please try again.",
			Toast.LENGTH_LONG).show();
		}

		}



		else {
	
		}

		dialogProgress.dismiss();
		
//		Toast.makeText(getApplicationContext(), "Response"+response2,
//				Toast.LENGTH_LONG).show();
		
    // Log.e("rspon", response2);

		}
		
		}


	
	
	
	
	
	
	
	
	
}
