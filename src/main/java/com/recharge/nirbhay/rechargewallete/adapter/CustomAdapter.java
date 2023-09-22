package com.recharge.nirbhay.rechargewallete.adapter;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends BaseAdapter implements OnClickListener {

	
	
	 private Activity activity;
     private ArrayList data;
     private static LayoutInflater inflater=null;
     public Resources res;
     ListModel tempValues=null;
     int i=0;
	
     public CustomAdapter( Activity a, ArrayList d ) {
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
	 public TextView text;
     public TextView text1;
     public TextView text2;
    public TextView text3;
}
	@Override
	public View getView(int possion, View convertview, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View vi=convertview;
		ViewHolder holder;
		if(convertview==null)
		{


		}
		else
		{
			holder=(ViewHolder)vi.getTag();
		}
		if(data.size()<=0)
        {

             
        }
		else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
             
            tempValues = ( ListModel ) data.get( possion );
             
             
            /************  Set Model values in Holder elements ***********/

             
             
             
            // holder.text3.setText( tempValues.getcol3() );
             
         
              
             /******** Set Item Click Listner for LayoutInflater for each row *******/

            // vi.setOnClickListener(new View.OnClickListener( possion ));
        }
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

}
