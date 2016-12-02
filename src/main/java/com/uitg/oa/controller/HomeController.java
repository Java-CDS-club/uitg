package com.uitg.oa.controller;

import com.uitg.oa.bean.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Description Here
 *
 * @author Michael
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private Context context;

    @RequestMapping({"/", "/erp"})
    public String showErpHomePage(Map<String, Object> model) {
       
        return "erp/erphome";
    }
    
    @RequestMapping("/index")
    public String showHomePage(Map<String, Object> model) {
       
        return "index";
    }
    
    @RequestMapping("/about")
    public String showAboutPage(Map<String, Object> model) {
       
        return "about";
    }
    
    @RequestMapping("/contactus")
    public String showContactUs(Map<String, Object> model) {
       
        return "contact_us";
    }
    
    @RequestMapping("/desktoppubish")
    public String showDesktopPublish(Map<String, Object> model) {
       
        return "desktop_publishing";
    }
    
    @RequestMapping("/interpreting")
    public String showInterpreting(Map<String, Object> model) {
       
        return "interpreting";
    }
    
    @RequestMapping("/localization")
    public String showLocalization(Map<String, Object> model) {
       
        return "localization";
    }
    
    @RequestMapping("/machineTranslation")
    public String showMachineTranslation(Map<String, Object> model) {
       
        return "machine_translation";
    }
    
    @RequestMapping("/ourclients")
    public String showOurclients(Map<String, Object> model) {
       
        return "our_clients";
    }
    
    @RequestMapping("/services")
    public String showServices(Map<String, Object> model) {
       
        return "services";
    }
    
    @RequestMapping("/subtitlingVoiceover")
    public String showSubtitlingVoiceover(Map<String, Object> model) {
       
        return "subtitling&voice-over";
    }
    
    @RequestMapping("/transcreation")
    public String showTranscreation(Map<String, Object> model) {
       
        return "transcreation";
    }
    
    @RequestMapping("/translation")
    public String showTranslation(Map<String, Object> model) {
       
        return "translation";
    }
    
    @RequestMapping("/workwithus")
    public String showWorkwithus(Map<String, Object> model) {
       
        return "work_with_us";
    }
    
}
