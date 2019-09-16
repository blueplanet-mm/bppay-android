# BPpay-android
##### a library to use BPpay easily in android
###  Features
  - enable easy integration of BPpay
  - can customize easily in both xml and runtime
 
#### Installation


```
    implementation 'mm.com.blueplanet:bppay:1.0.0'
```
#### Usage
##### Instantiation
First you need to build object BPpay from onCreate method of Activity or Fragment or other similar methods.
```java
   private BPpay instantiateBPpay(Activity activity) {
        return new BPpay.Builder(activity)
                .setPassword("your_password")
                .setServiceName("your_service_name")
                .setMerchantId("your_merchant_id")
                .setEmail("your_email")
                .build();
    }
```
##### Making payment
Call pay() on the BPpay object when you want to make payment.
```java
    mBPpay.pay("your_order_id", 1000 /*your_amount*/ );
```
##### Catching result

To catch payment result, override onActivityResult of payment.
```java
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BPpay.BPPAY_REQUEST_CODE) {
            //check your server for payment status
        }
    }
```
> Note
> BPpay doesn't return status to mobile or frontend side.
> You need to call your backend server for payment status.

### UI customizing

BPpay UI can be easily customized in both xml and runtime. 

##### Java
All the customizations are done in UIConfig object, you need to provide a UIConfig object when instanting BPpay. There are lots of options that can be overrided to modify payment ui as you require.

```java
private UIConfig getUIConfig(Context context){
        return new UIConfig.Builder(context)
                .setTitle("Pay")
                .setTitleColor(R.color.red)
                .build();
    }
```

##### xml
All the customizations made in runtime can be done in respective xml file. You just need to write the resource name in *snake-case* and prefixed with 'bp_pay'.
For example:
```xml
    <string name="bp_pay_title">Payment</string>
    <color name="bp_pay_title_color">@android:color/white</color>
```



