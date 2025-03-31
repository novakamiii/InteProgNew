package net.javaguides.springboot_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@RestController
public class WelcomeController 
{
    @GetMapping("/welcome")
    public String welcome()
    {
        return "Hello World.";
    }
    @GetMapping("hello")
	public String Hello(@RequestParam(value= "name") String name)
	{
		return String.format("Hello %s!", name);
	}
    /*
     * Text SMS Via SpringBoot
     */
    public static final String ACCOUNT_SID = "AC2eb7b1791c060b3c1783a8d8857471a8";
    public static final String AUTH_TOKEN = "d3fc68d994d035063855eddcf96029cc";

    @GetMapping("/sendSms")
    public ResponseEntity<String> sendSms()
    {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String receiver = "+63 991 527 3776";
        String sender = "+1 706 350 7970";
        String message = "Hello im under the water";

        Message.creator(
            new PhoneNumber(receiver), 
            new PhoneNumber(sender), 
            message)
            .create();
        return new ResponseEntity<>("SMS Sent!", HttpStatus.OK);
    }


}
