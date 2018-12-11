=== The Android plugin AppBundle Bug ===

If application contains native libraries like Fresco, app will crash on start if installed with AppBundle.

Tested on emulator Android 9.0 x86_64, Galaxy S9 and many more devices from release with 50% crash-free :(

Steps:
- set android plugin version to 3.3.0-rc02 or 3.4.0-alpha07 (any version after 3.2.1 is affected)
- build release bundle './gradlew :app:bundleRelease'
- run `java -jar ~/Downloads/bundletool-all-0.7.2.jar build-apks --bundle=app/build/outputs/bundle/release/app.aab --output=app_3.3.0_rc02.apks --ks=app/keystore --ks-pass=pass:123456 --ks-key-alias=bundle --key-pass=pass:123456`
- run `java -jar ~/Downloads/bundletool-all-0.7.2.jar install-apks --apks=app_3.3.0_rc02.apks`
- App will crash on start with

```
E/AndroidRuntime: FATAL EXCEPTION: OkHttp Dispatcher
    Process: com.android.bug.bundleerror, PID: 22308
    java.lang.UnsatisfiedLinkError: couldn't find DSO to load: libimagepipeline.so
        at com.facebook.soloader.SoLoader.doLoadLibraryBySoName(SoLoader.java:703)
        at com.facebook.soloader.SoLoader.loadLibraryBySoName(SoLoader.java:564)
        at com.facebook.soloader.SoLoader.loadLibrary(SoLoader.java:500)
        at com.facebook.soloader.SoLoader.loadLibrary(SoLoader.java:455)
```

It is not the Fresco bug because with stable version of android plugin (3.2.1) everything works fun.
Also if you build release apk with `./gradlew :app:assembleRelease`, everything will be fine too.

