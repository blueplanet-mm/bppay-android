package mm.com.blueplanet.bppay.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blueplanet.payment.BPpay;

import mm.com.blueplanet.bppay.sampleapp.R;

public class MainActivity extends AppCompatActivity {
    BPpay mBPpay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mBPpay = new BPpay.Builder(this)
                .setPassword("your_password")
                .setServiceName("your_service_name")
                .setMerchantId("your_merchant_id")
                .setEmail("your_email")
                .build();

        findViewById(R.id.btn_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBPpay.pay("your_order_id", 1000/*your_amount*/);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BPpay.BPPAY_REQUEST_CODE) {
            //check your server for payment status
        }
    }
}
