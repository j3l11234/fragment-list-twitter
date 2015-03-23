package com.deitel.twittersearches;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

public class WebListFragment extends ListFragment{ 
	private OnFragmentInteractionListener mListener;
	
	private ArrayAdapter<String> adapter; // binds tags to ListView
	
	public WebListFragment(ArrayAdapter<String> adapter) {
		this.adapter = adapter;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_list, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//register listener that searches Twitter when user touches a tag
		getListView().setOnItemClickListener(itemClickListener); 
		//set listener that allows user to delete or edit a search
		getListView().setOnItemLongClickListener(itemLongClickListener);
		
		super.onActivityCreated(savedInstanceState);
	}
	
	OnItemLongClickListener itemLongClickListener = new OnItemLongClickListener() {
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			// get the tag that the user long touched
			final String tag = ((TextView) view).getText().toString();
			mListener.onItemLongClick(tag);
			return true;
		} // end method onItemLongClick
	}; // end OnItemLongClickListener declaration

   OnItemClickListener itemClickListener = new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, 
         int position, long id) 
      {
         // get query string and create a URL representing the search
         String tag = ((TextView) view).getText().toString();
         mListener.onItemClick(tag);
        
      } 
   }; // end itemClickListener declaration
	
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * 
     * See the Android Training lesson Communicating with Other Fragments for more information.
	*/
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onItemLongClick(final String tag);
        public void onItemClick(final String tag);
    }
}
