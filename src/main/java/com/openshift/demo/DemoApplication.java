package com.openshift.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    private Fet fet = new Fet();
    private final String style = "<p style='font-size:40px ; font-weight:100; font-family: Helvetica, sans-serif;'>";
    public final String mainDiv = " style=\"background-image: url('http://www.rtig.org.uk/web/portals/_default/Skins/Minimalist-Ocean-Gradient-Skins/backgrounds/SkyBlue/11_image.jpg');" +
            "opacity:0.8; width:100%; height:100%; display: flex;" +
            "align-items:center; justify-content:center; background-size:cover;\"";
    public final String innerDiv = " style=\"font-size:20px;\n" +
            "font-style:italic;\"";
    @GetMapping("/{number}")
    public String service(@PathVariable String number){
        int num = 0;
        try {
            num = Integer.parseInt(number);
        }
        catch (NumberFormatException e)
        {
            num = 0;
        }

        return "<div" + mainDiv + ">"  + "<div" + innerDiv + ">" + fet.getRow(num) + "</div>" + "</div>";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
