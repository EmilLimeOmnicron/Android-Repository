package evangelista.emil.howareyou;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

   TimePicker alarmTime;
   TextClock currentTime;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      EditText text = (EditText)findViewById(R.id.editText);
      String str = text.getText().toString();
      //

   }


   private void setNotification(){

      //if(time == input) then notify user
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
      mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
      mBuilder.setContentTitle("How are you?");
      mBuilder.setContentText("Don't forget to log in how you feel!");


      Intent resultIntent = new Intent(this, MainActivity.class);
      TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
      stackBuilder.addParentStack(MainActivity.class);

   // Adds the Intent that starts the Activity to the top of the stack
      stackBuilder.addNextIntent(resultIntent);
      PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
      mBuilder.setContentIntent(resultPendingIntent);


      // Add as notification
      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      manager.notify(0, mBuilder.build());
   }
}


//minimum viable product set notification times/delete notification times
//store ratings
