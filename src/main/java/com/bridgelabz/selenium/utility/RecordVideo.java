/**
 * purpose : To implement video recording concept in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.utility;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordVideo {
    public static ATUTestRecorder recorder;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM--yyyy HH-mm-ss");
    Date date = new Date();

    public void startRecording() throws ATUTestRecorderException {
        //create an object of ScriptRecordingTest class and pass 3 parameters explained above.
        recorder = new ATUTestRecorder("C:\\Users\\kalam\\ScriptRecording", "Script_Video_" + dateFormat.format(date), false);

        //To start video recording
        recorder.start();
    }

    public void stopRecording() throws ATUTestRecorderException {
        //Stop the recording
        recorder.stop();
    }
}
