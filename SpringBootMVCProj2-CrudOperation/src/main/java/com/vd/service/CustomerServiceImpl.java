package com.vd.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.CustomerBO;
import com.vd.dao.CustomerRepo;
import com.vd.dto.CustomerDTO;

@Service("cservice")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo repo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		CustomerBO bo=new CustomerBO();
		CustomerBO bo2=null;
		//convert dto to bo 
		BeanUtils.copyProperties(dto, bo,"cid");
		bo2=repo.save(bo);
		return bo2==null?"Customer registration Failed":"Customer registration Succeded";
	}
	@Override
	public CustomerDTO getCustomerById(Integer id) {
		Optional<CustomerBO> optbo=null;
		CustomerBO bo=new CustomerBO();
		CustomerDTO dto=new CustomerDTO();
		optbo=repo.findById(id);
		bo=optbo.get();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	
	@Override
	public Set getAllCustomer() {
		Set<CustomerDTO> custListDTO= new LinkedHashSet();
		List<CustomerBO> custList=(List<CustomerBO>) repo.findAll();
		custList.forEach(cust->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(cust, dto);
			custListDTO.add(dto);
		});
		return custListDTO;
	}
	@Override
	public String updateCustomerById(CustomerDTO dto) {
		CustomerBO bo=new CustomerBO();
		CustomerBO bo2=null;
		BeanUtils.copyProperties(dto, bo);
		bo2=repo.save(bo);
		return bo2==null?bo.getName()+"Not found ":bo2.getName()+"Information update successfully";
	}
	
	@Override
	public String deleteCustomer(Integer id) {
		String msg=null;
		CustomerBO bo=null;
		bo=repo.findById(id).get();
		System.out.println(id);
		if(bo==null)
			msg="Customer not found or may be already deleted"+id;
		else {
			repo.delete(bo);
			msg="customer deleted sucessfully"+id;
		}
		return msg;
	}
}
