# Espresso animations test

It is not a secret that espresso fails when there are some animations in your application.

But not many people know that there is a flag for disabling animations in tests:
```
testOptions {
    animationsDisabled = true
}
```
Link to official documentation: [here](https://google.github.io/android-gradle-dsl/current/com.android.build.gradle.internal.dsl.TestOptions.html#com.android.build.gradle.internal.dsl.TestOptions:animationsDisabled)

Ok, that's great, but does it really work? Do I have to still turn off animations manually? 
(Setting window_animation_scale and transition_animation_scale and animator_duration_scale to 0)

### TDLR; Yes, it mostly works.

Because it is very hard to find any information about this flag I decided to check it by myself.
To do this I ran some tests against emulators with apis within range <16, 26>.

My tests consists of:
- checking if progress bar is visible
- checking if snackbar is visible
- performing click on snackbar action

Results:
Below tables shows how does the `animationsDisabled` flag work depending on animation settings.

The row `animations` represents the state of animations which can be altered through settings screen.

Assert progressBar is visible:

| API level  | 16 | 17 | 18 | 19 | 21 | 22 | 23 | 24  | 25 | 26 |
|------------|----|----|----|----|----|----|----|-----|----|----|
| Animations | DM | DM | DM | DM | ON | ON | ON | OFF | DM | DM |

// DM stand for doesn't matter

// OFF means that animations have to be turned off

// ON means that animations have to be turned on

Assert snackbar is visible:

| API level  | 16 | 17 | 18 | 19 | 21  | 22  | 23  | 24  | 25  | 26  |
|------------|----|----|----|----|-----|-----|-----|-----|-----|-----|
| Animations | DM | DM | DM | DM | OFF | OFF | OFF | OFF | OFF | OFF |

Assert snackbar is clickable:

| API level  | 16 | 17 | 18 | 19 | 21  | 22  | 23  | 24  | 25  | 26  |
|------------|----|----|----|----|-----|-----|-----|-----|-----|-----|
| Animations | DM | DM | DM | DM | DM  | DM  | DM  | DM  | DM  | DM  |

Summary:

The `animationsDisabled` flag is not a silver bullet. It can helps us a lot, 
but on some apis there is no easy solution to get espresso work with animations. 

E.g. On api 22 we can't have both progressBar and snackbar working.