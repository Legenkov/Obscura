package com.example.user.authmodule.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.authmodule.R;
import com.example.user.authmodule.common.IMainListener;
import com.mvc.imagepicker.ImagePicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static android.graphics.Bitmap.CompressFormat.JPEG;

/**
 * Created by User on 08.05.2018.
 */

public class BaseActivity extends AppCompatActivity {
    private IMainListener onMainListener;
    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mFragmentManager = getSupportFragmentManager();
    }

    protected void replaceWithAnimFragment(int id, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity, R.anim.move_left_in_activity, R.anim.move_right_out_activity).replace(id, fragment).addToBackStack(tag);
        fragmentTransaction.commit();
    }

    protected void replaceWithAnimFragment(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity, R.anim.move_left_in_activity, R.anim.move_right_out_activity).replace(id, fragment);
        fragmentTransaction.commit();
    }
    public boolean saveBitmapToFile(final Bitmap bitmap,
                                    final Bitmap.CompressFormat format,
                                    final int quality,
                                    final File file) {

        if (file == null)
            return false;
        if (file.getParent() != null && !file.isDirectory())
            file.mkdirs();
        OutputStream fos;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(format, quality, fos);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
            File outputDir = BaseActivity.this.getCacheDir(); // context being the Activity pointer
            File file = null;
            try {
                file = File.createTempFile("photo", ".jpeg", outputDir);
                BaseActivity.this.saveBitmapToFile(bitmap, JPEG, 75, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("RETy", "file.size " + file.length());

            onMainListener.updateAvatarWithGallery(bitmap);
        }
    }
}