package com.uitg.oa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.uitg.oa.bean.OrderList;
import com.uitg.oa.bean.Page;
import com.uitg.oa.bean.SelectLabelBean;
import com.uitg.oa.entity.Order;
import com.uitg.oa.entity.OrderValue;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.OrderService;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.BeanCopier;
import com.uitg.oa.util.LangUtil;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Autowired
    protected OrderService orderService;
	
	@Autowired
    protected UserService userService;	
	
	@RequestMapping("/orderlist")	    
    public String list(Model model, @RequestParam(required = false, defaultValue = "1") Integer page) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	    User user = (User)userDetails;
   	    
        Page<Order> orderlists = orderService.findOrder(page, getPageSize(),user.getId(),true,false);
        model.addAttribute("page", orderlists);
        Map langs = LangUtil.getSrcTargetLang();
        Map statusList = LangUtil.getStatusMap(ctx);
        model.addAttribute("statusmap", statusList);
        model.addAttribute("langmap", langs);
        return "erp/orderlist";
    }
	
	@RequestMapping("/tasklist")	    
    public String taskList(Model model, @RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(defaultValue = "") String status) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	    User user = (User)userDetails;
   	    status = (LangUtil.ORDER_STATUS_FINISH.equalsIgnoreCase(status))? "F":"";
        Page<Order> orderlists = orderService.findOrder(page, getPageSize(),user.getId(),false,false,status);
        model.addAttribute("page", orderlists);
        Map langs = LangUtil.getSrcTargetLang();
        Map statusList = LangUtil.getStatusMap(ctx);
        model.addAttribute("statusmap", statusList);
        model.addAttribute("langmap", langs);
        model.addAttribute("latesttask", status);
        return "erp/tasklist";
    }
	
	@RequestMapping("/allorderlist")	    
    public String allOrderList(Model model, @RequestParam(required = false, defaultValue = "1") Integer page) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	    User user = (User)userDetails;
        Page<Order> orderlists = orderService.findOrder(page, getPageSize(),user.getId(),true,true);
        model.addAttribute("page", orderlists);
        Map langs = LangUtil.getSrcTargetLang();
        Map statusList = LangUtil.getStatusMap(ctx);
        model.addAttribute("statusmap", statusList);
        model.addAttribute("langmap", langs);
        
        return "erp/allorderlist";
    }

	@RequestMapping("/addorder")
	public String addOrder(Model model){
		Order order = new Order();
		
		String yesvalue = LangUtil.getMessage("label.yes",ctx);
	    String novalue =  LangUtil.getMessage("label.no",ctx);
	    String select = LangUtil.getMessage("label.pleaseselect",ctx);
	    
		List needModifylist = new ArrayList();
		needModifylist.add(new SelectLabelBean("--"+select+"--",""));
		needModifylist.add(new SelectLabelBean(yesvalue,"Y"));
		needModifylist.add(new SelectLabelBean(novalue,"N"));			
		
		List cashbacklist = new ArrayList();
		cashbacklist.add(new SelectLabelBean("--"+select+"--",""));
		cashbacklist.add(new SelectLabelBean(yesvalue,"Y"));
		cashbacklist.add(new SelectLabelBean(novalue,"N"));		
		
		List confirmlist = new ArrayList();
		confirmlist.add(new SelectLabelBean("--"+select+"--",""));
		confirmlist.add(new SelectLabelBean(yesvalue,"Y"));
		confirmlist.add(new SelectLabelBean(novalue,"N"));		
		
		List freelancerpaylist = new ArrayList();
		freelancerpaylist.add(new SelectLabelBean("--"+select+"--",""));
		freelancerpaylist.add(new SelectLabelBean(yesvalue,"Y"));
		freelancerpaylist.add(new SelectLabelBean(novalue,"N"));		
		
		List srclanlist = LangUtil.getSrcTargetLang(ctx);
		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
		List statuslist = LangUtil.getStatus(ctx);
		List currlist = getCurrency();
		model.addAttribute("order", order);
		model.addAttribute("needModifylist",needModifylist);
		model.addAttribute("cashbacklist",cashbacklist);
		model.addAttribute("confirmlist",confirmlist);
		model.addAttribute("freelancerpaylist",freelancerpaylist);
		model.addAttribute("srclanlist",srclanlist);
		model.addAttribute("tarlanlist",tarlanlist);
		model.addAttribute("statuslist",statuslist);
		model.addAttribute("currlist",currlist);
		return "erp/orderedit";
	}
	
	@RequestMapping("/createorder")
	public String createOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){
		order = new Order();
		List srclanlist = LangUtil.getSrcTargetLang(ctx);
		List tarlanlist = LangUtil.getSrcTargetLang(ctx);

		model.addAttribute("order", order);

		model.addAttribute("srclanlist",srclanlist);
		model.addAttribute("tarlanlist",tarlanlist);
		return "erp/createorder";
	}
	
	@RequestMapping("/editcreateorder")
	public String editcreateOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){
		order = orderService.findById(Order.class, order.getId());
		List srclanlist = LangUtil.getSrcTargetLang(ctx);
		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
		model.addAttribute("srclanlist",srclanlist);
		model.addAttribute("tarlanlist",tarlanlist);
		model.addAttribute("order", order);
		return "erp/createorder";
	}	
	
	@RequestMapping("/savecreateorder")
	public String savecreateOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){
		
		if(order.getId()!=null){
			Order ord = orderService.findById(Order.class, order.getId());
			ord.setOrderDesc(order.getOrderDesc());
			ord.setTotalCount(order.getTotalCount());			
			ord.setDeliveryDate(order.getDeliveryDate());
			ord.setSourceLanguage(order.getSourceLanguage());
			ord.setTargetLanguage(order.getTargetLanguage());
			orderService.update(ord);
		}else{
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyyMMddHHmmss");
			String po=dateformat1.format(new Date());
			order.setPo(po);
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user = (User) userDetails;
			order.setClient(new User(user.getId()));
			order.setOrderDate(new Date());
			order.setTotalamt(0.0);
			order.setMainOrder(true);
			order.setStatus(LangUtil.ORDER_STATUS_PENDING);
			orderService.save(order);
		}
		
		return "redirect:/order/orderlist";
	}	
	
	@RequestMapping("/changeorder")
	public String changeOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){	
		String yesvalue = LangUtil.getMessage("label.yes",ctx);
	    String novalue =  LangUtil.getMessage("label.no",ctx);
	    String select = LangUtil.getMessage("label.pleaseselect",ctx);
	    
		List acceptlist = new ArrayList();
		acceptlist.add(new SelectLabelBean("--"+select+"--",""));
		acceptlist.add(new SelectLabelBean(yesvalue,"Y"));
		acceptlist.add(new SelectLabelBean(novalue,"N"));
		
		Order ord = orderService.findById(Order.class, order.getId());
		model.addAttribute("order", ord);
		model.addAttribute("acceptlist", acceptlist);
		return "erp/changeorder";
	}
	
	@RequestMapping("/savechangeorder")
	public String savechangeOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){
		
		Order ord = orderService.findById(Order.class, order.getId());
		ord.setAmount(order.getAmount());
		ord.setAccept(order.getAccept());
		orderService.update(ord);
		return "redirect:/order/tasklist";
	}	
	
	@RequestMapping("/editorder")
	public String editOrder(Model model, Order order, Errors errors){
		order = orderService.findById(Order.class, order.getId());
		Order ord = new Order();
		ord.setPo(order.getPo());
		ord.setCopyEdit(false);
		List orders = orderService.findAllByExample(ord);
		
		if(orders.size()==1){
			int oid = ((Order)orders.get(0)).getId();
			if(order.getId()==oid && order.getAssignee()==null){
				orders = new ArrayList();
			}
		}
		
		ord = new Order();
		ord.setPo(order.getPo());
		ord.setCopyEdit(true);
        List editorders = orderService.findAllByExample(ord);
        
		String yesvalue = LangUtil.getMessage("label.yes",ctx);
	    String novalue =  LangUtil.getMessage("label.no",ctx);
	    String select = LangUtil.getMessage("label.pleaseselect",ctx);
	    
		List needModifylist = new ArrayList();
		needModifylist.add(new SelectLabelBean("--"+select+"--",""));
		needModifylist.add(new SelectLabelBean(yesvalue,"Y"));
		needModifylist.add(new SelectLabelBean(novalue,"N"));			
		
		List cashbacklist = new ArrayList();
		cashbacklist.add(new SelectLabelBean("--"+select+"--",""));
		cashbacklist.add(new SelectLabelBean(yesvalue,"Y"));
		cashbacklist.add(new SelectLabelBean(novalue,"N"));		
		
		List confirmlist = new ArrayList();
		confirmlist.add(new SelectLabelBean("--"+select+"--",""));
		confirmlist.add(new SelectLabelBean(yesvalue,"Y"));
		confirmlist.add(new SelectLabelBean(novalue,"N"));		
		
		List freelancerpaylist = new ArrayList();
		freelancerpaylist.add(new SelectLabelBean("--"+select+"--",""));
		freelancerpaylist.add(new SelectLabelBean(yesvalue,"Y"));
		freelancerpaylist.add(new SelectLabelBean(novalue,"N"));	
		
		List statuslist = LangUtil.getStatus(ctx);
		
		List srclanlist = LangUtil.getSrcTargetLang(ctx);
		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
		List currlist = getCurrency();

		model.addAttribute("order", order);
		model.addAttribute("orders", orders);
		model.addAttribute("editorders", editorders);
		model.addAttribute("needModifylist",needModifylist);
		model.addAttribute("cashbacklist",cashbacklist);
		model.addAttribute("confirmlist",confirmlist);
		model.addAttribute("freelancerpaylist",freelancerpaylist);
		model.addAttribute("srclanlist",srclanlist);
		model.addAttribute("tarlanlist",tarlanlist);
		model.addAttribute("statuslist",statuslist);
		model.addAttribute("currlist",currlist);
		return "erp/orderedit";
	}
	
	@RequestMapping("/saveorder")
	public String saveOrder(Model model,@Valid @ModelAttribute Order order, Errors errors){
		if(StringUtils.isBlank(order.getOrderDesc())){
	    	String projectname = LangUtil.getMessage("label.projectname", ctx);
			errors.reject("validation.required", new String[]{projectname}, "project name is requried");
		}
		
		if(order.getOrderDate()==null){
	    	String orderdate = LangUtil.getMessage("label.orderdate", ctx);
			errors.reject("validation.required", new String[]{orderdate}, "order date is requried");
		}
		
		if(order.getDeliveryDate()==null){
	    	String diliverydate = LangUtil.getMessage("label.diliverydate", ctx);
			errors.reject("validation.required", new String[]{diliverydate}, "dilivery date is requried");
		}
		
		if(order.getClient()==null || order.getClient().getId()==null){
	    	String client = LangUtil.getMessage("label.client", ctx);
			errors.reject("validation.required", new String[]{client}, "client is requried");
		}
		
		if(order.getEndDate()==null){
	    	String enddate = LangUtil.getMessage("label.enddate", ctx);
			errors.reject("validation.required", new String[]{enddate}, "return date is requried");
		}
		
		if(order.getTotalamt()==null){
	    	String total = LangUtil.getMessage("label.total", ctx);
			errors.reject("validation.required", new String[]{total}, "total amount is requried");
		}
		
		if(order.getDiscount()==null){
	    	String discount = LangUtil.getMessage("label.discount", ctx);
			errors.reject("validation.required", new String[]{discount}, "discount is requried");
		}
				
		if(StringUtils.isBlank(order.getSourceLanguage())){
	    	String sourcelang = LangUtil.getMessage("label.sourcelang", ctx);
			errors.reject("validation.pleaseselect", new String[]{sourcelang}, "source language is requried");
		}
		
		if(StringUtils.isBlank(order.getTargetLanguage())){
	    	String targetlang = LangUtil.getMessage("label.targetlang", ctx);
			errors.reject("validation.pleaseselect", new String[]{targetlang}, "target language is requried");
		}
		
		if(StringUtils.isBlank(order.getStatus())){
	    	String status = LangUtil.getMessage("label.status", ctx);
			errors.reject("validation.pleaseselect", new String[]{status}, "status is requried");
		}
		
		if(StringUtils.isBlank(order.getCurrency())){
	    	String currency = LangUtil.getMessage("label.currency", ctx);
			errors.reject("validation.required", new String[]{currency}, "currency is requried");
		}
		
		 if(errors.hasErrors()) {
	        	String yesvalue = LangUtil.getMessage("label.yes",ctx);
	    	    String novalue =  LangUtil.getMessage("label.no",ctx);
	    	    String select = LangUtil.getMessage("label.pleaseselect",ctx);
	    	    
	    		List needModifylist = new ArrayList();
	    		needModifylist.add(new SelectLabelBean("--"+select+"--",""));
	    		needModifylist.add(new SelectLabelBean(yesvalue,"Y"));
	    		needModifylist.add(new SelectLabelBean(novalue,"N"));			
	    		
	    		List cashbacklist = new ArrayList();
	    		cashbacklist.add(new SelectLabelBean("--"+select+"--",""));
	    		cashbacklist.add(new SelectLabelBean(yesvalue,"Y"));
	    		cashbacklist.add(new SelectLabelBean(novalue,"N"));		
	    		
	    		List confirmlist = new ArrayList();
	    		confirmlist.add(new SelectLabelBean("--"+select+"--",""));
	    		confirmlist.add(new SelectLabelBean(yesvalue,"Y"));
	    		confirmlist.add(new SelectLabelBean(novalue,"N"));		
	    		
	    		List freelancerpaylist = new ArrayList();
	    		freelancerpaylist.add(new SelectLabelBean("--"+select+"--",""));
	    		freelancerpaylist.add(new SelectLabelBean(yesvalue,"Y"));
	    		freelancerpaylist.add(new SelectLabelBean(novalue,"N"));	
	    		
	    		List statuslist = LangUtil.getStatus(ctx);
	    		List currlist = getCurrency();
	    		
	    		List srclanlist = LangUtil.getSrcTargetLang(ctx);
	    		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
	    		model.addAttribute("needModifylist",needModifylist);
	    		model.addAttribute("cashbacklist",cashbacklist);
	    		model.addAttribute("confirmlist",confirmlist);
	    		model.addAttribute("freelancerpaylist",freelancerpaylist);
	    		model.addAttribute("srclanlist",srclanlist);
	    		model.addAttribute("tarlanlist",tarlanlist);
	    		model.addAttribute("statuslist",statuslist);
	    		model.addAttribute("currlist",currlist);
	    		
	    		List orders = new ArrayList();
	    		if(order.getId()!=null){    	        
    	           Order sorder = new Order();
    	           sorder.setPo(order.getPo());
    	           orders = orderService.findAllByExample(sorder);
	    		}
	    			    		
	    		if(orders.size()==1){
	    			int oid = ((Order)orders.get(0)).getId();
	    			if(order.getId()==oid && order.getAssignee()==null){
	    				orders = new ArrayList();
	    			}
	    		}
	    		model.addAttribute("orders", orders);
	            return "erp/orderedit";
	    }
		
		if(order.getId()!=null){
           Order ord = orderService.findById(Order.class, order.getId());
           
           BeanCopier.buildCopier(ord, order).excludeDefault().
              exclude("orderDate","returnDate","deliveryDate","endDate","fpo","amount","characterCount","assignee","totalCount","mainOrder").copy();
           ord.setOrderDate(order.getOrderDate());
           ord.setReturnDate(order.getReturnDate());
           ord.setDeliveryDate(order.getDeliveryDate());
           ord.setEndDate(order.getEndDate());
           
           Order suborder = new Order();
           suborder.setPo(ord.getPo());
           List suborders = orderService.findAllByExample(suborder);
           List allorder = new ArrayList();
           
           if(LangUtil.ORDER_STATUS_PENDING.equalsIgnoreCase(order.getStatus())){
				if(order.getTotalamt()!=null && order.getTotalamt()>0){					
					ord.setStatus(LangUtil.ORDER_STATUS_APPOVE);
				}
		   }
           
           allorder.add(ord);
           
           if(suborders.size()>0){
        	   for(int i = 0;i<suborders.size();i++){
        		   Order newsubord = (Order)suborders.get(i);
        		   if(order.getId()!=newsubord.getId()){       		   
    			     BeanCopier.buildCopier(newsubord, order).excludeDefault()
    			     .exclude("id","returnDate","orderDate","deliveryDate","endDate","fpo","amount","characterCount","assignee","totalCount","mainOrder").copy();
    			     newsubord.setOrderDate(order.getOrderDate());
    			     newsubord.setDeliveryDate(order.getDeliveryDate());
    			     newsubord.setReturnDate(order.getReturnDate());
    			     //newsubord.setEndDate(order.getEndDate());
        		     newsubord.setFreelancerPay(ord.getFreelancerPay());
        		     newsubord.setStatus(order.getStatus());
        		     allorder.add(newsubord);
        		   }
        	   }
           }
           
           orderService.updateAll(allorder);
		}else{
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyyMMddHHmmss");
			String po=dateformat1.format(new Date());

			order.setPo(po);					
			order.setMainOrder(true);
		    orderService.save(order);
		}


        return "redirect:/order/allorderlist";
	}
	
	@RequestMapping("/searchuser")
	@ResponseBody
    public List<User> searchUser(Model model,@ModelAttribute User user,Errors errors) {
       
        if(errors.hasErrors()) {
            //return editUser(model, user);
        }

        User usr = new User();
        usr.setSourceLanguage(user.getSourceLanguage());
        usr.setTargetLanguage(user.getTargetLanguage());
        List<User> userlists = userService.findAllByExample(usr);
        
        
        return userlists; 
    }
	
	@RequestMapping("/saveorders")
	@ResponseBody
    public String saveOrders(Model model,@RequestBody String orders,@RequestParam(defaultValue = "N") String copyEditFlag,Errors errors) {      
        if(errors.hasErrors()) {
            //return editUser(model, user);
        }
        ObjectMapper objectMapper= new ObjectMapper();
        List<Order> subOrders = new ArrayList<Order>();
        String orderId="";
        try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(orders, List.class);
			for (int i = 0; i < list.size(); i++) {
			    Map<String, Object> map = list.get(i);
			    Set<String> set = map.keySet();
			    Order order = new Order();
			       for (Iterator<String> it = set.iterator(); it.hasNext();) {
				     String key = it.next();
				     
				     if("userid".equals(key)){
				    	 User user = new User();
				    	 user.setId(Integer.valueOf(map.get(key).toString()));
				    	 order.setAssignee(user);
				     }
				     
				     if("orderid".equals(key)){
				    	 orderId = map.get(key).toString();
				     }
				     
				     if("po".equals(key)){
				    	 order.setPo(map.get(key).toString());
				     }
				     
				     if("fpo".equals(key)){
				    	 order.setFpo(map.get(key).toString());
				     }
				     
				     if("count".equals(key)){
				    	 if("".equals(map.get(key))){
				    		 order.setCharacterCount(0);
				    	 }else{
				    	   order.setCharacterCount(Integer.valueOf(map.get(key).toString()));
				    	 }
				     }
				     
				     if("amount".equals(key)){
				    	 if("".equals(map.get(key))){
				    		 order.setAmount(0.0);
				    	 }else{
				    	   order.setAmount(Double.valueOf(map.get(key).toString()));
				    	 }
				     }
				     
				     if("enddate".equals(key)){
				    	 if("".equals(map.get(key))){
				    		 order.setEndDate(new Date());;
				    	 }else{
					    	 SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
					    	 Date date =  sf.parse((String)map.get(key));
					    	 
					    	 order.setEndDate(date);
				    	 }
				     }
				      
				     if("score".equals(key)){
				    	 if("".equals(map.get(key))){
				    		 order.setScore(0.0);
				    	 }else{
				    	     order.setScore(Double.valueOf(map.get(key).toString()));
				    	 }
				     }
			     }
			       subOrders.add(order);
			}
			
			if("N".equalsIgnoreCase(copyEditFlag)){
			   orderService.saveSpiltOrder(Integer.valueOf(orderId), subOrders,false);
			}else{
				orderService.saveSpiltOrder(Integer.valueOf(orderId), subOrders,true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "{\"success\":\"success\"}"; 
    }
	
}
