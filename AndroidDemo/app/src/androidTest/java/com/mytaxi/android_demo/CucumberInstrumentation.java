package com.mytaxi.android_demo;

import android.os.Bundle;
import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentation;

import java.io.File;

/**
 * The CucumberOptions annotation is mandatory for exactly one of the classes in the test project.
 * Only the first annotated class that is found will be used, others are ignored. If no class is
 * annotated, an exception is thrown. This annotation does not have to placed in runner class
 */
@CucumberOptions(
        features = "features"
)
public class CucumberInstrumentation extends AndroidJUnitRunner {


    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
