# Intent
There are two types of intents:
* **Explicit Intents:** specify the component to start by name (the fully-qualified class name). You'll typically use an explicit intent to start a component in your own app, because you know the class name of the activity or service you want to start. For example, start a new activity in response to a user action or start a service to download a file in the background.
* **Implicit Intents:** do not name a specific component, but instead declare a general action to perform, which allows a component from another app to handle it. For example, if you want to show the user a location on a map, you can use an implicit intent to request that another capable app show a specified location on a map.

## Building an Intent
* Component name
* Action
* Data

**Caution:** If you want to set both the URI and MIME type, do not call setData() and setType() because they each nullify the value of the other. Always use setDataAndType() to set both URI and MIME type.
* Category
