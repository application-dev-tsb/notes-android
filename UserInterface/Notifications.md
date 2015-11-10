# Notifications
```java
//minimum
NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
builder.setSmallIcon(android.R.drawable.ic_dialog_email).setContentTitle("My notification").setContentText("Hello World!");

NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
notificationManager.notify(1, builder.build());
```

Priority and Heads-Up Notification
```
//If a notification's priority is flagged as High, Max, or full-screen, it gets a heads-up notification.
builder.setPriority(NotificationCompat.PRIORITY_MAX).setDefaults(NotificationCompat.DEFAULT_VIBRATE); //undocumented requirement
```

**Sources:**
* [Android API Guide: Notifications](http://developer.android.com/guide/topics/ui/notifiers/notifications.html)
* [Design Guide: Notifications](http://developer.android.com/design/patterns/notifications.html)
