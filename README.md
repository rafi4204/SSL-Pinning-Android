# SSL-Pinning-Android
📌📌 This project will show the implementation of SSL pinning with public key of the server certificate using retrofit okhttp client.

## Overview
Github Api has been used to show the ssl pinning. Its a simple user info api which will show user name.After clicking the button github api will be called and 
it will fetch user data.


![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot_20230206_233429.png "CertificatePinner")

## Explanation
 ### Create `CertificatePinner` object with hash pin and host name 
 
 ![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot%202023-02-06%20at%2011.51.49%20PM.png "CertificatePinner")
 
 ### Create `OkHttpClient` with `CertificatePinner` object
 
 ![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot%202023-02-06%20at%2011.51.10%20PM.png "CertificatePinner")
 
 ### Add `OkHttpClient` with `Retrofit`
 
 ![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot%202023-02-06%20at%2011.52.05%20PM.png "CertificatePinner")
 
## Install Openssl 
 ### Mac OS
- Run this command on terminal `brew install openssl`
 
 ### Windows
 https://thesecmaster.com/procedure-to-install-openssl-on-the-windows-platform/
   
## How to Extract Public Key/Hash from .cer/.crt file
 ### 1st Approach
- First download the server certificate and save the file in a folder
- run this command on that folder `openssl x509 -in your_cerficate.cer -pubkey -noout | openssl pkey -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64`
 ### 2nd Appraoch
- Give a wrong hash in retrofit 

![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot%202023-02-06%20at%2011.28.49%20PM.png "wrong hash")
- Hit github api then in logcat correct hash pin will be shown. Copy the first hash and use it for pinning

![Alt text](https://github.com/rafi4204/SSL-Pinning-Android/blob/master/image/Screenshot%202023-02-06%20at%2011.35.56%20PM.png "Logcat")

 ### 3rd Appraoch
- Run this command `openssl s_client -connect www.yourdomain.com:443 | openssl x509 -pubkey -noout | openssl rsa -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64`

## Resources 
https://tech.groww.in/ssl-pinning-in-android-part-2-b591dfc8c2f1
https://owasp.org/www-community/controls/Certificate_and_Public_Key_Pinning
https://mailapurvpandey.medium.com/ssl-pinning-in-android-90dddfa3e051#:~:text=Public%20Key%20Pinning,-Public%20key%20pinning&text=In%20this%20approach%2C%20we%20generate,throw%20a%20SSL%20certificate%20error.
