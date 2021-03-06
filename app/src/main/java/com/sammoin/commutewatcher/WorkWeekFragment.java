package com.sammoin.commutewatcher;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

//import android.support.v7.internal.widget.AdapterViewCompat.AdapterContextMenuInfo;

public class WorkWeekFragment extends Fragment
{

    private Uri mNewUri;
    public static final int REQUEST_POSITION = 3;
    public static final int REQUEST_NEW_COMMUTE = 4;
    public static final String LIST_BUNDLE = "com.sammoin.commutewatcher.bundle";
    static final String USER_INFO_FILE = "CommuteWatcher_user_info.txt";

    PassDayFromWeekListener mCallback;
    WorkDayListFragment.UpdateTitleListener mTitleCallback;
    private Toolbar mToolbar;
    private View view;
    TextView sundayTextView;
    CheckBox sundayCheckbox;
    TextView mondayTextView;
    CheckBox mondayCheckbox;
    TextView tuesdayTextView;
    CheckBox tuesdayCheckbox;
    TextView wednesdayTextView;
    CheckBox wednesdayCheckbox;
    TextView thursdayTextView;
    CheckBox thursdayCheckbox;
    TextView fridayTextView;
    CheckBox fridayCheckbox;
    TextView saturdayTextView;
    CheckBox saturdayCheckbox;




    public interface PassDayFromWeekListener {
        public void passDayFromWeek(Bundle bundle);
    }

	public WorkWeekFragment()
	{

	}

    public void addDayToWeek(UserDay userDay)
    {

    }


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		mCallback = (PassDayFromWeekListener)getActivity();

        UserDayItem udi = new UserDayItem(getContext());


    }


    @Override
    public void onResume() {
        super.onResume();
        mTitleCallback = (WorkDayListFragment.UpdateTitleListener)getActivity();
        mTitleCallback.updateTitle(R.string.activity_app_name);
        updateDayView();
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.workweeklayout_nonlist, container, false);



        sundayTextView = (TextView) view.findViewById(R.id.su_trips_TextView);
        sundayCheckbox = (CheckBox) view.findViewById(R.id.su_workday_list_item_activeCheckBox);
        mondayTextView = (TextView) view.findViewById(R.id.mo_trips_TextView);
        mondayCheckbox = (CheckBox) view.findViewById(R.id.mo_workday_list_item_activeCheckBox);
        tuesdayTextView = (TextView) view.findViewById(R.id.tu_trips_TextView);
        tuesdayCheckbox = (CheckBox) view.findViewById(R.id.tu_workday_list_item_activeCheckBox);
        wednesdayTextView = (TextView) view.findViewById(R.id.we_trips_TextView);
        wednesdayCheckbox = (CheckBox) view.findViewById(R.id.we_workday_list_item_activeCheckBox);
        thursdayTextView = (TextView) view.findViewById(R.id.th_trips_TextView);
        thursdayCheckbox = (CheckBox) view.findViewById(R.id.th_workday_list_item_activeCheckBox);
        fridayTextView = (TextView) view.findViewById(R.id.fr_trips_TextView);
        fridayCheckbox = (CheckBox) view.findViewById(R.id.fr_workday_list_item_activeCheckBox);
        saturdayTextView = (TextView) view.findViewById(R.id.sa_trips_TextView);
        saturdayCheckbox = (CheckBox) view.findViewById(R.id.sa_workday_list_item_activeCheckBox);
        updateDayView();

        Bundle extras = new Bundle();



        LinearLayout sundayBar = (LinearLayout) view.findViewById(R.id.su_layout);
        sundayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            proceedToWorkDayList(1);
            }
        });
        sundayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(1, sundayCheckbox.isChecked());
            }
        });

        LinearLayout mondayBar = (LinearLayout) view.findViewById(R.id.mo_layout);
        mondayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(2);
            }
        });
        mondayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(2, mondayCheckbox.isChecked());
            }
        });

        LinearLayout tuesdayBar = (LinearLayout) view.findViewById(R.id.tu_layout);
        tuesdayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(3);
            }
        });
        tuesdayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(3, tuesdayCheckbox.isChecked());
            }
        });

        LinearLayout wednesdayBar = (LinearLayout) view.findViewById(R.id.we_layout);
        wednesdayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(4);
            }
        });
        wednesdayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(4, wednesdayCheckbox.isChecked());
            }
        });

        LinearLayout thursdayBar = (LinearLayout) view.findViewById(R.id.th_layout);
        thursdayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(5);
            }
        });
        thursdayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(5, thursdayCheckbox.isChecked());
            }
        });

        LinearLayout fridayBar = (LinearLayout) view.findViewById(R.id.fr_layout);
        fridayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(6);
            }
        });
        fridayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(6, fridayCheckbox.isChecked());
            }
        });

        LinearLayout saturdayBar = (LinearLayout) view.findViewById(R.id.sa_layout);
        saturdayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToWorkDayList(7);
            }
        });
        saturdayCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayActivity(7, saturdayCheckbox.isChecked());
            }
        });

        return view;
    }


	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{

		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main_actions, menu);

	}

	@Override
	public void onPrepareOptionsMenu(Menu menu)
	{
		super.onPrepareOptionsMenu(menu);


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{

		case R.id.action_settings:
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	


    public void setDayActivity(int dayInt, boolean isActive)
    {
        ContentValues contentValues= new ContentValues();
        if (!isActive) {
            contentValues.put(UserScheduleContract.USER_ITEM_ACTIVE, 0);

        } else {
            contentValues.put(UserScheduleContract.USER_ITEM_ACTIVE, 1);

        }
        getActivity().getContentResolver().update(
                UserScheduleContract.CONTENT_URI,   // The content URI of the schedule table
                contentValues,                        // The columns to return for each row
                UserScheduleContract.USER_WORKDAY + "=" + dayInt,                    // Selection criteria
                null);
        updateDayView();
    }

    public void proceedToWorkDayList(int dayInt)
    {

        //this is a horrible way to go between fragments, but calling for a fragment transaction using supportfragmentmanager causes an issue going into detail here
        //http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
        Bundle extras = new Bundle();
        extras.putInt(WorkDayListFragment.USER_DAY_POSITION, dayInt);
        WorkDayListFragment workDayListFragment = new WorkDayListFragment ();
        Bundle args = new Bundle();
        args.putAll(extras);
        workDayListFragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in,android.R.anim.fade_out)
                .replace(R.id.container, workDayListFragment)
                .addToBackStack(null)
                .commit();


    }

    public void updateDayView() {
        if (view != null) {
            Cursor testCursor = getActivity().getContentResolver().query(UserScheduleContract.CONTENT_URI, null, null, null, null);


            int sunNum = 0;
            int sunAct = 0;

            int monNum = 0;
            int monAct = 0;

            int tueNum = 0;
            int tueAct = 0;

            int wedNum = 0;
            int wedAct = 0;

            int thurNum = 0;
            int thurAct = 0;

            int friNum = 0;
            int friAct = 0;

            int satNum = 0;
            int satAct = 0;

            int indexWorkday = testCursor.getColumnIndex(UserScheduleContract.USER_WORKDAY);
            int indexActive = testCursor.getColumnIndex(UserScheduleContract.USER_ITEM_ACTIVE);

            while (testCursor.moveToNext()) {
                int day = testCursor.getInt(indexWorkday);
                int active = testCursor.getInt(indexActive);

                switch (day) {
                    case 1: {
                        sunNum++;
                        sunAct = sunAct + active;
                        break;
                    }
                    case 2: {
                        monNum++;
                        monAct = monAct + active;
                        break;
                    }
                    case 3: {
                        tueNum++;
                        tueAct = tueAct + active;
                        break;
                    }
                    case 4: {
                        wedNum++;
                        wedAct = wedAct + active;
                        break;
                    }
                    case 5: {
                        thurNum++;
                        thurAct = thurAct + active;
                        break;
                    }
                    case 6: {
                        friNum++;
                        friAct = friAct + active;
                        break;
                    }
                    case 7: {
                        satNum++;
                        satAct = satAct + active;
                        break;

                    }
                    default:
                        break;


                }





            }
            testCursor.close();
            sundayTextView.setText("Trips: " + sunNum + ", " + sunAct + " active");
            if (sunNum==sunAct && sunAct != 0)
            {
                sundayCheckbox.setChecked(true);
            }
            else
            {
                sundayCheckbox.setChecked(false);
            }
            mondayTextView.setText("Trips: " + monNum + ", " + monAct + " active");
            if (monNum==monAct && monAct != 0)
            {
                mondayCheckbox.setChecked(true);
            }
            else
            {
                mondayCheckbox.setChecked(false);
            }

            tuesdayTextView.setText("Trips: " + tueNum + ", " + tueAct + " active");
            if (tueNum==tueAct && tueAct != 0)
            {
                tuesdayCheckbox.setChecked(true);
            }
            else
            {
                tuesdayCheckbox.setChecked(false);
            }

            wednesdayTextView.setText("Trips: " + wedNum + ", " + wedAct + " active");
            if (wedNum==wedAct && wedAct != 0)
            {
                wednesdayCheckbox.setChecked(true);
            }
            else
            {
                wednesdayCheckbox.setChecked(false);
            }

            thursdayTextView.setText("Trips: " + thurNum + ", " + thurAct + " active");
            if (thurNum==thurAct && thurAct != 0)
            {
                thursdayCheckbox.setChecked(true);
            }
            else
            {
                thursdayCheckbox.setChecked(false);
            }

            fridayTextView.setText("Trips: " + friNum + ", " + friAct + " active");
            if (friNum==friAct && friAct != 0)
            {
                fridayCheckbox.setChecked(true);
            }
            else
            {
                fridayCheckbox.setChecked(false);
            }

            saturdayTextView.setText("Trips: " + satNum + ", " + satAct + " active");
            if (satNum==satAct && satAct != 0)
            {
                saturdayCheckbox.setChecked(true);
            }
            else
            {
                saturdayCheckbox.setChecked(false);
            }
        }
    }
}
