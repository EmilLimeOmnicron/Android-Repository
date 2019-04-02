package evangelista.emil.howareyou;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.widget.Toolbar;

import java.util.Calendar;


//
//minimum viable product set notification times/delete notification times
//store ratings


public class MainActivity extends AppCompatActivity {

   TimePicker alarmTime;
   TextClock currentTime;
   Switch mSwitch;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      Toolbar myToolbar =  findViewById(R.id.toolbar);
      // setSupportActionBar();

      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.HOUR_OF_DAY, 18);
      calendar.set(Calendar.MINUTE, 30);
      calendar.set(Calendar.SECOND, 0);
      Intent intent1 = new Intent(MainActivity.this, Settings.class);
      PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
      am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, pendingIntent);




      mSwitch = (Switch) findViewById(R.id.switch1);
      mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // do something, the isChecked will be
            // true if the switch is in the On position
         }
      });
   }
}


