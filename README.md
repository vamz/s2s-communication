# Android service to service communication insade one process

Application contains two services `SendingService` and `RecievingService`,
where `SendingService` sends simple `Intents` to `RecievingService` which count them. Application defines `IntentReciever`.

## What example does

Application has one activity with two buttons labeled `Start` and `Stop`. Pressing `Start` application launches 
`SendingService` and `RecievingService` services. During start of `SendingService` it creates simple thread which starts
sending Intents to  `RecievingService` every 5 seconds. `RecievingService` service counts recieved Intents and display
its count via Toast.
