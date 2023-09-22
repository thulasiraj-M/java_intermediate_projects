package com.recharge.nirbhay.rechargewallete.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.fragmetsclass.FragmentHistory;

import java.util.ArrayList;

public class WalletHistoryAdpater extends ArrayAdapter<String> {

	ArrayList<String> ArrId=new ArrayList<String>();
	ArrayList<String>Arrmo=new ArrayList<String>();
	ArrayList<String>ArrBal=new ArrayList<String>();
	ArrayList<String>Arrdt=new ArrayList<String>();

	private  Activity context;
	private FragmentManager fmgCommnet;
	ArrayList<Integer>adimg=new ArrayList<Integer>();
	ArrayList<String>txt=new ArrayList<String>();

	//String name2[]={"Event Service","Home Services"};
	public WalletHistoryAdpater(Activity context, FragmentManager fmg, ArrayList<String>ArrIdtxt, ArrayList<String>Arruidtxt, ArrayList<String>Arrmobtxt, ArrayList<String>Arramounttxt) {
		super(context,R.layout.transectiondetailrow,ArrIdtxt);
		// TODO Auto-generated constructor stub
		this.context=context;
		ArrId=ArrIdtxt;
		Arrmo=Arruidtxt;
		ArrBal=Arrmobtxt;
		Arrdt=Arramounttxt;

		//this.imge=imgDra;

		
		this.fmgCommnet=fmg;
		
		
		
		}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	LayoutInflater inflater=context.getLayoutInflater();
	View rowView=inflater.inflate(R.layout.walletdetailrow, null,true);
	TextView bal=(TextView)rowView.findViewById(R.id.balstr);
	TextView usertxt=(TextView)rowView.findViewById(R.id.userstr);
	TextView dttext=(TextView)rowView.findViewById(R.id.dtstr);
	TextView ammtxt=(TextView)rowView.findViewById(R.id.ammmt);

	bal.setText(ArrBal.get(position));
	usertxt.setText(Arrmo.get(position));
	dttext.setText(Arrdt.get(position));
	ammtxt.setText(ArrBal.get(position));


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
