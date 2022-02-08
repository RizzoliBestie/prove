package com.example.webserviceapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ProgressAsyncTask extends AsyncTask<Void, Integer, String> {
    ProgressDialog progressDialog = null;

    public ProgressAsyncTask(ProgressDialog pd){progressDialog=pd;}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setProgress(0);
        progressDialog.show();
    }
    @Override
    protected String doInBackground(Void... arg0) {
        try {
            for(int i=0;i<100;i++) {
                publishProgress(new Integer[]{i});
                Thread.sleep(20);
            }
        }
        catch (InterruptedException e) {}
        return "Fatto!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0].intValue());
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressDialog.dismiss();
    }
}

