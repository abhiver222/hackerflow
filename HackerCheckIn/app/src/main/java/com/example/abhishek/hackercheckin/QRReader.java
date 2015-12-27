package com.example.abhishek.hackercheckin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;

public class QRReader extends Activity implements View.OnClickListener{

    private String text;
    private Button webbutton;
    private Bitmap bmp;
    private ImageView ivPicture;
    private TextView textv;

    private String qrID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrreader);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        webbutton = (Button)findViewById(R.id.webbutton);

        ivPicture = (ImageView) findViewById(R.id.ivPicture);
        textv = (TextView) findViewById(R.id.mytext);

        webbutton.setOnClickListener(this);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qrreader, menu);
        return true;
    }

    private void decode() {


        if (bmp == null) {
            Log.i("tag", "wtf");
        }
        bmp = bmp.copy(Bitmap.Config.ARGB_8888, true);

        int[] intArray = new int[bmp.getWidth() * bmp.getHeight()];
        bmp.getPixels(intArray, 0, bmp.getWidth(), 0, 0, bmp.getWidth(),
                bmp.getHeight());

        LuminanceSource source = new com.google.zxing.RGBLuminanceSource(
                bmp.getWidth(), bmp.getHeight(), intArray);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        MultiFormatReader reader = new MultiFormatReader();
        try {
            com.google.zxing.Result result = reader.decode(bitmap);

            text = result.getText();
            byte[] rawBytes = result.getRawBytes();
            BarcodeFormat format = result.getBarcodeFormat();
            ResultPoint[] points = result.getResultPoints();
            textv.setText(text);
            qrID = text.toString();

            // start new intent to the new page
            //Intent i = new Intent(getApplicationContext(),DisplayData.class);
            //i.putExtra("QRKey",qrID);
            //startActivity(i);

        } catch (Exception e) {

            e.printStackTrace();
        }/*catch (ChecksumException e) {

            e.printStackTrace();
        } catch (FormatException e) {

            e.printStackTrace();

        }*/
        Log.i("done", "done");
        if(text!=null)
            Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
        else{
            Toast.makeText(getBaseContext(), "KEEP CAMERA STEADY AND SCAN AGAIN", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            ivPicture.setImageBitmap(bmp);
            decode();
        }
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
