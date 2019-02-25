package z1835941.niu.portfolio5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/*****************
 * Justin Dupre and Brady Goldsworthy
 * Portfolio 5
 * Different Intents
 * 2/25/19
 ****************/

public class MainActivity extends Activity {

    private ImageView pictureIV;
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pictureIV = findViewById(R.id.pictureImageView);

    }

    public void doBrowser (View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.niu.edu"));

        startActivity(browserIntent);

    } //end browser

    public void dialNum (View view) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:6304848015"));

        startActivity(dialIntent);

    } //end dial

    public void takePic (View view) {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (pictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pictureIntent, REQUEST_CODE);
        }
    } //end takePic

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //get the image
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap)extras.get("data");

            //put bitmap into imageView
            pictureIV.setImageBitmap(imageBitmap);
        }
    }//end onActivityResult
}
