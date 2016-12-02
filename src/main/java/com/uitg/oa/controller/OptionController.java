package com.uitg.oa.controller;

import com.uitg.oa.bean.OptionsBean;
import com.uitg.oa.entity.Option;
import com.uitg.oa.enumeration.Options;
import com.uitg.oa.services.OptionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Description Here
 *
 * @author Michael
 */
@Controller
@RequestMapping("/admin/option")
public class OptionController extends BaseAdminController {

    @Autowired
    OptionService optionService;

    @RequestMapping({"/", "/list"})
    public String list(@RequestParam(defaultValue = "USER") String type, Model model) {

        List<Option> options = optionService.findByType(type);
        Map<String, Option> name2opt = new HashMap<String, Option>();
        for(Option option : options) {
            name2opt.put(option.getName(), option);
        }

        Options[] opEnums = Options.getOptions(type);
        if(options.size() != opEnums.length) {
            for(Options opEnum : opEnums) {
                if(!name2opt.containsKey(opEnum.getName())) {
                    options.add(new Option(opEnum.getName(), type));
                }
            }
        }


        OptionsBean optionsBean = new OptionsBean();
        optionsBean.setOptions(options);

        model.addAttribute("options", optionsBean);
        model.addAttribute("type", type);

        return "admin/option/list";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String type, @ModelAttribute("options") OptionsBean optionsBean) {

        System.out.println(optionsBean);
        List<Option> options = optionService.findByType(type);
        Map<Integer, Option> id2opt = new HashMap<Integer, Option>();
        for(Option option: options) {
            id2opt.put(option.getId(), option);
        }

        options = new ArrayList<Option>();
        Option to;
        Integer id;
        for(Option option : optionsBean.getOptions()) {
            id = option.getId();
            if(id == null) {
                option.setCreatedBy(null);
                option.setCreatedOn(new Date());
                option.setType(type);
                options.add(option);
            } else {
                to = id2opt.get(id);
                if (!StringUtils.equals(option.getOptions(), to.getOptions())) {
                    to.setOptions(option.getOptions());
                    to.setUpdatedOn(new Date());
                    options.add(to);
                }
            }
        }

        if(options.size() > 0) {
            optionService.saveOrUpdateAll(options);
        }

        return "redirect:/admin/option/?type=" + type;
    }
}
