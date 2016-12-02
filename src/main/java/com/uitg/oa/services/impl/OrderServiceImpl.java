package com.uitg.oa.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uitg.oa.bean.Page;
import com.uitg.oa.dao.OrderDAO;
import com.uitg.oa.entity.Order;
import com.uitg.oa.services.OrderService;
import com.uitg.oa.util.BeanCopier;


@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	@Autowired
    OrderDAO orderDAO;

	@Override
    public Page<Order> findOrder(int pageIndex, int pageSize,int userId, boolean isClient,boolean isAdmin,String status) {
        return orderDAO.findOrder(pageIndex, pageSize,userId, isClient,isAdmin,status);
    }
	
    @Override
    public Page<Order> findOrder(int pageIndex, int pageSize,int userId, boolean isClient,boolean isAdmin) {
        return orderDAO.findOrder(pageIndex, pageSize,userId, isClient,isAdmin);
    }
    
    public void saveSpiltOrder(int orderId,List orders, boolean isCopyEdit){
    	   Order ord;
		   List savelist = new ArrayList();
		   List updatelist = new ArrayList();
		   
		   if(!isCopyEdit){
			   if(orders.size()==1){
				   ord = (Order)orders.get(0);
				   if(ord.getPo()!=null){
					   Order uporder = findById(Order.class, Integer.valueOf(orderId));
					   uporder.setAssignee(ord.getAssignee());
					   uporder.setFpo(ord.getFpo());
					   uporder.setCharacterCount(ord.getCharacterCount());
					   uporder.setAmount(ord.getAmount());
					   uporder.setEndDate(ord.getEndDate());
					   uporder.setScore(ord.getScore());
					   update(uporder);
				   }else{
					   ord.setFpo(ord.getPo() + "-1");
					   save(ord);
				   }			   
			   }else if(orders.size()>1){
	           //main order should be updated no matter add or update the splitted order  
				   Order mainorder = new Order();
				   for(int i=0;  i<orders.size();i++){
					   ord = (Order)orders.get(i);
					   if(ord.getPo()!=null && StringUtils.isBlank(ord.getFpo())){
						   ord.setFpo(ord.getPo() + "-"+String.valueOf(i+1));
						   if(i==0){
							   mainorder = findById(Order.class, Integer.valueOf(orderId));
							   mainorder.setAssignee(ord.getAssignee());
							   mainorder.setFpo(ord.getFpo());
							   mainorder.setCharacterCount(ord.getCharacterCount());
							   mainorder.setAmount(ord.getAmount());
							   mainorder.setEndDate(ord.getEndDate());
							   mainorder.setScore(ord.getScore());
							   updatelist.add(mainorder);
						   }else{
							   BeanCopier.buildCopier(ord, mainorder).excludeDefault()
							    .exclude("id","assignee","fpo","characterCount","amount","mainOrder","score","orderDate","returnDate","deliveryDate","endDate").copy();
							   ord.setOrderDate(mainorder.getOrderDate());
							   ord.setReturnDate(mainorder.getReturnDate());
							   ord.setDeliveryDate(mainorder.getDeliveryDate());
							   savelist.add(ord);	
						   }	   
					   }else{
						   Order updatedmainorder = new Order();
						   updatedmainorder.setPo(ord.getPo());
						   updatedmainorder.setFpo(ord.getFpo());
						   updatedmainorder = findByExample(updatedmainorder);
						   updatedmainorder.setAssignee(ord.getAssignee());
						   updatedmainorder.setFpo(ord.getFpo());
						   updatedmainorder.setCharacterCount(ord.getCharacterCount());
						   updatedmainorder.setAmount(ord.getAmount());
						   updatedmainorder.setEndDate(ord.getEndDate());
						   updatedmainorder.setScore(ord.getScore());
						   updatelist.add(updatedmainorder);
					   }
				   }	   
				   
			   }			   
		   }else{
			   
			   Order mainorder = findById(Order.class, Integer.valueOf(orderId));
			   for(int i=0;  i<orders.size();i++){
				   ord = (Order)orders.get(i);
				   if(ord.getPo()!=null && StringUtils.isBlank(ord.getFpo())){
					   ord.setFpo(ord.getPo() + "-"+String.valueOf(i+1)+"CE");
					   
				       BeanCopier.buildCopier(ord, mainorder).excludeDefault()
						    .exclude("id","assignee","fpo","characterCount","amount","mainOrder","score","orderDate","returnDate","deliveryDate","endDate").copy();
						   ord.setOrderDate(mainorder.getOrderDate());
						   ord.setReturnDate(mainorder.getReturnDate());
						   ord.setDeliveryDate(mainorder.getDeliveryDate());
						   ord.setCopyEdit(true);
						   savelist.add(ord);	   
				   }else{
					   Order updatedmainorder = new Order();
					   updatedmainorder.setPo(ord.getPo());
					   updatedmainorder.setFpo(ord.getFpo());
					   updatedmainorder.setCopyEdit(true);
					   updatedmainorder = findByExample(updatedmainorder);
					   updatedmainorder.setAssignee(ord.getAssignee());
					   updatedmainorder.setFpo(ord.getFpo());
					   updatedmainorder.setCharacterCount(ord.getCharacterCount());
					   updatedmainorder.setAmount(ord.getAmount());
					   updatedmainorder.setEndDate(ord.getEndDate());
					   updatedmainorder.setScore(ord.getScore());
					   updatelist.add(updatedmainorder);
				   }
			   }	
			   
		   }
		   
		   if(savelist.size()>0){
			   saveAll(savelist);
		   }
		   
		   if(updatelist.size()>0){
			   updateAll(updatelist);
		   }
    }

}
