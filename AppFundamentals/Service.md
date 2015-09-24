# Service
* **Bound Service** - allows application components to bind to it by calling **bindService()** in order to create a long-standing connection (and generally does not allow components to start it by calling **startService()**
* **Started Service** - started by calling **startService()**

![Service Lifecycle: Started and Bounded](http://developer.android.com/images/service_lifecycle.png)

**Note:** 
* When starting a Service, you should always specify the component name. Otherwise, you cannot be certain what service will respond to the intent, and the user cannot see which service starts.
* call **stopSelf(int)** to safely stop a service when multiple requests are expected
* Services can run on the [Foreground](http://developer.android.com/guide/components/services.html#Foreground)

## IntentService
Because most started services don't need to handle multiple requests simultaneously (which can actually be a dangerous multi-threading scenario), it's probably best if you implement your service using the IntentService class.

## Bound Service
* extending [Binder](http://developer.android.com/guide/components/bound-services.html#Binder) class
* using a [Messenger](http://developer.android.com/guide/components/bound-services.html#Messenger) (cross-process)
* [AIDL](http://developer.android.com/guide/components/aidl.html) (for cross-process communication) 

**Source:**
* [Android Developer: Service](http://developer.android.com/guide/components/services.html)
