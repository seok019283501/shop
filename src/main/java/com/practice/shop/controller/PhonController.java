package com.practice.shop.controller;

import com.practice.shop.domain.CertificationDto;
import com.practice.shop.service.CertificationService;
import com.practice.shop.service.CertificationServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Controller
public class PhonController {
    @Autowired
    CertificationService certificationService;
    @PostMapping("/compare")
    @ResponseBody
    public String compare(@RequestBody int certified){
        try {
            certificationService.select(certified);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "ok";

    }
    @PostMapping("/resend")
    @ResponseBody
    public String reSend(@RequestBody String param){
        String res=null;
        param = "0"+param;
        System.out.println("param = " + param);
        try {
            res =sendSMS(param);
            //res="1111";
            certificationService.deletePhon(param);
            CertificationDto certificationDto=new CertificationDto(Integer.parseInt(res),param);
            certificationService.insert(certificationDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return res;
    }
    @PostMapping("/send")
    @ResponseBody
    public String send(@RequestBody String param){
        String res=null;
        param = "0"+param;
        System.out.println("param = " + param);


        try {
            res =sendSMS(param);

           // res="1112";
            CertificationDto certificationDto=new CertificationDto(Integer.parseInt(res),param);
            System.out.println("certificationDto.getPhon_num() = " + certificationDto.getPhon_num());
            certificationService.insert(certificationDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return res;
    }
    /*
* https://api.ncloud-docs.com/docs/ko/ai-application-service-sens-smsv2
{
"type":"(SMS | LMS | MMS)",
"contentType":"(COMM | AD)",
"countryCode":"string",
"from":"string",
"subject":"string",
"content":"string",
"messages":[
    {
        "to":"string",
        "subject":"string",
        "content":"string"
    }
],
"files":[
    {
        "name":"string",
        "body":"string"
    }
],
"reserveTime": "yyyy-MM-dd HH:mm",
"reserveTimeZone": "string",
"scheduleCode": "string"
}
*/
    private String sendSMS(String phon) {
        String hostNameUrl = "https://sens.apigw.ntruss.com";     		// ????????? URL
        String requestUrl= "/sms/v2/services/";                   		// ?????? URL
        String requestUrlType = "/messages";                      		// ?????? URL
        String accessKey = "aE05lWem8uj6PY8pgz38";                     	// ????????? ???????????? ????????? ???????????? ???????????? ?????? ?????????			// Access Key : https://www.ncloud.com/mypage/manage/info > ????????? ?????? > Access Key ID
        String secretKey = "DTN6RAJatWGN1vRwX1zaDADj5903FTpYh1AQaQ4G";  // 2??? ????????? ?????? ??????????????? ???????????? service secret key	// Service Key : https://www.ncloud.com/mypage/manage/info > ????????? ?????? > Access Key ID
        String serviceId = "ncp:sms:kr:291279493137:sms_api";       // ??????????????? ????????? SMS ????????? ID							// service ID : https://console.ncloud.com/sens/project > Simple & ... > Project > ????????? ID
        String method = "POST";											// ?????? method
        String timestamp = Long.toString(System.currentTimeMillis()); 	// current timestamp (epoch)
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl;

        // JSON ??? ????????? body data ??????
        JSONObject bodyJson = new JSONObject();
        JSONObject toJson = new JSONObject();
        JSONArray toArr = new JSONArray();

        //toJson.put("subject","");							// Optional, messages.subject	?????? ????????? ??????, LMS, MMS????????? ?????? ??????
        // Optional, messages.content	?????? ????????? ??????, SMS: ?????? 80byte, LMS, MMS: ?????? 2000byte
        toJson.put("to",phon);						// Mandatory(??????), messages.to	????????????, -??? ????????? ????????? ?????? ??????
        toArr.put(toJson);
        int random = (int) ((Math.random() * (9000)) + 1000);
        String sRandom = Integer.toString(random);
        bodyJson.put("type","SMS");							// Madantory, ????????? Type (SMS | LMS | MMS), (????????? ??????)
        bodyJson.put("contentType","COMM");					// Optional, ????????? ?????? Type (AD | COMM) * AD: ?????????, COMM: ????????? (default: COMM) * ????????? ????????? ?????? ??? ?????? ?????? ????????? ?????? ?????????????????? (??? 50???)??? ???????????????.
        bodyJson.put("countryCode","82");					// Optional, ?????? ????????????, (default: 82)
        bodyJson.put("from","01040691651");					// Mandatory, ????????????, ?????? ????????? ??????????????? ?????? ??????
//        bodyJson.put("subject","");						// Optional, ?????? ????????? ??????, LMS, MMS????????? ?????? ??????
        bodyJson.put("content",sRandom);	// Mandatory(??????), ?????? ????????? ??????, SMS: ?????? 80byte, LMS, MMS: ?????? 2000byte
        bodyJson.put("messages", toArr);					// Mandatory(??????), ?????? ????????? ?????? (messages.XXX), ?????? 1,000???

        //String body = bodyJson.toJSONString();
        String body = bodyJson.toString();

        System.out.println(body);

        try {
            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            wr.write(body.getBytes());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            System.out.println("responseCode" +" " + responseCode);
            if(responseCode == 202) { // ?????? ??????
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { // ?????? ??????
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sRandom;
    }
    // https://api.ncloud-docs.com/docs/common-ncpapi
    private String makeSignature(String url, String timestamp, String method, String accessKey, String secretKey) throws NoSuchAlgorithmException {
        String space = " ";                    // one space
        String newLine = "\n";                 // new line


        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey;
        String encodeBase64String;
        try {

            signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            encodeBase64String = e.toString();
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }


        return encodeBase64String;
    }


}
