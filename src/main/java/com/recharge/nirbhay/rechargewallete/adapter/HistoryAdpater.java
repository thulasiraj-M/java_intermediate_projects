package com.recharge.nirbhay.rechargewallete.adapter;

import java.util.ArrayList;





import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.fragmetsclass.FragmentHistory;

public class HistoryAdpater extends ArrayAdapter<String> {

	ArrayList<String>ArrId=new ArrayList<String>();
	ArrayList<String>Arrprovd=new ArrayList<String>();
	ArrayList<String>ArrMob=new ArrayList<String>();
	ArrayList<String>Arrstatus=new ArrayList<String>();
	ArrayList<String>Arrdt=new ArrayList<String>();
	ArrayList<String>Arramout=new ArrayList<String>();
	ArrayList<String>Arruid=new ArrayList<String>();
	private  Activity context;
	private FragmentManager fmgCommnet;
	ArrayList<Integer>adimg=new ArrayList<Integer>();
	ArrayList<String>txt=new ArrayList<String>();

	//String name2[]={"Event Service","Home Services"};
	public HistoryAdpater(Activity context, FragmentManager fmg, ArrayList<String>ArrIdtxt, ArrayList<String>Arruidtxt,ArrayList<String>Arrmobtxt,ArrayList<String>Arramounttxt,ArrayList<String>Arrprotxt,ArrayList<String>Arrdttxt ,ArrayList<String>Arrstatustxt) {
		super(context,R.layout.transectiondetailrow,Arrprotxt);
		// TODO Auto-generated constructor stub
		this.context=context;
		ArrId=ArrIdtxt;
		Arrprovd=Arrprotxt;
		ArrMob=Arrmobtxt;
		Arrstatus=Arrstatustxt;
		Arrdt=Arrdttxt;
		Arramout=Arramounttxt;
		Arruid=Arruidtxt;
		//this.imge=imgDra;

		
		this.fmgCommnet=fmg;
		
		
		
		}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	LayoutInflater inflater=context.getLayoutInflater();
	View rowView=inflater.inflate(R.layout.transectiondetailrow, null,true);
	TextView dt=(TextView)rowView.findViewById(R.id.dt);
	TextView statustxt=(TextView)rowView.findViewById(R.id.statustxt);
	TextView mobno=(TextView)rowView.findViewById(R.id.mobno);
	TextView prtxt=(TextView)rowView.findViewById(R.id.prtxt);
	TextView money=(TextView)rowView.findViewById(R.id.money);
	dt.setText(Arrdt.get(position));
	mobno.setText(ArrMob.get(position));

	statustxt.setText(Arramout.get(position));
//if(Arrstatus.get(position).toString().equals("1"))
//{
//	statustxt.setText("Success");
//}
//	else
//{
//	statustxt.setText("Failed");
//}
	ImageView cross_icon=(ImageView) rowView.findViewById(R.id.cross_icon);
	cross_icon.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {

		}
	});
	return rowView;
}


public void getDetailsFrag()
{
	Fragment req_frag=new FragmentHistory();
	
	FragmentTransaction req_transion=fmgCommnet.beginTransaction();
	req_transion.replace(R.id.frame_container, req_frag);
	req_transion.commit();
	
}




}
