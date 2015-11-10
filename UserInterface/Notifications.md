# Notifications
```java
//minimum
NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
builder.setSmallIcon(android.R.drawable.ic_dialog_email).setContentTitle("My notification").setContentText("Hello World!");

NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
notificationManager.notify(1, builder.build());
```
