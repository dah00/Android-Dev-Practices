package edu.sju.android.shakedemowithgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import edu.sju.android.shakedemowithgraph.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private double accelerationCurrentValue;
    private double accelerationPreviousValue;
    private SensorEventListener sensorEventListner = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelerationCurrentValue = Math.sqrt(x*x + y*y + z+z);
            double changeInAcceleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue = accelerationCurrentValue;

            // update text views
            binding.txtCurrentAccel.setText("Current = " + (int)accelerationCurrentValue);
            binding.txtPrevAccel.setText("Prev = " + (int)accelerationPreviousValue);
            binding.txtAccel.setText("Acceleratoin change =" + (int)changeInAcceleration);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



    }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(sensorEventListner, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListner);
    }
}